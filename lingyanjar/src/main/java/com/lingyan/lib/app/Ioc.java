package com.lingyan.lib.app;

import java.util.Properties;

import android.app.Application;

import com.lingyan.util.Handler_Properties;
import com.lingyan.util.Logger;

public class Ioc {
    /**
     * Application对象
     */
    private Application application;
    private static Ioc ioc;
    private Logger logger = null;
    /**
     * 默认高度和宽度,所有的缩放比根据这个常数来获得
     */
    private int mode_w = 480;
    private int mode_h = 800;

    public Application getApplication() {
        return application;
    }

    public Logger getLogger() {
        return logger;
    }

    public static Ioc getIoc() {
        if (ioc == null) {
            ioc = new Ioc();
        }
        return ioc;
    }

    public void init(Application app) {

        long time = System.currentTimeMillis();
        // registerActivityLifecycleCallbacks(callbacks);
        application = app;
        logger = Logger.getLogger("debug");
        // 读取配置文件
        Properties properties = Handler_Properties.loadConfigAssets("mvc.properties");
        if (properties != null && properties.containsKey("standard_w")) {
            mode_w = Integer.valueOf(properties.get("standard_w").toString());
        }
        if (properties != null && properties.containsKey("standard_h")) {
            mode_h = Integer.valueOf(properties.get("standard_h").toString());
        }
        // --------------------------------------------------------------------------------------------------
        // 是否打开兼容模式
        boolean iscompatible = false;
        if (properties != null && properties.containsKey("iscompatible")) {
            iscompatible = Boolean.valueOf(properties.get("iscompatible").toString());
        }
        // --------------------------------------------------------------------------------------------------
        logger.d("appliaction 加载时间为:" + (System.currentTimeMillis() - time));
    }


    public int getMode_w() {
        return mode_w;
    }

    public void setMode_w(int mode_w) {
        this.mode_w = mode_w;
    }

    public int getMode_h() {
        return mode_h;
    }

    public void setMode_h(int mode_h) {
        this.mode_h = mode_h;
    }

}
