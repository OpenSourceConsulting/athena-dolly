/* 
 * Athena Peacock Dolly - DataGrid based Clustering 
 * 
 * Copyright (C) 2014 Open Source Consulting, Inc. All rights reserved by Open Source Consulting, Inc.
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
 * Bong-Jin Kwon	2015. 1. 13.		First Draft.
 */
package com.athena.dolly.controller;

/**
 * <pre>
 *
 * </pre>
 * @author Bong-Jin Kwon
 * @version 2.0
 */
public abstract class DollyConstants {

	/**
	 * env.sh 로딩완료
	 * - 11 은 에러발생
	 */
	public static final int INSTANCE_STATE_PEND1 = 10;
	
	/**
	 * server.xml 로딩완료
	 * - 21 은 에러발생
	 */
	public static final int INSTANCE_STATE_PEND2 = 20;
	
	/**
	 * context.xml 로딩완료
	 * - 31 은 에러발생
	 */
	public static final int INSTANCE_STATE_PEND3 = 30;
	
	/**
	 * 설치가 유효한 상태
	 */
	public static final int INSTANCE_STATE_VALID = 100;


}
