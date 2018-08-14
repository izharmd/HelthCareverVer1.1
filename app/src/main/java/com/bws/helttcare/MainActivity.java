package com.bws.helttcare;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bws.helthcare.R;
import com.numetriclabz.numandroidcharts.ChartData;
import com.numetriclabz.numandroidcharts.MultiLineChart;

import java.util.ArrayList;
import java.util.List;

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
import adapter.SideMenuAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    private boolean isDrawerLocked = false;
    DrawerLayout drawerLayout;
    private LinearLayout DrawerLinear;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private String[] drawerItems;

    ImageView imgDrawer, imgTopUpSide, imgSearch;
    CircleImageView circleImageView;
    TextView itemHeader;
    EditText editsearch;

    Button btn1, btn2, btn3, btn4;
    ListView listView;

    FragmentManager fragmentManager;
    Fragment fragment = null;

    String Urls = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";
    String selectedFromList;
    String AsynkResult = "";






    //use for drawer list item
    String countryList[] = {"Sugar Level", "Health Dashboard",
    "Diagnosis board","Health Record","Heart Rate","Health Monitoring","Body Temperature",
    "Weight Status"};
    int flags[] = {R.drawable.ic_sugarlevel,
            R.drawable.ic_healthdashboard,
            R.drawable.ic_diagnosisboard,

            R.drawable.ic_healthrecord,
            R.drawable.ic_heartrate,
            R.drawable.ic_healthmonitoring,
            R.drawable.ic_bodytemperaturel,
            R.drawable.ic_weightstatus,};

    public MainActivity() {

    }

    ProgressDialog mDialog;

    ImageView imv_header,imv_header_back;
    TextView text_headerMain,text_header;

    Button btnwearable,btnLifeStyle;

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
                    // mTextMessage.setText(R.string.title_home);

                    fragment = new FavouriteFragment();
                    if (fragment != null) {
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                    }

                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);

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
        setContentView(R.layout.activity_main);

        MultiLineChart multiLineChart = (MultiLineChart) findViewById(R.id.chart);

        List<ChartData> value1 = new ArrayList();

        value1.add(new ChartData(4f, 0.5f)); //values.add(new ChartData(y,x));
        value1.add(new ChartData(9f, 1f));
        value1.add(new ChartData(18f, 2f));
        value1.add(new ChartData(2f, 4f));
        value1.add(new ChartData(12f, 5f));
        value1.add(new ChartData(9f, 7f));

        List<ChartData> value2 = new ArrayList();

       /* for (int i = 0;i<=3; i++){
            value2.add( new ChartData());
        }*/

        value2.add(new ChartData(5f, 1f)); //values.add(new ChartData(y,x));<br />
        value2.add(new ChartData(6f, 2f));
        value2.add(new ChartData(15f, 3f));
        value2.add(new ChartData(2f, 5f));
        value2.add(new ChartData(3f, 8f));

        List<ChartData> value3 = new ArrayList();
        value3.add(new ChartData(value1));
        //value3.add(new ChartData(value2));

        multiLineChart.setData(value3);




       /* ArrayList<Customer> custArr = new ArrayList<Customer>();
        int i = 0;
        while(i == 5) {
            //get a customerName
            //get an amount
            custArr.add(new Customer("", 4));
            i++;
        }*/

        initView();
        clickEvent();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }




    private void clickEvent() {
        //Use for open side drawer
        imgDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(DrawerLinear);
            }
        });

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
        DrawerLinear = (LinearLayout) findViewById(R.id.DrawerLinear);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        imgDrawer = (ImageView) findViewById(R.id.imgDrawer);
        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        btnwearable = (Button) findViewById(R.id.btnwearable);
        btnLifeStyle = (Button) findViewById(R.id.btnLifeStyle);
        imv_header_back = (ImageView)findViewById(R.id.imv_header_back);
        imv_header = (ImageView)findViewById(R.id.imv_header);
        imv_header.setImageResource(R.drawable.ic_share_icon);

        ll_header = (LinearLayout)findViewById(R.id.ll_header);
        ll_header_healthMonitiring = (LinearLayout)findViewById(R.id.ll_header_healthMonitiring);
        ll_header_healthMonitiring.setVisibility(View.GONE);
        ll_tab = (LinearLayout)findViewById(R.id.ll_tab);
        ll_tab.setVisibility(View.GONE);
        ll_tab_healthRecord = (LinearLayout)findViewById(R.id.ll_tab_healthRecord);
        ll_tab_healthRecord.setVisibility(View.GONE);

        text_headerMain = (TextView) findViewById(R.id.text_headerMain);
        text_header = (TextView) findViewById(R.id.text_header);


        //FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content_frame);

        // Set the adapter for the list view
        drawerItems = getResources().getStringArray(R.array.drawerOptions);
        SideMenuAdapter customAdapter = new SideMenuAdapter(getApplicationContext(), countryList, flags);
        drawerList.setAdapter(customAdapter);
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.drawable.menu_icon,
                R.string.actionSort,
                R.string.actionSort
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                //    getActionBar().setTitle(title);
                //   ((FragmentInterface)fragment).showMenuActions();
                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
