package com.bodykh.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import maes.tech.intentanim.CustomIntent;

public class gender extends AppCompatActivity {

    TextView genderState;
    FloatingActionButton back, next;
    MaterialButton male, female;
    ImageView maleArrow, femaleArrow;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        male = findViewById(R.id.buttonMale);
        female = findViewById(R.id.buttonFemale);
        back = findViewById(R.id.backButton);
        next = findViewById(R.id.nextButton);
        genderState = findViewById(R.id.genderState);
        maleArrow = findViewById(R.id.maleArrow);
        femaleArrow = findViewById(R.id.femaleArrow);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.rose));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lightRose, this.getTheme()));
        } else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lightRose));
        }


        back.setOnClickListener(view -> onBackPressed());

        next.setOnClickListener(view -> {
            String gender = genderState.getText().toString();
            Intent i = new Intent(gender.this, WandL.class);
            i.putExtra("genderState", gender);
            startActivity(i);
            CustomIntent.customType(gender.this,"left-to-right");
        });

        male.setOnClickListener(view -> {
            male.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#E66063")));
            femaleArrow.setVisibility(View.INVISIBLE);
            maleArrow.setVisibility(View.VISIBLE);
            male.setStrokeWidth(5);
            female.setStrokeWidth(0);
            genderState.setText("male");
        });

        female.setOnClickListener(view -> {
            female.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#E66063")));
            femaleArrow.setVisibility(View.VISIBLE);
            maleArrow.setVisibility(View.INVISIBLE);
            female.setStrokeWidth(5);
            male.setStrokeWidth(0);
            genderState.setText("female");
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.r_to_l, R.anim.l_to_r);
    }
}
