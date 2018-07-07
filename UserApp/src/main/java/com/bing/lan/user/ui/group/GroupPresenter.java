package com.bing.lan.user.ui.group;

import com.bing.lan.mainLib.base.MainLibFragmentPresenter;

/**
 * @author 蓝兵
 */
public class GroupPresenter extends
        MainLibFragmentPresenter<IGroupContract.IGroupView, IGroupContract.IGroupModule>
        implements IGroupContract.IGroupPresenter {

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
