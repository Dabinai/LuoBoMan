package com.dabin.www.luobomvp.utils;

import com.dabin.www.luobomvp.home.bean.HomeBase;
import com.dabin.www.luobomvp.kind.bean.OneBase;
import com.dabin.www.luobomvp.commodi.bean.ParticularsBase;
import com.dabin.www.luobomvp.kind.bean.ThreeBase;
import com.dabin.www.luobomvp.kind.bean.TwoBase;
import com.dabin.www.luobomvp.mine.bean.LoginBase;
import com.dabin.www.luobomvp.mine.bean.MessBase;
import com.dabin.www.luobomvp.mine.bean.SignBase;

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

    //分类第一个适配器
    @GET("mobile/index.php?act=goods_class")
    Observable<OneBase> getOnes();
    //分类第二个适配器
    @POST
    Observable<TwoBase> getTwos(@Url String url, @QueryMap Map<String,String> map);
    //分类第三个适配器
    @POST
    Observable<ThreeBase> getThrees(@Url String url, @QueryMap Map<String,String> map);

    //商品详情
    @POST
    Observable<ParticularsBase> getParticulars(@Url String url,@QueryMap Map<String,String > map);
}
