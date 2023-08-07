package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    int totalPoints;
    CheckBox Mothercheckbox, Fathercheckbox, Siblingscheckbox, Childrencheckbox, No_dontknowcheckbox;
    Button viewtotalScore, ViewRisk;
    Spinner ethnic_spinner, educationlevel_spinner;
    TextView textViewScore;
    CanRiskFile userSurveyFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        userSurveyFile = new CanRiskFile(getApplicationContext());
        Intent intent = getIntent();
        totalPoints = intent.getIntExtra("totalPoints", 0);
        String gender = intent.getStringExtra("gender");

        Mothercheckbox = findViewById(R.id.checkBox);
        Fathercheckbox = findViewById(R.id.checkBox2);
        Siblingscheckbox = findViewById(R.id.checkBox3);
        Childrencheckbox = findViewById(R.id.checkBox4);
        No_dontknowcheckbox = findViewById(R.id.checkBox5);
        viewtotalScore = findViewById(R.id.calc_totalscore);
        ViewRisk = findViewById(R.id.DisplayRisk);
        ethnic_spinner = findViewById(R.id.ethnic_spinner);
        educationlevel_spinner = findViewById(R.id.edu_spinner);
        textViewScore = findViewById(R.id.textViewScore);

        ArrayAdapter<CharSequence> ethnic_adapter = ArrayAdapter.createFromResource(
                this,
                R.array.ethnic_ranges,
                android.R.layout.simple_spinner_item
        );
        ethnic_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ethnic_spinner.setAdapter(ethnic_adapter);

        ArrayAdapter<CharSequence> education_adapter = ArrayAdapter.createFromResource(
                this,
                R.array.education_ranges,
                android.R.layout.simple_spinner_item
        );
        education_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        educationlevel_spinner.setAdapter(education_adapter);

        ethnic_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int selectedethnicgroup = position;

                if (selectedethnicgroup == 1) {
                    totalPoints += 0;
                } else if (selectedethnicgroup == 2) {
                    totalPoints += 3;
                } else if (selectedethnicgroup == 3) {
                    totalPoints += 5;
                } else if (selectedethnicgroup == 4) {
                    totalPoints += 10;
                } else if (selectedethnicgroup == 5) {
                    totalPoints += 11;
                } else if (selectedethnicgroup == 6) {
                    totalPoints += 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        educationlevel_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int selectededucationgroup = position;

                if (selectededucationgroup == 1) {
                    totalPoints += 5;
                } else if (selectededucationgroup == 2) {
                    totalPoints += 1;
                } else if (selectededucationgroup == 3) {
                    totalPoints += 0;
                } else if (selectededucationgroup == 4) {
                    totalPoints += 0;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Mothercheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    totalPoints += 2;
                } else {

                }
            }
        });

        Fathercheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    totalPoints += 2;
                } else {

                }
            }
        });

        Siblingscheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    totalPoints += 2;
                } else {

                }
            }
        });

        Childrencheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    totalPoints += 2;
                } else {

                }
            }
        });
        No_dontknowcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    totalPoints += 0;
                } else {

                }
            }
        });

        viewtotalScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    textViewScore.setText("" + totalPoints);
            }


        });

        ViewRisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    userSurveyFile.writeDataToFile(gender, totalPoints);

                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                    intent.putExtra("totalPoints", totalPoints);
                    intent.putExtra("gender", gender);
                    startActivity(intent);

            }
        });
    }
}
