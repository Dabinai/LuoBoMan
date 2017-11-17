package com.dabin.www.luobomvp.home.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.dabin.www.luobomvp.R;
import com.dabin.www.luobomvp.home.bean.WebBase;
import com.dabin.www.luobomvp.utils.ToastShow;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.homewebview)
    WebView homewebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        //注册
        EventBus.getDefault().register(this);

    }

    //传值   使用粘性
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Onbanner(WebBase webBase) {
        ToastShow.showLong(WebViewActivity.this,"粘性事假");
       homewebview.loadUrl(webBase.getUrl());
    }

   /* //传值   使用粘性
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void OnQian(WebBase webBase) {
        ToastShow.showLong(WebViewActivity.this,"粘性事假");
        homewebview.loadUrl(webBase.getUrl());
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
