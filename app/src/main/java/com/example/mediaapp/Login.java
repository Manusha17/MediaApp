package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    int counter = 3;
    EditText username = (EditText) findViewById(R.id.txt_email);
    EditText password = (EditText) findViewById(R.id.txt_password);
    EditText formEmail;
    EditText formPassword;
    TextView register;
    Button loginBtn;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        formEmail = (EditText) findViewById(R.id.txt_email);
        formPassword = (EditText) findViewById(R.id.txt_password);
        register = (TextView) findViewById(R.id.view_register);
        loginBtn = (Button) findViewById(R.id.btn_login);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent registerIntent = new Intent(Login.this,Register.class);
                startActivity(registerIntent);
            }

        });
        loginBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String email = formEmail.getText().toString().trim();
                String password = formPassword.getText().toString().trim();
                String username = email.substring(0,email.indexOf("@"));
                if(db.isUserRegistered(email,password))
                {
                    // We can create an Intent and go to another activity or screen, else show a Toast Message
                    Intent moveToWelcomePage = new Intent(Login.this,MainActivity.class);
                    moveToWelcomePage.putExtra("username",username);
                    startActivity(moveToWelcomePage);
                    Toast.makeText(Login.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Login.this, "User does not Exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

