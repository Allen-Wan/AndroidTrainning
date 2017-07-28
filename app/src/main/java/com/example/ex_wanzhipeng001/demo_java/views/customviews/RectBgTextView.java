package com.example.ex_wanzhipeng001.demo_java.views.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ex-wanzhipeng001 on 17/6/15.
 * 对现有控件进行拓展
 */

public class RectBgTextView extends TextView {
    private  Paint mPaint1;
    private  Paint mPaint2;

    public RectBgTextView(Context context) {
        super(context);
        initView();
    }

    public RectBgTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RectBgTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //在回调父类之前,即是在textview绘制文本之前
        //绘制外层矩形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        //绘制内层矩形
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);
        canvas.save();
        //绘制文字前平移10像素
        canvas.translate(10,0);//对于原始的textview便捷位置
        //父类完成的方法,即绘制文本
        super.onDraw(canvas);
        canvas.restore();
        //在回调父类之后,即是在textview绘制文本之后
    }
}
