package com.example.myloginpagedemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.myloginpagedemo.MainActivity.signine1;

public class Home extends AppCompatActivity {
    ListView l1; Dialog dialog;
 DatabaseReference databaseReference;
 int icon[] = {R.drawable.soap, R.drawable.softdrink, R.drawable.juice, R.drawable.water, R.drawable.shampoo, R.drawable.food_containers,
            R.drawable.toys, R.drawable.recycling_receptacles, R.drawable.outdoor_signage,
            R.drawable.rigid_pipes, R.drawable.wire_insulation, R.drawable.residential_flooring, R.drawable.building, R.drawable.shop, R.drawable.film,
            R.drawable.medical, R.drawable.furniture, R.drawable.luggage, R.drawable.car, R.drawable.house,
            R.drawable.child, R.drawable.it, R.drawable.foil,R.drawable.food_tray,R.drawable.dvd, R.drawable.glasses, R.drawable.cups};
    String title[] = {"Liquid hand soap bottles", "Soft drink bottles", "Hexisol", "Water bottles", "Shampoo bottles", "Carry-home food containers",
            "Toys", "Waste & recycling receptacles", "Outdoor signage",
            "Rigid pipes", "Wire insulation", "Residential flooring", "Building siding", "Disposable shopping bags", "Plastic film", "Medical components", "Outdoor furniture", "Luggage", "Car parts", "Household appliances", "Foam in child car seats", "IT equipment","Foil Containers",
          "Food Tray", "CD and DVD cases", "Eyeglasses", "Jute bag"};
    List<Class1> listItems = new ArrayList<>();
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);l1 = findViewById(R.id.se1);
       // StatusBarUtil.setTransparent(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("Resources");
        for (int i = 0; i < title.length; i++) {
            Class1 model = new Class1(title[i], icon[i]);
            listItems.add(model); }
        customAdapter = new CustomAdapter(listItems, this);
        l1.setAdapter(customAdapter); }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return true;
            }   });return true; }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();if (id == R.id.action_search) { return true; }
        if(id==R.id.action_settings) { Intent intw1 = new Intent(getApplicationContext(),Settings.class);
            startActivity(intw1); }
        if(id==R.id.retrieve) { Intent intw = new Intent(getApplicationContext(), Retrieve2.class);
            startActivity(intw); }
        if(id==R.id.foorprint) { Intent intw = new Intent(getApplicationContext(), footprint.class);
            startActivity(intw); }
        if(id==R.id.timenotifi) { Intent intw2 = new Intent(getApplicationContext(),activity_time.class);
            startActivity(intw2); }
        if(id==R.id.signout) {FirebaseAuth.getInstance().signOut(); finish();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);startActivity(intent); }
        return super.onOptionsItemSelected(item); }
    public class CustomAdapter extends BaseAdapter implements Filterable {
 private List<Class1> itemsModelList;private List<Class1> itemsMOdelListFiltered;private Context context;
        public CustomAdapter(List<Class1> itemsMOdelList, Context context) {
  this.itemsModelList = itemsMOdelList;this.context = context;this.itemsMOdelListFiltered = itemsModelList; }
        @Override
        public int getCount() {
            return itemsMOdelListFiltered.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row, null);
            CircleImageView imageView = view.findViewById(R.id.layout1);
            TextView t1 = view.findViewById(R.id.layout2);
            imageView.setImageResource(itemsMOdelListFiltered.get(position).getIcon());
            t1.setText(itemsMOdelListFiltered.get(position).getS1());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        final AlertDialog.Builder alert=new AlertDialog.Builder(Home.this);
                        View mView=getLayoutInflater().inflate(R.layout.custom_dialog,null);
      EditText t12=(EditText) mView.findViewById(R.id.custom1);
      EditText t22=(EditText) mView.findViewById(R.id.custom2);
                    Button im1=mView.findViewById(R.id.custom); alert.setView(mView);
                    final AlertDialog alertDialog=alert.create(); alertDialog.setCanceledOnTouchOutside(false);
                    im1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
          if(t12.getText().toString().trim().isEmpty() ||t22.getText().toString().trim().isEmpty())
     {Toast.makeText(Home.this,"Please enter correctly",Toast.LENGTH_SHORT).show();return; }
                            String st=signine1.getText().toString().trim();
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("Type", t1.getText().toString().trim());
                            hashMap.put("Name",t12.getText().toString().trim());
                            hashMap.put("Size", t22.getText().toString().trim());
                            hashMap.put("User Name",st);
                           // hashMap.put("Reward point",String.valueOf(0));
                            Toast.makeText(Home.this,"Data stored",Toast.LENGTH_LONG).show();
                            databaseReference.child(t1.getText().toString().trim()).setValue(hashMap);
                            t12.setText("");
                            t22.setText("");
                            alertDialog.dismiss();
                        }
                    }); alertDialog.show();
                    /*dialog.setContentView(R.layout.custom_dialog);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));*/
                           /* dialog.dismiss();
                    dialog.show();*/
                     }});
            return view; }
        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint == null || constraint.length() == 0) {
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList; }
                    else { String searcgStr = constraint.toString();
                        List<Class1> resultData = new ArrayList<>();
                        for (Class1 class1 : itemsModelList) {
                            if (class1.getS1().contains(searcgStr)) {
                                resultData.add(class1); }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData; } }
                    return filterResults; }
                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemsMOdelListFiltered = (List<Class1>) results.values;
                    notifyDataSetChanged();
                }   };
            return filter;
        }}}