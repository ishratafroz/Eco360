package com.example.myloginpagedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LIstAdapter extends BaseAdapter {

Context mCOntest; LayoutInflater inflater; List<Class1> modellist; ArrayList<Class1>arrayList;

    public LIstAdapter(Context mCOntest,List<Class1> modellist) {
       mCOntest=mCOntest; this.modellist=modellist;
        inflater=LayoutInflater.from(mCOntest);
        this.arrayList=new ArrayList<Class1>();
        this.arrayList.addAll(modellist);
    }
    public class ViewHolder {
        TextView mTitleTv; ImageView mIconTv;
    }
    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int position) {
        return modellist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {    ViewHolder holder; if(convertView==null)
    {
        holder=new ViewHolder(); convertView=inflater.inflate(R.layout.row,null);
           holder.mTitleTv=convertView.findViewById(R.id.layout2);
        holder.mIconTv=convertView.findViewById(R.id.layout1); convertView.setTag(holder);
    }
    else { holder=(ViewHolder)convertView.getTag(); }
     holder.mTitleTv.setText(modellist.get(position).getS1());
        holder.mIconTv.setImageResource(modellist.get(position).getIcon());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //custom dialogue ceeta ekret hbe
            }
        });
        return convertView;
    }
    public void filter(String charText)
    {
        charText=charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if(charText.length()==0) { modellist.addAll(arrayList);}
         notifyDataSetChanged();
    }

}
