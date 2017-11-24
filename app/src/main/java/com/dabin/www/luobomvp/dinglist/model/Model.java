package com.dabin.www.luobomvp.dinglist.model;

import com.dabin.www.luobomvp.dinglist.bean.DingListBase;
import com.dabin.www.luobomvp.utils.RetroFactoryPost;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dabin on 2017/11/22.
 */

public class Model implements IModel{

    private OnFinishDingList onFinishDingList;

    public interface OnFinishDingList{
        void FinishDingList(DingListBase dingListBase);
    }
    public void setOnFinishDingList(OnFinishDingList onFinishDingList){
        this.onFinishDingList = onFinishDingList;
    }

    @Override
    public void getUrl(String uid) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid",uid);
        RetroFactoryPost.getInstance().getDingList("product/getOrders",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DingListBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DingListBase dingListBase) {
                        onFinishDingList.FinishDingList(dingListBase);
                    }
                });
    }
}
