package com.dabin.www.luobomvp.shop.bean;

/**
 * Created by Dabin on 2017/11/15.
 */

public class TwoClass {
    private String twoName;     //名字
    private String twoPrice;   //单价
    private int twoNum;  // 数量
    private boolean twoCheck; //是否被选

    public TwoClass(String twoName, String twoPrice, int twoNum, boolean twoCheck) {
        this.twoName = twoName;
        this.twoPrice = twoPrice;
        this.twoNum = twoNum;
        this.twoCheck = twoCheck;
    }

    public String getTwoName() {
        return twoName;
    }

    public void setTwoName(String twoName) {
        this.twoName = twoName;
    }

    public String getTwoPrice() {
        return twoPrice;
    }

    public void setTwoPrice(String twoPrice) {
        this.twoPrice = twoPrice;
    }

    public int getTwoNum() {
        return twoNum;
    }

    public void setTwoNum(int twoNum) {
        this.twoNum = twoNum;
    }

    public boolean isTwoCheck() {
        return twoCheck;
    }

    public void setTwoCheck(boolean twoCheck) {
        this.twoCheck = twoCheck;
    }
}
