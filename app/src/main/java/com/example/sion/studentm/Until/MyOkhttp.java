package com.example.sion.studentm.Until;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public  class MyOkhttp {
    static   private  String id="http://139.199.190.21";
    static RequestBody requestBody(JSONObject jsonObject) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
    }
    public static JSONObject buildJSON(String json) throws JSONException {
        return new JSONObject(json);
    }

    static OkHttpClient okHttpClient=new OkHttpClient();

    static  public Call GetBody(String url) throws IOException {
        Request request=new Request.Builder().get().url(id+url).build();
        Call call = okHttpClient.newCall(request);
        return call;
    }
    static  public Call PostBody(String url,String Json) throws IOException, JSONException {
        Request request=new Request.Builder().post(requestBody(buildJSON(Json))).url(id+url).build();
        Call call = okHttpClient.newCall(request);
        return call;
    }

   static public String Getbody(Response response) throws IOException {
        String string = response.body().string();
        return string;
    }
   static  public <T>T GetClass(Response response,Class<T> MyClass) throws IOException {
        String getbody = Getbody(response);
        return new Gson().fromJson(getbody,MyClass);
    }
    static  public void PrintError(Exception e){
        Log.i("PrintError", e.toString());
    }
}
