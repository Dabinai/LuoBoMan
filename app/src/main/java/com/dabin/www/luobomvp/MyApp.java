package com.dabin.www.luobomvp;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Dabin on 2017/11/10.
 */

public class MyApp extends Application{
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        if (context == null)
            context = this;
        ImageLoaderConfiguration aDefault = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(aDefault);
    }

}
