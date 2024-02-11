package com.example.myloginpagedemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.jetbrains.annotations.NotNull;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static EditText signine1, signine2, signine3;
    private TextView signupt1;
    private Button signinb1,signinb2;
    ProgressBar progressbar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        signine1 = (EditText) findViewById(R.id.m1);
        signine2 = (EditText) findViewById(R.id.m2);
        signine3 = (EditText) findViewById(R.id.m3);
        signinb1 = (Button) findViewById(R.id.m41);
        signinb2 = (Button) findViewById(R.id.m42);
        signupt1 = (TextView) findViewById(R.id.m5);
        signinb1.setOnClickListener(this);  signinb2.setOnClickListener(this);
        progressbar=findViewById(R.id.m6);
        signupt1.setOnClickListener(this); }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.m41:
                userLogin();
                break;
            case R.id.m42:
                userLogin1();
                break;
            case R.id.m5:
                Intent intent=new Intent(getApplicationContext(),SignUP.class);
                startActivity(intent);
                break;
        }
    }

    private void userLogin1() {
        String name=signine1.getText().toString().trim();
        String email=signine2.getText().toString().trim();
        String password=signine3.getText().toString().trim();
        if(email.isEmpty())
        {
            signine2.setError("Enter an email address"); signine2.requestFocus(); return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signine2.setError("Enter a valid email address"); signine2.requestFocus(); return;
        } if(password.isEmpty())
        {
            signine3.setError("Enter a password"); signine3.requestFocus(); return;
        }
        if(password.length()<6)
        {
            signine3.setError("Minimum length of a password should be 6"); return;
        }
        progressbar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                progressbar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {  //Toast.makeText(MainActivity.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),Decomposer1.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();Toast.makeText(MainActivity.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void userLogin() {
        String name=signine1.getText().toString().trim();
        String email=signine2.getText().toString().trim();
        String password=signine3.getText().toString().trim();
        if(email.isEmpty())
        {
            signine2.setError("Enter an email address"); signine2.requestFocus(); return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signine2.setError("Enter a valid email address"); signine2.requestFocus(); return;
        } if(password.isEmpty())
        {
            signine3.setError("Enter a password"); signine3.requestFocus(); return;
        }
        if(password.length()<6)
        {
            signine3.setError("Minimum length of a password should be 6"); return;
        }
        progressbar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                progressbar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {  Toast.makeText(MainActivity.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();     }
                else {
                    Toast.makeText(MainActivity.this,"Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        } return true;

    }
}