package com.example.ex_wanzhipeng001.demo_java.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.ex_wanzhipeng001.demo_java.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewAnimActivity extends AppCompatActivity {

    @BindView(R.id.iv_viewAnimRotate)
    ImageView mBtnAnimation1;
    @BindView(R.id.iv_viewAnimTranslate)
    ImageView mBtnAnimation2;
    @BindView(R.id.iv_viewAnimScale)
    ImageView mBtnAnimation3;
    @BindView(R.id.iv_viewAnimAlpha)
    ImageView mBtnAnimation4;
    @BindView(R.id.iv_viewAnimSet)
    ImageView mBtnAnimation5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_viewAnimRotate,R.id.iv_viewAnimScale,R.id.iv_viewAnimAlpha,R.id.iv_viewAnimTranslate,R.id.iv_viewAnimSet})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_viewAnimRotate:
                RotateAnimation rotateAnimation = new RotateAnimation(0,360,
                        RotateAnimation.RELATIVE_TO_SELF,0.5F,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(1000);
                v.startAnimation(rotateAnimation);
                break;
            case R.id.iv_viewAnimScale:
                ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,
                        ScaleAnimation.RELATIVE_TO_SELF,0.5F,
                        ScaleAnimation.RELATIVE_TO_SELF,0.5F);
                scaleAnimation.setDuration(1000);
                v.startAnimation(scaleAnimation);
                break;
            case R.id.iv_viewAnimAlpha:
                AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
                alphaAnimation.setDuration(1000);
                v.startAnimation(alphaAnimation);
                break;
            case R.id.iv_viewAnimTranslate:
                TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,300);
                translateAnimation.setDuration(1000);
                v.startAnimation(translateAnimation);
                break;
            case R.id.iv_viewAnimSet:
                AnimationSet set = new AnimationSet(true);
                set.setDuration(1000);

                TranslateAnimation translateAnimation2 = new TranslateAnimation(0,200,0,300);
                translateAnimation2.setDuration(1000);
                set.addAnimation(translateAnimation2);

                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0,1);
                alphaAnimation2.setDuration(1000);
                set.addAnimation(alphaAnimation2);

                v.startAnimation(set);


                set.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.d("ViewAnimActivity", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.d("ViewAnimActivity", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.d("ViewAnimActivity", "onAnimationRepeat");
                    }
                });

                break;
            default:
                break;
        }
    }
}
