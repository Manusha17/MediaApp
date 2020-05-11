package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHelper db;
    EditText formEmail;
    EditText formPassword;
    EditText formCnfPassword;
    TextView login;
    Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        formEmail = (EditText) findViewById(R.id.txt_email);
        formPassword = (EditText) findViewById(R.id.txt_password);
        formCnfPassword = (EditText) findViewById(R.id.txt_cnf_password);
        login = (TextView) findViewById(R.id.view_login);
        registerBtn = (Button) findViewById(R.id.btn_register);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent registerIntent = new Intent(Register.this, MainActivity.class);
                startActivity(registerIntent);
            }

        });
        registerBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String email = formEmail.getText().toString().trim();
                String password = formPassword.getText().toString().trim();
                String cnfPassword = formCnfPassword.getText().toString().trim();

		/*
		 Email/Password Validation (We can add different forms of validation here)
		 But since validation is not the context here, skipping it
		  */
                if(password.equals(cnfPassword))
                {
                    long result = db.registerUser(email,password);
                    if(result>0)
                    {
                        Toast.makeText(Register.this,"You have successfully Registered", Toast.LENGTH_SHORT).show();
                        Intent loginPage = new Intent(Register.this, MainActivity.class);
                        startActivity(loginPage);
                    }
                    else
                    {
                        Toast.makeText(Register.this,"Error while Registering", Toast.LENGTH_SHORT).show();

                    }
                }
                else
                {
                    Toast.makeText(Register.this,"Password did not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
