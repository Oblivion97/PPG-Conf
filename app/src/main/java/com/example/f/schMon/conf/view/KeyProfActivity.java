/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.Resume;
import com.example.f.schMon.conf.model.NavDrawer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;


public class KeyProfActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName();
    private final Context context = KeyProfActivity.this;
    private SQLiteDatabase db;

    @BindView(R.id.confCV)
    Button cv;

//___________________Start option menu______________________________________

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);//Menu Resource, Menu
        return true;
    }

    /**
     * hiding irrelevant option menu for this Activity
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_menu:
                Intent intent = new Intent(context, DashActivity.class);
                context.startActivity(intent);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //___________________End option menu______________________________________
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_prof);
        ButterKnife.bind(this);

        //appbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, DashActivity.class));
            }
        });
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*_____ nav drawer _____*/
         NavDrawer.navDrawerBtnsClick(context, toolbar);


    }


    @OnClick(R.id.confCV)
    public void onClickShowCV(View view) {
        copyDB();

    }

    Snackbar snacBa;


    private static final int STORAGE_PERMISSION = 120;

    @AfterPermissionGranted(STORAGE_PERMISSION)
    void copyDB() {

        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {

            Resume.copyDataBase(context, null, null);
            snacBa = Snackbar.make(cv, "CV Downloaded", Snackbar.LENGTH_INDEFINITE)
                    .setActionTextColor(getResources().getColor(R.color.white))
                    .setAction("Open CV", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(context, CVActivity.class));
                        }
                    });
            snacBa.show();
        } else {
            EasyPermissions.requestPermissions(this, "This App needs Storage Permission to Run Properly",
                    STORAGE_PERMISSION, perms);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
