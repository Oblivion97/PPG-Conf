/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.DAO;
import com.example.f.schMon.conf.model.NavDrawer;
import com.example.f.schMon.conf.model.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContribActivity extends AppCompatActivity {
    private static final String TAG = ContribActivity.class.getName();
    private Context context = ContribActivity.this;
    @BindView(R.id.cList)
    ListView listview;
    SQLiteDatabase db;
    ContribAdapter adapter;
    String theme;
    Integer themeInt;


    //___________________Start option menu______________________________________


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);//Menu Resource, Menu
        return true;
    }

//___________________End option menu______________________________________


// __________ nav drawer close on back button click ____________________

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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //_____________________basics_______________________________
    List<Person> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrib);
        ButterKnife.bind(this);

        //app bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //nav drawer
        NavDrawer.navDrawerBtnsClick(context, toolbar);


        //=============== set data ======================


        new MyAsyncTask().execute(theme);


    }

    //======================== thread ===============================
    class MyAsyncTask extends AsyncTask<String, Void, List<Person>> {

        @Override
        protected List<Person> doInBackground(String... strings) {
            list = DAO.getContributor();
            adapter = new ContribAdapter(context, -1, list);
            return list;
        }


        @Override
        protected void onPostExecute(List<Person> persons) {

            listview.setAdapter(adapter);
        }
    }
}
