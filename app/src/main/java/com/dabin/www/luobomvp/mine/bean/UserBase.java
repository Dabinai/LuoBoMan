package com.dabin.www.luobomvp.mine.bean;

/**
 * Created by Dabin on 2017/11/13.
 */

public class UserBase {
    private String username;
    private String password;

    public UserBase(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
