 package com.example.sion.studentm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.sion.studentm.JAVABeans.LHWTemp;
import com.example.sion.studentm.Until.MyOkhttp;

import okhttp3.Response;

 public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Response execute = MyOkhttp.PostBody("http://192.168.1.100:8020/api/v2/get_weather", "{\"UserName\":\"user1\"}").execute();
                LHWTemp mystudent= (LHWTemp) MyOkhttp.GetClass(execute, LHWTemp.class);

            } catch (Exception e) {
                e.printStackTrace();
                MyOkhttp.PrintError(e);
            }
        }
    }).start();
    }
}
