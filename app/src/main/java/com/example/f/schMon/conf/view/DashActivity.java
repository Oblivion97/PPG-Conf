/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.Resume;
import com.example.f.schMon.conf.model.NavDrawer;
import com.github.barteksc.pdfviewer.PDFView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName();
    private final Context context = DashActivity.this;

    @BindView(R.id.pdfView)
    PDFView pdfView;

    @BindView(R.id.confDashIMG)
    ImageView bck;
    //___________________start option menu______________________________________


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);//Menu Resource, Menu
        return true;
    }

    /**
     * hiding irrelevant option menu for this Activity
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(R.id.home_menu).setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //___________________End option menu______________________________________


    //_________________Start of Sync_______________________________

    String pdf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        ButterKnife.bind(this);
        //appbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //  nav drawer
        NavDrawer.navDrawerBtnsClick(context, toolbar);


        //pdf
        pdf = "poster.pdf";


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                pdf();
                return null;
            }
        }.execute();




        /*
        //glide

        RequestOptions options = new RequestOptions();
        options.centerCrop();

        Glide.with(this)
                .load(Uri.parse("file:///android_asset/poster.jpg")).apply(options)
                .into(bck);

*/


    }


    void pdf() {
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
