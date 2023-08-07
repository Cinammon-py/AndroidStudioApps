package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText et_password;
    Button bt_login;
    private static final String ADMIN_PASSWORD = "cmse419";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        et_password = findViewById(R.id.editTextTextPassword);
        bt_login = findViewById(R.id.login_bt);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredPassword = et_password.getText().toString().trim();
                if (enteredPassword.equals(ADMIN_PASSWORD)) {
                    Intent intent = new Intent(AdminLogin.this, MainActivity6.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(AdminLogin.this, "Invalid password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}