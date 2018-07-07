package com.bing.lan.user.ui.login;

import com.bing.lan.mainLib.base.IMainLibActivityContract;
import com.bing.lan.mainLib.comm.bean.LoginRegisterResultBean;

/**
 * @author 蓝兵
 */
public interface ILoginContract {

    interface ILoginView
            extends IMainLibActivityContract.IMainLibActivityView<ILoginPresenter> {

        void loginAndRegisterSuccess(LoginRegisterResultBean loginRegisterResultBean);
    }

    interface ILoginPresenter
            extends IMainLibActivityContract.IMainLibActivityPresenter<ILoginView, ILoginModule> {

        void loginAndRegister(String phone, String password);
    }

    interface ILoginModule
            extends IMainLibActivityContract.IMainLibActivityModule {

    }
}
