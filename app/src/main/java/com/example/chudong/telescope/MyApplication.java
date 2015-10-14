
package com.example.chudong.telescope;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.example.chudong.telescope.controller.DemoHXSDKHelper;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

import cn.smssdk.SMSSDK;

public class MyApplication extends Application {

    public static Context applicationContext;
    private static MyApplication instance;
    // login user name
    public final String PREF_USERNAME = "username";

    /**
     * 当前用户nickname,为了苹果推送不是userid而是昵称
     */
    public static String currentUserNick = "";
    public static DemoHXSDKHelper hxSDKHelper = new DemoHXSDKHelper();

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        instance = this;
        hxSDKHelper.onInit(applicationContext);

        SMSSDK.initSDK(this, "ae2a69581c54", "f61844963f479dccfa34d43a5c9454ce");

        PushAgent mPushAgent = PushAgent.getInstance(applicationContext);
        mPushAgent.setMessageHandler(messageHandler);
    }

    //umeng 推送消息处理
    UmengMessageHandler messageHandler = new UmengMessageHandler() {

        public void dealWithCustomMessage(final Context context, final UMessage msg) {
            new Handler(getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, msg.custom, Toast.LENGTH_LONG).show();
                }
            });
        }
    };

    public static MyApplication getInstance() {
        return instance;
    }


    /**
     * 获取当前登陆用户名
     *
     * @return
     */
    public String getUserName() {
        return hxSDKHelper.getHXId();
    }

    /**
     * 获取密码
     *
     * @return
     */
    public String getPassword() {
        return hxSDKHelper.getPassword();
    }

    /**
     * 设置用户名
     *
     * @param username
     */
    public void setUserName(String username) {
        hxSDKHelper.setHXId(username);
    }

    /**
     * 设置密码 下面的实例代码 只是demo，实际的应用中需要加password 加密后存入 preference 环信sdk
     * 内部的自动登录需要的密码，已经加密存储了
     *
     * @param pwd
     */
    public void setPassword(String pwd) {
        hxSDKHelper.setPassword(pwd);
    }

    /**
     * 退出登录,清空数据
     */
    public void logout(final boolean isGCM, final EMCallBack emCallBack) {
        // 先调用sdk logout，在清理app中自己的数据
        hxSDKHelper.logout(isGCM, emCallBack);
    }
}
