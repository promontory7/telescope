/**
 * Copyright 2013 ABSir's Studio
 * <p/>
 * All right reserved
 * <p/>
 * Create on 2013-5-2 下午2:33:16
 */
package com.lingyan.lib.view.listener;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.lingyan.lib.app.Ioc;

/**
 * @author absir
 */
public class OnRadioChecked extends OnListener implements OnCheckedChangeListener {

    /*
     * (non-Javadoc)
     *
     * @see
     * android.widget.RadioGroup.OnCheckedChangeListener#onCheckedChanged(android
     * .widget.RadioGroup, int)
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // TODO Auto-generated method stub
        invoke(group, checkedId);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.absir.android.view.listener.Listener#listener(android.view.View)
     */
    @Override
    protected void listener(View view) {
        if (view instanceof RadioGroup) {
            ((RadioGroup) view).setOnCheckedChangeListener(this);
        } else {
            Ioc.getIoc().getLogger().e(view.getClass() + " 无法设置OnRadioChecked 请检查InjectMethod的参数\n");
        }
    }

}
