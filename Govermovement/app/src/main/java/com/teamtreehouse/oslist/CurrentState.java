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


public class CurrentState extends AppCompatActivity {

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
        setContentView(R.layout.current_state);


        setTitle("Current Bills");

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        listView = (ExpandableListView)findViewById(R.id.Current_State_Bills);
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
                        Intent intent = new Intent(CurrentState.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1: //Your Voter Information
                        intent = new Intent(CurrentState.this, webview.class);
                        startActivity(intent);
                        break;
                    case 2: //Reps for Election
                        intent = new Intent(CurrentState.this, RepsNext.class);
                        startActivity(intent);
                        break;
                    case 3: //Previous Laws
                        intent = new Intent(CurrentState.this, PastBills.class);
                        startActivity(intent);
                        break;
                    case 4: //Laws up for Vote
                        intent = new Intent(CurrentState.this, LawsCurrent.class);
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

        listDataHeader.add("HB-3 Improve transparency of public data");
        listDataHeader.add("SB-1 Revise drug laws");
        listDataHeader.add("SB-4 Expand expungement and intervention");
        listDataHeader.add("SB-5 Address college affordability");
        listDataHeader.add("HB-4 Prescribe how cocaine is to be measured for offense");
        listDataHeader.add("HB-5 Define \"microbusiness.\"");
        listDataHeader.add("SB-6 Continue Bridge Partnership Program");

        List<String> CbiLL1 = new ArrayList<>();
        CbiLL1.add("This bill proposes to change the way public data of Ohio.gov is posted online.\n" + "\nBill Description:\nTo enact sections 117.432, 117.58, 149.60, 149.61, and 3375.03 of the Revised Code to create the DataOhio Board, to specify requirements for posting public records online, to require the Auditor of State to adopt rules regarding a uniform accounting system for public offices, to establish an online catalog of public data at data.Ohio.gov, to establish the Local Government Information Exchange Grant Program, and to make appropriations.");

        List<String> CbiLL2 = new ArrayList<>();
        CbiLL2.add("This bill proposes to revise and increase penalties for drug trafficking, drug possession violations, and aggravated funding of drug trafficking.\n"+"\nBill Description:\nTo amend sections 2925.01, 2925.02, 2925.03, 2925.04, 2925.05, 2925.11, 2925.13, 2925.36, 2929.01, 2929.13, 2929.14, 2941.1410, 3719.41, 3719.99, and 4729.99 of the Revised Code to increase penalties for drug trafficking violations, drug possession violations, and aggravated funding of drug trafficking when the drug involved in the offense is a fentanyl-related compound, except for drug possession violations when the fentanyl-related compound is combined with marihuana or a Schedule III, IV, or V controlled substance and the offender did not know of the fentanyl content; to revise the manner of determining sentence for certain violations of the offense of permitting drug abuse; and to add lisdexamfetamine to the list of schedule II controlled substances." );

        List<String> CbiLL3 = new ArrayList<>();
        CbiLL3.add("This bill proposes to allow a person to apply to a court to remove his/her personal record if that person was found not guilty of a charge, if the charge was for being a human trafficking victim.\n"+"\nBill description:\nTo amend sections 2951.041 and 2953.38 and to enact section 2953.521 of the Revised Code to allow a person who is found not guilty of an offense or who is the defendant named in a dismissed criminal charge to apply for a court order to expunge the person's official records in the case if the charge or not guilty finding was the result of the applicant having been a human trafficking victim; to allow a person convicted of certain prostitution-related offenses to apply for the expungement of the conviction record of any offense, other than a specified disqualifying offense, the person's participation in which was a result of having been a human trafficking victim; and to allow intervention in lieu of conviction for persons charged with committing an offense while a victim of compelling prostitution." );

        List<String> CbiLL4 = new ArrayList<>();
        CbiLL4.add("This bill proposes to increase the maximum income tax deduction for contributions to college savings accounts and disability expense savings accounts.\n"+"\nBill Description:\nTo amend section 5747.70 of the Revised Code to increase the maximum income tax deduction for contributions to college savings accounts and disability expense savings accounts to $4,000 annually for each beneficiary, to create the Joint Committee on Ohio College Affordability, and to declare an emergency." );

        List<String> CbiLL5 = new ArrayList<>();
        CbiLL5.add("This bill proposes to determine the amount of cocaine that will dictate trafficking and possession offenses\n"+"\nBill Description:\nTo amend sections 2925.03 and 2925.11 of the Revised Code to provide that in determining the amount of cocaine for trafficking and possession offenses, it also includes a compound, mixture, preparation, or substance containing cocaine, and to declare an emergency." );

        List<String> CbiLL6 = new ArrayList<>();
        CbiLL6.add("This bill proposes to create a definition for microbusinesses\n"+"\nBill Description:\nTo enact section 166.50 of the Revised Code to create a statutory definition of \"microbusiness.\"" );

        List<String> CbiLL7 = new ArrayList<>();
        CbiLL7.add("This bill proposes to extend the Ohio Bridge Partnership Program through the end of fiscal year 2019.\n"+"\nBill Description:\nTo enact section 5501.491 of the Revised Code to extend the Ohio Bridge Partnership Program through the end of fiscal year 2019 and to require the Director of Transportation to submit a report to the Governor, Senate, and House of Representatives recommending ways to continue to fund the program." );


        listHash.put(listDataHeader.get(0), CbiLL1);
        listHash.put(listDataHeader.get(1), CbiLL2);
        listHash.put(listDataHeader.get(2), CbiLL3);
        listHash.put(listDataHeader.get(3), CbiLL4);
        listHash.put(listDataHeader.get(4), CbiLL5);
        listHash.put(listDataHeader.get(5), CbiLL6);
        listHash.put(listDataHeader.get(6), CbiLL7);





    }
}
