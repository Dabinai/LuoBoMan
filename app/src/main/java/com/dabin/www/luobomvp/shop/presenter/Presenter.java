package com.dabin.www.luobomvp.shop.presenter;

import com.dabin.www.luobomvp.shop.bean.DingBase;
import com.dabin.www.luobomvp.shop.bean.Shopbase;
import com.dabin.www.luobomvp.shop.bean.UpdateBase;
import com.dabin.www.luobomvp.shop.model.Model;
import com.dabin.www.luobomvp.shop.view.IView;

/**
 * Created by Dabin on 2017/11/17.
 */

public class Presenter implements Model.OnFinish{

    private final IView iView;
    private final Model model;

    public Presenter(IView iView) {
        this.iView = iView;
        this.model = new Model();
        model.setOnFinish(this);
    }


    public void setUrl(String uid){
        model.getUrl(uid);
    }
    //更新购物车
    public void setUpdateUrl(String uid, String sellerid, String pid, String num, String selected){
        model.getUpdate(uid, sellerid, pid, num, selected);
    };
    //生成订单
    public void setDingdan(String uid,String price){
        model.getDingDan(uid,price);
    }

    @Override
    public void Finish(Shopbase shopbase) {
        iView.getData(shopbase);
    }

    @Override
    public void FinishUpdate(UpdateBase updateBase) {
        iView.getDataUpdate(updateBase);
    }

    @Override
    public void FinishDing(DingBase dingBase) {
        iView.getDataDing(dingBase);
    }
}
