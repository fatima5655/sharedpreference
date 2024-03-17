package com.check.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                Boolean check = pref.getBoolean("flag", false);
                Intent intent;
                if (check) {
                    intent = new Intent(MainActivity.this, homeactivity.class);
                } else {
                    intent = new Intent(MainActivity.this, loginActivity.class);
                }

                startActivity(intent); // Intent execute karne ke liye startActivity function ka use karna hai
                //finish(); // Is activity ko finish kar dena sahi rahega taki user back press karke yaha na aa sake
            }
        }, 2000);
    }
}
