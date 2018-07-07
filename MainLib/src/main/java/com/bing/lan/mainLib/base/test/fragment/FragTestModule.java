package com.bing.lan.mainLib.base.test.fragment;

import com.bing.lan.comm.rx.OnDataChangerListener;
import com.bing.lan.mainLib.base.MainLibFragmentModule;

/**
 * @author 蓝兵
 */
public class FragTestModule extends MainLibFragmentModule
        implements IFragTestContract.IFragTestModule {

    @Override
    public void loadData(int action, OnDataChangerListener listener, Object... parameter) {
        super.loadData(action, listener, parameter);

    }
}
