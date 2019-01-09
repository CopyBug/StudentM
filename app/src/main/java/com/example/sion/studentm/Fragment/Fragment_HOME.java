package com.example.sion.studentm.Fragment;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sion.studentm.JAVABeans.Astudent;
import com.example.sion.studentm.R;
import com.example.sion.studentm.Until.MyOkhttp;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.qmuiteam.qmui.widget.QMUIProgressBar;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

public class Fragment_HOME extends Fragment {
    private LinearLayout L1;
    String[] xueqi = {"大一上学期", "大一下学期", "大二上学期", "大二下学期", "大三上学期"};
    public static String Sid;
    private FragmentActivity activity;
    private int myprocess;
    private BarChart Chart1;
    private RecyclerView RecyclerView;
    private WebView web;
    private QMUIProgressBar Myprocess;

    public String getSid() {
        return Sid;
    }

    public  void setSid(String sid) {
        Sid = sid;
    }

    public static Astudent getAstudent() {
        return astudent;
    }

    private static   Astudent astudent;
    private TextView Ts;
    View view = null;

    private Toolbar Tb;
    private CollapsingToolbarLayout CTL;
    private RecyclerView recyclerView;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater
                .inflate(R.layout.fragment01, container, false);

        context = getContext();
        activity = getActivity();
        initView(view);
        initWeb();
        return view;
    }

    private void initWeb() {
        web.loadUrl("http://www.gdpt.edu.cn/");
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                super.onProgressChanged(view, newProgress);
            }
        });
        web.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Myprocess.setProgress(newProgress);
                Myprocess.setVisibility(View.VISIBLE);
                if(newProgress==100){
                    Myprocess.setVisibility(View.GONE);
                    Myprocess.setProgress(0);
                }else {

                }
            }
        });

        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient() {
                                 @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                                 @Override
                                 public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                                     String s = request.getUrl().toString();
                                     view.loadUrl(s);
                                     return true;
                                 }


                                 @Override
                                 public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                     super.onPageStarted(view, url, favicon);
                                     Log.i("onPageStarted", "onPageStarted: ");
                                     myprocess=0;
                                     Myprocess.setProgress(myprocess);
                                     Myprocess.setVisibility(View.VISIBLE);

                                 }
                             }

        );
    }



    private void initView(View view) {
        web = (WebView) view.findViewById(R.id.web);
        Myprocess = (QMUIProgressBar) view.findViewById(R.id.Myprocess);

    }
}
