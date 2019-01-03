package com.example.sion.studentm;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Person;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sion.studentm.JAVABeans.Loginmsg;


import com.google.gson.Gson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginMa extends AppCompatActivity implements View.OnClickListener {
    private Boolean Error=true;
    private String name;
    private String User;
    private OkHttpClient okHttpClient;
    private ImageView HeadIm;
    private EditText user;
    private EditText psw;
    private Button Login;
    private Button Register;
    private Loginmsg loginmsg = null;
    private ProgressBar wait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ma);

        initView();
        OkInit();

    }

    public void OkInit() {
            okHttpClient = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).cookieJar(new CookieJar() {
                Map<String, List<Cookie>> cookiess = new HashMap();

                @Override
                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                    cookiess.put(url.host(), cookies);
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl url) {
                    return cookiess.get(url.host()) != null ? cookiess.get(url.host()) : new ArrayList<Cookie>();
                }
            }).build();



    }

    public  void Login(final String user, final String psw) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("loginmsg.getMsg()", "run: ");

                RequestBody fromBody = new FormBody.Builder().add("username", user)
                        .add("password", psw).build();
                Request request = new Request.Builder().post(fromBody).url("http://61.142.174.200/gzxg/login.do").build();
                try {
                    Response execute = okHttpClient.newCall(request).execute();
                    String string = execute.body().string();
                    loginmsg = new Gson().fromJson(string, Loginmsg.class);
                    Log.i("loginmsg.getMsg()", loginmsg.getMsg());

                     Goning(okHttpClient);
                } catch (Exception e) {
                    e.printStackTrace();
                    Error=false;

                }
            }
        }).start();

    }
   

    public synchronized void Reslut() {


        if (loginmsg != null) {
            if (loginmsg.getMsg().equals("登陆成功.")) {
                User=user.getText().toString();
                Intent intent = new Intent(LoginMa.this, MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("user",User);
                startActivity(intent);


            } else {

                Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_SHORT).show();

            }
        }

    }

    public void Goning(final OkHttpClient okHttpClient) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder().get().url("http://61.142.174.200/gzxg/index.do").build();
                try {
                    Response execute = okHttpClient.newCall(request).execute();
                    String string = execute.body().string();
                    Document document = Jsoup.parse(string);
                    Element span = document.getElementsByTag("table").get(0)
                            .getElementsByTag("tr").get(0)
                            .getElementsByTag("td").get(0)
                            .getElementsByTag("span").get(0);

                    String text = span.text();
                    name=text.substring(5, text.length());



                    Log.i("StudentSch2", string);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginMa.this,"服务器开小差",Toast.LENGTH_SHORT).show();
                }
            }
        }).start();
    }


    public synchronized void  setUi(){

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
        String s = user.getText().toString();
        String s1 = psw.getText().toString();
        if(s.equals("")||s1.equals("")){
            Toast.makeText(LoginMa.this,"请输入账号和密码",Toast.LENGTH_SHORT).show();

        }else{
            wait.setVisibility(View.VISIBLE);
        try {

            Login(s, s1);
            Thread.sleep(2000);
            if(Error!=true){
               throw  new Exception("服务器开小菜");
            }
            Reslut();
        } catch (Exception e) {
            Toast.makeText(LoginMa.this,e.toString(),Toast.LENGTH_SHORT).show();
        }finally {
            wait.setVisibility(View.INVISIBLE);
        }
        }


    }

}
