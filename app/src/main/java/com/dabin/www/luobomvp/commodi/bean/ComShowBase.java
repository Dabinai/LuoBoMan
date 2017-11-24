package com.dabin.www.luobomvp.commodi.bean;

import java.util.List;

/**
 * Created by Dabin on 2017/11/16.
 */

public class ComShowBase {
    private List<ParticularsBase.DataBean> data;
    private int posi;

    public ComShowBase(List<ParticularsBase.DataBean> data, int posi) {
        this.data = data;
        this.posi = posi;
    }

    public List<ParticularsBase.DataBean> getData() {
        return data;
    }

    public void setData(List<ParticularsBase.DataBean> data) {
        this.data = data;
    }

    public int getPosi() {
        return posi;
    }

    public void setPosi(int posi) {
        this.posi = posi;
    }
}
