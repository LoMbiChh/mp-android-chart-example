package com.example.mpandroidchartexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarChart barChart = findViewById(R.id.chart);

        List<BarEntry> entriesGroup1 = new ArrayList<>();
        entriesGroup1.add(new BarEntry(1, 100));
        entriesGroup1.add(new BarEntry(2, 100));
        List<BarEntry> entriesGroup2 = new ArrayList<>();
        entriesGroup2.add(new BarEntry(1, 50));
        entriesGroup2.add(new BarEntry(2, 50));
        BarDataSet set1 = new BarDataSet(entriesGroup1, "Entrate");
        BarDataSet set2 = new BarDataSet(entriesGroup2, "Uscite");

        set1.setColor(R.color.black);
        set2.setColor(R.color.purple_200);

        float groupSpace = 0.1f;
        float barSpace = 0f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
        // (0.02 + 0.45) * 2 + 0.06 = 1.00 -> interval per "group"
        BarData data = new BarData(set1, set2);
        data.setBarWidth(barWidth); // set the width of each bar
        barChart.setData(data);
        barChart.groupBars(0.5f, groupSpace, barSpace); // perform the "explicit" grouping
        XAxis xAxis = barChart.getXAxis();
        xAxis.setCenterAxisLabels(true);
        barChart.setTouchEnabled(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.invalidate(); // refresh
    }
}