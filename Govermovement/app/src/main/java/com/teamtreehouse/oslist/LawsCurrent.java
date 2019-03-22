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
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.R.layout.simple_selectable_list_item;


public class LawsCurrent extends AppCompatActivity implements View.OnClickListener{

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laws_current);

        setTitle("Current Bills");

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        ImageButton Statebtn = findViewById(R.id.CurrentStateBtn);
        ImageButton Localbtn = findViewById(R.id.CurrentLocalBtn);


        Statebtn.setOnClickListener(this);
        Localbtn.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.CurrentStateBtn:
                openButtonState();
                break;
            case R.id.CurrentLocalBtn:
                openButtonLocal();
                break;
        }
    }

    private void openButtonState() {
        Intent intent1 = new Intent(LawsCurrent.this, CurrentState.class);
        startActivity(intent1);
    }
    private void openButtonLocal() {
        Intent intent2 = new Intent(LawsCurrent.this, CurrentLocal.class);
        startActivity(intent2);
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
                        Intent intent = new Intent(LawsCurrent.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1: //Your Voter Information
                        intent = new Intent(LawsCurrent.this, webview.class);
                        startActivity(intent);
                        break;
                    case 2: //Reps for Election
                        intent = new Intent(LawsCurrent.this, RepsNext.class);
                        startActivity(intent);
                        break;
                    case 3: //Previous Laws
                        intent = new Intent(LawsCurrent.this, PastBills.class);
                        startActivity(intent);
                        break;
                    case 4: //Laws up for Vote
                        intent = new Intent(LawsCurrent.this, LawsCurrent.class);
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
}
