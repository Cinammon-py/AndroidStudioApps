package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerage, spinnerbmi;
    Button bt_next;
    RadioGroup MaleFemaleRadioGroup;
    private int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinnerage = findViewById(R.id.spinnerage);
        spinnerbmi = findViewById(R.id.spinnerbmi);
        bt_next = findViewById(R.id.button);
        MaleFemaleRadioGroup = findViewById(R.id.radiogroupgender);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.age_ranges,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerage.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterbmi = ArrayAdapter.createFromResource(
                this,
                R.array.spinner2_options,
                android.R.layout.simple_spinner_item
        );
        adapterbmi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerbmi.setAdapter(adapterbmi);

        spinnerage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int Agerange = position;

                if (Agerange == 2) {
                    totalScore += 7;
                } else if (Agerange == 3) {
                    totalScore += 13;
                } else if (Agerange == 4) {
                    totalScore += 15;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerbmi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                int BmiRangechosen = position;
                if (BmiRangechosen == 2) {
                    totalScore += 4;
                } else if (BmiRangechosen == 3) {
                    totalScore += 9;
                } else if (BmiRangechosen == 4) {
                    totalScore += 14;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        MaleFemaleRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);

                if (radioButton.getText().toString().equals("Male")) {
                    totalScore += 6;
                } else {
                    totalScore += 0;
                }

            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("totalPoints", totalScore);
                intent.putExtra("gender", getSelectedGender());
                startActivity(intent);

            }
        });

    }

    private String getSelectedGender() {
        int selectedGenderPosition = MaleFemaleRadioGroup.indexOfChild(findViewById(MaleFemaleRadioGroup.getCheckedRadioButtonId()));
        switch (selectedGenderPosition) {
            case 0:
                return "Male";
            case 1:
                return "Female";
            default:
                return "";
        }
    }
}
