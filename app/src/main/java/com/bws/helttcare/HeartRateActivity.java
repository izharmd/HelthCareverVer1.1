package com.bws.helttcare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bws.helthcare.R;
import com.daasuu.ahp.AnimateHorizontalProgressBar;

public class HeartRateActivity extends AppCompatActivity {

    AnimateHorizontalProgressBar heart_progress_bar, sys_progress_bar, dia_progress_bar;

    ImageView imv_plush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);

        initview();
    }

    private void initview() {

        imv_plush = (ImageView)findViewById(R.id.imv_header);
        imv_plush.setImageResource(R.drawable.ic_heart);

        heart_progress_bar = (AnimateHorizontalProgressBar) findViewById(R.id.heart_progress_bar);
        heart_progress_bar.setMax(100);
        heart_progress_bar.setProgress(92);

        sys_progress_bar = (AnimateHorizontalProgressBar) findViewById(R.id.sys_progress_bar);
        sys_progress_bar.setMax(100);
        sys_progress_bar.setProgress(85);

        dia_progress_bar = (AnimateHorizontalProgressBar) findViewById(R.id.dia_progress_bar);
        dia_progress_bar.setMax(100);
        dia_progress_bar.setProgress(78);
    }
}
