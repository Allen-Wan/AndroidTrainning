package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.model.IUserModel;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.model.UserModel;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.view.ILoginView;

/**
 * Created by ex-wanzhipeng001 on 17/9/4.
 */

public class LoginPresenterCompl implements ILoginPresenter {

    ILoginView iLoginView;
    IUserModel user;
    Handler mHandler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        mHandler = new Handler(Looper.getMainLooper());
        initUser();
    }

    private void initUser() {
        user = new UserModel("mvp","mvp");
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name,passwd);
        if (code != 0){
            isLoginSuccess = false;
        }
        final Boolean result = isLoginSuccess;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 3000);

    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iLoginView.onSetProgressBarVisibility(visiblity);
    }
}
