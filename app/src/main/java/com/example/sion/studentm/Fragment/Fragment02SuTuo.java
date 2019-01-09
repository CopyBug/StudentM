package com.example.sion.studentm.Fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sion.studentm.JAVABeans.Astudent;
import com.example.sion.studentm.MainActivity;
import com.example.sion.studentm.R;
import com.example.sion.studentm.Until.MyOkhttp;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

import static com.example.sion.studentm.Fragment.Fragment_HOME.Sid;

public class Fragment02SuTuo extends Fragment {
    String[] xueqi = {"大一上学期", "大一下学期", "大二上学期", "大二下学期", "大三上学期"};

    private BarChart Chart1;
    private Astudent astudent;
    private Activity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment02sutuo, container, false);
        activity=getActivity();
        initView(view);

        return view;
    }

    private void initView(View view) {
        Chart1 = (BarChart) view.findViewById(R.id.Mybarchar);
        GetCurrenPa();
    }

    public void GetCurrenPa() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Response execute = MyOkhttp.PostBody("/StudentP/GetSP", "{\"SID\":\"" + MainActivity.getStudent().getSid() + "\"}").execute();
                    astudent  = MyOkhttp.GetClass(execute, Astudent.class);
                    SetChart(astudent);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public synchronized void SetChart(Astudent astudent) {
        if (astudent != null) {
            List<Float> xue = new ArrayList<>();
            xue.add((float) astudent.getOneqi());
            xue.add((float) astudent.getTwoqi());
            xue.add((float) astudent.getThreeqi());
            xue.add((float) astudent.getFourqi());
            xue.add((float) astudent.getFiveqi());
            List<BarEntry> barEntries = new ArrayList<>();
            for (int i = 0; i < xueqi.length; i++) {
                barEntries.add(new BarEntry(xue.get(i), i));
            }
            BarDataSet barDataSet = new BarDataSet(barEntries, astudent.getName());
            barDataSet.setColor(Color.parseColor("#8bc34a"));
            barDataSet.setValueTextColor(Color.parseColor("#800000"));
            barDataSet.setValueTextSize(20);
            final BarData barData = new BarData(xueqi, barDataSet);
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Chart1.getAxisRight().setEnabled(false);
                    YAxis axisLeft = Chart1.getAxisLeft();
                    axisLeft.setDrawGridLines(false);
                    axisLeft.setTextColor(Color.parseColor("#FF1493"));
                    XAxis xAxis = Chart1.getXAxis();
                    xAxis.setTextSize(5);
                    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                    Chart1.setDescription("素拓分");
                    Chart1.setScaleEnabled(false);
                    Chart1.setBackgroundColor(Color.parseColor("#F5DEB3"));
                    Chart1.getXAxis().setTextSize(12);
                    Chart1.setData(barData);
                    Chart1.postInvalidate();
                }
            });
        }
    }

}
