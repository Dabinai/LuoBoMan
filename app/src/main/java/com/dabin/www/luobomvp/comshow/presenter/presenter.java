package com.dabin.www.luobomvp.comshow.presenter;


import com.dabin.www.luobomvp.comshow.bean.addbase;
import com.dabin.www.luobomvp.comshow.model.Model;
import com.dabin.www.luobomvp.comshow.view.IView;

/**
 * Created by Dabin on 2017/11/17.
 */

public class presenter implements Model.OnFinish{
    private final IView iView;
    private final Model model;

    public presenter(IView iView) {
        this.iView = iView;
        model = new Model();
        model.setOnFinish(this);
    }


    public void setMSG(String pid,String uid){
        model.getUrl(pid,uid);
    }

    @Override
    public void Finish(addbase addbase) {
        iView.getMSG(addbase);
    }
}
