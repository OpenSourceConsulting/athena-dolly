/*
 * File: app/controller/MenuController.js
 *
 * This file was generated by Sencha Architect version 3.0.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('webapp.controller.MenuController', {
    extend: 'Ext.app.Controller',

    onTreepanelItemClick: function(dataview, record, item, index, e, eOpts) {
        var menuId = record.get("menuId");
        var is_leaf = record.get("leaf");
        if(menuId !== undefined){
            if (!is_leaf){
               this.loadChildMenus(menuId);
            }

            this.showMenu(menuId);

        }

    },

    onTreepanelItemContextMenu: function(dataview, record, item, index, e, eOpts) {
        var menuId = record.get("menuId");

        var mnuContext = null;

        //Tomcat management level
        if (menuId==="tomcatMng"){
            mnuContext = Ext.create("Ext.menu.Menu",{

            items: [{
                id: 'new-domain',
                text: 'New Domain'
            },
            {
                id: 'collapse',
                text: 'Collapse'
            },
            {
                id: 'refresh',
                text: 'Refresh'
            }

                   ],
            listeners: {

                click: function( _menu, _item, _e, _eOpts ) {
                   switch (_item.id) {
                        case 'new-domain':
                            alert("Add new domain");
                            break;
                        case 'collapse':
                            alert("Collapse");
                            break;
                        case 'refresh':
                            alert("Refresh");
                            break;
                        default:
                            alert("Default");
                            break;
                   }
                },
                hide:function(menu){
                    menu.destroy();
                }
            },
            defaults: {
               clickHideDelay: 1
            }
        });
        } else if (menuId.indexOf("tomcatMng_domain_") >= 0 && menuId.indexOf("_tomcat_") < 0) { //domain level
            mnuContext =  Ext.create("Ext.menu.Menu",{

            items: [{
                id: 'new-tomcat',
                text: 'New Tomcat'
            },
            {
                id: 'edit-domain',
                text: 'Edit'
            },
            {
                id: 'delete-domain',
                text: 'Delete'
            },
            {
                id:'expand',
                text:'Expand'
            },
            {
                id:'refresh',
                text:'Refresh'
            }

                   ],
            listeners: {
               click: function( _menu, _item, _e, _eOpts ) {
                   switch (_item.id) {
                        case 'new-tomcat':
                            alert("Add new tomcat");
                            break;
                        case 'edit-domain':
                            alert("Edit domain");
                            break;
                        case 'delete-domain':
                            alert("Delete domain");
                            break;
                        case 'expand':
                            alert("Expand");
                            break;
                        case 'refresh':
                            alert("Refresh");
                            break;
                    }
                },
                hide:function(menu){
                    menu.destroy();
                }
           },
           defaults: {
             clickHideDelay: 1
           }
        });

        }
        else if (menuId.indexOf("tomcatMng_domain_") >= 0 && menuId.indexOf("_tomcat_") >= 0) { //tomcat level
            mnuContext =  Ext.create("Ext.menu.Menu",{

            items: [{
                id: 'start-tomcat',
                text: 'Start'
            },
            {
                id: 'stop-tomcat',
                text: 'Stop'
            },
            {
                id: 'edit-tomcat',
                text: 'Edit'
            },
            {
                id: 'delete-tomcat',
                text: 'Delete'
            },
            {
                id:'refresh',
                text:'Refresh'
            }

                   ],
            listeners: {
                click: function( _menu, _item, _e, _eOpts ) {
                   switch (_item.id) {
                        case 'start-tomcat':
                            alert("Start tomcat");
                            break;
                        case 'stop-tomcat':
                            alert("Stop tomcat");
                            break;
                        case 'edit-tomcat':
                            alert("Edit tomcat");
                            break;
                        case 'delete-tomcat':
                            alert("Delete tomcat");
                            break;
                        case 'refresh':
                                alert("Refresh");
                            break;
                    }
                },
                hide:function(menu){
                    menu.destroy();
                }
           },
           defaults: {
             clickHideDelay: 1
           }
        });
        }

        if (mnuContext !== null){
            mnuContext.showAt(e.getXY());

        }
        e.stopEvent();

    },

    showMenu: function(menuId) {
        var activeItem = -1;

        if(menuId === "dashboard"){
            activeItem = 0;

        }else if(menuId === "tomcatInsts"){
            activeItem = 1;

        }else if (menuId === "usermnt"){
            activeItem = 4;
            Ext.getStore("UserStore").load();
        }

        if(activeItem > -1){
            Ext.getCmp("centerContainer").layout.setActiveItem(activeItem);
        }
    },

    loadChildMenus: function(parentId) {
        var url = GlobalData.urlPrefix;
        var is_child_leaf = false;
        var prefix_child_menu_id = "";
        var params = {};
        if (parentId.indexOf("tomcatMng") >=0 && parentId.length == "tomcatMng".length) {
            url+="/domain/list";
            is_child_leaf = false;
            prefix_child_menu_id = parentId + "_domain_";
        }
        else if (parentId.indexOf("tomcatMng_domain") >= 0) {
            var domainId = parentId.substr(parentId.lastIndexOf("_") + 1);
            params = {"domainId":domainId};
            url+="/domain/tomcatlist";
            is_child_leaf = true;
            prefix_child_menu_id = parentId + "_tomcat_";

        }
        else if (parentId.indexOf("monitoring_servers") >= 0) {
            url+="machine/list";
            is_child_leaf = true;
            prefix_child_menu_id = parentId + "_server_";
        }
        else if (parentId.indexOf("monitoring_tomcats") >= 0) {
            url+="tomcat/list";
            is_child_leaf = true;
            prefix_child_menu_id = parentId + "_tomcat_";
        }
        else {
             return;
        }

        var treePanel = Ext.getCmp("menuTreePanel");
        var parentNode = treePanel.getRootNode().findChild("menuId", parentId, true);
        if (parentNode === undefined || parentNode === null) {
            return;
        }
        //remove all childs
        parentNode.removeAll();
        //get data from ajax
        Ext.Ajax.request({
            url: url,
            params: params,
            method: "GET",
            success: function(resp, ops) {
                var response = Ext.decode(resp.responseText);
                for(i = 0; i < response.length; i ++){
                    parentNode.appendChild({"text":response[i].name, "menuId": prefix_child_menu_id + response[i].id, "leaf": is_child_leaf,"expanded":!is_child_leaf});
                }
            }
        });
    },

    loadDomainList: function(parentId) {
        alert("Domain list is loading");
    },

    loadTomcatList: function(domainId) {
        alert("Tomcat list of " + domainId + " is loading");
    },

    loadMonitoringServerList: function() {
        alert("Server list is loading");
    },

    loadMonitoringTomcatList: function() {
        alert("Monitoring tomcat list is loading");
    },

    init: function(application) {
        this.control({
            "#menuTreePanel": {
                itemclick: this.onTreepanelItemClick
            },
            "treepanel": {
                itemcontextmenu: this.onTreepanelItemContextMenu
            }
        });
    }

});
