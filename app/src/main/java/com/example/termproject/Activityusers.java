package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activityusers extends AppCompatActivity {

    Button bt_user, bt_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityusers);

        bt_user = findViewById(R.id.button6);
        bt_admin = findViewById(R.id.button7);

        bt_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activityusers.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bt_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activityusers.this, AdminLogin.class);
                startActivity(intent);
            }
        });
    }
}