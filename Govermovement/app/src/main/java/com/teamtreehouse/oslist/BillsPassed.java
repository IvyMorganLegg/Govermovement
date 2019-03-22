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

public class BillsPassed extends AppCompatActivity {
    private ExpandableListView listView;//calls on expendablelistview to be used in code
    private ExpendableListAdapter listAdapter;//calls on Expendablelistadapter list adatpter class to be used in code.
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash; //HashMap stores mapping(Tables/list)Mapping is adding value to keys
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills_passed);//attached activity

        mDrawerList = findViewById(R.id.navList);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        listView = (ExpandableListView)findViewById(R.id.PassedBillsExp);//find list view labled in actibity
        initData();
        listAdapter = new ExpendableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);//set adapter to listview

    }

    private void initData()
    {
        listDataHeader = new ArrayList<>();//create array of headers
        listHash = new HashMap<>();
//headers to be used
        listDataHeader.add("Franklin County Disabilities Board Levy Replacement");
        listDataHeader.add("Franklin County Aging Office Tax Levy Question");
        listDataHeader.add(" Franklin County Children's Services Levy Referendum");
        listDataHeader.add("Department of Homeland Security Appropriations Act");
        listDataHeader.add("Violence Against Women Reauthorization Act");

        List<String> bill1 = new ArrayList<>();//String to be added to bills
        bill1.add("It was a measure that sought to replace disabilities board levy in 2017 with one set" +
                " a rate of $.35 per $100 of assessed property value for a period of six years in order to help pay for community" +
                " programs and services offered to mentally disabled residents in the county.");
        bill1.add("Year:2017");
        bill1.add("Source: https://ballotpedia.org/Franklin_County_Disabilities_Board_Levy_Replacement_(November_2011) ");//Contents of bills goes here

        List<String> bill2 = new ArrayList<>();
        bill2.add("This question authorized Franklin County to impose a replacement property tax" +
                " levy of 0.9 and increase it by 0.4 mills resulting in a property tax levy of 1.3" +
                " mills($1.3 per $1,00 of assessed valuation) for five years in order to fund support " +
                " for senior citizen services");//Contents of bills goes here
        bill2.add("Year:2012");
        bill2.add("Source:https://ballotpedia.org/Franklin_County_Aging_Office_Tax_Levy_Question_(November_2012)");


        List<String> bill3 = new ArrayList<>();
        bill3.add(" Franklin County Children's Services Levy Referendum was a levy to replace an exiting levy." +
                " The levy issues a replacement tax of 3.15 mills with a decrease of 0.05 mills to constitute" +
                " a tax of 3.1 mills($0.31 per valuation) for 10 years, starting in 2009 to support " +
                " Franklin county Children Services, protecting the abused and neglected children and families. ");//Contents of bills goes here
        bill3.add("Year:2009");
        bill3.add("Sources:https://ballotpedia.org/Franklin_County_Children%27s_Services_Levy_Referendum_(2009)");

        List<String> bill4 = new ArrayList<>();
        bill4.add("The Department of Homeland Security Appropriations Act, 2015 provides Fiscal Year 2015 appropriations for " +
                " the Department of Homeland Security (DHS), including U.S. Customs and Border Protection (CBP), " +
                " the U.S. Coast Guard, U.S. Immigration and Customs Enforcement (ICE), the Transportation Security Administration (TSA), " +
                " the Federal Emergency Management Agency, the U.S. Secret Service, and other DHS programs.The Act decreases " +
                " funding below Fiscal Year 2014 levels for TSA and the U.S Coastal Guard.The Act does not include House-passed amendments " +
                " that prohibit funding from being used for several immigration policies that the Administration is implementing by executive action. ");//Contents of bills goes here
        bill4.add("Year:2015");
        bill4.add("Sources:https://www.congress.gov/bill/114th-congress/house-bill/240");

        List<String> bill5 = new ArrayList<>();
        bill5.add("Violence Against Women Reauthorization Act of 2013 - (Sec. 3) Amends the Violence Against Women Act of 1994 (VAWA)" +
                " to add or expand definitions of several terms used in such Act, including : (1) \"culturally specific services\" to mean " +
                " community-based services that offer culturally relevant and linguistically specific services and resources to culturally " +
                " specific communities; (2) \"personally identifying information or personal information\" with respect to a victim of domestic " +
                " violence, dating violence, sexual assault, or stalking; (3) \"underserved populations\" as populations that face barriers in accessing" +
                "  and using victim services because of geographic location, religion, sexual orientation or gender identity; and (4) \"youth\" to mean a " +
                " person who is 11 to 24 years old.Requires the Office on Violence Against Women of the Department of Justice (DOJ) to establish a biennial " +
                " conferral process with state and tribal coalitions, technical assistance providers, and other key stakeholders on the administration of " +
                " grants and related matters.Requires the Attorney General to authorize in writing spending money for DOJ conferences that exceed $20,000.");//Contents of bills goes here
        bill5.add("Year:2013");
        bill5.add("Sources:https://www.congress.gov/bill/113th-congress/senate-bill/47");
//put and add values
        listHash.put(listDataHeader.get(0),bill1);
        listHash.put(listDataHeader.get(1),bill2);
        listHash.put(listDataHeader.get(2),bill3);
        listHash.put(listDataHeader.get(3),bill4);
        listHash.put(listDataHeader.get(4),bill5);
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
                        Intent intent = new Intent(BillsPassed.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1: //Your Voter Information
                        intent = new Intent(BillsPassed.this, webview.class);
                        startActivity(intent);
                        break;
                    case 2: //Reps for Election
                        intent = new Intent(BillsPassed.this, RepsNext.class);
                        startActivity(intent);
                        break;
                    case 3: //Previous Laws
                        intent = new Intent(BillsPassed.this, PastBills.class);
                        startActivity(intent);
                        break;
                    case 4: //Laws up for Vote
                        intent = new Intent(BillsPassed.this, LawsCurrent.class);
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

