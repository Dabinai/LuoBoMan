package com.dabin.www.luobomvp.commodi.model;

import android.util.Log;

import com.dabin.www.luobomvp.commodi.bean.ParticularsBase;
import com.dabin.www.luobomvp.utils.RetroFactoryPost;

import java.util.HashMap;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dabin on 2017/11/16.
 */

public class Model implements IModel{

    private List<ParticularsBase.DataBean> data;

    //详情
    private OnparticFinish onparticFinish;

    public interface OnparticFinish{
        void ParticFinish( List<ParticularsBase.DataBean> data);
    }

    public void setOnparticFinish(OnparticFinish onparticFinish){
        this.onparticFinish = onparticFinish;
    }



    //详情网络请求
    @Override
    public void getUrlPrati(String id) {
        HashMap map = new HashMap();
        map.put("pscid",id);
        Log.d("qingqiu", "getUrlPrati: "+id);
        RetroFactoryPost.getInstance().getParticulars("product/getProducts",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ParticularsBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ParticularsBase particularsBase) {
                        data =  particularsBase.getData();
                        onparticFinish.ParticFinish(data);
                    }
                });
    }

}
