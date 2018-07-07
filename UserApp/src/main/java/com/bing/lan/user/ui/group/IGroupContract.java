package com.bing.lan.user.ui.group;

import com.bing.lan.mainLib.base.IMainLibFragmentContract;

/**
 * @author 蓝兵
 */
public interface IGroupContract {

    interface IGroupView extends IMainLibFragmentContract.IMainLibFragmentView<IGroupPresenter> {

    }

    interface IGroupPresenter extends
            IMainLibFragmentContract.IMainLibFragmentPresenter<IGroupView, IGroupModule> {

    }

    interface IGroupModule extends IMainLibFragmentContract.IMainLibFragmentModule {

    }
}
