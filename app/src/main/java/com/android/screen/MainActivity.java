package com.android.screen;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 在手持设备上dpi=ppi,dpi即densityDpi
         * dpi可以计算出来计算出来,dpi=widthPixels^2+heightPixels^2开根号/屏幕大小(英寸)
         * 手机厂商也可以制定
         * 一般情况下,计算出来的和手机厂商指定的相等,但也有不相等情况
         * 例如Nexus6手机,屏幕dpi计算出来是1440^2+2560^2开根号/5.96=493,而通过代码打印,显示dpi是560,这就是一个例外
         * 通常smallestScreenWidthDp=min(screenWidthDp,screenHeightDp)
         * screenWidthDp=widthPixels/(dpi/160),screenHeightDp同理
         */
        getDensity();
    }

    private void getDensity() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Configuration config = getResources().getConfiguration();
        Log.d(TAG, "Density is " + displayMetrics.density +
                " densityDpi is " + displayMetrics.densityDpi +
                " height: " + displayMetrics.heightPixels +
                " width: " + displayMetrics.widthPixels +
//                " densityDpi: " + config.densityDpi +
                " smallestScreenWidthDp: " + config.smallestScreenWidthDp +
                " screenWidthDp: " + config.screenWidthDp +
                " screenHeightDp: " + config.screenHeightDp);
    }
}