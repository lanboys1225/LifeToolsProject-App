package com.bing.lan.comm.api;

import com.google.gson.Gson;

import java.util.Date;

/**
 * 统一处理返回数据
 */
public class HttpResult<T> {

    public static final int HTTP_CODE_SUCCESS = 200;

    private int code;

    private String msg;

    private T data;

    private Date time;

    public static <T> HttpResult<T> objectFromData(String str) {

        return new Gson().fromJson(str, HttpResult.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
