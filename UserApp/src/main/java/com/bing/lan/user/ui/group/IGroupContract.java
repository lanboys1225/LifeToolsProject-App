package com.bing.lan.user.ui.group;

import com.bing.lan.mainLib.base.IMainLibFragmentContract;
import com.bing.lan.mainLib.comm.bean.Groups;
import com.bing.lan.mainLib.comm.bean.QueryDomain;

/**
 * @author 蓝兵
 */
public interface IGroupContract {

    interface IGroupView extends IMainLibFragmentContract.IMainLibFragmentView<IGroupPresenter> {

        void updateList(QueryDomain<Groups> queryDomain);

        void loadMoreList(QueryDomain<Groups> queryDomain);
    }

    interface IGroupPresenter extends
            IMainLibFragmentContract.IMainLibFragmentPresenter<IGroupView, IGroupModule> {

        void update();

        void loadMore(int pageNum);
    }

    interface IGroupModule extends IMainLibFragmentContract.IMainLibFragmentModule {

    }
}
