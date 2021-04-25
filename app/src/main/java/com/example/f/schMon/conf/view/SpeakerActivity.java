/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.DAO;
import com.example.f.schMon.conf.model.Resume;
import com.example.f.schMon.conf.model.NavDrawer;
import com.example.f.schMon.conf.model.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpeakerActivity extends AppCompatActivity {
    private static final String TAG = SpeakerActivity.class.getName();
    private Context context = SpeakerActivity.this;
    @BindView(R.id.cList)
    ListView listview;
    SQLiteDatabase db;
    SpeakerAdapter adapter;
    String theme;
    List<Person> list = new ArrayList<>();
    List<Person> listBck = new ArrayList<>();
    Intent intent;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<String> spinList;
    @BindView(R.id.cSpinner1)
    Spinner spinner;
    SearchView searchView;
    MenuItem myActionMenuItem;
    //___________________Start option menu______________________________________


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);//Menu Resource, Menu


        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

       /* myActionMenuItem = menu.findItem(R.id.search_menu);
        searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        searchView.setSearchableInfo(                searchManager.getSearchableInfo(getComponentName()));

*/

      /*  searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Toast like print
                UserFeedback.show( "SearchOnQueryTextSubmit: " + query);
                if( ! searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                return false;
            }
        });
*/


        return true;
    }

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker);
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

        adapter = new SpeakerAdapter(context, -1, list);// for removing null exception in search adapter.clear()
        new MyAsyncTask().execute(theme);


//=============================search==============================================
        searchView = findViewById(R.id.search);
        //searchView.setIconified(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String find) {
                //adapter.getFilter().filter(find);
                search(find);
                return false;
            }
        });
    }


    void search(String find) {
        List<Person> temp = new ArrayList<>();
        if (find != null && find.length() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String t = list.get(i).name.toLowerCase();
                find = find.toLowerCase();

                if (t.contains(find)) {
                    temp.add(list.get(i));
                }
            }
            adapter.clear();
            adapter.addAll(temp);
            adapter.notifyDataSetChanged();
        } else {
            adapter.clear();
            adapter.addAll(listBck);
            adapter.notifyDataSetChanged();
        }
    }

    //======================== thread ===============================
    class MyAsyncTask extends AsyncTask<String, Void, List<Person>> {

        @Override
        protected List<Person> doInBackground(String... strings) {
            list = DAO.getSpeakerAllNew();
            list = Resume.formatPersonForAdapterList(list);
            listBck.addAll(list);
            adapter = new SpeakerAdapter(context, -1, list);
            return list;
        }


        @Override
        protected void onPostExecute(List<Person> persons) {
            listview.setAdapter(adapter);
            // Log.d(TAG, list.toString());
        }
    }
}
