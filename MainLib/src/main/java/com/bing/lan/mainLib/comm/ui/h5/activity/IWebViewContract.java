package com.bing.lan.mainLib.comm.ui.h5.activity;

import com.bing.lan.mainLib.base.IMainLibActivityContract;

/**
 * @author 蓝兵
 */
public interface IWebViewContract {

    interface IWebViewView
            extends IMainLibActivityContract.IMainLibActivityView<IWebViewPresenter> {

    }

    interface IWebViewPresenter
            extends IMainLibActivityContract.IMainLibActivityPresenter<IWebViewView, IWebViewModule> {

    }

    interface IWebViewModule
            extends IMainLibActivityContract.IMainLibActivityModule {

    }
}
