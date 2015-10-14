/**
 * Copyright 2013 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2013-5-2 上午9:37:59
 */
package com.lingyan.lib.view.listener;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author absir
 */
public class OnClick extends OnListener implements OnClickListener {

    @Override
    public void onClick(View v) {
        invoke(v);
    }

    @Override
    public void listener(View view) {
        view.setOnClickListener(this);
    }
}
