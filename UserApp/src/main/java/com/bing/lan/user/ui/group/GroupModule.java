package com.bing.lan.user.ui.group;

import com.bing.lan.comm.api.HttpResult;
import com.bing.lan.comm.rx.OnDataChangerListener;
import com.bing.lan.mainLib.api.ApiManager;
import com.bing.lan.mainLib.base.MainLibFragmentModule;
import com.bing.lan.mainLib.comm.bean.Groups;
import com.bing.lan.mainLib.comm.bean.QueryDomain;

import io.reactivex.Observable;

import static com.bing.lan.comm.cons.BaseCons.LIST_UPDATE_PAGE_SIZE;

/**
 * @author 蓝兵
 */
public class GroupModule extends MainLibFragmentModule
        implements IGroupContract.IGroupModule {

    @Override
    public void loadData(int action, OnDataChangerListener listener, Object... parameter) {
        super.loadData(action, listener, parameter);
        Observable<HttpResult<QueryDomain<Groups>>> observable = ApiManager.getInstance()
                .getApiService()
                .findAllGroupList(
                        (Integer) parameter[0],
                        LIST_UPDATE_PAGE_SIZE
                );
        subscribe(observable, action, listener, "群组列表");
    }
}
