package com.dabin.www.luobomvp.mine.model;

import com.dabin.www.luobomvp.mine.bean.LoginBase;
import com.dabin.www.luobomvp.utils.RetroFactoryPost;

import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dabin on 2017/11/10.
 */

public class ModelLogin implements IModelLogin{

    private String code;
    private OnLoginFinish onLoginFinish;
    public interface OnLoginFinish{
        void LoginFinish(String code);
    }
    public void setOnLoginFinish(OnLoginFinish onLoginFinish){
        this.onLoginFinish = onLoginFinish;

    }


    @Override
    public void getLoginUrl(String username,String password) {
        HashMap<String,String> map = new HashMap<>();
        map.put("mobile",username);
        map.put("password",password);

        RetroFactoryPost.getInstance().getLogin("user/login",map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<LoginBase>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(LoginBase loginBase) {
                code = loginBase.getCode();
                onLoginFinish.LoginFinish(code);
            }
        });
    }
}
