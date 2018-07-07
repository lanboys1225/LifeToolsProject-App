package com.bing.lan.mainLib.api;

import com.bing.lan.comm.api.HttpResult;
import com.bing.lan.mainLib.comm.bean.Groups;
import com.bing.lan.mainLib.comm.bean.LoginRegisterResultBean;
import com.bing.lan.mainLib.comm.bean.QueryDomain;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<HttpResult<LoginRegisterResultBean>> loginAndRegister(@FieldMap Map<String, String> map);

    /**
     * 群组列表
     */
    @GET("user/group/findAllGroupList")
    Observable<HttpResult<QueryDomain<Groups>>> findAllGroupList(
            @Query("currentPage") int currentPage,
            @Query("pageSize") int pageSize
    );

    /**
     * 获取验证码
     */
    @FormUrlEncoded
    @POST("user/ismscode/sendSms")
    Observable<ResponseResult<Object>> getVcode(@FieldMap Map<String, String> map);

    /**
     * 获取验证码
     */
    @FormUrlEncoded
    @POST("user/ismscode/sendSms")
    Observable<ResponseResult<Object>> getIDCardVcode(@FieldMap Map<String, String> map);

    ///**
    // * 重复获取支付验证码
    // */
    //@FormUrlEncoded
    //@POST("trade/order/repaysms")
    //Observable<ResponseResult<Order>> loginAndRegister(@FieldMap Map<String, String> map);

    ///**
    // * 获取支付验证码
    // */
    //@FormUrlEncoded
    //@POST("trade/order/paysms")
    //Observable<ResponseResult<OrderBean>> getPayOrderVcode(@FieldMap Map<String, String> map);
    //
    ///**
    // * 注册
    // */
    //@FormUrlEncoded
    //@POST("user/iregisteruser/register")
    //Observable<ResponseResult<UserBean>> register(@FieldMap Map<String, String> map);
    //
    ///**
    // * 注册
    // */
    //@GET("index/home")
    //Observable<ResponseResult<Home>> home(@QueryMap Map<String, String> map);
    //
    ///**
    // * 找回密码
    // */
    //@FormUrlEncoded
    //@POST("platform/login/found-pass")
    //Observable<HttpResult<Object>> foundPassword(
    //        @Field("phone") String phone,
    //        @Field("newPwd") String newPwd,
    //        @Field("newPwd_ag") String newPwd_ag
    //);
    ///**
    // * 投资列表
    // */
    //@GET("product/iproduct/search/findProListByCategoryIdAndFinancialPeriod")
    //Observable<ResponseResult<IProduct>> investList(@QueryMap Map<String, String> map);
    //
    ///**
    // * 投资详情
    // */
    //@FormUrlEncoded
    //@POST("product/iproduct/proDetailInfo")
    //Observable<ResponseResult<IProduct>> proDetailInfo(@FieldMap Map<String, String> map);
    //
    ///**
    // * 优惠券、红包查询接口（用于购买理财）
    // */
    //@GET("trade/payinfo/search/findByProductIdAndAmount")
    //Observable<ResponseResult<PayInfo>> payOrderInfo(@QueryMap Map<String, String> map);
    //
    ///**
    // * 支付订单
    // */
    //@FormUrlEncoded
    //@POST("trade/order/pay")
    //Observable<ResponseResult<OrderBean>> payOrder(@FieldMap Map<String, String> map);
    //
    ///**
    // * 查询银行卡列表接口
    // */
    //@GET("user/ibankcardlist/search/findBankCards")
    //Observable<ResponseResult<IBankCardList>> findBankCards(@QueryMap Map<String, String> map);
    //
    ///**
    // * 设置默认银行卡
    // */
    //@FormUrlEncoded
    //@POST("user/ibankcard/isDefault")
    //Observable<ResponseResult<IBankCard>> setDefaultBankCard(@FieldMap Map<String, String> map);
}
