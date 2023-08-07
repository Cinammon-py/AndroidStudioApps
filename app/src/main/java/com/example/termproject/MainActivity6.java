package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {

    ArrayList<Riskclass> allData;
    CanRiskFile userSurveyFile;

    TextView tv_header_low, tv_header_moderate, tv_header_high;
    TextView tv_result_low_male, tv_result_low_female;
    TextView tv_result_moderate_male, tv_result_moderate_female;
    TextView tv_result_high_male, tv_result_high_female;
    TextView totalnumberofusers;
    Button bt_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        userSurveyFile = new CanRiskFile(getApplicationContext());
        allData = userSurveyFile.readDataFromFile();

        tv_header_low = findViewById(R.id.textView30);
        tv_header_moderate = findViewById(R.id.textView35);
        tv_header_high = findViewById(R.id.textView40);
        tv_result_low_male = findViewById(R.id.textView33);
        tv_result_low_female = findViewById(R.id.textView34);
        tv_result_moderate_male = findViewById(R.id.textView38);
        tv_result_moderate_female = findViewById(R.id.textView39);
        tv_result_high_male = findViewById(R.id.textView43);
        tv_result_high_female = findViewById(R.id.textView44);
        totalnumberofusers = findViewById(R.id.textView45);
        bt_main = findViewById(R.id.button8);

        ArrayList<Riskclass> Low_risk = new ArrayList<>();
        ArrayList<Riskclass> Moderate_risk = new ArrayList<>();
        ArrayList<Riskclass> High_risk = new ArrayList<>();

        int end = allData.size();

        for (int i=0; i< end; i++) {
            Riskclass elem = allData.get(i);
            if (elem.getRiskassessment() < 21) {
                Low_risk.add(elem);
            }else if (elem.getRiskassessment()>= 21 && elem.getRiskassessment()<32) {
                Moderate_risk.add(elem);
            }else if (elem.getRiskassessment() >33){
                High_risk.add(elem);
            }
        }


        int[] low_risk_stats = classifyRisk(Low_risk);
        int[] mod_risk_stats = classifyRisk(Moderate_risk);
        int[] high_risk_stats = classifyRisk(High_risk);

        tv_header_low.setText("Low Risk");
        tv_header_low.setTextColor(Color.parseColor("#C2F70F"));
        tv_result_low_male.setText( ""+ low_risk_stats[0]);
        tv_result_low_female.setText(""+ low_risk_stats[1]);

        tv_header_moderate.setText("Moderate Risk");
        tv_header_moderate.setTextColor(Color.parseColor("#FFE20B"));
        tv_result_moderate_male.setText("" + mod_risk_stats[0]);
        tv_result_moderate_female.setText("" + mod_risk_stats[1]);

        tv_header_high.setText("High Risk");
        tv_header_high.setTextColor(Color.parseColor("#800000"));
        tv_result_high_male.setText("" + high_risk_stats[0]);
        tv_result_high_female.setText("" + high_risk_stats[1]);

        int totalUsers = allData.size();
        totalnumberofusers.setText("Total Users: " + totalUsers);

        bt_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(MainActivity6.this, Activityusers.class);
                startActivity(b);
            }
        });

    }

    public int[] classifyRisk (ArrayList<Riskclass> risk_class) {
        int male_counter = 0, female_counter = 0;

        for (int i =0; i< risk_class.size(); i++) {
            Riskclass elem = risk_class.get(i);
            if(elem.getGender().equals("Male")){
                male_counter = male_counter+1;
            }else if (elem.getGender().equals("Female")){
                female_counter = female_counter+1;
            }
        }
        int[] ans = {male_counter, female_counter};
        return ans;
    }
}