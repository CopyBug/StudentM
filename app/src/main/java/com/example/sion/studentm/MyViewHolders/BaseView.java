package com.example.sion.studentm.MyViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sion.studentm.R;

public class BaseView extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView Ts;
        public BaseView(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.Ts = (TextView) rootView.findViewById(R.id.Ts);
        }


}
