package com.example.sion.studentm;


import android.app.Application;
import android.app.Person;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.sion.studentm.JAVABeans.Studentlogin;
import com.example.sion.studentm.Until.MyOkhttp;

import java.io.Serializable;

import okhttp3.Response;

public class LoginMa extends AppCompatActivity implements View.OnClickListener {
    private Boolean Error=true;

    private ImageView HeadIm;
    private EditText user;
    private EditText psw;
    private Button Login;
    private Button Register;

    private ProgressBar wait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ma);

        initView();

    }

    private void initView() {
        HeadIm = (ImageView) findViewById(R.id.HeadIm);
        user = (EditText) findViewById(R.id.user);
        psw = (EditText) findViewById(R.id.psw);
        Login = (Button) findViewById(R.id.Login);
        Register = (Button) findViewById(R.id.Register);

        Login.setOnClickListener(this);
        Register.setOnClickListener(this);
        wait = (ProgressBar) findViewById(R.id.wait);
        wait.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Login:

                LoginBt();
                break;
            case R.id.Register:

                break;
        }
    }
    public void LoginBt(){
        String s2=user.getText().toString();
        String s1 = psw.getText().toString();

        if(s2.equals("")||s1.equals("")){
            Toast.makeText(LoginMa.this,"请输入账号和密码",Toast.LENGTH_SHORT).show();

        }else{
            Integer s = Integer.valueOf(s2);
            LoginFunction(s,s1);

        }
    }

    public void LoginFunction(final int SID,final String psw){
        new Thread(new Runnable() {
      @Override
      public void run() {
          try {
              Response execute = MyOkhttp.PostBody("/StudentP/Login", "{\"SID\":"+SID+",\"SCARE\":\""+psw+"\"}").execute();
              Studentlogin studentlogin = MyOkhttp.GetClass(execute, Studentlogin.class);

              if(studentlogin.getResult()){
                    Intent intent=new Intent().setClass(LoginMa.this,MainActivity.class);
                   intent.putExtra("Student",studentlogin);
                   startActivity(intent);
              }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginMa.this,"账号或者密码错误",Toast.LENGTH_SHORT).show();
                            }
                        });
              }
          } catch (Exception e) {
              e.printStackTrace();
              runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      Toast.makeText(LoginMa.this,"服务器开小差",Toast.LENGTH_SHORT).show();
                  }
              });
          }
      }
  }).start();
    }


}
