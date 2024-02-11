package com.example.myloginpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class Retrieve3 extends AppCompatActivity {
 private PieChart pieChart;
 Handler h=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve3);
        pieChart=findViewById(R.id.piechart1);
        setupPiechart(); loadPieChartData();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Retrieve3.this, Home.class);
                startActivity(i);finish(); }
        },2000); }
    private void setupPiechart(){
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12); pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("USAGE");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);
        Legend l=pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);

    }  private void loadPieChartData(){
        ArrayList<PieEntry>entries=new ArrayList<>();
        entries.add(new PieEntry(0.65f,"Eco products-Oct"));
        entries.add(new PieEntry(0.15f,"Single use plastic-Oct"));
        entries.add(new PieEntry(0.20f,"Multiuse plastic-Oct"));
        entries.add(new PieEntry(0.40f,"Eco products-Sep"));
        entries.add(new PieEntry(0.35f,"Single use plastic-Sep"));
        entries.add(new PieEntry(0.25f,"Multiuse plastic-Sep"));
        ArrayList<Integer>colors=new ArrayList<>();
        for(int color: ColorTemplate.MATERIAL_COLORS ){
            colors.add(color);
        }
        for(int color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }
        PieDataSet dataset=new PieDataSet(entries,"Usage of products");
    dataset.setColors(colors);
   PieData data=new PieData(dataset); data.setDrawValues(true);
   data.setValueFormatter(new PercentFormatter(pieChart));
   data.setValueTextSize(10f);
   data.setValueTextColor(Color.BLACK);
   pieChart.setData(data); pieChart.invalidate();
   pieChart.animateY(1400, Easing.EaseInOutQuad);
    }


}