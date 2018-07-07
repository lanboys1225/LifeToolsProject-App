package com.bing.lan.user.ui.login;

import com.bing.lan.comm.api.HttpResult;
import com.bing.lan.comm.rx.OnDataChangerListener;
import com.bing.lan.mainLib.api.ApiManager;
import com.bing.lan.mainLib.base.MainLibActivityModule;
import com.bing.lan.mainLib.comm.bean.LoginRegisterResultBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

import static com.bing.lan.mainLib.cons.RequestActionCons.ACTION_LOGIN_REGISTER;

/**
 * @author 蓝兵
 */
public class LoginModule extends MainLibActivityModule
        implements ILoginContract.ILoginModule {

    @Override
    public void loadData(int action, OnDataChangerListener listener, Object... parameter) {
        super.loadData(action, listener, parameter);

        switch (action) {
            case ACTION_LOGIN_REGISTER:
                loginAndRegister(action, listener, parameter);
                break;
        }
    }

    private void loginAndRegister(int action, OnDataChangerListener listener, Object[] parameter) {
        Map<String, String> params = new HashMap<>();
        checkNotNullAdd(params, (String) parameter[0], "phone");
        checkNotNullAdd(params, (String) parameter[1], "password");

        Observable<HttpResult<LoginRegisterResultBean>> observable = ApiManager.getInstance()
                .getApiService()
                .loginAndRegister(params);

        subscribe(observable, action, listener, "登录注册..");
    }
}
