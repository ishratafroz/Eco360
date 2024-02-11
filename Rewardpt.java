package com.example.myloginpagedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static com.example.myloginpagedemo.CustomAdapter.rewardpt;


public class Rewardpt extends AppCompatActivity {
  // SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
    //com.jjoe64.graphview.GraphView graphView;
    //LineGraphSeries series;
    //TextView t1, t2, t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewardpt);
        //t1 = findViewById(R.id.t11);
        //t2 = findViewById(R.id.t12);
        //t3 = findViewById(R.id.t13);
        // getSupportActionBar().hide();
        // Toast.makeText(Rewardpt.this, (int) rewardpt,Toast.LENGTH_SHORT).show();
        // Double  pp=Double.parseDouble(t2.getText().toString());
        //double pp1 = rewardpt;
        // pp=pp+pp1;
        //t2.setText(String.valueOf(pp1));
    }
}
