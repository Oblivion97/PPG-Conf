/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.f.schMon.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ARK on 10/1/2017.
 */

public class CodexAcitvity extends AppCompatActivity {
    private static final String TAG = CodexAcitvity.class.getName();
    private Intent intent;
    private RelativeLayout layoutTop, layoutLeft, layoutRight;
    private ImageView bckGrndIV;
    private Animation uptobottom, lefttoright, righttoleft;
    private long time;
    private boolean rememberMe;

    String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codex);
        ButterKnife.bind(this);

        time = 1000;    //time



    }


    @OnClick(R.id.codex)
    void onClickCodexLogo(View v) {
        Intent intent = new Intent(CodexAcitvity.this, WebActivity.class);
        intent.putExtra("url", "http://codexunicorn.pw/about");
        startActivity(intent);

    }

    @OnClick(R.id.nsu)
    void onClickNSULogo(View v) {
        url = "http://www.mppg-nsu.org/";
        Intent intent = new Intent(CodexAcitvity.this, WebActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

}
