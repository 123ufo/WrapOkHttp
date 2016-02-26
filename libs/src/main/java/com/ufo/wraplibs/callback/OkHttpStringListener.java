package com.ufo.wraplibs.callback;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 作者：XuDiWei
 * <p/>
 * 日期：2016/2/26.12:32
 * <p/>
 * 文件描述：回调运行在UI线程上的
 */
public abstract class OkHttpStringListener implements Callback {

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, final IOException e) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                onFail(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, Response response) throws IOException {
        final String s = response.body().string();
        handler.post(new Runnable() {
            @Override
            public void run() {
                onSuccess(call, s);
            }
        });
    }

    /**
     *  运行在UI线程的请求成功
     * @param call
     * @param response
     * @throws IOException
     */
    public abstract void onSuccess(Call call, String response);

    /**
     * 运行在UI线程的请求失败
     * @param call
     * @param e
     */
    public abstract void onFail(Call call, IOException e);
}
