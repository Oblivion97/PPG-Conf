/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.NavDrawer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AboutActivity extends AppCompatActivity {
    Context context = AboutActivity.this;
    String urlCodex = "http://codexunicorn.pw/about",
            urlMir = "https://www.linkedin.com/in/mirferdous/",
            urlHM = "https://www.linkedin.com/in/hm-mahmudul-hasan-hridoy-b08041111/";

    boolean showDev;
    @BindView(R.id.imgCodexLogo)
    ImageView imgCodexLogo;
    @BindView(R.id.hm)
    View hmView;
    @BindView(R.id.mir)
    View mirView;

    @BindView(R.id.site)
    TextView site;

    @BindView(R.id.dev)
    View dev;

    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        //appbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  nav drawer
        NavDrawer.navDrawerBtnsClick(context, toolbar);

        if (!showDev)
            dev.setVisibility(View.GONE);

    }


    @OnClick(R.id.imgCodexLogo)
    void onClickCodexLogo(View v) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", urlCodex);
        startActivity(intent);
    }

    @OnClick(R.id.site)
    void onClickCodexSite(View v) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", urlCodex);
        startActivity(intent);
    }


    @OnClick(R.id.hm)
    void onClickHM(View v) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", urlHM);
        startActivity(intent);
    }

    @OnClick(R.id.mir)
    void onClickMIR(View v) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", urlMir);
        startActivity(intent);
    }

    public void onClickAbout(View view) {
        if (!showDev) {
            dev.setVisibility(View.VISIBLE);
            scrollView.fullScroll(ScrollView.FOCUS_AFTER_DESCENDANTS);
            showDev = false;
        } else {
            dev.setVisibility(View.GONE);
            showDev = false;
        }
    }
}
