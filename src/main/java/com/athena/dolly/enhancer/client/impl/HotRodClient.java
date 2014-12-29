/* 
 * Copyright (C) 2012-2014 Open Source Consulting, Inc. All rights reserved by Open Source Consulting, Inc.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * Revision History
 * Author			Date				Description
 * ---------------	----------------	------------
 * Sang-cheon Park	2014. 12. 23.		First Draft.
 */
package com.athena.dolly.enhancer.client.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.ServerStatistics;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

import com.athena.dolly.enhancer.ConfigurationException;
import com.athena.dolly.enhancer.DollyConfig;
import com.athena.dolly.enhancer.client.DollyClient;
import com.athena.dolly.stats.DollyStats;

/**
 * <pre>
 * Infinispan용 Dolly Client
 * </pre>
 * @author Sang-cheon Park
 * @version 1.0
 */
public class HotRodClient implements DollyClient {

	private DollyConfig config;
	private RemoteCache<String, Object> cache;

    /**
     * <pre>
     * 주어진 프로퍼티를 이용하여 Infinispan Data Grid Server에 접속하여 RemoteCache object를 가져온다. 
     * </pre>
     */
	public HotRodClient() {
		if (DollyConfig.properties == null || config == null) {
			try {
	            config = new DollyConfig().load();
			} catch (ConfigurationException e) {
	            System.err.println("[Dolly] Configuration error : " + e.getMessage());
	            e.printStackTrace();
			}
		}

    	//https://issues.jboss.org/browse/ISPN-4468
		ConfigurationBuilder builder = new ConfigurationBuilder();
	    cache = new RemoteCacheManager(builder.withProperties(DollyConfig.properties).build()).getCache();
	}//end of Default Contructor()

	public Object get(String cacheKey) {
		return cache.get(cacheKey);
	}//end of get()

	/* (non-Javadoc)
	 * @see com.athena.dolly.enhancer.client.DollyClient#get(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Object get(String cacheKey, String dataKey) {
    	Map<String, Object> attribute = (Map<String, Object>)cache.get(cacheKey);
		
		if (attribute == null) {
			return null;
		} else {
			return attribute.get(dataKey);
		}
	}//end of get()

	/* (non-Javadoc)
	 * @see com.athena.dolly.enhancer.client.DollyClient#put(java.lang.String, java.lang.Object)
	 */
	public synchronized void put(String cacheKey, Object value) {
		cache.put(cacheKey, value, -1, TimeUnit.SECONDS, config.getTimeout() * 60, TimeUnit.SECONDS);
	}//end of put()

	/* (non-Javadoc)
	 * @see com.athena.dolly.enhancer.client.DollyClient#put(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public synchronized void put(String cacheKey, String dataKey, Object value) {
		if (dataKey != null) {
	    	Map<String, Object> attribute = (Map<String, Object>)cache.get(cacheKey);
			
			if (attribute == null) {
				attribute = new ConcurrentHashMap<String, Object>();
			}
			
			attribute.put(dataKey, value);
			cache.put(cacheKey, attribute, -1, TimeUnit.SECONDS, config.getTimeout() * 60, TimeUnit.SECONDS);
		}
	}//end of put()

	/* (non-Javadoc)
	 * @see com.athena.dolly.enhancer.client.DollyClient#remove(java.lang.String)
	 */
	public synchronized Object remove(String cacheKey) {
		return cache.remove(cacheKey);
	}//end of remove()

    /* (non-Javadoc)
     * @see com.athena.dolly.enhancer.client.DollyClient#remove(java.lang.String, java.lang.String)
     */
    @SuppressWarnings("unchecked")
	public synchronized void remove(String cacheKey, String dataKey) {
    	Map<String, Object> attribute = (Map<String, Object>)cache.get(cacheKey);
		
		if (attribute != null) {
			attribute.remove(dataKey);
		}
		
		cache.put(cacheKey, attribute, -1, TimeUnit.SECONDS, config.getTimeout() * 60, TimeUnit.SECONDS);
    }//end of remove()
    
