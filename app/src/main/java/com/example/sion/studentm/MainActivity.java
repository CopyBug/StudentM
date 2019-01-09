package com.example.sion.studentm;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sion.studentm.Fragment.Fragment02;
import com.example.sion.studentm.Fragment.Fragment03;
import com.example.sion.studentm.Fragment.Fragment04;
import com.example.sion.studentm.Fragment.Fragment_HOME;
import com.example.sion.studentm.JAVABeans.Studentlogin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
    private static Studentlogin student=new Studentlogin();
    private Toolbar Tb;
    private CollapsingToolbarLayout CTL;
    private NestedScrollView nestedScrollView;

    public static Studentlogin getStudent() {
        return student;
    }

    public static void setStudent(Studentlogin student) {
        MainActivity.student = student;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();


    }


    private void initView() {
        Intent intent = getIntent();
        student = (Studentlogin) intent.getSerializableExtra("Student");
        maincontent = findViewById(R.id.maincontent);

        slidingPL = (SlidingPaneLayout) findViewById(R.id.slidingPL);

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
        SetTeXT();

        Tb = (Toolbar) findViewById(R.id.Tb);
        setSupportActionBar(Tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (slidingPL.isOpen()) {
                    slidingPL.closePane();
                } else {
                    slidingPL.openPane();
                }
            }
        });
        CTL = (CollapsingToolbarLayout) findViewById(R.id.CTL);
        CTL.setTitle("广东职业技术学院");
        CTL.setExpandedTitleColor(Color.WHITE);
        CTL.setCollapsedTitleTextColor(Color.WHITE);
        //getSupportFragmentManager().beginTransaction().replace(R.id.maincontent, new Fragment_HOME()).commit();

        nestedScrollView = (NestedScrollView) findViewById(R.id.NestedScrollView);
        getSupportFragmentManager().beginTransaction().replace(R.id.maincontent,new Fragment_HOME()).commit();

    }

    public synchronized void SetTeXT() {
        if (student != null) {
            name = student.getStudent().getSname();
            myname.setText(name);
            user = student.getSid() + "";
            Stuid.setText(user);

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Mselected:
                nestedScrollView.setFillViewport(true);
              Fragment02 fragment02=  new Fragment02();

                getSupportFragmentManager().beginTransaction().replace(R.id.maincontent, fragment02).commit();

                break;
            case R.id.Mhome:
                nestedScrollView.setFillViewport(false);

                getSupportFragmentManager().beginTransaction().replace(R.id.maincontent,new Fragment_HOME()).commit();


                break;
            case R.id.MEven:
                nestedScrollView.setFillViewport(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontent, new Fragment03()).commit();


                break;
            case R.id.MED:
                nestedScrollView.setFillViewport(true);
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontent, new Fragment04()).commit();
                break;
            case R.id.GetOut:
                nestedScrollView.setFillViewport(true);
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
