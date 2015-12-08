/*
 * File: app/view/MonitoringTomcatInstance.js
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

Ext.define('webapp.view.MonitoringTomcatInstance', {
    extend: 'Ext.container.Container',
    alias: 'widget.monitoringtomcatinstance',

    requires: [
        'webapp.view.MonitoringTomcatInstanceViewModel',
        'Ext.toolbar.Toolbar',
        'Ext.form.Label',
        'Ext.tab.Panel',
        'Ext.tab.Tab',
        'Ext.menu.Menu',
        'Ext.menu.Item',
        'Ext.chart.CartesianChart',
        'Ext.chart.axis.Category',
        'Ext.chart.axis.Numeric',
        'Ext.chart.series.Bar',
        'Ext.chart.Legend',
        'Ext.chart.series.Line'
    ],

    viewModel: {
        type: 'monitoringtomcatinstance'
    },

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [
        {
            xtype: 'toolbar',
            flex: 0.5,
            height: 50,
            items: [
                {
                    xtype: 'label',
                    text: 'Monitoring > Tomcat instance'
                }
            ]
        },
        {
            xtype: 'tabpanel',
            flex: 9.5,
            id: 'tabPanel2',
            itemId: 'tabPanel',
            activeTab: 0,
            items: [
                {
                    xtype: 'panel',
                    title: 'Availability',
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'top',
                            items: [
                                {
                                    xtype: 'label',
                                    text: 'Availability Hisotry in '
                                },
                                {
                                    xtype: 'button',
                                    text: 'Last 24 hours',
                                    menu: {
                                        xtype: 'menu',
                                        items: [
                                            {
                                                xtype: 'menuitem',
                                                text: 'Last 30 days'
                                            }
                                        ]
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'cartesian',
                            dock: 'top',
                            height: 250,
                            width: 400,
                            insetPadding: 20,
                            axes: [
                                {
                                    type: 'category',
                                    fields: [
                                        'x'
                                    ],
                                    position: 'left'
                                },
                                {
                                    type: 'numeric',
                                    fields: [
                                        'y1',
                                        'y2',
                                        'y3'
                                    ],
                                    title: 'Numeric Axis',
                                    position: 'bottom'
                                }
                            ],
                            series: [
                                {
                                    type: 'bar',
                                    xField: 'x',
                                    yField: [
                                        'y1',
                                        'y2',
                                        'y3'
                                    ]
                                }
                            ],
                            legend: {
                                xtype: 'legend'
                            }
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    autoScroll: true,
                    title: 'Performance',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            flex: 0.5,
                            dock: 'top',
                            items: [
                                {
                                    xtype: 'label',
                                    text: 'Tracking in '
                                },
                                {
                                    xtype: 'button',
                                    text: 'Last 24 hours',
                                    menu: {
                                        xtype: 'menu',
                                        items: [
                                            {
                                                xtype: 'menuitem',
                                                text: 'Last 30 days'
                                            }
                                        ]
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            flex: 4.5,
                            dock: 'top',
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            items: [
                                {
                                    xtype: 'panel',
                                    flex: 1,
                                    width: 1226,
                                    title: 'Used Memory',
                                    dockedItems: [
                                        {
                                            xtype: 'cartesian',
                                            dock: 'top',
                                            height: 275,
                                            width: 400,
                                            insetPadding: 20,
                                            axes: [
                                                {
                                                    type: 'category',
                                                    fields: [
                                                        'x'
                                                    ],
                                                    title: 'Category Axis',
                                                    position: 'bottom'
                                                },
                                                {
                                                    type: 'numeric',
                                                    fields: [
                                                        'y'
                                                    ],
                                                    title: 'Numeric Axis',
                                                    position: 'bottom'
                                                }
                                            ],
                                            series: [
                                                {
                                                    type: 'line',
                                                    xField: 'x',
                                                    yField: [
                                                        'y'
                                                    ],
                                                    smooth: 3
                                                },
                                                {
                                                    type: 'line',
                                                    xField: 'x',
                                                    yField: [
                                                        'y'
                                                    ],
                                                    smooth: 3
                                                }
                                            ],
                                            legend: {
                                                xtype: 'legend'
                                            }
                                        }
                                    ]
                                },
                                {
                                    xtype: 'panel',
                                    flex: 1,
                                    width: 1226,
                                    title: 'Average Processing Time',
                                    dockedItems: [
                                        {
                                            xtype: 'cartesian',
                                            dock: 'top',
                                            height: 276,
                                            width: 400,
                                            insetPadding: 20,
                                            axes: [
                                                {
                                                    type: 'category',
                                                    fields: [
                                                        'x'
                                                    ],
                                                    title: 'Category Axis',
                                                    position: 'bottom'
                                                },
                                                {
                                                    type: 'numeric',
                                                    fields: [
                                                        'y'
                                                    ],
                                                    title: 'Numeric Axis',
                                                    position: 'bottom'
                                                }
                                            ],
                                            series: [
                                                {
                                                    type: 'line',
                                                    xField: 'x',
                                                    yField: [
                                                        'y'
                                                    ],
                                                    smooth: 3
                                                },
                                                {
                                                    type: 'line',
                                                    xField: 'x',
                                                    yField: [
                                                        'y'
                                                    ],
                                                    smooth: 3
                                                }
                                            ],
                                            legend: {
                                                xtype: 'legend'
                                            }
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            flex: 5,
                            dock: 'top',
                            width: 400,
                            collapsible: true,
                            manageHeight: false,
                            title: 'Health history',
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            dockedItems: [
                                {
                                    xtype: 'toolbar',
                                    dock: 'top',
                                    items: [
                                        {
                                            xtype: 'label',
                                            text: 'Filtering in'
                                        },
                                        {
                                            xtype: 'button',
                                            text: 'Last 24 hours',
                                            menu: {
                                                xtype: 'menu',
                                                items: [
                                                    {
                                                        xtype: 'menuitem',
                                                        text: 'Lst 30 days'
                                                    }
                                                ]
                                            }
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]

});