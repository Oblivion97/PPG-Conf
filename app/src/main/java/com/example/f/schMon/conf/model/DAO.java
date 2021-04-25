/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import com.example.f.schMon.Old.Global;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mir Ferdous on 10/24/2017.
 */

public class DAO {
    public static ArrayList<String> getUniqueThemeOfSpeakers() {
        ArrayList<String> list = new ArrayList<>();
        list.add("The Role of Gender In Policy & Administrative Processes");
        list.add("Institutionalism & Gender Process, Practice & Value");
        list.add("Gender & Practice of Sustainable Development");
        list.add("Gender & Political Value");
        return list;
    }


    public static List<Person> getSpeakerAll(@Nullable String theme) {
        /*if null all data will be in list if theme query will be based on themetic area*/
        List<Person> list = new ArrayList<>();
        Person p;
        SQLiteDatabase db = Global.getDB_with_nativeWay_writable(Global.dbName);
        Cursor c = null;
        String sel = DB.speaker_all.theme + " = ? ";
        String[] selArg = new String[]{theme};

        if (theme == null)
            c = db.query(DB.speaker_all.table, null, null, null, null, null, null);
        else
            c = db.query(DB.speaker_all.table, null, sel, selArg, null, null, null);

        if (c.moveToFirst()) {
            do {
                p = new Person();
                p._id = c.getString(c.getColumnIndex(DB.speaker_all._ID));
                p.sl = c.getString(c.getColumnIndex(DB.speaker_all.sl));
                p.name = c.getString(c.getColumnIndex(DB.speaker_all.name));
                p.topic = c.getString(c.getColumnIndex(DB.speaker_all.topic));
                p.theme = c.getString(c.getColumnIndex(DB.speaker_all.theme));
                p.country = c.getString(c.getColumnIndex(DB.speaker_all.country));
                p.digit = c.getString(c.getColumnIndex(DB.speaker_all.digit));
                list.add(p);
            } while (c.moveToNext());
        }


        if (c != null)
            c.close();

        return list;
    }


    public static List<Person> getSpeakerAllNew() {
        /*if null all data will be in list if theme query will be based on themetic area*/
        List<Person> list = new ArrayList<>();
        Person p;
        SQLiteDatabase db = Global.getDB_with_nativeWay_writable(Global.dbName);
        Cursor c = null;


        c = db.query(DB.speaker_new.table, null, null, null, null, null, null);

        if (c.moveToFirst()) {
            do {
                p = new Person();
                p.sl = c.getString(c.getColumnIndex(DB.speaker_new.sl_no));
                p.name = c.getString(c.getColumnIndex(DB.speaker_new.name));
                p.topic = c.getString(c.getColumnIndex(DB.speaker_new.topic));
                p.venue = c.getString(c.getColumnIndex(DB.speaker_new.venue));
                p.working = c.getString(c.getColumnIndex(DB.speaker_new.working_session));
                p.parallel = c.getString(c.getColumnIndex(DB.speaker_new.parallal_session));
                p.t_d = c.getString(c.getColumnIndex(DB.speaker_new.t_d));
                list.add(p);
            } while (c.moveToNext());
        }


        if (c != null)
            c.close();

        return list;
    }


