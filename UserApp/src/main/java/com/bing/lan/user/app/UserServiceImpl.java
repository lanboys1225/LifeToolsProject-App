package com.bing.lan.user.app;

import com.bing.lan.mainLib.base.MainLibFragment;
import com.bing.lan.mainLib.comm.service.UserService;
import com.bing.lan.mainLib.cons.FragmentTitleCons;
import com.bing.lan.user.ui.group.GroupFragment;

/**
 * Created by 蓝兵 on 2018/3/21.
 */

public class UserServiceImpl implements UserService {

    @Override
    public MainLibFragment getUserFragment() {
        return null;
        //return UserFragment.newInstance(FragmentTitleCons.FRAGMENT_USER_TITLE);
    }

    @Override
    public MainLibFragment getGroupFragment() {
        return GroupFragment.newInstance(FragmentTitleCons.FRAGMENT_GROUP_TITLE);
    }
}
