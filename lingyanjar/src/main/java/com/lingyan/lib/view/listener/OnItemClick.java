/**
 * Copyright 2013 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2013-5-2 下午2:02:48
 */
package com.lingyan.lib.view.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.lingyan.lib.app.Ioc;

public class OnItemClick extends OnListener implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        invoke(arg0, arg1, arg2, arg3);
    }

    @Override
    protected void listener(View view) {
        if (view instanceof ListView) {
            ((ListView) view).setOnItemClickListener(this);
        } else {
            Ioc.getIoc().getLogger().e(view.getClass() + " 无法设置OnItemClick 请检查InjectMethod的参数\n");
        }
    }
}
