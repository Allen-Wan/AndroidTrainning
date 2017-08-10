package com.example.ex_wanzhipeng001.demo_java.views.customviews.test.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ex_wanzhipeng001.demo_java.R;

/**
 * Created by ex-wanzhipeng001 on 17/8/8.
 */
public class MainMenuRecyclerAdapter3 extends RecyclerView.Adapter<MainMenuRecyclerAdapter3.ViewHolder> {

    private static final String TAG = "MainMenuRecyclerAdapter";
    private Context mContext;
    /**
     * 抽屉图标
     **/
    private int[] drawer_ig = {R.mipmap.ic_launcher,// 首页
            R.mipmap.ic_launcher,// 任务列表
            R.mipmap.ic_launcher,// 通知信息
            R.mipmap.ic_launcher,// 知识库
            R.mipmap.ic_launcher,// 计算器
            R.mipmap.ic_launcher,// 诉讼
            R.mipmap.ic_launcher,// 案件信息
            R.mipmap.ic_launcher,// 任务流查询
            R.mipmap.ic_launcher,// 支付信息
            R.mipmap.ic_launcher};// 设置

    /**
     * 抽屉文字颜色颜色
     **/
    private int[] drawer_text_color = {0xFFff8b61,// 首页
            0xFFe3c892,// 任务列表
            0xFF15c5e5,// 通知信息
            0xFF30d390,// 知识库
            0xFFd698f6,// 计算器
            0xFFffdcfb,// 诉讼
            0xFFe3c892,// 案件信息
            0xFFabd221,// 任务流查询
            0xFF4be0de,// 支付信息
            0xFF15c5e5};// 设置

    /**
     * 抽屉右边背景图颜色
     **/
    private int[] drawer_right_bg = {R.color.black_overlay,// 首页
            R.color.black_overlay,// 任务列表
            R.color.black_overlay,// 通知信息
            R.color.black_overlay,// 知识库
            R.color.black_overlay,// 计算器
            R.color.black_overlay,// 诉讼
            R.color.black_overlay,// 案件信息
            R.color.black_overlay,// 任务流查询
            R.color.black_overlay,// 支付信息
            R.color.black_overlay};// 设置

    private String[] drawer_name = {"首页",
            "任务列表", "通知信息", "知识库", "计算器", "诉讼",
            "案件信息", "任务流查询", "支付信息",
            "设置"};

    private OnRecyclerViewItemClickListener onRecyclerViewListener = null;

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }


    public MainMenuRecyclerAdapter3(Context context) {
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Activity activity = (Activity) mContext;
        View view = activity.getLayoutInflater().inflate(R.layout.main_drawer_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder1, final int position) {
        final MainMenuRecyclerAdapter3.ViewHolder holder = (ViewHolder) holder1;
        holder.imageView_drawer_ig.setBackgroundResource(drawer_ig[position]);
        holder.imageView_drawer_right_bg
                .setBackgroundResource(drawer_right_bg[position]);
        holder.textView_name.setText(drawer_name[position]);
        holder.textView_name.setTextColor(drawer_text_color[position]);
        if (position == 1) {
            holder.textView_number.setVisibility(View.INVISIBLE);
            holder.textView_number.setText("" + position);
        } else if (position == 2) {
            holder.textView_number.setText("" + position);
            holder.textView_number.setVisibility(View.INVISIBLE);
        } else {
            holder.textView_number.setVisibility(View.INVISIBLE);
        }
        if (0 < position && position < getItemCount()) {
            holder.textView_name.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        }

        // 如果设置了回调，则设置点击事件-回调处理
        if (onRecyclerViewListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onRecyclerViewListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    onRecyclerViewListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }

//        // 或者下面这种--直接处理--耦合较高
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mContext, "position:" + position, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return drawer_ig.length;//目前只有两个模块
    }

    //自定义的ViewHolder,减少findViewById调用次数
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_drawer_ig;
        ImageView imageView_drawer_right_bg;
        TextView textView_number;
        TextView textView_name;

        //在布局中找到所含有的UI组件
        public ViewHolder(View itemView) {
            super(itemView);
            imageView_drawer_ig = (ImageView) itemView.findViewById(R.id.imageView_drawer_ig);
            imageView_drawer_right_bg = (ImageView) itemView.findViewById(R.id.imageView_drawer_right_bg);
            textView_number = (TextView) itemView.findViewById(R.id.textView_drawer_number);
            textView_name = (TextView) itemView.findViewById(R.id.textView_drawer_name);
        }
    }
}
