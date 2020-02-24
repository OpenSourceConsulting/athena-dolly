/*
 * File: app/view/createViewWindow.js
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

Ext.define('webapp.view.createViewWindow', {
    extend: 'Ext.window.Window',
    alias: 'widget.createViewWindow',

    requires: [
        'Ext.panel.Panel',
        'Ext.form.Label',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Spacer',
        'Ext.button.Button'
    ],

    height: 264,
    id: 'createViewWindow',
    itemId: 'createViewWindow',
    width: 400,
    resizable: false,
    layout: 'fit',
    title: 'Create View',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    margin: '10 10 10 10',
                    layout: 'absolute',
                    items: [
                        {
                            xtype: 'label',
                            x: 10,
                            y: 10,
                            html: '<font size=\'4pt\'><b>Design Document Name :</b></font>'
                        },
                        {
                            xtype: 'textfield',
                            x: 20,
                            y: 40,
                            height: 30,
                            id: 'designDocumentName',
                            itemId: 'designDocumentName',
                            width: 330,
                            hideLabel: true
                        },
                        {
                            xtype: 'label',
                            x: 10,
                            y: 90,
                            html: '<font size=\'4pt\'><b>View Name :</b></font>'
                        },
                        {
                            xtype: 'textfield',
                            x: 20,
                            y: 120,
                            height: 30,
                            id: 'viewName',
                            itemId: 'viewName',
                            width: 330,
                            hideLabel: true
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            x: 73,
                            dock: 'bottom',
                            items: [
                                {
                                    xtype: 'tbspacer',
                                    flex: 1
                                },
                                {
                                    xtype: 'button',
                                    id: 'viewPopupSaveBtn',
                                    itemId: 'viewPopupSaveBtn',
                                    width: 60,
                                    text: 'Create'
                                },
                                {
                                    xtype: 'button',
                                    id: 'viewPopupCancelBtn',
                                    itemId: 'viewPopupCancelBtn',
                                    width: 60,
                                    text: 'Cancel'
                                },
                                {
                                    xtype: 'tbspacer',
                                    flex: 1
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});