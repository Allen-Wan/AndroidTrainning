package com.example.ex_wanzhipeng001.demo_java.views.customviews.test.recyclerview;

import android.view.View;

/**
 * Created by ex-wanzhipeng001 on 17/8/10.
 */

public interface OnRecyclerViewItemClickListener {
    void onItemClick(View view, int position);

    boolean onItemLongClick(View view, int position);
}
