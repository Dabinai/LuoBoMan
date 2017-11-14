package com.dabin.www.luobomvp.home.presenter;

import com.dabin.www.luobomvp.home.bean.HomeBase;
import com.dabin.www.luobomvp.home.model.ModelHome;
import com.dabin.www.luobomvp.home.view.IViewHome;

/**
 * Created by Dabin on 2017/11/10.
 */

public class PresenterHome implements ModelHome.OnHomeFinish {

    private final IViewHome iView;
    private final ModelHome model;

    public PresenterHome(IViewHome iView) {
        this.iView = iView;
        model = new ModelHome();
        model.setOnHomeFinish(this);
    }

    public void setUrl(String url){
        model.getString(url);
    }



    @Override
    public void HomeFinish(HomeBase.DataBean data) {
        iView.getData(data);
    }
}
