package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username = getIntent().getStringExtra("username");
        TextView uname = (TextView) findViewById(R.id.username);
        uname.setText("Welcome "+username);
        Locale locale = new Locale("si");
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // We have 2 different activities to Handle via Menus
        int id = item.getItemId();
        if(id==R.id.menu_game)
        {
            Intent audioIntent = new Intent(MainActivity.this,AudioActivity.class);
            startActivity(audioIntent);
        }
        else if(id==R.id.menu_pictures)
        {
            Intent pictureIntent = new Intent(MainActivity.this, PictureActivity.class);
            startActivity(pictureIntent);
        }else if(id==R.id.menu_reg)
        {
            Intent pictureIntent = new Intent(MainActivity.this, Register.class);
            startActivity(pictureIntent);
        }else if(id==R.id.menu_login)
        {
            Intent pictureIntent = new Intent(MainActivity.this, Login.class);
            startActivity(pictureIntent);
        }
        return true;
    }}
