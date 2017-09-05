package com.example.ex_wanzhipeng001.demo_java.patterns_mvp.mvp;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V>{
    protected V mView;
    @Override
    public void attachView(V view) {
        mView=view;
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
