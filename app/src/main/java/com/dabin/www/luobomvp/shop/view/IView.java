package com.dabin.www.luobomvp.shop.view;

import com.dabin.www.luobomvp.shop.bean.DingBase;
import com.dabin.www.luobomvp.shop.bean.Shopbase;
import com.dabin.www.luobomvp.shop.bean.UpdateBase;

/**
 * Created by Dabin on 2017/11/17.
 */

public interface IView {
    void getData(Shopbase shopbase);
    void getDataUpdate(UpdateBase updateBase);
    void getDataDing(DingBase dingBase);
}
