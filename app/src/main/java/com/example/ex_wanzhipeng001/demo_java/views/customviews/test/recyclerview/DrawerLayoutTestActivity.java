package com.example.ex_wanzhipeng001.demo_java.views.customviews.test.recyclerview;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.ex_wanzhipeng001.demo_java.R;

public class DrawerLayoutTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout_test);
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_main);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.menu_recyView_main);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));//分隔线

        //viewholder implements View.OnClickListener+ 构造方法setOnClickListener + getLayoutPosition
//        MainMenuRecyclerAdapter adapter = new MainMenuRecyclerAdapter(this);
//        adapter.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(DrawerLayoutTestActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
//                drawerLayout.closeDrawers();
//            }
//
//            @Override
//            public boolean onItemLongClick(View view, int position) {
//                return true;
//            }
//        });
//        mRecyclerView.setAdapter(adapter);

        //MainMenuRecyclerAdapter2 implements View.OnClickListener+ onCreateViewHolder-setOnClickListener+holder.itemView.setTag(position)
//        在 onCreateViewHolder中实现的优点是onCreateViewHolder(ViewGroup parent, int viewType)
//        有两个参数，如果你的 ViewHolder有多种类型的话，可以根据 viewType参数来对不同的ViewHolder做不同的处理。
//        MainMenuRecyclerAdapter2 adapter2 = new MainMenuRecyclerAdapter2(this);
//        adapter2.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(DrawerLayoutTestActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
//                drawerLayout.closeDrawers();
//            }
//
//            @Override
//            public boolean onItemLongClick(View view, int position) {
//                return true;
//            }
//        });
//        mRecyclerView.setAdapter(adapter2);

        //onBindViewHolder直接-holder.itemView.setOnClickListener+holder--本质上和MainMenuRecyclerAdapter相同,只是holderå注册监听位置变化
        MainMenuRecyclerAdapter3 adapter3 = new MainMenuRecyclerAdapter3(this);
        adapter3.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(DrawerLayoutTestActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawers();
            }

            @Override
            public boolean onItemLongClick(View view, int position) {
                return true;
            }
        });
        mRecyclerView.setAdapter(adapter3);
    }

}
