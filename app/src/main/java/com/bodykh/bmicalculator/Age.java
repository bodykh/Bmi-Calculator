package com.bodykh.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import maes.tech.intentanim.CustomIntent;

public class Age extends AppCompatActivity {

    FloatingActionButton back, next;
    TextView textAge;
    ImageView ageImage;
    ImageButton mines, plus;
    String gender;
    int age = 20;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        back = findViewById(R.id.backButton3);
        next = findViewById(R.id.nextButton3);
        mines = findViewById(R.id.minesButton);
        plus = findViewById(R.id.plusButton);
        textAge = findViewById(R.id.textAge);
        ageImage = findViewById(R.id.ageImage);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.rose));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lightRose, this.getTheme()));
        } else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lightRose));
        }


        Bundle bundle = getIntent().getExtras();
        gender = bundle.getString("genderState");
        float BMI = Float.parseFloat(bundle.getString("BMI"));

        if (gender.equals("male")) {
            ageImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_man, null));
        } else {
            ageImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_girl, null));
        }

        back.setOnClickListener(view -> onBackPressed());

        next.setOnClickListener(view -> {

            Intent i = new Intent(Age.this, Result.class);
            i.putExtra("age", String.valueOf(age));
            i.putExtra("BMI", String.valueOf(BMI));
            i.putExtra("genderState", gender);
            startActivity(i);
            CustomIntent.customType(Age.this,"left-to-right");
        });

        mines.setOnClickListener(view -> {
            age--;
            textAge.setText("I'm " + age);

        });

        plus.setOnClickListener(view -> {
            age++;
            textAge.setText("I'm " + age);
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.r_to_l, R.anim.l_to_r);
    }

}