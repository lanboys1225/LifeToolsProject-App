package com.bing.lan.user.ui.login;

import com.bing.lan.mainLib.base.MainLibActivityPresenter;
import com.bing.lan.mainLib.comm.bean.LoginRegisterResultBean;

import static com.bing.lan.mainLib.cons.RequestActionCons.ACTION_LOGIN_REGISTER;

/**
 * @author 蓝兵
 */
public class LoginPresenter
        extends MainLibActivityPresenter<ILoginContract.ILoginView, ILoginContract.ILoginModule>
        implements ILoginContract.ILoginPresenter {

    @Override
    public void onStart(Object... params) {
    }

    @Override
    public void loginAndRegister(String phone, String password) {
        showProgressDialog("正在加载..");
        requestData(ACTION_LOGIN_REGISTER, phone, password);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(int action, Object data) {
        super.onSuccess(action, data);
        switch (action) {
            case ACTION_LOGIN_REGISTER:
                mView.loginAndRegisterSuccess((LoginRegisterResultBean) data);
                break;
        }
    }

    @Override
    public void onError(int action, Throwable e) {
        super.onError(action, e);
    }

    @Override
    public void onCompleted(int action) {
        super.onCompleted(action);
    }
}
