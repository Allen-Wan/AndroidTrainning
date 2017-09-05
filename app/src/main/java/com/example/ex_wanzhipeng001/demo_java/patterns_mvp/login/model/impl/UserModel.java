package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.login.model.impl;

import android.text.TextUtils;

import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.login.model.IUserModel;

/**
 * Created by ex-wanzhipeng001 on 17/9/5.
 */

public class UserModel implements IUserModel {

    private String username;
    private String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public int checkUserValidity(String name, String passwd) {
        if (TextUtils.equals(username,name) && TextUtils.equals(password,passwd)) {
            return 0;
        }
        return -1;
    }
}
