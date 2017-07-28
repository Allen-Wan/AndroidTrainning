package com.example.ex_wanzhipeng001.demo_java.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.example.ex_wanzhipeng001.demo_java.views.customviews.test.CircleProgressTestActivity;
import com.example.ex_wanzhipeng001.demo_java.views.customviews.test.ScrollViewTestActivity;
import com.example.ex_wanzhipeng001.demo_java.views.customviews.test.SearchViewTestActivity;
import com.example.ex_wanzhipeng001.demo_java.views.astemplate.TemplateActivityTestActivity;
import com.example.ex_wanzhipeng001.demo_java.views.customviews.test.TopBarTestActivity;
import com.example.ex_wanzhipeng001.demo_java.views.customviews.test.VolumeTestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewsMainActivity extends AppCompatActivity {

    @BindView(R.id.btn_templateActivity)
    Button mBtnTemplateActivity;
    @BindView(R.id.btn_topbar)
    Button mBtnTopbar;
    @BindView(R.id.btn_circleProgressView)
    Button mBtnCircleProgressView;
    @BindView(R.id.btn_volumeView)
    Button mBtnVolumeView;
    @BindView(R.id.btn_scrollView)
    Button mBtnScrollView;
    @BindView(R.id.btn_searchView)
    Button mBtnSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views_main);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.btn_templateActivity,
            R.id.btn_topbar,
            R.id.btn_circleProgressView,
            R.id.btn_volumeView,
            R.id.btn_scrollView,
            R.id.btn_searchView
    })
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_templateActivity:
                Intent intent0 = new Intent(this, TemplateActivityTestActivity.class);
                startActivity(intent0);
                break;
            case R.id.btn_topbar:
                Intent intent = new Intent(this, TopBarTestActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_circleProgressView:
                Intent intent2 = new Intent(this, CircleProgressTestActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_volumeView:
                Intent intent3 = new Intent(this, VolumeTestActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_scrollView:
                Intent intent4 = new Intent(this, ScrollViewTestActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_searchView:
                Intent intent5 = new Intent(this, SearchViewTestActivity.class);
                startActivity(intent5);
                break;
            default:
                break;
        }
    }
}
