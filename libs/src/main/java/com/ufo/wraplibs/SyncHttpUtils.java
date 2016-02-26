package com.ufo.wraplibs;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：XuDiWei
 * <p/>
 * 日期：2016/2/24.21:49
 * <p/>
 * 文件描述：同步网络请求 http
 */
public class SyncHttpUtils {
    private static final OkHttpClient client = new OkHttpClient();

    /**
     * 同步 http get请求
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * 同步 http post请求
     * @param url
     * @return
     * @throws IOException
     */
    public static String post(String url) throws IOException {
        FormBody formBody = new FormBody.Builder().build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        return client.newCall(request).execute().body().string();
    }

}
