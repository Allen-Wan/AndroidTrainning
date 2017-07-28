package com.example.ex_wanzhipeng001.demo_java.views.astemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ex_wanzhipeng001.demo_java.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TemplateActivityTestActivity extends AppCompatActivity {

    @BindView(R.id.btn_Basic)
    Button mBtnTemplateActivity7;
    @BindView(R.id.btn_FullScreen)
    Button mBtnTemplateActivity8;
    @BindView(R.id.btn_GoogleADMobs)
    Button mBtnTemplateActivity;
    @BindView(R.id.btn_GoogleMaps)
    Button mBtnTemplateActivity1;
    @BindView(R.id.btn_Login)
    Button mBtnTemplateActivity2;
    @BindView(R.id.btn_MasterDetailFlow)
    Button mBtnTemplateActivity3;
    @BindView(R.id.btn_Scrolling)
    Button mBtnTemplateActivity4;
    @BindView(R.id.btn_Settings)
    Button mBtnTemplateActivity5;
    @BindView(R.id.btn_Tabbed)
    Button mBtnTemplateActivity6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_test);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.btn_Basic,
            R.id.btn_FullScreen,
            R.id.btn_GoogleADMobs,
            R.id.btn_GoogleMaps,
            R.id.btn_Login,
            R.id.btn_MasterDetailFlow,
            R.id.btn_Scrolling,
            R.id.btn_Settings,
            R.id.btn_Tabbed
    })
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Basic:
                Intent intent0 = new Intent(this, BasicActivity.class);
                startActivity(intent0);
                break;
            case R.id.btn_FullScreen:
                Intent intent1 = new Intent(this, FullscreenActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_GoogleADMobs:
                Intent intent2 = new Intent(this, GoogleADMobsAdsActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_GoogleMaps:
                Intent intent3 = new Intent(this, GoogleMapsActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_Login:
                Intent intent4 = new Intent(this, LoginActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_MasterDetailFlow:
                Intent intent5 = new Intent(this, ItemListActivity.class);
                startActivity(intent5);
                break;
            case R.id.btn_Settings:
                Intent intent6 = new Intent(this, SettingsActivity.class);
                startActivity(intent6);
                break;
            case R.id.btn_Tabbed:
                Intent intent7 = new Intent(this, TabbedActivity.class);
                startActivity(intent7);
                break;
            case R.id.btn_Scrolling:
                Intent intent8 = new Intent(this, ScrollingActivity.class);
                startActivity(intent8);
                break;
            default:
                break;
        }
    }
}
