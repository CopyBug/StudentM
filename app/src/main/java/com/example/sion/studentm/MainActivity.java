package com.example.sion.studentm;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sion.studentm.Fragment.Fragment01;
import com.example.sion.studentm.JAVABeans.LHWTemp;
import com.example.sion.studentm.Until.MyOkhttp;

import okhttp3.Response;

public class MainActivity extends FragmentActivity implements View.OnClickListener {


    private ImageView imageView_home;
    private ImageView imageView_Sliding;
    private TextView tv_title;
    private RelativeLayout maincontent;
    private LinearLayout fragment_content;
    private SlidingPaneLayout slidingPL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response execute = MyOkhttp.PostBody("http://192.168.1.100:8020/api/v2/get_weather", "{\"UserName\":\"user1\"}").execute();
                    LHWTemp mystudent = (LHWTemp) MyOkhttp.GetClass(execute, LHWTemp.class);

                } catch (Exception e) {
                    e.printStackTrace();
                    MyOkhttp.PrintError(e);
                }
            }
        }).start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Home:
                Log.i("MyHome", "onClick: ");
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontent, new Fragment01()).commit();
                break;
            case R.id.Select:

                break;
            case R.id.JoinA:

                break;
            case R.id.AIns:

                break;
        }
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
    }
}
