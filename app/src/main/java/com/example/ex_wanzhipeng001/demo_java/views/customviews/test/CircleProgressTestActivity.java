package com.example.ex_wanzhipeng001.demo_java.views.customviews.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.example.ex_wanzhipeng001.demo_java.views.customviews.CircleProgressView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleProgressTestActivity extends AppCompatActivity {

    @BindView(R.id.circleProgressView)
    CircleProgressView mCircleProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress_test);
        ButterKnife.bind(this);

        mCircleProgressView.setSweepValue(80);
    }
}
