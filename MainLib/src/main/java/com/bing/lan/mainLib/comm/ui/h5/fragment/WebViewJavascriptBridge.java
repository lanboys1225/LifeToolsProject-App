package com.bing.lan.mainLib.comm.ui.h5.fragment;

import android.os.Handler;
import android.os.Message;
import android.webkit.JavascriptInterface;

/**
 * Created by 蓝兵 on 2018/3/22.
 * js 交互方法
 */
public class WebViewJavascriptBridge {

    Handler handler;
    Html5Fragment html5Fragment;

    public WebViewJavascriptBridge(Handler handler, Html5Fragment html5Fragment) {
        this.handler = handler;
        this.html5Fragment = html5Fragment;
    }

    /**
     * 修改标题
     */
    @JavascriptInterface
    public void openAddPerson() {
        Message msg = new Message();
        msg.obj = "添加联系人";
        handler.sendMessage(msg);
        html5Fragment.isJsBrdge = true;
    }
}
