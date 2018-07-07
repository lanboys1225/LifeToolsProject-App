package com.bing.lan.life.ui.main.activity;

import com.bing.lan.comm.rx.OnDataChangerListener;
import com.bing.lan.mainLib.base.MainLibActivityModule;

/**
 * @author 蓝兵
 */
public class MainAppModule extends MainLibActivityModule
        implements IMainAppContract.IMainAppModule {

    @Override
    public void loadData(int action, OnDataChangerListener listener, Object... parameter) {
        super.loadData(action, listener, parameter);
    }
}
