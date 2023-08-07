package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    int totalPoints;
    TextView tv_header, tv_description;
    Button bt_newsurvey, bt_backtomain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);



        tv_header = findViewById(R.id.textView16);
        tv_description = findViewById(R.id.textView29);
        bt_newsurvey = findViewById(R.id.button4);
        bt_backtomain = findViewById(R.id.button5);

        Intent intent = getIntent();
        totalPoints = intent.getIntExtra("totalPoints", 0);


        if (totalPoints<21){
            tv_header.setText("Low risk");
            tv_header.setTextColor(Color.parseColor("#0BDB1B"));
            tv_description.setText("Your risk of having pre-diabetes or type 2 diabetes is fairly low, though it always pays to maintain a healthy lifestyle");
        }else if (totalPoints>=21 && totalPoints<=32){
            tv_header.setText("Moderate risk");
            tv_header.setTextColor(Color.parseColor("#E2F808"));
            tv_description.setText("Based on your identified risk factors, your risk of having pre-diabetes or type 2 diabetes is moderate You may wish to consult with a health care practitioner about your risk of developing diabetes");
        }else if (totalPoints>33){
            tv_header.setText("High risk");
            tv_header.setTextColor(Color.parseColor("#FF5733"));
            tv_description.setText("Based on your identified risk factors, your risk of having pre-diabetes or type 2 diabetes is high. You may wish to consult with a health care practitioner to discuss getting your blood sugar tested.");
        }

        bt_newsurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(MainActivity5.this, MainActivity.class);
                b.putExtra("reset", 1);
                startActivity(b);
            }
        });

        bt_backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(MainActivity5.this, Activityusers.class);
                startActivity(b);
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        totalPoints = intent.getIntExtra("totalPoints", 0);
        if (totalPoints<21){
            tv_header.setText("Low risk");
            tv_description.setText("Your risk of having pre-diabetes or type 2 diabetes is fairly low, though it always pays to maintain a healthy lifestyle");
        }else if (totalPoints>=21 && totalPoints<=32){
            tv_header.setText("Moderate risk");
            tv_description.setText("Based on your identified risk factors, your risk of having pre-diabetes or type 2 diabetes is moderate You may wish to consult with a health care practitioner about your risk of developing diabetes");
        }else if (totalPoints>33){
            tv_header.setText("High risk");
            tv_description.setText("Based on your identified risk factors, your risk of having pre-diabetes or type 2 diabetes is high. You may wish to consult with a health care practitioner to discuss getting your blood sugar tested.");
        }
    }

}