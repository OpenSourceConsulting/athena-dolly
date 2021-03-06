/*
 * File: app/controller/LoginController.js
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

Ext.define('webapp.controller.LoginController', {
    extend: 'Ext.app.Controller',

    onIntroContainerActivate: function(component, eOpts) {
        //Login Session Check
        var me = this;

        Ext.Ajax.request({
            url: GlobalData.urlPrefix + 'user/onAfterLogin',
            success: function(resp, ops) {

                var response = Ext.decode(resp.responseText);
                me.successfulLogin(response.data, "json");

            },
            failure: function(resp, ops){

                // maybe 403 에러
                // Create new login form window
                var login = Ext.create("widget.loginWindow");

                // Show window
                login.show();

                Ext.getCmp("loginForm").getForm().findField("userName").focus();
            }
        });



    },

    onLoginClick: function(button, e, eOpts) {

        var form = Ext.getCmp("loginForm"),			// Login form
            formWindow = Ext.getCmp('loginWindow'),	// Login form window
            values = form.getValues();				// Form values

        var me = this;

        var userName = form.getForm().findField("userName"),
            password = form.getForm().findField("password");

        var userNameVal = userName.getValue(),
            passwordVal = password.getValue();


        // login Failure
        var failureCallback = function(resp, ops) {

            var msg = "로그인에 실패하였습니다.";
            if(resp.msg !== null) {
                msg = resp.msg;
            }
            // Show login failure error
            Ext.Msg.alert({
                title: "Login Failure",
                msg: msg,
                buttons: Ext.Msg.OK,
                fn: function(choice) {
                    password.setValue("");
                    password.focus();
                },
                icon: Ext.Msg.ERROR
            });
        };

        if (userNameVal === "") {

            // username must not be null.
            Ext.Msg.show({
                title: "Message",
                msg: "사용자아이디를 입력해주세요.",
                buttons: Ext.Msg.OK,
                fn: function(choice) {
                    userName.focus();
                },
                icon: Ext.Msg.WARNING
            });
        } else if (passwordVal === "") {

            // password must not be null.
            Ext.Msg.show({
                title: "Message",
                msg: "비밀번호를 입력해주세요.",
                buttons: Ext.Msg.OK,
                fn: function(choice) {
                    password.focus();
                },
                icon: Ext.Msg.WARNING
            });
        } else {


            //request login
            Ext.Ajax.request({
                url: GlobalData.urlPrefix + "user/login",
                params: values,
                success: function(resp, ops) {

                    var response = Ext.decode(resp.responseText);
                    if(response.success){
                        me.successfulLogin(response.data, "json");
                    }
                    else {
                        failureCallback(response, ops);
                    }

                },
                failure: failureCallback
            });

        }
    },

    onLogoutButtonClick: function(button, e, eOpts) {
        Ext.Ajax.request({
            url: GlobalData.urlPrefix + 'user/logout',
            disableCaching : true,
            success: function(response){
                /*

                var sessionInfo = Ext.getStore('SessionStore');
                sessionInfo.removeAll();
                sessionInfo.sync();

                */

                window.location.reload();

            }
        });

    },

    onTextfieldSpecialkey: function(field, e, eOpts) {
        if (e.getKey() == e.ENTER) {
            this.onLoginClick();
        }
    },

    successfulLogin: function(session, ops) {

        GlobalData.isLoginded = true;

        //Login Session 설정
        this.session = session;



        var newRecord;
        if(ops == 'json') {

            newRecord = Ext.create("model.UserModel", this.session);

        } else {

            newRecord = this.session;
        }


        // Close window
        var loginWindow = Ext.getCmp('loginWindow');
        if(loginWindow !== undefined) {
            loginWindow.destroy();
        }

        //Main Layout 설정
        Ext.getCmp("dollyViewport").layout.setActiveItem(1);
        Ext.getCmp("topUsername").setText(newRecord.get("username"));
        //Ext.getCmp("topLastLogonLabel").setText("(최근 접속시간 : "+newRecord.get("lastLogon")+")");

        //Menu 권한 설정
        //this.initMenuAuthSetting();
    },

    init: function(application) {
        this.control({
            "#introContainer": {
                activate: this.onIntroContainerActivate
            },
            "#loginBtn": {
                click: this.onLoginClick
            },
            "#logoutBtn": {
                click: this.onLogoutButtonClick
            },
            "#password": {
                specialkey: this.onTextfieldSpecialkey
            }
        });
    }

});
