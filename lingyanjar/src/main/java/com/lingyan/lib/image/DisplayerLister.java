package com.lingyan.lib.image;

import android.graphics.Bitmap;
import android.widget.ImageView;

public abstract class DisplayerLister {

    /**
     * 开始下载图片 如需要请重写
     *
     * @param imageView
     * @return void
     * @author gdpancheng@gmail.com 2014-2-11 上午11:03:30
     */
    public void startLoader(ImageView imageView) {
    }

    ;

    /**
     * 图片加载完成 回调的函数
     *
     * @param bitmap
     * @param imageView
     * @return Bitmap
     * @author gdpancheng@gmail.com 2014-2-11 上午11:03:52
     */
    public void finishLoader(Bitmap bitmap, ImageView imageView) {
    }

    ;

    /**
     * 下载进度 如果需要请重写
     *
     * @param progress
     * @return void
     * @author gdpancheng@gmail.com 2014-2-11 上午11:31:44
     */
    public void progressLoader(int progress, ImageView imageView) {
    }

    ;

    /**
     * 图片加载失败回调函数 如需要请重写
     *
     * @param imageView
     * @return void
     * @author gdpancheng@gmail.com 2014-2-11 上午11:03:22
     */
    public void failLoader(ImageView imageView) {

    }

    ;

}
