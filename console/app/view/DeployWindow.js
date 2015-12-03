/*
 * File: app/view/DeployWindow.js
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

Ext.define('webapp.view.DeployWindow', {
    extend: 'Ext.window.Window',

    height: 119,
    width: 400,
    layout: {
        type: 'border'
    },
    title: 'Deploy',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            dockedItems: [
                {
                    xtype: 'container',
                    margins: '10',
                    dock: 'top',
                    items: [
                        {
                            xtype: 'filefield',
                            margin: 10,
                            width: 366,
                            fieldLabel: 'Label'
                        },
                        {
                            xtype: 'button',
                            margin: '0 0 10 100',
                            text: 'Deploy'
                        },
                        {
                            xtype: 'button',
                            margin: '0 0 10 10 ',
                            text: 'Cancel'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});