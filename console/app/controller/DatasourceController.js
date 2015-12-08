/*
 * File: app/controller/DatasourceController.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 5.0.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 5.0.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('webapp.controller.DatasourceController', {
    extend: 'Ext.app.Controller',

    control: {
        "#mybutton10": {
            click: 'onNewDatasourceClick'
        }
    },

    onNewDatasourceClick: function(button, e, eOpts) {

    },

    showLinkDatasourceWindow: function(type, id) {
        var window = Ext.create("widget.LinkNewDataSourceWindow");
        window.show();
        if(type ==='edit'){
            window.title = "Edit linking datasource";
        }
    }

});
