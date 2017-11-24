package com.dabin.www.luobomvp.kind.view.view;

import com.dabin.www.luobomvp.kind.view.bean.LeftBase;
import com.dabin.www.luobomvp.kind.view.bean.RightBase;

import java.util.List;

/**
 * Created by Dabin on 2017/11/17.
 */

public interface IView {
    void getleftData(List<LeftBase.DataBean> data);
    void getrightData(List<RightBase.DataBean> dataright);

}
