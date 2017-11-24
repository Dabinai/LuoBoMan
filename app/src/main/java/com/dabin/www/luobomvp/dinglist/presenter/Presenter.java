package com.dabin.www.luobomvp.dinglist.presenter;


import com.dabin.www.luobomvp.dinglist.bean.DingListBase;
import com.dabin.www.luobomvp.dinglist.model.Model;
import com.dabin.www.luobomvp.dinglist.view.IView;

/**
 * Created by Dabin on 2017/11/22.
 */

public class Presenter implements Model.OnFinishDingList {

    private final IView iView;
    private final Model model;

    public Presenter(IView iView) {
        this.iView = iView;
        model = new Model();
        model.setOnFinishDingList(this);
    }

    public void setUrl(String uid) {
        model.getUrl(uid);
    }

    @Override
    public void FinishDingList(DingListBase dingListBase) {
        iView.getData(dingListBase);
    }
}
