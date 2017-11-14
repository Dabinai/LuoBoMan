package com.dabin.www.luobomvp.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import com.dabin.www.luobomvp.R;
import com.facebook.drawee.backends.pipeline.Fresco;

public class BaseActivity extends FragmentActivity{
  /*  *//** 是否沉浸状态栏 **//*
    private boolean isSetStatusBar = true;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

       /* if (isSetStatusBar) {
            steepStatusBar();
        }*/
    }

   /* private void steepStatusBar() {

    }*/

    /**
     * 是否设置沉浸状态栏
     * @param isSetStatusBar
     *//*
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }*/
}
