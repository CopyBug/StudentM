package com.example.sion.studentm.MySelfView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPage extends ViewPager {
    private boolean noScrool=true;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(noScrool)
            return false;
        else
        return super.onTouchEvent(ev);
    }

    public MyViewPage(@NonNull Context context) {

        super(context);
    }
    public void setNoScroll(boolean noScrool) {
        this.noScrool = noScrool;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    public MyViewPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
