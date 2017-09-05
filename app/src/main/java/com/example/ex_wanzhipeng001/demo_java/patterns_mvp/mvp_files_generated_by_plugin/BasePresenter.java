package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.mvp_files_generated_by_plugin;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public interface  BasePresenter <V extends BaseView>{
    void attachView(V view);

    void detachView();
}
