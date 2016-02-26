package com.ufo.wraplibs;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 作者：XuDiWei
 * <p/>
 * 日期：2016/2/24.22:14
 * <p/>
 * 文件描述：异步网络请求 http
 */
public class AsyncHttpUtils {

    private static final OkHttpClient client = new OkHttpClient();

    /**
     * 异步请求 get
     *
     * @param url      请求地址
     * @param callback 回调接口
     */
    public static void get(String url, Callback callback) {
        doGet(url, callback);
    }

    /**
     * 异步请求 get 只有一对参数的请求
     *
     * @param url         请求地址
     * @param paramsKey   参数的key  不能为空
     * @param paramsValue 参数的value    不能为空
     * @param callback    回调接口
     */
    public static void get(String url, String paramsKey, String paramsValue, Callback callback) {
        if (null == paramsKey || null == paramsValue) {
            throw new NullPointerException("paramsKey and paramsValue can not null");
        }

        RequestParams params = new RequestParams();
        params.put(paramsKey, paramsValue);
        get(url, params, callback);

    }

    /**
     * 异步请求 get 请求参数封装在RequestParams里
     *
     * @param url           请求地址
     * @param requestParams 请求参数
     * @param callback      回调接口
     */
    public static void get(String url, RequestParams requestParams, Callback callback) {
        url = url + requestParams.getParamsString();
        doGet(url, callback);
    }

    /**
     * 此方法不对外公开，执行get请求
     *
     * @param url      请求地址
     * @param callback 回调接口
     */
    private static void doGet(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(callback);
    }


    /**
     * 异步请求 post
     *
     * @param url      请求地址
     * @param callback 回调接口
     */
    public static void post(String url, Callback callback) {
        post(url, null, null, callback);
    }

    /**
     * 异步请求 post 带一对键值对参数的
     *
     * @param url         请求地址
     * @param paramsKey   参数的key
     * @param paramsValue 参数的value
     * @param callback    回调接口
     */
    public static void post(String url, String paramsKey, String paramsValue, Callback callback) {
        FormBody formBody = null;
        if (null == paramsKey || null == paramsValue) {
            formBody = getFormBody(new HashMap<String, String>());
        } else {
            HashMap<String, String> map = new HashMap<>();
            map.put(paramsKey, paramsValue);
            formBody = getFormBody(map);
        }

        doPost(url, formBody, callback);
    }

    /**
     * 异步请求 post 多组参数，通过创建一个RequestParams实例来封装参数。
     *
     * @param url      请求地址
     * @param params   请求参数
     * @param callback 回调接口
     */
    public static void post(String url, RequestParams params, Callback callback) {
        FormBody formBody = null;
        if (null == params) {
            throw new NullPointerException("params can not null");
        }
        formBody = getFormBody(params.getParams());
        doPost(url, formBody, callback);

    }

    /**
     * 此方法不对外公开，执行post请求
     * @param url
     * @param requestBody
     * @param callback
     */
    private static void doPost(String url, RequestBody requestBody, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 根据一个map集合，生成一个给post可用的，封装过的FormBody
     *
     * @param paramsMap 参数集合
     * @return formbody 实体
     */
    private static FormBody getFormBody(Map<String, String> paramsMap) {
        FormBody formBody = null;
        if (null == paramsMap) {
            throw new NullPointerException("paramsMap can not null");
        }

        if (paramsMap.size() == 0) {
            return formBody = new FormBody.Builder().build();
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> m : paramsMap.entrySet()) {
            builder.add(m.getKey(), m.getValue());
        }
        return formBody = builder.build();
    }
}
