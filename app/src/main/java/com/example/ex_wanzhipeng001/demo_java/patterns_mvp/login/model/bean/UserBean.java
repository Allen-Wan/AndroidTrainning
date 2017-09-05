package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.login.model.bean;

/**
 * Created by ex-wanzhipeng001 on 17/9/4.
 */

public class UserBean{

    private  String username;
    private  String password;

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

}
