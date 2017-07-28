package com.example.ex_wanzhipeng001.demo_java.animations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ex_wanzhipeng001.demo_java.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationMainActivity extends AppCompatActivity {

    @BindView(R.id.btn_viewAnim)
    Button mBtnViewAnim;
    @BindView(R.id.btn_objectAnim)
    Button mBtnObjectAnim;
    @BindView(R.id.btn_customTV)
    Button mBtnCustomTV;
    @BindView(R.id.btn_customAnim)
    Button mBtnCustomAnim;
    @BindView(R.id.btnTimer)
    Button btnTimer;
    @BindView(R.id.btnProperty)
    Button btnProperty;
    @BindView(R.id.btnDrop)
    Button btnDrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_viewAnim,R.id.btn_objectAnim,R.id.btn_customAnim,R.id.btn_customTV,R.id.btnDrop,R.id
            .btnProperty,R.id.btnTimer})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_viewAnim:
                Intent intent = new Intent(this, ViewAnimActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_objectAnim:
                Intent intent2 = new Intent(this, ObjectAnimActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_customAnim:
                btnAnim(v);
                break;
            case R.id.btn_customTV:
                imgClose(v);
                break;
            case R.id.btnTimer:
                btnTimer(v);
                break;
            case R.id.btnProperty:
                btnProperty(v);
                break;
            case R.id.btnDrop:
                btnDrop(v);
                break;
            default:
                break;
        }
    }


    public void btnAnim(View view) {
        CustomAnim customAnim = new CustomAnim();
        customAnim.setRotateY(30);
        view.startAnimation(customAnim);
    }

    public void imgClose(View view) {
        CustomTV customTV = new CustomTV();
        view.startAnimation(customTV);
    }

    public void btnDrop(View view) {
        startActivity(new Intent(this, DropTest.class));
    }

    public void btnProperty(View view) {
        startActivity(new Intent(this, PropertyTest.class));
    }

    public void btnTimer(View view) {
        startActivity(new Intent(this, TimerTest.class));
    }
}
