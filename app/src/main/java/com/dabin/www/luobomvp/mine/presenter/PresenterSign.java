package com.dabin.www.luobomvp.mine.presenter;

import com.dabin.www.luobomvp.mine.model.ModelSign;
import com.dabin.www.luobomvp.mine.view.IViewSign;

/**
 * Created by Dabin on 2017/11/13.
 */

public class PresenterSign implements ModelSign.OnSignFinish{
    private final IViewSign iViewSign;
    private final ModelSign modelSign;

    public PresenterSign(IViewSign iViewSign) {
        this.iViewSign = iViewSign;
        modelSign = new ModelSign();
        modelSign.setOnSignFinish(this);
    }

    public void setUrl(String signname,String signpass){
        modelSign.getUrl(signname,signpass);
    }


    @Override
    public void signFinish(String code) {
        iViewSign.signsuccess(code);
    }
}