    /* (non-Javadoc)
     * @see com.athena.dolly.enhancer.client.DollyClient#getValueNames(java.lang.String)
     */
    @SuppressWarnings("unchecked")
	public Enumeration<String> getValueNames(String cacheKey) {
    	Map<String, Object> attribute = (Map<String, Object>)cache.get(cacheKey);
		
		if (attribute == null) {
			return null;
		} else {
			return Collections.enumeration(attribute.keySet());
		}
    }//end of getValueNames()

	/* (non-Javadoc)
	 * @see com.athena.dolly.enhancer.client.DollyClient#getKeys()
	 */
	public List<String> getKeys() {
		List<String> keyList = new ArrayList<String>();
		Enumeration<String> cacheKeys = Collections.enumeration(cache.keySet());
		String key = null;
	    while (cacheKeys.hasMoreElements()) {
	    	key = cacheKeys.nextElement();
	    	keyList.add(key);
	    }
	    
	    return keyList;
	}//end of getKeys()

    /* (non-Javadoc)
     * @see com.athena.dolly.enhancer.client.DollyClient#destory()
     */
    public void destory() {
	    cache.stop();
    }//end of destory()
    
	/* (non-Javadoc)
	 * @see com.athena.dolly.enhancer.client.DollyClient#getStats()
	 */
	public DollyStats getStats() {
		DollyStats stats = new DollyStats();
		
		stats.setProtocolVersion(cache.getProtocolVersion());
		stats.setVersion(cache.getVersion());
		stats.setName(cache.getName());
		stats.setIsEmpty(cache.isEmpty());
		stats.setSize(cache.size());
		
		ServerStatistics statistics = cache.stats();
		stats.setTimeSinceStart(statistics.getStatistic(ServerStatistics.TIME_SINCE_START));
		stats.setCurrentNumberOfEntries(statistics.getStatistic(ServerStatistics.CURRENT_NR_OF_ENTRIES));
		stats.setTotalNumberOfEntries(statistics.getStatistic(ServerStatistics.TOTAL_NR_OF_ENTRIES));
		stats.setStores(statistics.getStatistic(ServerStatistics.STORES));
		stats.setRetrievals(statistics.getStatistic(ServerStatistics.RETRIEVALS));
		stats.setHits(statistics.getStatistic(ServerStatistics.HITS));
		stats.setMisses(statistics.getStatistic(ServerStatistics.MISSES));
		stats.setRemoveHits(statistics.getStatistic(ServerStatistics.REMOVE_HITS));
		stats.setRemoveMisses(statistics.getStatistic(ServerStatistics.REMOVE_MISSES));
		
		stats.setCacheKeys(new ArrayList<String>(cache.keySet()));
		
		return stats;
	}//end of getStats()

	/* (non-Javadoc)
	 * @see com.athena.dolly.enhancer.client.DollyClient#printAllCache()
	 */
	public void printAllCache() {
	    System.out.println("ProtocolVersion : " + cache.getProtocolVersion());
	    System.out.println("Version : " + cache.getVersion());
	    System.out.println("isEmpty : " + cache.isEmpty());
	    System.out.println("Size : " + cache.size());
	    
	    Enumeration<String> cacheKeys = Collections.enumeration(cache.keySet());
	    String cacheKey = null;
    	Object data = null;
	    int i = 1;
	    while (cacheKeys.hasMoreElements()) {
	    	cacheKey = cacheKeys.nextElement();
    		System.out.println("================== Element index [" + i + "] ==================");
    		System.out.println("Cache Key : " + cacheKey);
	    	
	    	data = cache.get(cacheKey);
	    	
	    	if (data != null) {
    			System.out.println("Cache Data : " + data.toString());
	    	} else {
	    		System.out.println("Cache Data is NULL.");
	    	}
    		
    		System.out.println("");
    		i++;  
	    }
    }//end of printAllCache()
}
//end of HotRodClient.java