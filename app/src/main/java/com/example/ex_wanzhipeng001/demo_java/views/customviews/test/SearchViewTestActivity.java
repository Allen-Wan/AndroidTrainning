package com.example.ex_wanzhipeng001.demo_java.views.customviews.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.lapism.searchview.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchViewTestActivity extends AppCompatActivity {

    @BindView(R.id.searchView)
    SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        ButterKnife.bind(this);


    }

    // Only for SearchView.VERSION_MENU_ITEM
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_search: {
//                mSearchView.open(true/false); // enable or disable animation
//                return true;
//            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
