/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.NavDrawer;

import butterknife.ButterKnife;

public class EmergencyActivity extends AppCompatActivity {
    private static final String TAG = SpeakerActivity.class.getName();
    private Context context =  EmergencyActivity .this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        ButterKnife.bind(this);

        //app bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //nav drawer
        NavDrawer.navDrawerBtnsClick(context, toolbar);
    }
}
