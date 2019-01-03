package com.example.sion.studentm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sion.studentm.Fragment.Fragment01;
import com.example.sion.studentm.Fragment.Fragment02;
import com.example.sion.studentm.Fragment.Fragment03;
import com.example.sion.studentm.Fragment.Fragment04;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private String name, user;
    private ImageView imageView_home;
    private ImageView imageView_Sliding;
    private TextView tv_title;
    private RelativeLayout maincontent;
    private LinearLayout fragment_content;
    private SlidingPaneLayout slidingPL;
    private Button Mhome;
    private Button Mselected;
    private Button MEven;
    private Button MED;
    private TextView myname;
    private TextView Stuid;
    private Button GetOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        user = intent.getStringExtra("user");
        Log.i("intent.getStringExtra(", name + user);
        initView();


    }


    private void initView() {
        imageView_home = (ImageView) findViewById(R.id.imageView_home);
        imageView_Sliding = (ImageView) findViewById(R.id.imageView_Sliding);
        tv_title = (TextView) findViewById(R.id.tv_title);
        maincontent = (RelativeLayout) findViewById(R.id.maincontent);
        fragment_content = (LinearLayout) findViewById(R.id.fragment_content);
        slidingPL = (SlidingPaneLayout) findViewById(R.id.slidingPL);
        imageView_Sliding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (slidingPL.isOpen()) {
                    slidingPL.closePane();
                } else {
                    slidingPL.openPane();
                }
            }
        });
        Mhome = (Button) findViewById(R.id.Mhome);
        Mhome.setOnClickListener(this);
        Mselected = (Button) findViewById(R.id.Mselected);
        Mselected.setOnClickListener(this);
        MEven = (Button) findViewById(R.id.MEven);
        MEven.setOnClickListener(this);
        MED = (Button) findViewById(R.id.MED);
        MED.setOnClickListener(this);
        myname = (TextView) findViewById(R.id.myname);
        myname.setOnClickListener(this);
        Stuid = (TextView) findViewById(R.id.Stuid);
        Stuid.setOnClickListener(this);
        GetOut = (Button) findViewById(R.id.GetOut);
        GetOut.setOnClickListener(this);
        Stuid.setText(user);
        myname.setText(name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Mhome:
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontent, new Fragment01()).commit();

                break;
            case R.id.Mselected:
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontent, new Fragment02()).commit();

                break;
            case R.id.MEven:
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontent, new Fragment03()).commit();

                break;
            case R.id.MED:
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontent, new Fragment04()).commit();
                break;
            case R.id.GetOut:
                break;
        }
    }
}
