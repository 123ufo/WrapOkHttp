# WrapOkHttp

####基于OkHttp二次封装

- 同步:SyncHttpUtils
- 异步：AsyncHttpUtils
- 回调运行在UI线程中的：OkHttpStringListener


	
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