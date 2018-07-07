package com.bing.lan.user.ui.group;

import com.bing.lan.comm.rx.OnDataChangerListener;
import com.bing.lan.mainLib.base.MainLibFragmentModule;

/**
 * @author 蓝兵
 */
public class GroupModule extends MainLibFragmentModule
        implements IGroupContract.IGroupModule {

    @Override
    public void loadData(int action, OnDataChangerListener listener, Object... parameter) {
        super.loadData(action, listener, parameter);

    }
}
