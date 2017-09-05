package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.login.view;

/**
 * Created by ex-wanzhipeng001 on 17/9/4.
 */

public interface ILoginView {
    void onClearText();
    void onLoginResult(Boolean result, int code);
    void onSetProgressBarVisibility(int visibility);
}
