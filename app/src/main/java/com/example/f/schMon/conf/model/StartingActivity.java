/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.f.schMon.R;

public class StartingActivity extends AppCompatActivity {
    boolean rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);


        finish();
    }
}
