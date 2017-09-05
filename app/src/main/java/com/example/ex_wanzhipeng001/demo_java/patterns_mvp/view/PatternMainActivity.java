package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.example.ex_wanzhipeng001.demo_java.patterns_mvp.presenter.LoginPresenterCompl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PatternMainActivity extends AppCompatActivity implements ILoginView,View.OnClickListener {

    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.btn_clear)
    Button mBtnClear;
    @BindView(R.id.pb_loading)
    ProgressBar mPbLoading;

    private LoginPresenterCompl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_main);
        ButterKnife.bind(this);

        initListener();

        //init
        loginPresenter = new LoginPresenterCompl(this);
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);
    }

    private void initListener() {
        mBtnLogin.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                loginPresenter.setProgressBarVisiblity(View.VISIBLE);
                mBtnLogin.setEnabled(false);
                mBtnClear.setEnabled(false);
                loginPresenter.doLogin(mEtUsername.getText().toString(),mEtPwd.getText().toString());
                break;
            case R.id.btn_clear:
                loginPresenter.clear();
                break;
            default:
                break;
        }
    }

    @Override
    public void onClearText() {
        mEtPwd.setText("");
        mEtUsername.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE);

        mBtnLogin.setEnabled(true);
        mBtnClear.setEnabled(true);
        if (result){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        mPbLoading.setVisibility(visibility);
    }
}
