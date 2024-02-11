package com.example.myloginpagedemo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.myloginpagedemo.CustomAdapter.rewardpt;
import static com.example.myloginpagedemo.MainActivity.signine1;

public class Settings extends AppCompatActivity {
    CircleImageView c1;
    Uri selctedImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        c1 = findViewById(R.id.profile_image);
        ImageView c2 = findViewById(R.id.coin);
        //EditText e1, e2;
        //e1=findViewById(R.id.settingeditname);
          //  e1.setText(signine1.getText().toString());
       // getSupportActionBar().hide();
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intw = new Intent(getApplicationContext(), Rewardpt.class);
                startActivity(intw);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 10); }}); }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10 && data!=null)
        {
        { selctedImageUri=data.getData(); c1.setImageURI(selctedImageUri); }}}
}