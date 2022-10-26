package com.bodykh.bmicalculator;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import maes.tech.intentanim.CustomIntent;

public class Result extends AppCompatActivity {

    ImageView resultImage, blue, green, yellow, orange, red;
    TextView resultText, detailsText;
    ConstraintLayout bmiTableDialog;
    FloatingActionButton back, refresh;

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultImage = findViewById(R.id.resultImage);
        blue = findViewById(R.id.blueCursor);
        green = findViewById(R.id.greenCursor);
        yellow = findViewById(R.id.yellowCursor);
        orange = findViewById(R.id.orangeCursor);
        red = findViewById(R.id.redCursor);
        resultText = findViewById(R.id.textResult);
        detailsText = findViewById(R.id.textBmiResults);
        bmiTableDialog = findViewById(R.id.BmiTableDialog);
        back = findViewById(R.id.backButton4);
        refresh = findViewById(R.id.refreshButton);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }

        Bundle bundle = getIntent().getExtras();
        float BMI = Float.parseFloat(bundle.getString("BMI"));
        String gender = bundle.getString("genderState");

        if (gender.equals("male")) {
            resultImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_menresult, null));
        } else {
            resultImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_girlresult, null));
        }


        if (BMI <= 18.5) {
            resultText.setText("BMI condition is Thinness !");
            resultText.setTextColor(this.getResources().getColor(R.color.blue));
            detailsText.setText("Your BMI result is " + BMI+ "\n" + "I think you're in great shape but you need to gain weight \uD83D\uDC4F");
            detailsText.setTextColor(this.getResources().getColor(R.color.blue));
            blue.setVisibility(View.VISIBLE);
            green.setVisibility(View.INVISIBLE);
            yellow.setVisibility(View.INVISIBLE);
            orange.setVisibility(View.INVISIBLE);
            red.setVisibility(View.INVISIBLE);
        } else if (BMI > 18.5 && BMI <= 25) {
            resultText.setText("BMI condition is Normal !");
            resultText.setTextColor(this.getResources().getColor(R.color.green));
            detailsText.setText("Your BMI result is " + BMI+ "\n" + "You are in a very great shape, keep it up \uD83D\uDD96");
            detailsText.setTextColor(this.getResources().getColor(R.color.green));
            blue.setVisibility(View.INVISIBLE);
            green.setVisibility(View.VISIBLE);
            yellow.setVisibility(View.INVISIBLE);
            orange.setVisibility(View.INVISIBLE);
            red.setVisibility(View.INVISIBLE);
        } else if (BMI > 25 && BMI <= 30) {
            resultText.setText("BMI condition is Overweight !");
            resultText.setTextColor(this.getResources().getColor(R.color.yellow));
            detailsText.setText("Your BMI result is " + BMI + "\n" + "I think you are in good shape but what do you think about losing some weight \uD83E\uDD1D");
            detailsText.setTextColor(this.getResources().getColor(R.color.yellow));
            blue.setVisibility(View.INVISIBLE);
            green.setVisibility(View.INVISIBLE);
            yellow.setVisibility(View.VISIBLE);
            orange.setVisibility(View.INVISIBLE);
            red.setVisibility(View.INVISIBLE);
        } else if (BMI > 30 && BMI <= 35) {
            resultText.setText("BMI condition is Obese Class I !");
            resultText.setTextColor(this.getResources().getColor(R.color.orange));
            detailsText.setText("Your BMI result is " + BMI+ "\n" + "You can still fix it, you just have to consult a good doctor for treatment \uD83E\uDD0C");
            detailsText.setTextColor(this.getResources().getColor(R.color.orange));
            blue.setVisibility(View.INVISIBLE);
            green.setVisibility(View.INVISIBLE);
            yellow.setVisibility(View.INVISIBLE);
            orange.setVisibility(View.VISIBLE);
            red.setVisibility(View.INVISIBLE);
        } else if (BMI > 35 && BMI <= 40) {
            resultText.setText("BMI condition is Obese Class II !");
            resultText.setTextColor(this.getResources().getColor(R.color.red));
            detailsText.setText("Your BMI result is " + BMI+ "\n" + "You can still fix it, you just have to consult a good doctor for treatment \uD83E\uDD0C");
            detailsText.setTextColor(this.getResources().getColor(R.color.red));
            blue.setVisibility(View.INVISIBLE);
            green.setVisibility(View.INVISIBLE);
            yellow.setVisibility(View.INVISIBLE);
            orange.setVisibility(View.INVISIBLE);
            red.setVisibility(View.VISIBLE);
        } else {
            resultText.setText("BMI condition is Obese Class III !");
            resultText.setTextColor(this.getResources().getColor(R.color.red));
            detailsText.setText("Your BMI result is " + BMI + "\n" + "You can still fix it, you just have to consult a good doctor for treatment \uD83E\uDD0C");
            detailsText.setTextColor(this.getResources().getColor(R.color.red));
            blue.setVisibility(View.INVISIBLE);
            green.setVisibility(View.INVISIBLE);
            yellow.setVisibility(View.INVISIBLE);
            orange.setVisibility(View.INVISIBLE);
            red.setVisibility(View.VISIBLE);
        }

        back.setOnClickListener(view -> onBackPressed());

        refresh.setOnClickListener(view -> {
            Intent i = new Intent(Result.this, start.class);
            startActivity(i);
            CustomIntent.customType(Result.this, "left-to-right");
        });

        bmiTableDialog.setOnClickListener(view -> {
            Dialog dialog = new Dialog(Result.this);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setContentView(R.layout.tabledialog);
            dialog.show();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.r_to_l, R.anim.l_to_r);
    }
}