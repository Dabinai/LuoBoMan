package com.dabin.www.luobomvp.shop.model;

/**
 * Created by Dabin on 2017/11/17.
 */

public interface IModel {
    void getUrl(String uid);
    void getUpdate(String uid,String sellerid,String pid,String num,String selected);
    void getDingDan(String uid,String price);
}
