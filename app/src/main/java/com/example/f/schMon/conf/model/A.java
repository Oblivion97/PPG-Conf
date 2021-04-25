/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.model;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.f.schMon.Old.Global;
import com.example.f.schMon.Old.analyseTemp.SQLiteDbHelper;
import com.example.f.schMon.R;
import com.example.f.schMon.conf.view.CVActivity;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Mir Ferdous on 11/06/2017.
 */


public class A extends Application {
    /**
     * this is global class
     */
    private static Context context;
    private static A instance;
    private String TAG = this.getClass().getName();

    private SQLiteDbHelper sqLiteDbHelper;
    private String dbName = "schoolMonDB.db";
    private int ver = 1;
    public static int listPosition;
    private static String u;
    private static String p;

    private static String themeArea;

    private static List<String> themeList;

    private static Person person;
    //=============== conf ==================


    public static Person getPerson() {
        return person;
    }

    public static void setPerson(Person person) {
        A.person = person;
    }

    public static String getThemeArea() {
        return themeArea;
    }

    public static void setThemeArea(String themeArea) {
        A.themeArea = themeArea;
    }


    public static List<String> getThemeList() {
        return themeList;
    }

    public static void setThemeList(List<String> themeList) {
        A.themeList = themeList;
    }

    public static Context getAppContext() {
        return getInstance().context;
    }

    public static A getInstance() {
        if (instance == null) {
            instance = new A();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        Global.getDB_with_AssetHelper_readable(Global.dbName);
        /**db copy from asset*/

        //this.instance = this;
        // this.sqLiteDbHelper = SQLiteDbHelper.getInstance(getApplicationContext(), dbName, null, ver);
    }

    //============= global database variable ===================
    public SQLiteDatabase getDatabase() {
        return sqLiteDbHelper.getWritableDatabase();
    }

    public static int getListPosition() {
        return listPosition;
    }

    public static void setListPosition(int mlistPosition) {
        listPosition = mlistPosition;
    }



    private static final int STORAGE_PERMISSION = 120;

    @AfterPermissionGranted(STORAGE_PERMISSION)
    void copyDB() {

        String[] perms = {Manifest.permission.READ_PHONE_STATE};
        if (EasyPermissions.hasPermissions(this, perms)) {



        } else {
            EasyPermissions.requestPermissions(this, "This App needs Storage Permission to Run Properly",
                    STORAGE_PERMISSION, perms);
        }
    }






}


