package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.login.presenter;

/**
 * Created by ex-wanzhipeng001 on 17/9/4.
 */

public interface ILoginPresenter {
    void clear();
    void doLogin(String name, String passwd);
    void setProgressBarVisiblity(int visiblity);
}
