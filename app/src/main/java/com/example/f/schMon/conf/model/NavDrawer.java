/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.model;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.view.AboutActivity;
import com.example.f.schMon.conf.view.AboutActivity2;
import com.example.f.schMon.conf.view.CodexAcitvity;
import com.example.f.schMon.conf.view.ContribActivity;
import com.example.f.schMon.conf.view.CountryActivity;
import com.example.f.schMon.conf.view.DashActivity;
import com.example.f.schMon.conf.view.EmergencyActivity;
import com.example.f.schMon.conf.view.EmergencyActivity2;
import com.example.f.schMon.conf.view.KeyProfActivity;
import com.example.f.schMon.conf.view.MapActivity;
import com.example.f.schMon.conf.view.ScheduleActivity;
import com.example.f.schMon.conf.view.SpeakerActivity;
import com.example.f.schMon.conf.view.TopicActivity;
import com.example.f.schMon.conf.view.VenueActivity;

/**
 * Created by Mir Ferdous on 04/09/2017.
 */

public class NavDrawer {
    public static void navDrawerBtnsClick(final Context context, Toolbar toolbar) {

        final AppCompatActivity appCompatActivity = (AppCompatActivity) context;

        // ________________ StartOfApp Nav Drawer ________________

        DrawerLayout drawer = appCompatActivity.findViewById(R.id.drawer_layout);

        NavigationView navigationView = appCompatActivity.findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView text = headerView.findViewById(R.id.text);
        Resume.setFont(context, new View[]{text});


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                appCompatActivity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                Intent intent;
                if (id == R.id.Poster) {

                    intent = new Intent(context, DashActivity.class);
                    appCompatActivity.startActivity(intent);
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

                } else if (id == R.id.Speakers) {

                    intent = new Intent(context, SpeakerActivity.class);
                    intent.putExtra("theme", Data.topicWisDefalut);
                    appCompatActivity.startActivity(intent);
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                } else if (id == R.id.SpeakerTopic) {

                    intent = new Intent(context, TopicActivity.class);
                    intent.putExtra("theme", Data.topicWisDefalut);
                    appCompatActivity.startActivity(intent);
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                } else if (id == R.id.SpeakerCountry) {

                    intent = new Intent(context, CountryActivity.class);
                    intent.putExtra("theme", Data.countryWisDefalut);
                    appCompatActivity.startActivity(intent);
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

                } else if (id == R.id.Contributors) {

                    intent = new Intent(context, ContribActivity.class);
                    appCompatActivity.startActivity(intent);
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

                } else if (id == R.id.Schedule) {

                    intent = new Intent(context, ScheduleActivity.class);
                    appCompatActivity.startActivity(intent);
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);


                } else if (id == R.id.KeyNote) {

                    intent = new Intent(context, KeyProfActivity.class);
                    appCompatActivity.startActivity(intent);
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);


                } else if (id == R.id.Venu) {

                    appCompatActivity.startActivity(new Intent(context, VenueActivity.class));
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

                } else if (id == R.id.Map) {

                    appCompatActivity.startActivity(new Intent(context, MapActivity.class));
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

                } else if (id == R.id.CodexUnicorn) {

                    appCompatActivity.startActivity(new Intent(context, CodexAcitvity.class));
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
                } else if (id == R.id.Emergency) {

                    appCompatActivity.startActivity(new Intent(context, EmergencyActivity2.class));
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

                }
                else if (id == R.id.AboutUS) {

                    appCompatActivity.startActivity(new Intent(context, AboutActivity2.class));
                    appCompatActivity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

                }

                DrawerLayout drawer = appCompatActivity.findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        // ________________ End Nav Drawer Menu ________________


        //____________________________ header click user profile opens _______________________________________________________________

        headerView.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, KeyProfActivity.class);
                //   context.startActivity(intent);
            }
        });


    }
}
