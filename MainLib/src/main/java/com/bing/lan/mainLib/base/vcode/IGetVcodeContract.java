package com.bing.lan.mainLib.base.vcode;

import com.bing.lan.mainLib.base.IMainLibActivityContract;
import com.bing.lan.mainLib.cons.GetVCodeType;

/**
 * @author 蓝兵
 */
public interface IGetVcodeContract {

    interface IGetVcodeView<T extends IGetVcodePresenter>
            extends IMainLibActivityContract.IMainLibActivityView<T> {

        //void setVerificationStatus();

        void checkVcodeSuccess(boolean isSuccess);

        void getVcodeSuccess(boolean isSuccess);

        void updateWaitingVerificationCodeTime(int time);
    }

    interface IGetVcodePresenter<T extends IGetVcodeView, M extends IGetVcodeModule>
            extends IMainLibActivityContract.IMainLibActivityPresenter<T, M> {

        void updateWaitingVerificationCodeTime();

        void releaseTask(int code);

        void checkVcode(String phone, GetVCodeType type, String code);

        void getVcode(String phone, GetVCodeType type);

        void getForgetVcode(String phone, GetVCodeType type);
    }

    interface IGetVcodeModule
            extends IMainLibActivityContract.IMainLibActivityModule {

    }
}
