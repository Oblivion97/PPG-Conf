/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.f.schMon.Old.Global;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mir Ferdous on 10/24/2017.
 */

public class Resume {

    public static Person makeNonNull(Person in) {
        Person out = new Person();
        out = in;

        out._id = "";
        out.name = "";
        out.country = "";
        out.digit = "";
        out.designation = "";
        out.mail = "";
        out.organization = "";
        out.topic = "";
        out.sl = "";


        return out;
    }

    /*============================== Font ======================================================================================*/
    public static boolean setFont(Context cntx, View[] views) {
        boolean f = true;
        try {
            Typeface codexUnicornFont = Typeface.createFromAsset(cntx.getAssets(), "fonts/codexunicornfont.ttf");
            for (int i = 0; i < views.length; i++)
                if (views[i] instanceof TextView)
                    ((TextView) views[i]).setTypeface(codexUnicornFont);
                else if (views[i] instanceof Button)
                    ((Button) views[i]).setTypeface(codexUnicornFont);
                else if (views[i] instanceof EditText)
                    ((EditText) views[i]).setTypeface(codexUnicornFont);

        } catch (Exception e) {
            e.printStackTrace();
            f = false;
        } finally {
        }
        return f;
    }

    public static int copyDataBase(Context context, String src, String path) {
        String dbName = Global.dbName;

        int success = 0;
        try {


            if (path == null)
                path = SDCardManager.getSdCardPath();

//            InputStream is = new FileInputStream(new File(src));

            InputStream is = context.getAssets().open("cv.pdf");

            OutputStream os = new FileOutputStream(new File(path + "Ragnhild Louise Muriaas cv.pdf"));

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            success = 1;
            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static Person formatPersonForAdapter(Person in) {
        if (in.country == null || in.country.equals(""))
            in.countryExtra = "";
        else in.countryExtra = "Country: " + in.country;

        if (in.digit == null || in.digit.equals(""))
            in.digitExtra = "";
        else in.digitExtra = "  " + in.digit;

        if (in.topic == null || in.topic.equals("")) {
            in.topicExtra = "";
            in.themeExtra = "Theme: " + in.theme;
        } else {
            in.topicExtra = "Paper Title: " + in.topic;
            in.themeExtra = "";
        }

        return in;
    }


    public static List<Person> formatPersonForAdapterList(List<Person> in) {
        List<Person> out = new ArrayList<>();
        for (int i = 0; i < in.size(); i++) {
            out.add(formatPersonForAdapter(in.get(i)));
        }
        return out;
    }


    public static void resume(Context context) {
        String d = "20-11-2017";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String s = simpleDateFormat.format(new Date(System.currentTimeMillis()));


        boolean t = a(d, s);
        if (!t) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }


    public static boolean a(String in, String sys) {
        boolean r = true;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = null, date2 = null;
        try {
            date1 = sdf.parse(in);
            date2 = sdf.parse(sys);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (date1.compareTo(date2) > 0) {
            r = true;
        } else if (date1.compareTo(date2) < 0) {
            r = false;
        } else if (date1.compareTo(date2) == 0) {
            r = true;
        }
        return r;
    }
}
