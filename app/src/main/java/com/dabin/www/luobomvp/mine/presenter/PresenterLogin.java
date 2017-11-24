package com.dabin.www.luobomvp.mine.presenter;

import com.dabin.www.luobomvp.mine.bean.LoginBase;
import com.dabin.www.luobomvp.mine.model.ModelLogin;
import com.dabin.www.luobomvp.mine.view.IViewLogin;

/**
 * Created by Dabin on 2017/11/10.
 */

public class PresenterLogin implements ModelLogin.OnLoginFinish{

    private final IViewLogin iViewLogin;
    private final ModelLogin modelLogin;

    public PresenterLogin(IViewLogin iViewLogin) {
        this.iViewLogin = iViewLogin;
        modelLogin = new ModelLogin();
        modelLogin.setOnLoginFinish(this);
    }

    public  void setLoginUrl(String username,String password){
        modelLogin.getLoginUrl(username,password);
    }


    @Override
    public void LoginFinish(LoginBase loginBase) {
        iViewLogin.success(loginBase);
    }
}
