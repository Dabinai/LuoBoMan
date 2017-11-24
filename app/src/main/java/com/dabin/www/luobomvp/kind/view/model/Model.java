package com.dabin.www.luobomvp.kind.view.model;

import android.util.Log;

import com.dabin.www.luobomvp.kind.view.bean.LeftBase;
import com.dabin.www.luobomvp.kind.view.bean.RightBase;
import com.dabin.www.luobomvp.utils.RetroFactoryPost;

import java.util.HashMap;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dabin on 2017/11/17.
 */

public class Model implements IModel{

    private List<LeftBase.DataBean> dataleft;

    private OnLeftFinish onLeftFinish;

    public interface  OnLeftFinish{
        void  LeftFinish(List<LeftBase.DataBean> data);
    }

    public void setOnLeftFinish(OnLeftFinish onLeftFinish){
        this.onLeftFinish = onLeftFinish;
    }


    private List<RightBase.DataBean> dataright;

    private OnRightFinish onRightFinish;

    public interface  OnRightFinish{
        void  RightFinish(List<RightBase.DataBean> data);
    }

    public void setOnRightFinish(OnRightFinish onRightFinish){
        this.onRightFinish = onRightFinish;
    }


    @Override
    public void getLeftUrl(String string) {
        RetroFactoryPost.getInstance().getLeft(string)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftBase>() {
                    public static final String TAG = "Model";

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LeftBase leftBase) {
                        dataleft = leftBase.getData();
                        Log.d(TAG, "onNext: "+leftBase.getData().get(0).getName());
                        onLeftFinish.LeftFinish(dataleft);
                    }
                });
    }

    @Override
    public void getRightUrl(String string, String cid) {
        HashMap<String,String> map = new HashMap();
        map.put("cid",cid);
        RetroFactoryPost.getInstance().getRight(string,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RightBase rightBase) {
                        dataright = rightBase.getData();
                        onRightFinish.RightFinish(dataright);
                    }
                });
    }


}
