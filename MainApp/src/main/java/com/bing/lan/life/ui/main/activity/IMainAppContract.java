package com.bing.lan.life.ui.main.activity;

import com.bing.lan.mainLib.base.IMainLibActivityContract;

/**
 * @author 蓝兵
 */
public interface IMainAppContract {

    interface IMainAppView
            extends IMainLibActivityContract.IMainLibActivityView<IMainAppPresenter> {

    }

    interface IMainAppPresenter
            extends IMainLibActivityContract.IMainLibActivityPresenter<IMainAppView, IMainAppModule> {

    }

    interface IMainAppModule
            extends IMainLibActivityContract.IMainLibActivityModule {

    }
}
