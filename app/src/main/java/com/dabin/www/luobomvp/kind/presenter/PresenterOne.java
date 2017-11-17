package com.dabin.www.luobomvp.kind.presenter;

import com.dabin.www.luobomvp.kind.bean.OneBase;
import com.dabin.www.luobomvp.kind.bean.ThreeBase;
import com.dabin.www.luobomvp.kind.bean.TwoBase;
import com.dabin.www.luobomvp.kind.model.ModelOne;
import com.dabin.www.luobomvp.kind.view.IViewOne;

import java.util.List;

/**
 * Created by Dabin on 2017/11/13.
 */

public class PresenterOne implements ModelOne.OnOneFinish,ModelOne.OnTwoFinish,ModelOne.OnThreeFinish{
    private final IViewOne iViewOne;
    private final ModelOne modelOne;
    public PresenterOne(IViewOne iViewOne) {
        this.iViewOne = iViewOne;
        modelOne = new ModelOne();
        modelOne.setOnOneFinish(this);
        modelOne.setOnTwoFinish(this);
        modelOne.setOnThreeFinish(this);
    }

    public void setUrl(String url){
        modelOne.getUrl(url);
    }

    public void setUrlTwo(String gc_id){
        modelOne.getUrlTwo(gc_id);
    }



    //第一个分类
    @Override
    public void OneFinish(List<OneBase.DatasBean.ClassListBean> class_list) {
        iViewOne.getUrl(class_list);
    }
    //第二个分类
    @Override
    public void TwoFinish(List<TwoBase.DatasBean.ClassListBean> class_listtwo) {
        iViewOne.getUrlTwo(class_listtwo);
    }
    //第三个分类
    @Override
    public void ThreeFinish(List<ThreeBase.DatasBean.ClassListBean> class_listthree) {

    }

}
