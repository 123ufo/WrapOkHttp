package com.ufo.testwrapokhttpsmaple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ufo.wraplibs.AsyncHttpUtils;
import com.ufo.wraplibs.RequestParams;
import com.ufo.wraplibs.callback.OkHttpStringListener;

import java.io.IOException;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String url = "http://api.avatardata.cn/GuoNeiNews/Query";

    private static final String tag = "TestOkhttpSimple";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        Button btnGet1 = (Button) findViewById(R.id.btn_get1);
        Button btnGet2 = (Button) findViewById(R.id.btn_get2);
        Button btnGet3 = (Button) findViewById(R.id.btn_get3);

        Button btnPost1 = (Button) findViewById(R.id.btn_post1);
        Button btnPost2 = (Button) findViewById(R.id.btn_post2);
        Button btnPost3 = (Button) findViewById(R.id.btn_post3);

        btnGet1.setOnClickListener(this);
        btnGet2.setOnClickListener(this);
        btnGet3.setOnClickListener(this);

        btnPost1.setOnClickListener(this);
        btnPost2.setOnClickListener(this);
        btnPost3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get1:
                get1();
                break;
            case R.id.btn_get2:
                get2();
                break;
            case R.id.btn_get3:
                get3();
                break;
            case R.id.btn_post1:
                post1();
                break;
            case R.id.btn_post2:
                post2();
                break;
            case R.id.btn_post3:
                post3();
                break;
        }
    }

    private void post3() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("key", "e38d390e10e243bb835a8162bbfacbd2");
        AsyncHttpUtils.post(url, requestParams, new OkHttpStringListener() {
            @Override
            public void onSuccess(Call call, String response) {
                Log.d(tag, "post3 请求成功:" + response);
            }

            @Override
            public void onFail(Call call, IOException e) {
                Log.d(tag, "post3 请求失败" + e.toString());
            }
        });
    }

    private void post2() {
        AsyncHttpUtils.post(url,"key","e38d390e10e243bb835a8162bbfacbd2", new OkHttpStringListener() {
            @Override
            public void onSuccess(Call call, String response) {
                Log.d(tag, "post2 请求成功:" + response);
            }

            @Override
            public void onFail(Call call, IOException e) {
                Log.d(tag, "post2 请求失败" + e.toString());
            }
        });
    }

    private void post1() {
        AsyncHttpUtils.post(url, new OkHttpStringListener() {
            @Override
            public void onSuccess(Call call, String response) {
                Log.d(tag, "post1 请求成功:" + response);
            }

            @Override
            public void onFail(Call call, IOException e) {
                Log.d(tag, "post1 请求失败" + e.toString());
            }
        });
    }

    private void get3() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("key", "e38d390e10e243bb835a8162bbfacbd2");
        AsyncHttpUtils.get(url, requestParams, new OkHttpStringListener() {
            @Override
            public void onSuccess(Call call, String response) {
                Log.d(tag, "get3 请求成功:" + response);
            }

            @Override
            public void onFail(Call call, IOException e) {
                Log.d(tag, "get3 请求失败" + e.toString());
            }
        });
    }

    private void get2() {
        AsyncHttpUtils.get(url, "key", "e38d390e10e243bb835a8162bbfacbd2", new OkHttpStringListener() {
            @Override
            public void onSuccess(Call call, String response) {
                Log.d(tag, "get2 请求成功:" + response);
            }

            @Override
            public void onFail(Call call, IOException e) {
                Log.d(tag, "get2 请求失败" + e.toString());
            }
        });

    }

    public void get1() {
        AsyncHttpUtils.get(url, new OkHttpStringListener() {
            @Override
            public void onSuccess(Call call, String response) {
                Log.d(tag, "get1 请求成功:" + response);
            }

            @Override
            public void onFail(Call call, IOException e) {
                Log.d(tag, "get1 请求失败" + e.toString());
            }
        });
    }
}