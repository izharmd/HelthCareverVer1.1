package com.bws.helttcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.bws.helthcare.R;


public class HealthRecordActivity extends AppCompatActivity {

   Button btnNFCTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_record);
        initview();
    }

    private void initview() {

        btnNFCTab = (Button) findViewById(R.id.btnNFCTab);
        btnNFCTab.setBackgroundColor(getResources().getColor(R.color.gray));
    }
}
