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
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


import static android.R.layout.simple_selectable_list_item;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerList = findViewById(R.id.navList);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ImageButton Button1 = findViewById(R.id.imageButton);
        ImageButton Button2 = findViewById(R.id.imageButton2);
        ImageButton Button3= findViewById(R.id.imageButton3);

        Button1.setOnClickListener(this);
        Button2.setOnClickListener(this);
        Button3.setOnClickListener(this);

        TextView description = (TextView)findViewById(R.id.description);


    }



    private void addDrawerItems() {
        String[] Array = { "Home", "Your Voter Information", "Upcoming Elections", "Previously Voted Upon Bills", "Bills up for Vote" };
        ArrayAdapter<String> mAdapter;
        mAdapter = new ArrayAdapter<>(this, simple_selectable_list_item, Array);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                switch (position) {
                    case 0: //Home
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1: //Your Voter Information
                        intent = new Intent(MainActivity.this, webview.class);
                        startActivity(intent);
                        break;
                    case 2: //Reps for Election
                        intent = new Intent(MainActivity.this, RepsNext.class);
                        startActivity(intent);
                        break;
                    case 3: //Previous Laws
                        intent = new Intent(MainActivity.this, PastBills.class);
                        startActivity(intent);
                        break;
                    case 4: //Laws up for Vote
                        intent = new Intent(MainActivity.this, LawsCurrent.class);
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
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);

    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButton:
                openWebView1();
                break;
            case R.id.imageButton2:
                openWebView2();
                break;
            case R.id.imageButton3:
                openWebView3();
                break;
        }
}


    private void openWebView1() {
        Intent intent = new Intent(MainActivity.this, webview1.class);
        startActivity(intent);
    }
    private void openWebView2() {
        Intent intent = new Intent(MainActivity.this, webview2.class);
        startActivity(intent);
    }
    private void openWebView3() {
        Intent intent = new Intent(MainActivity.this, webview3.class);
        startActivity(intent);
    }
}
