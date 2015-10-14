package com.lingyan.lib.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

/*
 */
public class BaseFragment extends Fragment {

    protected LayoutInflater inflater;
    protected Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }
}
