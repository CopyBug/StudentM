package com.example.sion.studentm.Until;

import android.util.Log;

import com.example.sion.studentm.JAVABeans.Loginmsg;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpSchool {
    public Loginmsg getLoginmsg() {
        return loginmsg;
    }

    public void setLoginmsg(Loginmsg loginmsg) {
        this.loginmsg = loginmsg;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    private   Loginmsg loginmsg=null;
   private   OkHttpClient okHttpClient=null;
    public  void Coming(){
        Log.i("Coming()", "Coming: ");
        okHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJar() {
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


                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i(".printStackTrace(", e.toString());
                }
            }
        }).start();

    }

}
