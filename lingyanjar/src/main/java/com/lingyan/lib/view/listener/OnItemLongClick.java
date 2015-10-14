/**
 * Copyright 2013 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2013-5-2 下午2:08:39
 */
package com.lingyan.lib.view.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.lingyan.lib.app.Ioc;
import com.lingyan.lib.core.kernel.KernelDyna;

/**
 * @author absir
 */
public class OnItemLongClick extends OnListener implements OnItemLongClickListener {

    /*
     * (non-Javadoc)
     *
     * @see
     * android.widget.AdapterView.OnItemLongClickListener#onItemLongClick(android
     * .widget.AdapterView, android.view.View, int, long)
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        return KernelDyna.to(invoke(arg0, arg1, arg2, arg3), boolean.class);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.absir.android.view.Listener.Listener#listener(android.view.View)
     */
    @Override
    protected void listener(View view) {
        // TODO Auto-generated method stub
        if (view instanceof ListView) {
            ((ListView) view).setOnItemLongClickListener(this);
        } else {
            Ioc.getIoc().getLogger().e(view.getClass() + " 无法设置onItemLongClick 请检查InjectMethod的参数\n");
        }
    }

}
