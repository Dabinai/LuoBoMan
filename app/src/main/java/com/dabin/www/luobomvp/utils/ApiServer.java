package com.dabin.www.luobomvp.utils;

import com.dabin.www.luobomvp.commodi.bean.ParticularsBase;
import com.dabin.www.luobomvp.comshow.bean.addbase;
import com.dabin.www.luobomvp.dinglist.bean.DingListBase;
import com.dabin.www.luobomvp.home.bean.HomeBase;
import com.dabin.www.luobomvp.kind.view.bean.LeftBase;
import com.dabin.www.luobomvp.kind.view.bean.RightBase;
import com.dabin.www.luobomvp.mine.bean.LoginBase;
import com.dabin.www.luobomvp.mine.bean.MessBase;
import com.dabin.www.luobomvp.mine.bean.SignBase;
import com.dabin.www.luobomvp.shop.bean.DingBase;
import com.dabin.www.luobomvp.shop.bean.Shopbase;
import com.dabin.www.luobomvp.shop.bean.UpdateBase;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {

    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBase> getHome();
    //登录
    @POST
    Observable<LoginBase> getLogin(@Url String url, @QueryMap Map<String,String> map);
    //注册
    @POST
    Observable<SignBase> getSign(@Url String url, @QueryMap Map<String,String> map);
    //个人信息
    @POST
    Observable<MessBase> getMess(@Url String url, @QueryMap Map<String,String> map);
    //分类
    @POST
    Observable<LeftBase> getLeft(@Url String url);
    //分类
    @POST
    Observable<RightBase> getRight(@Url String url, @QueryMap Map<String,String> map);


    //商品详情
    @POST
    Observable<ParticularsBase> getParticulars(@Url String url,@QueryMap Map<String,String > map);

    //添加购物车
    @POST
    Observable<addbase> getadd(@Url String url, @QueryMap Map<String,String > map);

    //查询购物车
    @POST
    Observable<Shopbase> getshop(@Url String url, @QueryMap Map<String,String > map);

    //更新购物车
    @POST
    Observable<UpdateBase> getUpdate(@Url String url, @QueryMap Map<String,String > map);

    //生成订单
    @POST
    Observable<DingBase> getDing(@Url String url,@QueryMap Map<String,String> map);

    //订单列表
    @POST
    Observable<DingListBase> getDingList(@Url String url,@QueryMap Map<String,String> map);
}
