package com.example.sion.studentm.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.example.sion.studentm.Adapters.MyViewPagerAdapter;
import com.example.sion.studentm.JAVABeans.Astudent;
import com.example.sion.studentm.JAVABeans.Studentlogin;
import com.example.sion.studentm.MainActivity;
import com.example.sion.studentm.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import java.util.ArrayList;
import java.util.List;

public class Fragment02 extends Fragment {
    private QMUIRadiusImageView MyTouxiang;
    private EditText name;
    private EditText xuehao;
    private EditText Class;
    FragmentTransaction fragmentManager ;
    FragmentManager myfs;
    List<Fragment> fragments;
    private ViewPager MyViewP;
    private TabLayout  Title;
    private Studentlogin studentlogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment02, container, false);
        myfs=getFragmentManager();

        initView(view);
        return view;
    }

    private void initView(View view) {
        MyTouxiang = (QMUIRadiusImageView) view.findViewById(R.id.MyTouxiang);
        name = (EditText) view.findViewById(R.id.name);
        xuehao = (EditText) view.findViewById(R.id.xuehao);
        Class = (EditText) view.findViewById(R.id.Class);

        MyViewP = (ViewPager) view.findViewById(R.id.MyViewP);
        Title = view.findViewById(R.id.Title);
        studentlogin=MainActivity.getStudent();
        name.setText(studentlogin.getStudent().getSname());
        xuehao.setText(studentlogin.getSid()+"");
        Class.setText(studentlogin.getStudent().getMajory()+"");
        initViewpage(MyViewP,Title);

    }

    private void initViewpage(final ViewPager myViewP, TabLayout tabLayout) {
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new Fragment02Class());
        fragments.add(new Fragment02Chenji());
        fragments.add(new Fragment02SuTuo());
        //适配器
        MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter(getActivity().getSupportFragmentManager(),fragments);
        myViewP.setAdapter(myViewPagerAdapter);
        tabLayout.setupWithViewPager(myViewP,true);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        myViewP.setCurrentItem(0);

    }


}
