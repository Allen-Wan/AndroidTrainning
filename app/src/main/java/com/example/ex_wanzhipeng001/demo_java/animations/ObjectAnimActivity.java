package com.example.ex_wanzhipeng001.demo_java.animations;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.ex_wanzhipeng001.demo_java.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObjectAnimActivity extends AppCompatActivity {
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
    @BindView(R.id.ll_container)
    LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        ButterKnife.bind(this);

        //设置过渡动画
        ScaleAnimation sa = new ScaleAnimation(0,1,0,1);
        sa.setDuration(2000);
        //设置布局动画的显示属性,  0.5f = 0.5f*sa.getDuration();
        LayoutAnimationController lac = new LayoutAnimationController(sa,0.5f);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        //为mLinearLayout设置布局动画
        mLinearLayout.setLayoutAnimation(lac);

        //差值器
//        AccelerateInterpolator
//        BounceInterpolator
//        DecelerateInterpolator
//        LinearInterpolator
//        OvershootInterpolator
//        AnticipateInterpolator
    }

    @OnClick({R.id.iv_viewAnimRotate,R.id.iv_viewAnimScale,R.id.iv_viewAnimAlpha,R.id.iv_viewAnimTranslate,R.id.iv_viewAnimSet})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_viewAnimRotate://xml defined
                Animator animator = AnimatorInflater.loadAnimator(this,R.animator.rotate);
                animator.setTarget(v);
                animator.start();
                break;
            case R.id.iv_viewAnimScale:
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(v,"scaleX",2);
                objectAnimator.setDuration(300);
                objectAnimator.start();
                objectAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                });
                break;
            case R.id.iv_viewAnimAlpha:
//                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,100);
//                valueAnimator.setTarget(v);
//                valueAnimator.setDuration(1000).start();
//                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        Float value = (Float) animation.getAnimatedValue();
//                    }
//                });
                v.animate().alpha(0.5f).y(300).setDuration(300)
                        .withStartAction(new Runnable() {
                    @Override
                    public void run() {

                    }
                }).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    }
                }).start();
                break;
            case R.id.iv_viewAnimTranslate:
                WrapperView wrapperView = new WrapperView(v);
                ObjectAnimator.ofInt(wrapperView,"width",500).setDuration(5000).start();
                break;
            case R.id.iv_viewAnimSet:

//                PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofFloat("translationX",300f);
//                PropertyValuesHolder valuesHolder2 = PropertyValuesHolder.ofFloat("scaleX",1f,0,1f);
//                PropertyValuesHolder valuesHolder3 = PropertyValuesHolder.ofFloat("scaleY",1f,0,1f);
//                ObjectAnimator.ofPropertyValuesHolder(v,valuesHolder,valuesHolder2,valuesHolder3).
//                        setDuration(1000).start();

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(v,"translationX",300f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(v,"scaleX",1f,0,1f);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(v,"scaleY",1f,0,1f);
                AnimatorSet set = new AnimatorSet();
//                set.playTogether(animator,animator2,animator3);
                set.playSequentially(animator1,animator2,animator3);
                set.setDuration(1000).start();

                break;
            default:
                break;
        }
    }

    /**
     * 自定义属性类、包装类来提供get set方法
     */
    private  static  class WrapperView{
        private  View mTarget;

        public WrapperView(View target) {
            mTarget = target;
        }

        public  int getWidth(){
            return  mTarget.getWidth();
        }

        public void setWidth(int width){
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }

    }
}
