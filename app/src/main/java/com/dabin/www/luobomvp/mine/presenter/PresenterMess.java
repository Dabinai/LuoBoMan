package com.dabin.www.luobomvp.mine.presenter;

import com.dabin.www.luobomvp.mine.bean.MessBase;
import com.dabin.www.luobomvp.mine.model.ModelMess;
import com.dabin.www.luobomvp.mine.view.IViewMess;

/**
 * Created by Dabin on 2017/11/13.
 */

public class PresenterMess implements ModelMess.OnMessFinish{
    private final IViewMess iViewMess;
    private final ModelMess modelMess;

    public PresenterMess(IViewMess iViewMess) {
        this.iViewMess = iViewMess;
        modelMess = new ModelMess();
        modelMess.setOnMessFinish(this);
    }

    public void setUrl(String messuser,String messpass){

        modelMess.getUrl(messuser,messpass);
    }


    @Override
    public void Finish(MessBase.DataBean data) {
        iViewMess.success(data);
    }
}
