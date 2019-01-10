package com.example.sion.studentm.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sion.studentm.Adapters.KebiaoRecylerView;
import com.example.sion.studentm.R;
import com.example.sion.studentm.Until.MyUntil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Fragment02Class extends Fragment {
    private Map<Integer, List<String>> mapclass;
    private RecyclerView MyReLt;
    private Context context;
    private TextView day1;
    private TextView day2;
    private TextView day3;
    private TextView day4;
    private TextView day5;
    private TextView[] textViews;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        View view = inflater
                .inflate(R.layout.fragment02kebiao, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        initdate();
        MyReLt = (RecyclerView) view.findViewById(R.id.MyReLt);
        initRv();
        day1 = (TextView) view.findViewById(R.id.day1);
        day2 = (TextView) view.findViewById(R.id.day2);
        day3 = (TextView) view.findViewById(R.id.day3);
        day4 = (TextView) view.findViewById(R.id.day4);
        day5 = (TextView) view.findViewById(R.id.day5);
        textViews= new TextView[]{day1, day2, day3, day4, day5};
        ChangeColor();

    }
    public void ChangeColor(){
        for (int i = 0; i <textViews.length ; i++) {
            String temp=textViews[i].getText()+"";
            if(temp.equals(MyUntil.GetWeek())){
                textViews[i].setBackgroundColor(Color.RED);
            }

        }
    }

    public void initdate() {
        mapclass = new LinkedHashMap<>();
        String[] Myclass = {"大学英语（三）\n" +
                "周一第1,2节{第1-19周}\n" +
                "刘宏文\n" +
                "B2-503", "大学英语（三）", "大学英语（三）\n" +
                "周一第1,2节{第1-19周}\n" +
                "刘宏文\n" +
                "B2-503", "Android应用程序设计", "Android应用程序设计", "Android应用程序设计", "", "", "", "", "", ""};


        List<String> list1 = Arrays.asList(Myclass);
        for (int i = 0; i < 6; i++) {
            if(i==0){
                String[] Pclass={"第一节课","第二节课","第三节课","第四节课",
                        "第五节课","第六节课","第七节课","第八节课","第九节课","第十节课","第十一节课","第十二节课"};
                List<String> list = Arrays.asList(Pclass);
                mapclass.put(i,list);

            }else {
                mapclass.put(i, list1);
            }

        }
    }

    public void initRv() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 6);

        KebiaoRecylerView kebiaoRecylerView = new KebiaoRecylerView(mapclass);
        MyReLt.setLayoutManager(gridLayoutManager);
        MyReLt.setAdapter(kebiaoRecylerView);
//      MyReLt.notify();
    }
}
