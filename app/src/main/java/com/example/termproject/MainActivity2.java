package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    int totalPoints;

    RadioGroup Men_Waist_Circumference, Women_Waist_Circumference;
    RadioGroup PhysicalActivity, Fooditem;
    Button bt_nextpage2;
    RadioButton mencircumference_1,mencircumference_2,mencircumference_3;
    RadioButton womencircumference_1,womencircumference_2,womencircumference_3;
    CanRiskFile userSurveyFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        userSurveyFile= new CanRiskFile(getApplicationContext());

        Intent intent = getIntent();
        totalPoints = intent.getIntExtra("totalPoints", 0);
        String gender = intent.getStringExtra("gender");

        Men_Waist_Circumference = findViewById(R.id.menwaistcircumference);
        Women_Waist_Circumference = findViewById(R.id.womenwaistcircumference);
        PhysicalActivity = findViewById(R.id.physicalactivity);
        Fooditem = findViewById(R.id.fooditem);
        mencircumference_1 = findViewById(R.id.mencircumference_1);
        mencircumference_2 = findViewById(R.id.mencircumference_2);
        mencircumference_3 = findViewById(R.id.mencircumference_3);
        womencircumference_1 = findViewById(R.id.womencircumference_1);
        womencircumference_2 = findViewById(R.id.womencircumference_2);
        womencircumference_3 = findViewById(R.id.womencircumference_3);
        bt_nextpage2 = findViewById(R.id.button2);



        Men_Waist_Circumference.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int position) {

                switch (position){
                    case R.id.mencircumference_1:
                        totalPoints += 0;
                        break;
                    case R.id.mencircumference_2:
                        totalPoints += 4;
                        break;
                    case R.id.mencircumference_3:
                        totalPoints += 6;
                }

            }
        });

        Women_Waist_Circumference.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int position) {
                if(gender == "male"){
                    Toast.makeText(getApplicationContext(),"Your selected gender was Male!",Toast.LENGTH_SHORT).show();
                    Women_Waist_Circumference.clearCheck();
                }else {
                    switch (position) {
                        case R.id.womencircumference_1:
                            totalPoints += 0;
                            break;
                        case R.id.womencircumference_2:
                            totalPoints += 4;
                            break;
                        case R.id.womencircumference_3:
                            totalPoints += 6;
                    }
                }
            }
        });

        PhysicalActivity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedIdPhysicalActivity) {
                RadioButton radioButton = findViewById(checkedIdPhysicalActivity);

                if (radioButton.getText().toString().equals("No")) {
                    totalPoints += 1;
                } else {
                    totalPoints += 0;
                }

            }
        });

        Fooditem.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedIdFoodItem) {
                RadioButton radioButton = findViewById(checkedIdFoodItem);

                if (radioButton.getText().toString().equals("Not Everyday")) {
                    totalPoints += 2;
                } else {
                    totalPoints += 0;
                }

            }
        });


        bt_nextpage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("totalPoints", totalPoints);
                    intent.putExtra("gender", gender);
                    startActivity(intent);

            }
        });
    }


}


