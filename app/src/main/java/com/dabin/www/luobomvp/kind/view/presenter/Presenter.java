package com.dabin.www.luobomvp.kind.view.presenter;

import com.dabin.www.luobomvp.kind.view.bean.LeftBase;
import com.dabin.www.luobomvp.kind.view.bean.RightBase;
import com.dabin.www.luobomvp.kind.view.model.Model;
import com.dabin.www.luobomvp.kind.view.view.IView;

import java.util.List;

/**
 * Created by Dabin on 2017/11/17.
 */

public class Presenter implements Model.OnLeftFinish,Model.OnRightFinish{

    private final IView iView;
    private final Model model;

    public Presenter(IView iView) {
        this.iView = iView;
        model = new Model();
        model.setOnLeftFinish(this);
        model.setOnRightFinish(this);
    }

    public void setleftUrl(String url){
        model.getLeftUrl(url);
    }

    public void setRightUrl(String url,String cid){
        model.getRightUrl(url,cid);
    }



    @Override
    public void LeftFinish(List<LeftBase.DataBean> data) {
        iView.getleftData(data);
    }

    @Override
    public void RightFinish(List<RightBase.DataBean> data) {
        iView.getrightData(data);
    }
}
