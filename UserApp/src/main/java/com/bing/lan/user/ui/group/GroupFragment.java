package com.bing.lan.user.ui.group;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bing.lan.comm.adapter.BaseRecyclerAdapter;
import com.bing.lan.mainLib.base.MainLibFragment;
import com.bing.lan.mainLib.comm.bean.Groups;
import com.bing.lan.mainLib.comm.bean.QueryDomain;
import com.bing.lan.user.R;
import com.bing.lan.user.ui.login.LoginActivity;
import com.ganxin.library.LoadDataLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;

import static com.bing.lan.comm.cons.BaseCons.LIST_LOAD_MORE_TIP;

/**
 * @author 蓝兵
 */
public class GroupFragment extends MainLibFragment<IGroupContract.IGroupPresenter>
        implements IGroupContract.IGroupView {

    //@BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    //@BindView(R.id.smartLayout)
    RefreshLayout mRefreshLayout;
    //@BindView(R.id.loadDataLayout)
    LoadDataLayout mLoadDataLayout;
    private ArrayList<Groups> mShopInfoBeen = new ArrayList<>();
    private ShopListAdapter mAdapter;
    private int mPageCount;
    private int mPageNum = 1;
    private int mTotalCount;

    public GroupFragment() {

    }

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

    @Override
    protected void initViewAndData(Intent intent, Bundle arguments) {

        mRecyclerView= mContentView.findViewById(R.id.recyclerView);
        mRefreshLayout= mContentView.findViewById(R.id.smartLayout);
        mLoadDataLayout= mContentView.findViewById(R.id.loadDataLayout);

        initRefreshLayout();
        initRecyclerView();
    }

    @Override
    protected void readyStartPresenter() {
        mPresenter.update();
    }

    private void initRefreshLayout() {
        mRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                if (mLoadDataLayout != null) {
                    mLoadDataLayout.setStatus(LoadDataLayout.SUCCESS);
                }
                mPresenter.update();
            }

            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if (mPageNum < mPageCount) {
                    mPresenter.loadMore(mPageNum + 1);
                } else {
                    showError(LIST_LOAD_MORE_TIP);
                    refreshlayout.finishLoadmore();
                }
            }
        });
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //https://github.com/yqritc/RecyclerView-FlexibleDivider

        mRecyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(Color.TRANSPARENT)
                        .sizeResId(R.dimen.dimen_recycleView_divider_10dp)
                        .marginResId(R.dimen.dimen_recycleView_divider_left_margin_10dp, R.dimen.dimen_recycleView_divider_right_margin_10dp)
                        .build());

        mAdapter = new ShopListAdapter();

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setDataAndRefresh(mShopInfoBeen);
        mAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onRecyclerViewItemClick(View v, int position) {
                Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void updateList(QueryDomain<Groups> queryDomain) {
        mPageCount = queryDomain.getTotalPages();
        mPageNum = queryDomain.getPageSize();
        mTotalCount = queryDomain.getTotalSize();

        mAdapter.setDataAndRefresh(queryDomain.getList());
        setEnableLoadMore();
    }

    public void setEnableLoadMore() {
        if (mRefreshLayout != null) {
            //mRefreshLayout.setEnableLoadmore(mPageNum < mPageCount);
            mRefreshLayout.setLoadmoreFinished(mPageNum >= mPageCount);
        }
    }

    @Override
    public void loadMoreList(QueryDomain<Groups> queryDomain) {
        mPageCount = queryDomain.getTotalPages();
        mPageNum = queryDomain.getPageSize();
        mTotalCount = queryDomain.getTotalSize();

        mAdapter.addDataAndRefresh(queryDomain.getList());
        setEnableLoadMore();
    }
}
