package com.sparrowmon.bookbook;

import android.app.Application;

import com.sparrowmon.bookbook.utilities.MyanmarSarUtil;
import com.sparrowmon.bookbook.utilities.PicassoImageLoadingService;

import me.myatminsoe.mdetect.MDetect;
import ss.com.bannerslider.Slider;

public class BookBookApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MDetect.INSTANCE.init(this);

        MyanmarSarUtil.detectFont(getApplicationContext());

        Slider.init(new PicassoImageLoadingService(getApplicationContext()));
    }
}
