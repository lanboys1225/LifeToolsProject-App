package com.bing.lan.mainLib.base.test.fragment;

import com.bing.lan.mainLib.base.IMainLibFragmentContract;

/**
 * @author 蓝兵
 */
public interface IFragTestContract {

    interface IFragTestView extends IMainLibFragmentContract.IMainLibFragmentView<IFragTestPresenter> {

    }

    interface IFragTestPresenter extends
            IMainLibFragmentContract.IMainLibFragmentPresenter<IFragTestView, IFragTestModule> {

    }

    interface IFragTestModule extends IMainLibFragmentContract.IMainLibFragmentModule {

    }
}
