package com.bing.lan.mainLib.comm.service;

import com.bing.lan.mainLib.base.MainLibFragment;

/**
 * Created by 蓝兵 on 2018/3/21.
 */

public interface UserService extends ComponentService {

    MainLibFragment getUserFragment();

    MainLibFragment getGroupFragment();
}