//                getActionBar().setTitle("Select Option");
                //  ((FragmentInterface)fragment).hideMenuActions();
                invalidateOptionsMenu();
            }
        };

        if (!isDrawerLocked) {
            drawerLayout.setDrawerListener(drawerToggle);
        }

        // Set the drawer toggle as the DrawerListener
        DrawerItemClickListener drawerItemClickListener = new DrawerItemClickListener();
        drawerList.setOnItemClickListener(drawerItemClickListener);

        if (!isDrawerLocked) {
            //  getActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }


    /**
     * The drawer item click listener
     */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }

        /**
         * Swaps fragments in the main content view
         */
        private void selectItem(int position) {
            //Use for selected drawer item show in header
            selectedFromList = (String) drawerList.getItemAtPosition(position);
           // itemHeader.setText(selectedFromList);
            Bundle bundle;
            Fragment fragment = null;

            switch (position) {
                case 0:


                   // Intent intent = new Intent(MainActivity.this,BloodGlucoseActivity.class);
                   // startActivity(intent);
                    //Toast.makeText(MainActivity.this, "selected item 0", Toast.LENGTH_SHORT).show();

                    fragment = new BloodGlucoseFragment();
                    if (fragment != null) {
                        text_headerMain.setText("Your SUGUR LEVEL");
                        text_header.setText("Blood Glucose");
                        ll_header.setVisibility(View.VISIBLE);
                        ll_tab.setVisibility(View.GONE);
                        ll_tab_healthRecord.setVisibility(View.GONE);
                        ll_header_healthMonitiring.setVisibility(View.GONE);
                        imv_header.setVisibility(View.VISIBLE);
                        imv_header_back.setVisibility(View.VISIBLE);

                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                        //ll_header.setVisibility(View.VISIBLE);

                        if (!isDrawerLocked) {
                            drawerLayout.closeDrawer(DrawerLinear);
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                    }

                    break;
                //Use for open Activity not fragment
                case 1:

                    //Intent intent1 = new Intent(MainActivity.this,HelthDashBoardActivity.class);
                   // startActivity(intent1);



                    fragment = new HealthDashBoardFragment();
                    if (fragment != null) {
                        ll_header.setVisibility(View.GONE);
                        ll_tab.setVisibility(View.VISIBLE);
                        ll_tab_healthRecord.setVisibility(View.GONE);
                        text_headerMain.setText("Health DASHBOARD");

                        imv_header.setVisibility(View.VISIBLE);
                        imv_header_back.setVisibility(View.VISIBLE);
                        ll_header_healthMonitiring.setVisibility(View.GONE);

                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                        if (!isDrawerLocked) {
                            drawerLayout.closeDrawer(DrawerLinear);
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                    }


                    // Not : You can start activity like blew code
                    /*Intent intent = new Intent(MainActivity.this, ListVIewDataActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(DrawerLinear);*/
                    break;
                case 2:
                  // Intent intent2 = new Intent(getApplicationContext(),DiagonosisBoardActivity.class);
                   // startActivity(intent2);


                    fragment = new DiagonosisBoardFragment();
                    if (fragment != null) {
                        ll_header.setVisibility(View.VISIBLE);
                        ll_tab.setVisibility(View.GONE);
                        ll_tab_healthRecord.setVisibility(View.GONE);
                        text_headerMain.setText("Your DIAGNOSIS BOARD");
                        text_header.setText("CONDITION");

                        imv_header.setVisibility(View.VISIBLE);
                        imv_header_back.setVisibility(View.VISIBLE);

                        ll_header_healthMonitiring.setVisibility(View.GONE);
                        imv_header.setImageResource(R.drawable.ic_quary);

                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();

                        if (!isDrawerLocked) {
                            drawerLayout.closeDrawer(DrawerLinear);
                        }


                    } else {
                        Toast.makeText(MainActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                    }

                    break;

                case 3:
                    //Intent intent3 = new Intent(getApplicationContext(),HealthRecordActivity.class);
                    //startActivity(intent3);

                    if (!isDrawerLocked) {
                        drawerLayout.closeDrawer(DrawerLinear);
                    }

                    fragment = new HealthRecordFragment();
                    if (fragment != null) {
                        ll_tab_healthRecord.setVisibility(View.VISIBLE);
                        ll_tab.setVisibility(View.GONE);
                        ll_header.setVisibility(View.GONE);

                        imv_header.setVisibility(View.VISIBLE);
                        imv_header_back.setVisibility(View.VISIBLE);
                        ll_header_healthMonitiring.setVisibility(View.GONE);

                        text_headerMain.setText("My HEALTH RECORDS");
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                    } else {
                        Toast.makeText(MainActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                    }

                    break;

                case 4:
                   // Intent intent4 = new Intent(getApplicationContext(),HeartRateActivity.class);
                   // startActivity(intent4);

                    if (!isDrawerLocked) {
                        drawerLayout.closeDrawer(DrawerLinear);
                    }

                    fragment = new HeartRateFragment();
                    if (fragment != null) {

                        ll_header.setVisibility(View.VISIBLE);
                        ll_tab.setVisibility(View.GONE);
                        ll_tab_healthRecord.setVisibility(View.GONE);
                        text_headerMain.setText("Your HEART RATE");
                        text_header.setText("Heart Rate");
                        imv_header.setVisibility(View.VISIBLE);
                        imv_header_back.setVisibility(View.VISIBLE);
                        ll_header_healthMonitiring.setVisibility(View.GONE);
                        imv_header.setImageResource(R.drawable.ic_heart);

                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                    } else {
                        Toast.makeText(MainActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                    }

                    break;


                case 5:
                   // Intent intent5 = new Intent(getApplicationContext(),HealthMonetaringActivity.class);
                   // startActivity(intent5);

                    if (!isDrawerLocked) {
                        drawerLayout.closeDrawer(DrawerLinear);
                    }

                    fragment = new HealthMoneteringFragment();
                    if (fragment != null) {

                        ll_header.setVisibility(View.GONE);
                        ll_tab.setVisibility(View.GONE);
                        ll_tab_healthRecord.setVisibility(View.GONE);
                        text_headerMain.setText("Your Health Monitoring");
                        //text_header.setText("Hi Izhar, how can i help you?");
                        ll_header_healthMonitiring.setVisibility(View.VISIBLE);

                        imv_header.setVisibility(View.GONE);
                        imv_header_back.setVisibility(View.GONE);

                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                    } else {
                        Toast.makeText(MainActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                    }

                    break;


                case 6:
                   // Intent intent6 = new Intent(getApplicationContext(),TempretureActivity.class);
                   // startActivity(intent6);

                    if (!isDrawerLocked) {
                        drawerLayout.closeDrawer(DrawerLinear);
                    }

                    fragment = new TempretureFragment();
                    if (fragment != null) {


                        ll_header.setVisibility(View.VISIBLE);
                        ll_tab.setVisibility(View.GONE);
                        ll_tab_healthRecord.setVisibility(View.GONE);
                        text_headerMain.setText("Your BOBY TEMPERATURE");
                        text_header.setText("Temperature");
                        ll_header_healthMonitiring.setVisibility(View.GONE);

                        imv_header.setVisibility(View.VISIBLE);
                        imv_header.setImageResource(R.drawable.ic_share_icon);
                        imv_header_back.setVisibility(View.VISIBLE);



                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                    } else {
                        Toast.makeText(MainActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                    }


                    break;

                case 7:
                   // Intent intent7 = new Intent(getApplicationContext(),WeightActivity.class);
                   // startActivity(intent7);

                    if (!isDrawerLocked) {
                        drawerLayout.closeDrawer(DrawerLinear);
                    }

                    fragment = new WeightFragment();
                    if (fragment != null) {

                        ll_header.setVisibility(View.VISIBLE);
                        ll_tab.setVisibility(View.GONE);
                        ll_tab_healthRecord.setVisibility(View.GONE);
                        text_headerMain.setText("Your WEIHGT STATUS");
                        text_header.setText("Weight");
                        ll_header_healthMonitiring.setVisibility(View.GONE);

                        imv_header.setVisibility(View.VISIBLE);
                        imv_header.setImageResource(R.drawable.ic_share_icon);
                        imv_header_back.setVisibility(View.VISIBLE);



                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
                    } else {
                        Toast.makeText(MainActivity.this, "Error in creating fragment", Toast.LENGTH_SHORT).show();
                    }

                    break;
                default:
                    break;
            }
        }
    }
}
