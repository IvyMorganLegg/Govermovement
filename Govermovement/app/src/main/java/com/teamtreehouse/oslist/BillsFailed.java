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

public class BillsFailed extends AppCompatActivity {
    private ExpandableListView listView;
    private ExpendableListAdapterFailedBills listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills_failed);

        mDrawerList = findViewById(R.id.navList);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        listView = (ExpandableListView)findViewById(R.id.FailedBillsExp);
        initData();
        listAdapter = new ExpendableListAdapterFailedBills(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);

    }

    private void initData()
    {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Jefferson Township Current Levy Addition");//Header/title goes here
        listDataHeader.add("Bexley City Charter Amendments");//Header/title goes here
        listDataHeader.add("Gahanna Heights School District Levy Addition");//Header/title goes here
        listDataHeader.add("Impeaching Donald John Trump, President of the United States, of high misdemeanors ");//Header/title goes here
        listDataHeader.add("Pain-Capable Unborn Child Protection Act");//Header/title goes here

        List<String> bill1 = new ArrayList<>();
        bill1.add("This measure sought to add to the current levy by a " +
                " rate of $.20 per $100 of assessed property value for a further " +
                " five years in order to continue to pay for current expenses in the township.");//Contents of bills goes here
        bill1.add("Year:2012");
        bill1.add("Source:https://ballotpedia.org/Jefferson_Township_Current_Levy_Addition_(March_2012)");

        List<String> bill2 = new ArrayList<>();
        bill2.add("The first measure sought to amend the charter so as to eliminate the County Auditor position" +
                " and replace it with an appointed Finance Director. ");//Contents of bills goes here
        bill2.add("Year:2011");
        bill2.add("Source:https://ballotpedia.org/Bexley_City_Charter_Amendments,_4_(November_2011)");

        List<String> bill3 = new ArrayList<>();
        bill3.add("The Gahanna Heights school measure sought to add $.68 per $100 to the current property tax rate" +
                " for a further period of time in order to help pay for current expenses at the school district");//Contents of bills goes here
        bill3.add("Year:2010");
        bill3.add("Source:https://ballotpedia.org/Bexley,_%26_Gahanna_Heights_School_District_Levy_Additions,_2_(November_2010)");

        List<String> bill4 = new ArrayList<>();
        bill4.add("Rep. Al Green introduced articles of impeachment against President Trump. The bill did not move forward." +
                " Green accesses the president of bringin 'disrepute, contempt, ridicule and disgrace on the Presidency', " +
                " 'associating... the presidency with causes rooted in white supremacy, bigotry, racism, anti-Semitism,and white" +
                " nationalism', and also 'inciting hate and hostility.. on the basis of race, national origin, religion, gender, and " +
                " sexual orientation'.");//Contents of bills goes here
        bill4.add("Year:2018");
        bill4.add("Source:https://www.govtrack.us/congress/bills/115/hres646");

        List<String> bill5 = new ArrayList<>();
        bill5.add("This bill amends the federal criminal code to make it a crime for any person to perform or attempt to perform an abortion " +
                " if the probable post-fertilization age of the fetus is 20 weeks or more. A violator is subject to criminal penalties—a fine," +
                " up to five years in prison, or both. The bill provides exceptions for an abortion: (1) that is necessary to save the life of the " +
                " pregnant woman, or (2) when the pregnancy is the result of rape or incest. A physician who performs or attempts to perform an abortion " +
                " under an exception must comply with specified requirements. A woman who undergoes a prohibited abortion may not be prosecuted for violating or " +
                " conspiring to violate the provisions of this bill");//Contents of bills goes here
        bill5.add("Year:2018");
        bill5.add("Source:https://www.govtrack.us/congress/bills/115/s2311/summary");

        listHash.put(listDataHeader.get(0),bill1);
        listHash.put(listDataHeader.get(1),bill2);
        listHash.put(listDataHeader.get(2),bill3);
        listHash.put(listDataHeader.get(3),bill4);
        listHash.put(listDataHeader.get(4),bill5);
    }
    //Opens current state bills after button was clicked
    private void openPassedBills() {
        Intent intent3 = new Intent(this, BillsPassed.class);
        startActivity(intent3);
    }

    //Opens current local bills after button was clicked
    private void openLocalLaws() {
        Intent intent3 = new Intent(this, BillsFailed.class);
        startActivity(intent3);
    }

    private void addDrawerItems() {
        String[] Array = {"Home", "Your Voter Information", "Upcoming Elections", "Previously Voted Upon Bills", "Bills up for Vote"};
        ArrayAdapter<String> mAdapter;
        mAdapter = new ArrayAdapter<>(this, simple_selectable_list_item, Array);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                switch (position) {
                    case 0: //Home
                        Intent intent = new Intent(BillsFailed.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1: //Your Voter Information
                        intent = new Intent(BillsFailed.this, webview.class);
                        startActivity(intent);
                        break;
                    case 2: //Reps for Election
                        intent = new Intent(BillsFailed.this, RepsNext.class);
                        startActivity(intent);
                        break;
                    case 3: //Previous Laws
                        intent = new Intent(BillsFailed.this, PastBills.class);
                        startActivity(intent);
                        break;
                    case 4: //Laws up for Vote
                        intent = new Intent(BillsFailed.this, LawsCurrent.class);
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
}
