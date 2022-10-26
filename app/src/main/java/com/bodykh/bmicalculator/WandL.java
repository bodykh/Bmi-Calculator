package com.bodykh.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import maes.tech.intentanim.CustomIntent;

public class WandL extends AppCompatActivity {

    VerticalSeekBar weight, length;
    FloatingActionButton back, next;
    TextView textWeight, textLength, textTemp;
    ImageView genderImage;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wandl);

        back = findViewById(R.id.backButton2);
        next = findViewById(R.id.nextButton2);
        weight = findViewById(R.id.sliderWeight);
        length = findViewById(R.id.sliderLength);
        textWeight = findViewById(R.id.textWeight);
        textLength = findViewById(R.id.textLength);
        genderImage = findViewById(R.id.genderImage);
        textTemp = findViewById(R.id.textTemp);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.rose));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lightRose, this.getTheme()));
        } else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.lightRose));
        }



        Bundle bundle = getIntent().getExtras();
        String gender = bundle.getString("genderState");
        if (gender.equals("male")) {
            genderImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_man, null));
        } else {
            genderImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_girl, null));
        }



        back.setOnClickListener(view -> onBackPressed());
        next.setOnClickListener(view -> {
            float weightValue = Float.parseFloat(textWeight.getText().toString());
            float lengthValue = Float.parseFloat(textLength.getText().toString());
            float lengthInMeter = lengthValue / 100;
            float BMI = Math.round(weightValue / (lengthInMeter * lengthInMeter));
            textTemp.setText(BMI+"");
            Intent i = new Intent(WandL.this, Age.class);
            i.putExtra("BMI", String.valueOf(BMI));
            i.putExtra("genderState", gender);
            startActivity(i);
            CustomIntent.customType(WandL.this,"left-to-right");
        });

        weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textWeight.setText(progress + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        length.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textLength.setText(progress + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.r_to_l, R.anim.l_to_r);
    }
}