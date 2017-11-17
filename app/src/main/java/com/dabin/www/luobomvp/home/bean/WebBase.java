package com.dabin.www.luobomvp.home.bean;

/**
 * Created by Dabin on 2017/11/14.
 */

public class WebBase {
    private String ad_type_dynamic_data;

    public WebBase(String ad_type_dynamic_data) {
        this.ad_type_dynamic_data = ad_type_dynamic_data;
    }

    public String getUrl() {
        return ad_type_dynamic_data;
    }

    public void setUrl(String ad_type_dynamic_data) {
        this.ad_type_dynamic_data = ad_type_dynamic_data;
    }
}
