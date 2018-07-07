package com.bing.lan.mainLib.base.test.activity;

import com.bing.lan.mainLib.base.IMainLibActivityContract;

/**
 * @author 蓝兵
 */
public interface IActivityTestContract {

    interface IActivityTestView
            extends IMainLibActivityContract.IMainLibActivityView<IActivityTestPresenter> {

    }

    interface IActivityTestPresenter
            extends IMainLibActivityContract.IMainLibActivityPresenter<IActivityTestView, IActivityTestModule> {

    }

    interface IActivityTestModule
            extends IMainLibActivityContract.IMainLibActivityModule {

    }
}
