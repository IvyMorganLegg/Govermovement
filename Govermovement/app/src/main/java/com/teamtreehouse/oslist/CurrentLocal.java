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


public class CurrentLocal extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    private ExpandableListView listView;
    private DataAdapterCurrentState listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_local);


        setTitle("Current Local");

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        listView = (ExpandableListView)findViewById(R.id.Current_Local_Bills);
        initData();
        listAdapter = new DataAdapterCurrentState(this, listDataHeader, listHash);
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
                        Intent intent = new Intent(CurrentLocal.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1: //Your Voter Information
                        intent = new Intent(CurrentLocal.this, webview.class);
                        startActivity(intent);
                        break;
                    case 2: //Reps for Election
                        intent = new Intent(CurrentLocal.this, RepsNext.class);
                        startActivity(intent);
                        break;
                    case 3: //Previous Laws
                        intent = new Intent(CurrentLocal.this, PastBills.class);
                        startActivity(intent);
                        break;
                    case 4: //Laws up for Vote
                        intent = new Intent(CurrentLocal.this, LawsCurrent.class);
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


    // Lite Productions!
    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("#2 Gahanna Jefferson City School District – Proposed Bond Issue and Tax Levy-Additional");
        listDataHeader.add("#5A Columbus 7-B Local Option Precinct Wide");
        listDataHeader.add("#6A Columbus 7-B Local Option Precinct Wide");
        listDataHeader.add("#7A Columbus 7-D Local Option Precinct Wide");
        listDataHeader.add("#8A Columbus 7-D Local Option Precinct Wide");
        listDataHeader.add("#9b Columbus 18-B Local Option Particular Location");
        listDataHeader.add("#10b Columbus 19-B Local Option Particular Location");
        listDataHeader.add("#11b Columbus 25-G Local Option Particular Location");
        listDataHeader.add("#12b Columbus 40-C Local Option Particular Location");
        listDataHeader.add("#14A Dublin 2-F Local Option Particular Location");
        listDataHeader.add("#14b Dublin 2-F Local Option Particular Location");
        listDataHeader.add("#15b Gahanna 2-D Local Option Particular Location");
        listDataHeader.add("#16b Gahanna 2-D Local Option Particular Location");
        listDataHeader.add("#17b Grandview-E Local Option Particular Location");
        listDataHeader.add("#18A Westerville 1-D Local Option Particular Location");
        listDataHeader.add("#18b Westerville 1-D Local Option Particular Location");
        listDataHeader.add("#19 Mifflin Township – Proposed Tax Levy – Replacement and Increase");
        listDataHeader.add("#20 Prairie Township – Proposed Tax Levy – Additional");

        List<String> CbiLL1 = new ArrayList<>();
        CbiLL1.add("Bonds – constructing school Facilities, including a new elementary school, and renovating, repairing, improving, and constructing improvements and additions to existing facilities and sites thereof.\n" +
                "Levy – current operating expenses" );

        List<String> CbiLL2 = new ArrayList<>();
        CbiLL2.add("Sale of Beer for off-premises consumption." );

        List<String> CbiLL3 = new ArrayList<>();
        CbiLL3.add("Sale of Wine & Mixed Beverages for off-premises consumption." );

        List<String> CbiLL4 = new ArrayList<>();
        CbiLL4.add("Sale of Beer for off-premises consumption." );

        List<String> CbiLL5 = new ArrayList<>();
        CbiLL5.add("Sale of Wine & Mixed Beverages for off-premises consumption.");

        List<String> CbiLL6 = new ArrayList<>();
        CbiLL6.add("Sunday Sales (10am-midnight) (Wine/Mixed & Spirituous Liquor) Crest Gastropub and Patio\n" +
                "2855 Indianola Ave, Columbus, OH 43202" );

        List<String> CbiLL7 = new ArrayList<>();
        CbiLL7.add("Sunday Sales (10am-midnight) (Wine/Mixed Beverages) Palmer’s Beverage Center\n" +
                "3375 Indianola Ave, Columbus, OH 43214" );

        List<String> CbiLL8 = new ArrayList<>();
        CbiLL8.add("Sunday Sales (10am-midnight) (Wine/Mixed Beverages) American Eagle Discount\n" +
                "1485 Sunbury Rd, Columbus, OH 43219");
        List<String> CbiLL9 = new ArrayList<>();
        CbiLL9.add("Sunday Sales (10am-midnight) (Wine/Mixed Beverages) Brewdog Brewing\n"+
                "1175-1177 N High St, Columbus, OH 43215");
        List<String> CbiLL10 = new ArrayList<>();
        CbiLL10.add("Weekday Sales (Beer, Wine/Mixed & Spirituous Liquor)\n" +
                "Homewood Suites 5300 Parkcenter Ave, Dublin, OH 43017 ");

        List<String> CbiLL11 = new ArrayList<>();
        CbiLL11.add("Sunday Sales (10am-midnight)(Wine/Mixed & Spirituous Liquor)\n" +
                "Homewood Suites 5300 Parkcenter Ave, Dublin, OH 43017");

        List<String> CbiLL12 = new ArrayList<>();
        CbiLL12.add("Sunday Sales (11am-midnight)(Wine/Mixed & Spirituous Liquor)\n" +
                "Mug & Jug 333 Agler Rd, Gahanna, OH 43230 ");

        List<String> CbiLL13 = new ArrayList<>();
        CbiLL13.add("Sunday Sales (11am-midnight)(Wine/Mixed & Spirituous Liquor)\n" +
                "Pub in Gahanna 207 W Johnstown Rd, Gahanna, OH 43230");

        List<String> CbiLL14 = new ArrayList<>();
        CbiLL14.add("Sunday Sales (10am-midnight) (Wine/Mixed Beverages)\n" +
                "Butcher and Grocer 1089 W First Ave, Grandview Heights, OH 43212");

        List<String> CbiLL15 = new ArrayList<>();
        CbiLL15.add("Weekday Sales (Beer, Wine/Mixed & Spirituous Liquor)\n" +
                "Phatt Taco 20 S. State St, Unit K, Westerville, OH 43081 ");

        List<String> CbiLL16 = new ArrayList<>();
        CbiLL16.add("Sunday Sales (10am-midnight)(Wine/Mixed & Spirituous Liquor)\n" +
                "Phatt Taco 20 S. State St, Unit K, Westerville, OH 43081 ");

        List<String> CbiLL17 = new ArrayList<>();
        CbiLL17.add("Police Protection - Replace 3 mills and increase 3 mills for a total of 6 mills, $0.60 per $100 of valuation, for a continuing period of time,commencing in 2018 ");

        List<String> CbiLL18 = new ArrayList<>();
        CbiLL18.add("Fire Protection - 3.61mills, $0.361 per $100 valuation, for a continuing period of time, commencing in 2018 ");





        listHash.put(listDataHeader.get(0), CbiLL1);
        listHash.put(listDataHeader.get(1), CbiLL2);
        listHash.put(listDataHeader.get(2), CbiLL3);
        listHash.put(listDataHeader.get(3), CbiLL4);
        listHash.put(listDataHeader.get(4), CbiLL5);
        listHash.put(listDataHeader.get(5), CbiLL6);
        listHash.put(listDataHeader.get(6), CbiLL7);
        listHash.put(listDataHeader.get(7), CbiLL8);
        listHash.put(listDataHeader.get(8), CbiLL9);
        listHash.put(listDataHeader.get(9), CbiLL10);
        listHash.put(listDataHeader.get(10), CbiLL11);
        listHash.put(listDataHeader.get(11), CbiLL12);
        listHash.put(listDataHeader.get(12), CbiLL13);
        listHash.put(listDataHeader.get(13), CbiLL14);
        listHash.put(listDataHeader.get(14), CbiLL15);
        listHash.put(listDataHeader.get(15), CbiLL16);
        listHash.put(listDataHeader.get(16), CbiLL17);
        listHash.put(listDataHeader.get(17), CbiLL18);






    }
}
