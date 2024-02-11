package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;

public class footprint extends AppCompatActivity {
  SeekBar seekbar,seekbar2,seekbar3; TextView textview;
    Handler h=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footprint);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(footprint.this, Retrieve3.class);
                startActivity(i);
                finish();
            }
        },1000);
    }
}