package com.dabin.www.luobomvp.home.model;

import com.dabin.www.luobomvp.home.bean.HomeBase;
import com.dabin.www.luobomvp.utils.RetroFactory;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dabin on 2017/11/9.
 */

public class ModelHome implements IModelHome {

    private HomeBase.DataBean data;
    private OnHomeFinish onHomeFinish;

    public interface OnHomeFinish {
        void HomeFinish(HomeBase.DataBean data);
    }

    public void setOnHomeFinish(OnHomeFinish onHomeFinish) {
        this.onHomeFinish = onHomeFinish;
    }


    @Override
    public void getString(String url) {
        RetroFactory.getInstance().getHome()
                .subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<HomeBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(HomeBase homeBase) {
                        data = homeBase.getData();
                        onHomeFinish.HomeFinish(data);
                    }
                });
    }
}
