package com.dabin.www.luobomvp.commodi.presenter;

import com.dabin.www.luobomvp.commodi.bean.ParticularsBase;
import com.dabin.www.luobomvp.commodi.model.Model;
import com.dabin.www.luobomvp.commodi.view.IView;

import java.util.List;

/**
 * Created by Dabin on 2017/11/16.
 */

public class Presenter implements Model.OnparticFinish{

    private final IView iView;
    private final Model model;

    public Presenter(IView iView) {
        this.iView = iView;
        model = new Model();
        model.setOnparticFinish(this);
    }
    public void setParticUrl(String id){
        model.getUrlPrati(id);
    }

    //详情分类
    @Override
    public void ParticFinish(List<ParticularsBase.DataBean> data) {
        iView.getPrrtiData(data);
    }
}
