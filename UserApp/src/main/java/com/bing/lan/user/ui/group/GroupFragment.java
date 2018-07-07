package com.bing.lan.user.ui.group;

import android.content.Intent;
import android.os.Bundle;

import com.bing.lan.mainLib.base.MainLibFragment;
import com.bing.lan.user.R;

/**
 * @author 蓝兵
 */
public class GroupFragment extends MainLibFragment<IGroupContract.IGroupPresenter>
        implements IGroupContract.IGroupView {

    public GroupFragment() {

    }

    //Bundle args = new Bundle();
    //    args.putString("fragment标题", title);
    //    fragment.setArguments(args);

    public static GroupFragment newInstance(String title) {
        GroupFragment fragment = new GroupFragment();
        fragment.setTitle(title);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_user_app;
    }

    @Override
    protected IGroupContract.IGroupPresenter initPresenter() {
        GroupPresenter presenter = new GroupPresenter();
        presenter.setModule(new GroupModule());
        presenter.onAttachView(this);
        return presenter;
    }

    // @Override
    // protected void startInject(FragmentComponent fragmentComponent) {
    //     //        fragmentComponent.inject(this);
    // }

    @Override
    protected void initViewAndData(Intent intent, Bundle arguments) {

    }

    @Override
    protected void readyStartPresenter() {

    }
}
