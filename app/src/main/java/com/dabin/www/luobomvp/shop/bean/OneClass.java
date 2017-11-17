package com.dabin.www.luobomvp.shop.bean;

import java.util.ArrayList;

/**
 * Created by Dabin on 2017/11/15.
 */

public class OneClass {

    private String oneName;
    private boolean oneCheck;
    private ArrayList<TwoClass> twos;

    public OneClass(String oneName, boolean oneCheck, ArrayList<TwoClass> twos) {
        this.oneName = oneName;
        this.oneCheck = oneCheck;
        this.twos = twos;
    }

    public String getOneName() {
        return oneName;
    }

    public void setOneName(String oneName) {
        this.oneName = oneName;
    }

    public boolean isOneCheck() {
        return oneCheck;
    }

    public void setOneCheck(boolean oneCheck) {
        this.oneCheck = oneCheck;
    }

    public ArrayList<TwoClass> getTwos() {
        return twos;
    }

    public void setTwos(ArrayList<TwoClass> twos) {
        this.twos = twos;
    }
}
