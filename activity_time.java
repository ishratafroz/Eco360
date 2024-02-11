package com.example.myloginpagedemo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myloginpagedemo.Adapter.EventAdapter;
import com.example.myloginpagedemo.Database.DatabaseClass;
import com.example.myloginpagedemo.Database.EntityClass;

import java.util.List;
public class activity_time extends AppCompatActivity implements View.OnClickListener {
    Button createEvent;
    EventAdapter eventAdapter;
    RecyclerView recyclerview;
    DatabaseClass databaseClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        createEvent = findViewById(R.id.btn_createEvent);
        recyclerview = findViewById(R.id.recyclerview1);
        createEvent.setOnClickListener(this);
        databaseClass = DatabaseClass.getDatabase(getApplicationContext()); }
    @Override
    protected void onResume() {
        super.onResume();
        setAdapter(); }
    private void setAdapter() {
        List<EntityClass> classList = databaseClass.EventDao().getAllData();
        eventAdapter = new EventAdapter(getApplicationContext(), classList);
        recyclerview.setAdapter(eventAdapter);
    }
    @Override
    public void onClick(View view) {
        if (view == createEvent) {
            goToCreateEventActivity();
        }
    }

    private void goToCreateEventActivity() {
        Intent intent = new Intent(getApplicationContext(), CreateEvent.class);
        startActivity(intent);
    }
}