    public static List<Person> getSpekrTopicWise(@Nullable String theme) {
        /*if null all data will be in list if theme query will be based on themetic area*/
        List<Person> list = new ArrayList<>();
        Person temp;
        SQLiteDatabase db = Global.getDB_with_nativeWay_writable(Global.dbName);
        Cursor c = null;

        String sel = DB.speaker_all.theme + " = ? ";
        String[] selArg = new String[]{theme};


        if (theme == null)
            c = db.query(DB.speaker_all.table, null, null, null, null, null, null);
        else
            c = db.query(DB.speaker_all.table, null, sel, selArg, null, null, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    temp = new Person();
                    temp._id = c.getString(c.getColumnIndex(DB.speaker_all._ID));
                    temp.sl = c.getString(c.getColumnIndex(DB.speaker_all.sl));
                    temp.name = c.getString(c.getColumnIndex(DB.speaker_all.name));
                    temp.theme = c.getString(c.getColumnIndex(DB.speaker_all.theme));
                    temp.topic = c.getString(c.getColumnIndex(DB.speaker_all.topic));
                    list.add(temp);
                } while (c.moveToNext());
            }
        }


        if (c != null)
            c.close();

        return list;
    }


    public static List<Person> getSpekrCountryWise(@Nullable String theme) {
        /*if null all data will be in list if theme query will be based on themetic area*/
        List<Person> list = new ArrayList<>();
        Person temp;
        SQLiteDatabase db = Global.getDB_with_nativeWay_writable(Global.dbName);
        Cursor c = null;

        String sel = DB.countrywise.theme + " = ? ";
        String[] selArg = new String[]{theme};


        if (theme == null)
            c = db.query(DB.countrywise.table, null, null, null, null, null, null);
        else
            c = db.query(DB.countrywise.table, null, sel, selArg, null, null, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    temp = new Person();
                    temp._id = c.getString(c.getColumnIndex(DB.countrywise._ID));
                    temp.sl = c.getString(c.getColumnIndex(DB.countrywise.sl));
                    temp.name = c.getString(c.getColumnIndex(DB.countrywise.name));
                    temp.theme = c.getString(c.getColumnIndex(DB.countrywise.theme));
                    temp.country = c.getString(c.getColumnIndex(DB.countrywise.country));
                    temp.digit = c.getString(c.getColumnIndex(DB.countrywise.digit));

                    list.add(temp);
                } while (c.moveToNext());
            }
        }


        if (c != null)
            c.close();

        return list;
    }


    public static List<Person> getContributor() {
        /*if null all data will be in list if theme query will be based on themetic area*/
        List<Person> list = new ArrayList<>();
        Person temp;
        SQLiteDatabase db = Global.getDB_with_nativeWay_writable(Global.dbName);
        Cursor c = null;


        c = db.query(DB.contributor.table, null, null, null, null, null, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    temp = new Person();
                    temp._id = c.getString(c.getColumnIndex(DB.contributor._ID));
                    temp.sl = c.getString(c.getColumnIndex(DB.contributor.sl));
                    temp.name = c.getString(c.getColumnIndex(DB.contributor.name));
                    temp.designation = c.getString(c.getColumnIndex(DB.contributor.designation));
                    temp.organization = c.getString(c.getColumnIndex(DB.contributor.organization));
                    temp.mail = c.getString(c.getColumnIndex(DB.contributor.mail));

                    list.add(temp);
                } while (c.moveToNext());
            }
        }


        if (c != null)
            c.close();

        return list;
    }


    public static List<Schedule> getSchedule() {
        List<Schedule> list = new ArrayList<>();
        SQLiteDatabase db = Global.getDB_with_nativeWay_writable(Global.dbName);
        Cursor c = null;


        if (c != null)
            c.close();

        return list;
    }

    public static List<String> all_values_from_a_Column(SQLiteDatabase db, String tableName, String column) {
    /* all values(not unique) of a column of any table in DB,*/
        List<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT " + column + " FROM " + tableName, null);

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    list.add(c.getString(c.getColumnIndex(column)));
                } while (c.moveToNext());
            }
        }
        if (c != null)
            c.close();
        return list;
    }

    public static List<String> all_unique_values_from_a_Column(String tableName, String column) {
        /* all values(unique) of a column of any table from DB,*/
        SQLiteDatabase db = Global.getDB_with_nativeWay_writable(Global.dbName);
        List<String> list = new ArrayList<>();
        Cursor c = null;
        String[] proj = new String[]{column};
        c = db.query(tableName, proj, null, null, null, null, null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    String temp = c.getString(c.getColumnIndex(column));
                    if (!list.contains(temp))
                        list.add(temp);
                } while (c.moveToNext());
            }
        }

        if (c != null)
            c.close();

        return list;
    }


}
