package com.bodykh.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.lightRose));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lightRose, this.getTheme()));
        } else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lightRose));
        }

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this,start.class);
            startActivity(intent);
            CustomIntent.customType(MainActivity.this,"left-to-right");
            finish();
        },800);
    }
}