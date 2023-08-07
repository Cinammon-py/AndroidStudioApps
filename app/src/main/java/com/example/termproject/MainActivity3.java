package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    int totalPoints;
    Button bt_next3;
    RadioGroup high_blood_pressure, high_blood_sugar, baby_birth;
    CanRiskFile userSurveyFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        userSurveyFile= new CanRiskFile(getApplicationContext());

        Intent intent = getIntent();
        totalPoints = intent.getIntExtra("totalPoints", 0);
        String gender = intent.getStringExtra("gender");
        high_blood_pressure = findViewById(R.id.bloodpressure);
        high_blood_sugar = findViewById(R.id.bloodsugar);
        baby_birth = findViewById(R.id.babysize);
        bt_next3 = findViewById(R.id.button3);

        high_blood_pressure.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedidhighbloodpressure) {
                RadioButton radioButton = findViewById(checkedidhighbloodpressure);
                if (radioButton.getText().toString().equals("Yes")) {
                    totalPoints += 4;
                } else {
                    totalPoints += 0;
                }

            }
        });

        high_blood_sugar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedidhighbloodsugar) {
                RadioButton radioButton = findViewById(checkedidhighbloodsugar);
                if (radioButton.getText().toString().equals("Yes")) {
                    totalPoints += 14;
                } else {
                    totalPoints += 0;
                }

            }
        });

        baby_birth.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedidbabybirth) {
                RadioButton radioButton = findViewById(checkedidbabybirth);
                if (radioButton.getText().toString().equals("Yes")) {
                    totalPoints += 1;
                } else {
                    totalPoints += 0;
                }

            }
        });

        bt_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                    intent.putExtra("totalPoints", totalPoints);
                    intent.putExtra("gender", gender);
                    startActivity(intent);

            }
        });
    }



}



