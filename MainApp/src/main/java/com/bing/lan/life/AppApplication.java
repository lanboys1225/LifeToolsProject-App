package com.bing.lan.life;

import com.bing.lan.comm.app.BaseApplication;
import com.bing.lan.mainLib.cons.UIRouterCons;
import com.luojilab.component.componentlib.router.ui.UIRouter;

public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        UIRouter.getInstance().registerUI(UIRouterCons.APP_HOST);

        //如果isRegisterCompoAuto为false，则需要通过反射加载组件
        //        Router.registerComponent("com.luojilab.reader.applike.ReaderAppLike");
        //        Router.registerComponent("com.luojilab.share.applike.ShareApplike");
    }

    @Override
    protected boolean getLogDebug() {
        return true;
    }
}
