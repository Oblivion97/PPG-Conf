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
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.A;
import com.example.f.schMon.conf.model.DAO;
import com.example.f.schMon.conf.model.NavDrawer;
import com.example.f.schMon.conf.model.Data;
import com.example.f.schMon.conf.model.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryActivity extends AppCompatActivity {
    private static final String TAG = CountryActivity.class.getName();
    private Context context = CountryActivity.this;
    @BindView(R.id.cList)
    ListView listview;
    SQLiteDatabase db;
    CountryAdapter adapter;
    String theme;
    Integer themeInt;

    @BindView(R.id.cSpinner1)
    Spinner spinner;
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


//___________________Start sync______________________________________

    //_____________________basics_______________________________
    List<Person> list = new ArrayList<>();
    Intent intent;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<String> spinList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);

        //app bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //nav drawer
        NavDrawer.navDrawerBtnsClick(context, toolbar);

        //=============== set data ======================
        intent = getIntent();
        theme = intent.getStringExtra("theme");

        theme = null;
        new MyAsyncTask().execute(theme);

        /*
        list = DAO.getSpekrTopicWise(spinList.get(0));
        adapter = new TopicAdapter(context, -1, list);
        listview.setAdapter(adapter);*/


        //============= spinner =======================

        spinList = Data.getThemeCountryWise();
        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinList);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                theme = spinner.getItemAtPosition(i).toString();
                A.setThemeArea(theme);

                new MyAsyncTask().execute(theme);

                Log.d(TAG, theme);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    //======================== thread ===============================
    class MyAsyncTask extends AsyncTask<String, Void, List<Person>> {

        @Override
        protected List<Person> doInBackground(String... strings) {
            list = DAO.getSpekrCountryWise(strings[0]);
            adapter = new CountryAdapter(context, -1, list);
            return list;
        }


        @Override
        protected void onPostExecute(List<Person> persons) {
            listview.setAdapter(adapter);
           // Helper.getAlertDialog(context, list.toString());
        }
    }
}
