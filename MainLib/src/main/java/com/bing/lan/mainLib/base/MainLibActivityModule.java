package com.bing.lan.mainLib.base;

import com.bing.lan.comm.api.HttpResult;
import com.bing.lan.comm.mvp.BasePresenter;
import com.bing.lan.comm.mvp.activity.BaseActivityModule;
import com.bing.lan.comm.utils.LogUtil;

import java.util.Date;

/**
 * @author 蓝兵
 */

public abstract class MainLibActivityModule extends BaseActivityModule
        implements IMainLibActivityContract.IMainLibActivityModule {

    @Override
    public void onSuccess(int action, Object data) {
        if (presenter != null) {
            HttpResult<Object> result = (HttpResult<Object>) data;
            if (result == null) {
                onError(action, new BasePresenter.MvpHttpException("result 为空"));
                return;
            }

            int code = result.getCode();
            String message = result.getMsg();
            Date resultTime = result.getTime();

            // 响应码不正确
            if (HttpResult.HTTP_CODE_SUCCESS != code) {
                onError(action, new BasePresenter.MvpHttpException(message));
                return;
            }

            presenter.onSuccess(action, result.getData());
        }
    }

    protected static final LogUtil log1 = LogUtil.getLogUtil(MainLibActivityModule.class, LogUtil.LOG_VERBOSE);
}
