package com.bws.helttcare;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bws.helthcare.R;

import FragmentView.BloodGlucoseFragment;
import FragmentView.DiagonosisBoardFragment;
import FragmentView.FavouriteFragment;
import FragmentView.FragmentWearable;
import FragmentView.HealthDashBoardFragment;
import FragmentView.HealthMoneteringFragment;
import FragmentView.HealthRecordFragment;
import FragmentView.HeartRateFragment;
import FragmentView.TempretureFragment;
import FragmentView.VideoFragment;
import FragmentView.WeightFragment;
import de.hdodenhof.circleimageview.CircleImageView;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private EndDrawerToggle drawerToggle;
    TextView toolbar_title;

    FragmentManager fragmentManager;
    Fragment fragment = null;

    ImageView imv_header, imv_header_back;
    TextView text_headerMain, text_header;

    Button btnwearable, btnLifeStyle;

    LinearLayout ll_header;
    LinearLayout ll_tab;
    LinearLayout ll_tab_healthRecord;
    LinearLayout ll_header_healthMonitiring;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new FavouriteFragment();
                    if (fragment != null) {
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                    }
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new VideoFragment();
                    if (fragment != null) {
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                    }
                    return true;
                case R.id.navigation_notifications:
                    // mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText("Your BLOOD PRESSURE");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerToggle = new EndDrawerToggle(this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(drawerToggle);

        initView();
        clickEvent();
    }

    private void clickEvent() {

        btnwearable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new FragmentWearable();
                if (fragment != null) {
                    btnwearable.setBackgroundColor(getResources().getColor(R.color.white));
                    btnLifeStyle.setBackgroundColor(getResources().getColor(R.color.gray));
                    btnLifeStyle.setTextColor(getResources().getColor(R.color.graydark));
                    btnwearable.setTextColor(getResources().getColor(R.color.orange_header));

                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                }
            }
        });

        btnLifeStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new HealthDashBoardFragment();
                if (fragment != null) {
                    btnwearable.setBackgroundColor(getResources().getColor(R.color.gray));
                    btnLifeStyle.setBackgroundColor(getResources().getColor(R.color.white));
                    btnLifeStyle.setTextColor(getResources().getColor(R.color.orange_header));
                    btnwearable.setTextColor(getResources().getColor(R.color.graydark));

                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                }
            }
        });
    }

    private void initView() {
        btnwearable = (Button) findViewById(R.id.btnwearable);
        btnLifeStyle = (Button) findViewById(R.id.btnLifeStyle);
        imv_header_back = (ImageView) findViewById(R.id.imv_header_back);
        imv_header = (ImageView) findViewById(R.id.imv_header);
        imv_header.setImageResource(R.drawable.ic_share_icon);

        ll_header = (LinearLayout) findViewById(R.id.ll_header);
        ll_header_healthMonitiring = (LinearLayout) findViewById(R.id.ll_header_healthMonitiring);
        ll_header_healthMonitiring.setVisibility(View.GONE);
        ll_tab = (LinearLayout) findViewById(R.id.ll_tab);
        ll_tab.setVisibility(View.GONE);
        ll_tab_healthRecord = (LinearLayout) findViewById(R.id.ll_tab_healthRecord);
        ll_tab_healthRecord.setVisibility(View.GONE);

        text_header = (TextView) findViewById(R.id.text_header);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            toolbar_title.setText("Your SUGUR LEVEL");
            text_header.setText("Blood Glucose");
            ll_header.setVisibility(View.VISIBLE);
            ll_tab.setVisibility(View.GONE);
            ll_tab_healthRecord.setVisibility(View.GONE);
            ll_header_healthMonitiring.setVisibility(View.GONE);
            imv_header.setVisibility(View.VISIBLE);
            imv_header_back.setVisibility(View.VISIBLE);
            fragment = new BloodGlucoseFragment();
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            }

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            toolbar_title.setText("Health DASHBOARD");
            ll_header.setVisibility(View.GONE);
            ll_tab.setVisibility(View.VISIBLE);
            ll_tab_healthRecord.setVisibility(View.GONE);

            imv_header.setVisibility(View.VISIBLE);
            imv_header_back.setVisibility(View.VISIBLE);
            ll_header_healthMonitiring.setVisibility(View.GONE);
            fragment = new HealthDashBoardFragment();
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            }

        } else if (id == R.id.nav_slideshow) {

            toolbar_title.setText("Your DIAGNOSIS BOARD");
            ll_header.setVisibility(View.VISIBLE);
            ll_tab.setVisibility(View.GONE);
            ll_tab_healthRecord.setVisibility(View.GONE);
            text_header.setText("CONDITION");
            imv_header.setVisibility(View.VISIBLE);
            imv_header_back.setVisibility(View.VISIBLE);
            ll_header_healthMonitiring.setVisibility(View.GONE);
            imv_header.setImageResource(R.drawable.ic_quary);
            fragment = new DiagonosisBoardFragment();
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            }

        } else if (id == R.id.nav_Record) {
            toolbar_title.setText("My HEALTH RECORDS");
            ll_tab_healthRecord.setVisibility(View.VISIBLE);
            ll_tab.setVisibility(View.GONE);
            ll_header.setVisibility(View.GONE);
            imv_header.setVisibility(View.VISIBLE);
            imv_header_back.setVisibility(View.VISIBLE);
            ll_header_healthMonitiring.setVisibility(View.GONE);
            fragment = new HealthRecordFragment();
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            }

        } else if (id == R.id.nav_heartRate) {
            toolbar_title.setText("Your HEART RATE");
            ll_header.setVisibility(View.VISIBLE);
            ll_tab.setVisibility(View.GONE);
            ll_tab_healthRecord.setVisibility(View.GONE);
            text_header.setText("Heart Rate");
            imv_header.setVisibility(View.VISIBLE);
            imv_header_back.setVisibility(View.VISIBLE);
            ll_header_healthMonitiring.setVisibility(View.GONE);
            imv_header.setImageResource(R.drawable.ic_heart);
            fragment = new HeartRateFragment();
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            }

        } else if (id == R.id.nav_Monitoring) {
            toolbar_title.setText("Your Health Monitoring");
            ll_header.setVisibility(View.GONE);
            ll_tab.setVisibility(View.GONE);
            ll_tab_healthRecord.setVisibility(View.GONE);
            ll_header_healthMonitiring.setVisibility(View.VISIBLE);
            imv_header.setVisibility(View.GONE);
            imv_header_back.setVisibility(View.GONE);
            fragment = new HealthMoneteringFragment();
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            }

        } else if (id == R.id.nav_Temperature) {
            toolbar_title.setText("Your BOBY TEMPERATURE");
            ll_header.setVisibility(View.VISIBLE);
            ll_tab.setVisibility(View.GONE);
            ll_tab_healthRecord.setVisibility(View.GONE);
            text_header.setText("Temperature");
            ll_header_healthMonitiring.setVisibility(View.GONE);
            imv_header.setVisibility(View.VISIBLE);
            imv_header.setImageResource(R.drawable.ic_share_icon);
            imv_header_back.setVisibility(View.VISIBLE);
            fragment = new TempretureFragment();
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            }
        } else if (id == R.id.nav_Status) {

            toolbar_title.setText("Your WEIHGT STATUS");
            ll_header.setVisibility(View.VISIBLE);
            ll_tab.setVisibility(View.GONE);
            ll_tab_healthRecord.setVisibility(View.GONE);
            text_header.setText("Weight");
            ll_header_healthMonitiring.setVisibility(View.GONE);
            imv_header.setVisibility(View.VISIBLE);
            imv_header.setImageResource(R.drawable.ic_share_icon);
            imv_header_back.setVisibility(View.VISIBLE);
            fragment = new WeightFragment();
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }


}
