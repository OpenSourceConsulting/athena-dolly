/*
 * File: app/controller/sessionDataController.js
 *
 * This file was generated by Sencha Architect version 3.0.4.
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

Ext.define('webapp.controller.sessionDataController', {
    extend: 'Ext.app.Controller',

    refs: [
        {
            ref: 'centerContainer',
            selector: '#centerContainer'
        },
        {
            ref: 'detailPanel',
            selector: '#detailPanel'
        },
        {
            ref: 'dashboardBtn',
            selector: '#dashboardBtn'
        },
        {
            ref: 'sessionDataBtn',
            selector: '#sessionDataBtn'
        },
        {
            ref: 'sessionDataGrid',
            selector: '#sessionDataGrid'
        },
        {
            ref: 'sessionDataField',
            selector: '#sessionDataField'
        }
    ],

    click: function(button, e, eOpts) {
        /**
         * Session Data List 메뉴 버튼 클릭 시 수행되는 function
         */
        var centerContainer = this.getCenterContainer(),
            dashboardBtn = this.getDashboardBtn(),
            sessionDataBtn = this.getSessionDataBtn();

        // 현재 선택된 item이 sessionDataPanel일 경우 무시한다.
        if (centerContainer.layout.getActiveItem().itemId === "sessionDataPanel") {
            sessionDataBtn.toggle(true);
            return;
        }

        dashboardBtn.toggle(false);
        centerContainer.layout.setActiveItem(1);

        var me = this;
        me.loadSessionList();
    },

    select: function(rowmodel, record, index, eOpts) {
        /**
         * Session Data List에서 특정 세션 선택 시 해당 세션의 내용을 조회하고 Detail Panel에 보여주기 위한 function
         */
        var detailPanel = this.getDetailPanel();
        var sessionDataField = this.getSessionDataField();

        detailPanel.setLoading(true);


        // JSON Pretty Format으로 세션 상세 내용을 보여주기 위해 설정
        if (!library) {
           var library = {};
        }

        library.json = {
           replacer: function(match, pIndent, pKey, pVal, pEnd) {
              var key = '<span class=json-key>';
              var val = '<span class=json-value>';
              var str = '<span class=json-string>';
              var r = pIndent || '';
              if (pKey)
                 r = r + key + pKey.replace(/[": ]/g, '') + '</span>: ';
              if (pVal)
                 r = r + (pVal[0] == '"' ? str : val) + pVal + '</span>';
              return r + (pEnd || '');
           },
           prettyPrint: function(obj) {
              var jsonLine = /^( *)("[\w]+": )?("[^"]*"|[\w.+-]*)?([,[{])?$/mg;
              return JSON.stringify(obj, null, 5)
                 .replace(/&/g, '&amp;').replace(/\\"/g, '&quot;')
                 .replace(/</g, '&lt;').replace(/>/g, '&gt;')
                 .replace(jsonLine, library.json.replacer);
           }
        };


        Ext.Ajax.request({
            url: GlobalData.urlPrefix + 'getSessionData?key=' + record.get('key'),
            params: {
            },
            success: function(response, opts){
                detailPanel.setLoading(false);

                if (detailPanel.collapsed !== false) {
                    detailPanel.toggleCollapse();
                }

                var result = "<h2>" + response.responseText + "</h2>";
                sessionDataField.setValue("<pre>" + library.json.prettyPrint(Ext.decode(response.responseText)) + "</pre>");
            },
            failure: function(response, opts) {
                detailPanel.setLoading(false);
                sessionDataField.setValue(null);
                Ext.Msg.alert('Error', 'Server-side failure with status code ' + response.status);
            }
        });

    },

    onToolClick: function(tool, e, eOpts) {
        /**
         * Session Data List를 refresh 하기 위해 panel의 refresh tool을 활성화
         */
        var me = this;
        me.loadSessionList();
    },

    loadSessionList: function() {
        /**
         * Session Data List를 refresh 하기 위한 function
         */
        var sessionDataGrid = this.getSessionDataGrid(),
            detailPanel = this.getDetailPanel();

        if (detailPanel.collapsed === false) {
            detailPanel.toggleCollapse();
        }

        sessionDataGrid.setLoading(true);

        Ext.Ajax.request({
            url: GlobalData.urlPrefix + 'getSessionKeyList',
            params: {
            },
            success: function(response, opts) {
                sessionDataGrid.setLoading(false);
                var obj = Ext.decode(response.responseText);
                var store = Ext.data.StoreManager.lookup('sessionDataStore');
                store.loadData(obj);
                sessionDataGrid.update();
            },
            failure: function(response, opts) {
                sessionDataGrid.setLoading(false);
                Ext.Msg.alert('Error', 'Server-side failure with status code ' + response.status);
            }
        });
    },

    init: function(application) {
        this.control({
            "#sessionDataBtn": {
                click: this.click
            },
            "#sessionDataGrid": {
                select: this.select
            },
            "#refreshTool": {
                click: this.onToolClick
            }
        });
    }

});