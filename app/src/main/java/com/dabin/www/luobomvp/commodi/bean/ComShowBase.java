package com.dabin.www.luobomvp.commodi.bean;

import java.util.List;

/**
 * Created by Dabin on 2017/11/16.
 */

public class ComShowBase {
    private List<ParticularsBase.DataBean> data;

    public ComShowBase(List<ParticularsBase.DataBean> data) {
        this.data = data;
    }

    public List<ParticularsBase.DataBean> getData() {
        return data;
    }

    public void setData(List<ParticularsBase.DataBean> data) {
        this.data = data;
    }
}
