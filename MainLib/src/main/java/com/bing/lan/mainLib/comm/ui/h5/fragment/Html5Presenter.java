package com.bing.lan.mainLib.comm.ui.h5.fragment;

import com.bing.lan.mainLib.base.MainLibFragmentPresenter;

/**
 * @author 蓝兵
 */
public class Html5Presenter extends
        MainLibFragmentPresenter<IHtml5Contract.IHtml5View, IHtml5Contract.IHtml5Module>
        implements IHtml5Contract.IHtml5Presenter {

    @Override
    public void onStart(Object... params) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(int action, Object data) {
        super.onSuccess(action, data);
        switch (action) {
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
