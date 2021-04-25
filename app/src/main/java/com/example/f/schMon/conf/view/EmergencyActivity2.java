/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.NavDrawer;
import com.github.barteksc.pdfviewer.PDFView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EmergencyActivity2 extends AppCompatActivity {
    private Context context = EmergencyActivity2.this;
    @BindView(R.id.pdfView)
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency2);
        ButterKnife.bind(this);
        //appbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  nav drawer
        NavDrawer.navDrawerBtnsClick(context, toolbar);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                pdf("contact.pdf");
                return null;
            }
        }.execute();


    }


    void pdf(String pdf) {
        pdfView.fromAsset(pdf)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(false)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .spacing(0)
                .load();
    }
}
