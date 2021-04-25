/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.NavDrawer;
import com.github.barteksc.pdfviewer.PDFView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CVActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    private final Context context = CVActivity.this;

    @BindView(R.id.pdfView)
    PDFView pdfView;


    //___________________start option menu______________________________________


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);//Menu Resource, Menu
        return true;
    }

    String pdf;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.home_menu:
                startActivity(new Intent(context, DashActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);
        ButterKnife.bind(this);

        //appbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, KeyProfActivity.class));
            }
        });
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //  nav drawer
        NavDrawer.navDrawerBtnsClick(context, toolbar);


        pdf = "cv.pdf";
        pdf();
    }

    void pdf() {
        pdfView.fromAsset(pdf)
                // .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
               /* .onDraw(onDrawListener)
                // allows to draw something on all pages, separately for every page. Called only for visible pages
                .onDrawAll(onDrawListener)
                .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
                .onPageChange(onPageChangeListener)
                .onPageScroll(onPageScrollListener)
                .onError(onErrorListener)
                .onRender(onRenderListener) // called after document is rendered for the first time
                // called on single tap, return true if handled, false to toggle scroll handle visibility
                .onTap(onTapListener)*/
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .load();
    }
}
