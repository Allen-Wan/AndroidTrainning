package com.example.ex_wanzhipeng001.demo_java.views.customviews.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.example.ex_wanzhipeng001.demo_java.views.customviews.TopBarView;

public class TopBarTestActivity extends AppCompatActivity {

    private TopBarView mTopbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topbar_test);
        // 获得我们创建的topbar
        mTopbar = (TopBarView) findViewById(R.id.topBar);
        // 为topbar注册监听事件，传入定义的接口
        // 并以匿名类的方式实现接口内的方法
        mTopbar.setOnTopbarClickListener(
                new TopBarView.topbarClickListener() {

                    @Override
                    public void rightClick() {
                        Toast.makeText(TopBarTestActivity.this,
                                "right", Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void leftClick() {
                        Toast.makeText(TopBarTestActivity.this,
                                "left", Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        // 控制topbar上组件的状态
        mTopbar.setButtonVisable(0, true);
        mTopbar.setButtonVisable(1, false);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
