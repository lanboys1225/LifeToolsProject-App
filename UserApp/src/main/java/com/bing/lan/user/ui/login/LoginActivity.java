package com.bing.lan.user.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bing.lan.comm.view.MyToolbar;
import com.bing.lan.mainLib.base.MainLibActivity;
import com.bing.lan.mainLib.comm.bean.LoginRegisterResultBean;
import com.bing.lan.user.R;

/**
 * @author 蓝兵
 */
public class LoginActivity extends MainLibActivity<ILoginContract.ILoginPresenter>
        implements ILoginContract.ILoginView {

    MyToolbar mToolbar;
    private Button mBtn_login;
    private EditText mEt_password;
    private EditText mEt_phone;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected ILoginContract.ILoginPresenter initPresenter() {
        LoginPresenter presenter = new LoginPresenter();
        presenter.setModule(new LoginModule());
        presenter.onAttachView(this);
        return presenter;
    }

    @Override
    protected void initViewAndData(Intent intent) {
        mToolbar = findViewById(R.id.toolbar);
        mEt_phone = findViewById(R.id.et_phone);
        mEt_password = findViewById(R.id.et_password);
        mBtn_login = findViewById(R.id.btn_login);

        setToolBar(mToolbar, "登录", true, 0);
        mEt_phone.setText("13556000000");
        mEt_password.setText("12345");

        mBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loginAndRegister(mEt_phone.getText().toString().trim(), mEt_password.getText().toString().trim());
            }
        });
    }

    @Override
    protected void readyStartPresenter() {

    }

    @Override
    public void loginAndRegisterSuccess(LoginRegisterResultBean loginRegisterResultBean) {
        showToast("登录成功");
        finish();
    }
}
