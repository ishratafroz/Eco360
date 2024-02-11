package com.example.myloginpagedemo;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.myloginpagedemo.CustomAdapter.rewardpt;
import static com.example.myloginpagedemo.MainActivity.signine1;
public class Retrieve extends AppCompatActivity {
    ListView listview;
    List<Class2> studentList = new ArrayList<>();
    //private CustomAdapter customAdapter;
    DatabaseReference databaseReference;FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  setContentView(R.layout.activity_retrieve);
        auth = FirebaseAuth.getInstance();  databaseReference = FirebaseDatabase.getInstance().getReference();
        //  child(auth.getCurrentUser().getUid()); studentList=new ArrayList<>();
        listview = findViewById(R.id.listviewclass);
        //getSupportActionBar().hide();
        DatabaseReference d=FirebaseDatabase.getInstance().getReference("Rewardpoint").
                child(FirebaseAuth.getInstance().getUid());
        if(d.child("Rating")!=null) d.child("Rating").setValue(rewardpt);
        else { rewardpt=0.0;d.child("Rating").setValue(0);}
        //customAdapter=new CustomAdapter(Retrieve.this,studentList);listview.setAdapter(customAdapter);
        databaseReference.child("Resources").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if (studentList != null && studentList.size() > 0) studentList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
                    String str1 = map.get("Name");
                    String str2 = map.get("Size");
                    String str3 = map.get("Type");
                    String str4 = map.get("User Name");
                    //String str5=map.get("Reward point");
                    String st = signine1.getText().toString().trim();
                    if (!st.equals(str4)) continue;
                   // Double p=Double.parseDouble(str5);
                   //p=p+rewardpt; str5=String.valueOf(p);
                   //Toast.makeText(Retrieve.this,str5,Toast.LENGTH_SHORT).show();
                    Class2 class2 = new Class2(str1, str2, str3, str4);
                    studentList.add(class2);
                    // Toast.makeText(Retrieve.this,st,Toast.LENGTH_SHORT).show();
                }
                if (studentList.size() > 0) {
                    CustomAdapter customAdapter = new CustomAdapter(Retrieve.this, studentList);
                    listview.setAdapter(customAdapter);
                }
                else {
                    Toast.makeText(Retrieve.this, "No record found!", Toast.LENGTH_SHORT).show(); }
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) { }
        });   }
   /* @Override
    public void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot snapshot) {
               // studentList.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Student student=dataSnapshot.getValue(Student.class);
                    studentList.add(student);
                } listview.setAdapter(customAdapter);
            }*/
}