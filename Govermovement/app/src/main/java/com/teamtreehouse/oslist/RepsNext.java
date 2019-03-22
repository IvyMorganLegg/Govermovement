package com.teamtreehouse.oslist;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.R.layout.simple_selectable_list_item;


public class RepsNext extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reps_next);

        mDrawerList = findViewById(R.id.navList);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setTitle("Upcoming Elections");

        listView = findViewById(R.id.Elections);
        initData();
        listAdapter = new DataAdapterElection(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    private void addDrawerItems() {
        String[] Array = { "Home", "Your Voter Information", "Upcoming Elections", "Previously Voted Upon Laws", "Laws up for Vote" };
        ArrayAdapter<String> mAdapter;
        mAdapter = new ArrayAdapter<>(this, simple_selectable_list_item, Array);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                switch (position) {
                    case 0: //Home
                        Intent intent = new Intent(RepsNext.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1: //Your Voter Information
                        intent = new Intent(RepsNext.this, webview.class);
                        startActivity(intent);
                        break;
                    case 2: //Reps for Election
                        intent = new Intent(RepsNext.this, RepsNext.class);
                        startActivity(intent);
                        break;
                    case 3: //Previous Laws
                        intent = new Intent(RepsNext.this, PastBills.class);
                        startActivity(intent);
                        break;
                    case 4: //Laws up for Vote
                        intent = new Intent(RepsNext.this, LawsCurrent.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // Activate the navigation drawer toggle
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);

    }

    private ExpandableListView listView;
    private DataAdapterElection listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;


    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Types of Elections");
        listDataHeader.add("Primary Election - May 8, 2018");
        listDataHeader.add("Special Election - August 7, 2018");
        listDataHeader.add("General Election - November 6, 2018");


        List<String> Election1 = new ArrayList<>();
        Election1.add("There are three basic types -- primary, general and local. " +
                "In addition, \"special elections\" can be called which are limited to" +
                "one specific purpose." );

        List<String> Election2 = new ArrayList<>();
        Election2.add("A primary election is an election in which registered voters select " +
                "a candidate that they believe should be a political party's candidate for " +
                "elected office to run in the general election. They are also used to choose " +
                "convention delegates and party leaders. Primaries are state-level and " +
                "local-level elections that take place prior to a general election. Ohio " +
                "uses an open primary system. In an open primary system, a voter does " +
                "not have to register with a political party beforehand in order to vote in " +
                "that party's primary. You can select your preferred party primary " +
                "ballots at your polling place on Election Day." );

        List<String> Election3 = new ArrayList<>();
        Election3.add("A special election for Ohio's 12th congressional" +
                "district will be held August 7, 2018, following the resignation" +
                "of U.S. Representative Pat Tiberi. Special elections are held to fill the vacancies " +
                "that occur when a Senator dies or resigns before the completion " +
                "of his or her six-year term. Winners of these special elections " +
                "typically serve the remainder of the term of the senator who has " +
                "caused the vacancy. " );

        List<String> Election4 = new ArrayList<>();
        Election4.add("General elections occur every two to six years " +
                "depending on the positions being filled, with most positions " +
                "good for four years. These include the presidential election," +
                "Senate election, House election, and local election like a mayor. " );


        listHash.put(listDataHeader.get(0), Election1);
        listHash.put(listDataHeader.get(1), Election2);
        listHash.put(listDataHeader.get(2), Election3);
        listHash.put(listDataHeader.get(3), Election4);

    }
}
