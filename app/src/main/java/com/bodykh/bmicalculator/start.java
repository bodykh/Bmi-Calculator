package com.bodykh.bmicalculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import maes.tech.intentanim.CustomIntent;

public class start extends AppCompatActivity {

    Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        buttonStart= findViewById(R.id.buttonStart);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        buttonStart.setOnClickListener(view -> {
            Intent i = new Intent(start.this,gender.class);
            startActivity(i);
            CustomIntent.customType(start.this,"left-to-right");
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.r_to_l, R.anim.l_to_r);
    }
}