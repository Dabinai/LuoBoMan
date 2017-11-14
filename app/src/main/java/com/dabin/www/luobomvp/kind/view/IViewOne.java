package com.dabin.www.luobomvp.kind.view;

import com.dabin.www.luobomvp.kind.bean.OneBase;
import com.dabin.www.luobomvp.kind.bean.TwoBase;

import java.util.List;

/**
 * Created by Dabin on 2017/11/13.
 */

public interface IViewOne {
    void getUrl(List<OneBase.DatasBean.ClassListBean> class_list);
    void getUrlTwo(List<TwoBase.DatasBean.ClassListBean> class_listtwo);

}
