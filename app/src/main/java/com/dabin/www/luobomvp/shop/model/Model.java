package com.dabin.www.luobomvp.shop.model;

import com.dabin.www.luobomvp.shop.bean.DingBase;
import com.dabin.www.luobomvp.shop.bean.Shopbase;
import com.dabin.www.luobomvp.shop.bean.UpdateBase;
import com.dabin.www.luobomvp.utils.RetroFactoryPost;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dabin on 2017/11/17.
 */

public class Model implements IModel{

    private OnFinish onFinish;

    public interface OnFinish{
        void Finish(Shopbase shopbase);
        void FinishUpdate(UpdateBase updateBase);
        void FinishDing(DingBase dingBase);
    }
    public void setOnFinish(OnFinish onFinish){
        this.onFinish = onFinish;
    }


    @Override
    public void getUrl(String uid) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid",uid+"");
        RetroFactoryPost.getInstance().getshop("product/getCarts",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Shopbase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Shopbase shopbase) {
                        onFinish.Finish(shopbase);
                    }
                });
    }

    //更新购物车
    @Override
    public void getUpdate(String uid, String sellerid, String pid, String num, String selected) {
        HashMap<String,String> map = new HashMap();
        map.put("uid",uid);
        map.put("sellerid",sellerid);
        map.put("pid",pid);
        map.put("num",num);
        map.put("selected",selected);
        RetroFactoryPost.getInstance().getUpdate("product/updateCarts",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpdateBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UpdateBase updateBase) {
                        onFinish.FinishUpdate(updateBase);
                    }
                });
    }
    //订单
    @Override
    public void getDingDan(String uid, String price) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid",uid);
        map.put("price",price);
        RetroFactoryPost.getInstance().getDing("product/createOrder",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DingBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DingBase dingBase) {
                        onFinish.FinishDing(dingBase);
                    }
                });
    }

}
