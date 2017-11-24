package com.dabin.www.luobomvp.dinglist.bean;

import java.util.List;

/**
 * Created by Dabin on 2017/11/22.
 */

public class DingListBase {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-11-22T11:04:13","orderid":3077,"price":440,"status":0,"title":null,"uid":2166},{"createtime":"2017-11-22T11:04:24","orderid":3078,"price":9,"status":0,"title":null,"uid":2166}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-11-22T11:04:13
         * orderid : 3077
         * price : 440
         * status : 0
         * title : null
         * uid : 2166
         */

        private String createtime;
        private int orderid;
        private int price;
        private int status;
        private Object title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
