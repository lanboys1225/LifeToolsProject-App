package com.bing.lan.user.ui.group;

import com.bing.lan.mainLib.base.MainLibFragmentPresenter;
import com.bing.lan.mainLib.comm.bean.Groups;
import com.bing.lan.mainLib.comm.bean.QueryDomain;
import com.ganxin.library.LoadDataLayout;

import java.util.List;

import static com.bing.lan.mainLib.cons.RequestActionCons.ACTION_LOAD_MORE_GROUP;
import static com.bing.lan.mainLib.cons.RequestActionCons.ACTION_UPDATE_GROUP;

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
    public void update() {
        requestData(ACTION_UPDATE_GROUP, 1);
    }

    @Override
    public void loadMore(int pageNum) {
        requestData(ACTION_LOAD_MORE_GROUP, pageNum);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(int action, Object data) {
        super.onSuccess(action, data);

        QueryDomain<Groups> queryDomain = (QueryDomain<Groups>) data;
        List<Groups> list = queryDomain.getList();

        switch (action) {
            case ACTION_UPDATE_GROUP:
                if (list == null || list.size() == 0) {
                    mView.setLoadDataLayoutStatus(LoadDataLayout.EMPTY);
                } else {
                    mView.updateList(queryDomain);
                }
                break;
            case ACTION_LOAD_MORE_GROUP:
                mView.loadMoreList(queryDomain);
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
