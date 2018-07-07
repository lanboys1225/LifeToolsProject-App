package com.bing.lan.mainLib.base.test.activity;

import com.bing.lan.comm.rx.OnDataChangerListener;
import com.bing.lan.mainLib.base.MainLibActivityModule;

/**
 * @author 蓝兵
 */
public class ActivityTestModule extends MainLibActivityModule
        implements IActivityTestContract.IActivityTestModule {

    @Override
    public void loadData(int action, OnDataChangerListener listener, Object... parameter) {
        super.loadData(action, listener, parameter);
    }
}
