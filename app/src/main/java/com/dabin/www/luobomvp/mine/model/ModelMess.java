package com.dabin.www.luobomvp.mine.model;

import com.dabin.www.luobomvp.mine.bean.MessBase;
import com.dabin.www.luobomvp.utils.RetroFactoryPost;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dabin on 2017/11/13.
 */

public class ModelMess implements IModelMessage{
    private  MessBase.DataBean data;

    public void setOnMessFinish(OnMessFinish onMessFinish) {
        this.onMessFinish = onMessFinish;
    }

    public interface OnMessFinish{
        void Finish(MessBase.DataBean data);
    }

    private OnMessFinish onMessFinish;


    @Override
    public void getUrl(String uid) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid",uid);
        RetroFactoryPost.getInstance().getMess("user/getUserInfo",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MessBase>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(MessBase messBase) {
                        data = messBase.getData();
                        onMessFinish.Finish(data);
                    }
                });
    }
}
