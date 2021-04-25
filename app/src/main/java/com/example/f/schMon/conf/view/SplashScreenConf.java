/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.f.schMon.R;
public class SplashScreenConf extends AppCompatActivity {
    private static final String TAG = SplashScreenConf.class.getName();
    private Intent intent;
    private RelativeLayout layoutTop, layoutLeft, layoutRight;
    private ImageView bckGrndIV;
    private Animation uptobottom, lefttoright, righttoleft;
    private long time;
    private boolean rememberMe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_splash_conf);
        //singleImageForAllDevice();


        // animationSplash();

        time = 2000;    //time


        intent = new Intent(this, DashActivity.class);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };

        timer.start();

    }
    

}
