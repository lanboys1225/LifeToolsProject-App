package com.bing.lan.user.app;

import com.bing.lan.mainLib.comm.service.UserService;
import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;

import static com.bing.lan.mainLib.cons.UIRouterCons.USER_HOST;

public class UserAppLike implements IApplicationLike {

    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        uiRouter.registerUI(USER_HOST);
        router.addService(UserService.class.getSimpleName(), new UserServiceImpl());
    }

    @Override
    public void onStop() {
        uiRouter.unregisterUI(USER_HOST);
        router.removeService(UserService.class.getSimpleName());
    }
}
