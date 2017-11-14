package com.dabin.www.luobomvp.utils;

import com.dabin.www.luobomvp.home.bean.HomeBase;
import com.dabin.www.luobomvp.kind.bean.OneBase;
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

    @POST
    Observable<LoginBase> getLogin(@Url String url, @QueryMap Map<String,String> map);

    @POST
    Observable<SignBase> getSign(@Url String url, @QueryMap Map<String,String> map);

    @POST
    Observable<MessBase> getMess(@Url String url, @QueryMap Map<String,String> map);


    @GET("mobile/index.php?act=goods_class")
    Observable<OneBase> getOnes();

    @POST
    Observable<TwoBase> getTwos(@Url String url, @QueryMap Map<String,String> map);

    @POST
    Observable<ThreeBase> getThrees(@Url String url, @QueryMap Map<String,String> map);
}
