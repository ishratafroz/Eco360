package com.example.myloginpagedemo;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
public class CustomAdapter extends ArrayAdapter<Class2>{
    Activity context;    List<Class2> studentList; public  static double  rewardpt=0;
    public CustomAdapter(Activity context,List<Class2> studentList) {
        super(context,R.layout.sample_layout1,studentList);
        this.context=context;
        this.studentList = studentList; }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.sample_layout1,null,true);
        Class2 Student=studentList.get(position);
        TextView t1=view.findViewById(R.id.name1);
        TextView t4=view.findViewById(R.id.name2);
        TextView t2=view.findViewById(R.id.cgpa1);
        Button t3=view.findViewById(R.id.cgpa2);
        t1.setText("Type: "+Student.getS3());
        t4.setText("Name: "+Student.getS1());
        t2.setText("Size: "+Student.getS2()+" mL");
      /*  FirebaseDatabase.getInstance().getReference("Rewardpoint").
                child(FirebaseAuth.getInstance().getUid()).child("Rating").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
              String st=  snapshot.getValue().toString();
              //if(snapshot!=null)
                rewardpt=Double.parseDouble(st);
              //else rewardpt=0;
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });*/

       t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Student.getS3().equals("Liquid hand soap bottles")||Student.getS3().equals("Soft drink bottles")||
                        Student.getS3().equals("Juice bottles") || Student.getS3().equals("Water bottles")
                        || Student.getS3().equals("Shampoo bottles")||Student.getS3().equals("Eyeglasses"))
                {
                    //500 mililiter hole ekta 10 point,100 point equals=1reward pt.
                    int   s1=Integer.valueOf(Student.getS2().toString()); rewardpt+=Double.valueOf(s1)*(100.0/500.0);
                }else if(Student.getS3().equals("Carry-home food containers")||Student.getS3().equals("Food Tray")||
                        Student.getS3().equals("Toys")||
                        Student.getS3().equals("Waste & recycling receptacles") || Student.getS3().equals("Disposable shopping bags")
                        ||Student.getS3().equals("Medical components")||Student.getS3().equals("Car parts")|| Student.getS3().equals("PLA compostable cups"))
                {
                    //200 ml e 10 point,100 pt=1 reward pt.
                    int s1=Integer.valueOf(Student.getS2().toString());rewardpt+=Double.valueOf(s1)*(10.0/200.0);

                }
                else if(Student.getS3().equals("Outdoor signage") ||Student.getS3().equals("Residential flooring")
                        || Student.getS3().equals("Building siding")||Student.getS3().equals("Outdoor furniture")||
                        Student.getS3().equals("Household appliances")  )
                {
                    //100 ml e 10 pt.100 pt=1 reward pt.
                    int s1=Integer.valueOf(Student.getS2().toString()); // s1=s1*1.0*(10/100);
                  rewardpt+=Double.valueOf(s1)*(10.0/100.0);
                }
                else if(Student.getS3().equals("Wire insulation") ||Student.getS3().equals("Rigid pipes")||
                        Student.getS3().equals("Plastic film") ||Student.getS3().equals("Foil_Containers")||
                        Student.getS3().equals("Food Tray")|| Student.getS3().equals("Luggage")
                        ||Student.getS3().equals("Foam in child car seats") ||Student.getS3().equals("IT equipment")||
                        Student.getS3().equals("CD and DVD cases")){
                    //1000 ml e 1 reward pt.
                    int s1=Integer.valueOf(Student.getS2().toString()); rewardpt+=Double.valueOf(s1)*(10.0/1000.0);
                }
                DatabaseReference database= FirebaseDatabase.getInstance().getReference("Rewardpoint").
                        child(FirebaseAuth.getInstance().getUid());

                if(database.child("Rating")==null) {database.child("Rating").setValue(0); rewardpt=0.0;}
               // HashMap<String, String> hashMap1 = new HashMap<>();
               // hashMap1.put("Rewardpt",String.valueOf(rewardpt));
              else{  database.child("Rating").setValue(rewardpt);}
               // int s2=Integer.valueOf(Student.getS2().toString()); //s2+=rewardpt;
               // Student.setS5(String.valueOf(s2));
                // rewardpt+=Double.valueOf(Student.getS5().toString());
                //Student.setS5(Double.toString(rewardpt));
            }
        });



       return  view;}
}
