package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.example.ex_wanzhipeng001.demo_java.basis.java.TestJavaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasisMainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "BasisMainActivity";
    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;
    @BindView(R.id.btn_testJava)
    Button mBtnTestJava;
    @BindView(R.id.btn_testUI)
    Button mBtnTestUI;
    @BindView(R.id.btn_testBroadcast)
    Button mBtnTestBroadcast;
    @BindView(R.id.btn_testContentProvider)
    Button mBtnTestContentProvider;
    @BindView(R.id.btn_testRuntimePermission)
    Button mBtnTestRuntimePermission;
    @BindView(R.id.btn_testSendNotification)
    Button mBtnTestSendNotification;
    @BindView(R.id.btn_testCamera)
    Button mBtnTestCamera;
    @BindView(R.id.btn_testMedia)
    Button mBtnTestMedia;
    @BindView(R.id.btn_testService)
    Button mBtnTestService;
    @BindView(R.id.btn_testAlarmManager)
    Button mBtnTestAlarmManager;
    @BindView(R.id.btn_testWebView)
    Button mBtnTestWebView;
    @BindView(R.id.btn_testXMLAndGson)
    Button mBtnTestXMLAndGson;
//    @BindString(R.string.app_name) String title; //bind string or drawable...etc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basis_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_testJava, R.id.btn_testRuntimePermission, R.id.btn_testUI, R.id.btn_testBroadcast, R.id
            .btn_testContentProvider, R.id.btn_testSendNotification, R.id.btn_testCamera, R.id.btn_testMedia,R.id
            .btn_testService,R.id.btn_testAlarmManager,R.id.btn_testWebView,R.id.btn_testXMLAndGson})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_testJava:
                Intent intent = new Intent(BasisMainActivity.this, TestJavaActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_testRuntimePermission:
                Intent intent1 = new Intent(BasisMainActivity.this, RuntimePermissionActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_testUI:
                Intent intent2 = new Intent(BasisMainActivity.this, UIComponentsActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_testBroadcast:
                Intent intent3 = new Intent(BasisMainActivity.this, BroadCastReceiverActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_testContentProvider:
                Intent intent4 = new Intent(BasisMainActivity.this, ContentProviderActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_testSendNotification:
                Intent intent6 = new Intent(BasisMainActivity.this, NotificationActivity.class);
                startActivity(intent6);
                break;
            case R.id.btn_testCamera:
                Intent intent7 = new Intent(BasisMainActivity.this, CameraActivity.class);
                startActivity(intent7);
                break;
            case R.id.btn_testMedia:
                Intent intent8 = new Intent(BasisMainActivity.this, MediaActivity.class);
                startActivity(intent8);
                break;
            case R.id.btn_testService:
                Intent intent9 = new Intent(BasisMainActivity.this, ServiceActivity.class);
                startActivity(intent9);
                break;
            case R.id.btn_testAlarmManager:
                Intent intent10 = new Intent(BasisMainActivity.this, AlarmManagerActivity.class);
                startActivity(intent10);
                break;
            case R.id.btn_testWebView:
                Intent intent11 = new Intent(BasisMainActivity.this, WebViewActivity.class);
                startActivity(intent11);
                break;
            case R.id.btn_testXMLAndGson:
                Intent intent12 = new Intent(BasisMainActivity.this, XMLAndGsonActivity.class);
                startActivity(intent12);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
