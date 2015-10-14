/**
 * Copyright 2013 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2013-5-2 �??2:02:48
 */
package com.lingyan.lib.view.listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.lingyan.lib.core.kernel.KernelDyna;

/**
 * @author absir
 */
public class OnTouch extends OnListener implements OnTouchListener {

    /*
     * (non-Javadoc)
     *
     * @see android.view.View.OnTouchListener#onTouch(android.view.View,
     * android.view.MotionEvent)
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return KernelDyna.to(invoke(v, event), boolean.class);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.absir.android.view.Listener.Listener#listener(android.view.View)
     */
    @Override
    protected void listener(View view) {
        // TODO Auto-generated method stub
        view.setOnTouchListener(this);
    }
}
