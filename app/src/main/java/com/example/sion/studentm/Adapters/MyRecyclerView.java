package com.example.sion.studentm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import com.example.sion.studentm.R;
import android.view.ViewGroup;
import android.view.ViewGroup;
import com.example.sion.studentm.MyViewHolders.BaseView;

public class MyRecyclerView extends  RecyclerView.Adapter<BaseView>{
   private String[] strings = {"1", "1", "1", "1", "1", "1"};

    @NonNull
    @Override
    public BaseView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        BaseView baseView=new BaseView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.baselistview,viewGroup,false));

        return baseView;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseView baseView, int i) {
        baseView.Ts.setText(strings[i]);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }
}
