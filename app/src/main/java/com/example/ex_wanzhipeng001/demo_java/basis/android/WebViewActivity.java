package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.ex_wanzhipeng001.demo_java.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView mWebview;
    @BindView(R.id.btn_sendRequest)
    Button mBtnSendRequest;
    @BindView(R.id.tv_response)
    TextView mTvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

//        mWebview.setVisibility(View.VISIBLE);
//        mWebview.getSettings().setJavaScriptEnabled(true);
//        mWebview.setWebViewClient(new WebViewClient());
//        mWebview.loadUrl("http://www.baidu.com");
    }

    @OnClick({R.id.btn_sendRequest})
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn_sendRequest:
//                sendRequest();
//                sendRequestWithOkHttp(null);
                sendRequestWithOkHttp("https://www.baidu.com",new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        runOnUiThread(new Runnable() {//需要手动和主线程通信
                            @Override
                            public void run() {
                                // TODO: 17/6/13
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        runOnUiThread(new Runnable() {//需要手动和主线程通信
                            @Override
                            public void run() {
                                // TODO: 17/6/13
                            }
                        });
                    }
                });
                break;
            default:
                break;
        }
    }

    private void sendRequestWithOkHttp(final String address, okhttp3.Callback callback) {
        if (callback == null) {
            new Thread(new Runnable() {//同步方式,需要手动开启子线程
                @Override
                public void run() {
                    OkHttpClient client = new OkHttpClient();
                    //get 请求
//                Request request = new Request.Builder().url(address).build();
                    //post请求
                    RequestBody requestBody = new FormBody.Builder().add("username","admin").add("password","123456").build();
                    Request request = new Request.Builder().url(address).post(requestBody).build();
                    try {
                        Response response = client.newCall(request).execute();//同步方式,需要手动开启子线程
                        String string = response.body().toString();
                        showResponse(string);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }else {
            OkHttpClient client = new OkHttpClient();
            Request request =  new Request.Builder().url(address).build();
            client.newCall(request).enqueue(callback);//异步方式,自动开启子线程
        }

    }

    private void sendRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL("https://www.baidu.com");//http://www.baidu.com 不行
                    connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("POST");
//                    DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
//                    outputStream.writeBytes("username=admin&password=123456");
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    if (200 == connection.getResponseCode()) {
                        InputStream inputStream = connection.getInputStream();
                        //读取输入流
                        // TODO  --- by wanzp on 17/8/25.
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null){
                            response.append(line);
                        }
                        showResponse(response.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvResponse.setText(response);
            }
        });
    }

    //获取其他页面的数据
    /**
     * POST请求获取数据
     */
    public static String postDownloadJson(String path,String post){
        URL url = null;
        PrintWriter printWriter = null;
        BufferedInputStream bis = null;
        try {
            url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            printWriter = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "utf-8"));

            // 发送请求参数
            printWriter.write(post);//post的参数 xx=xx&yy=yy
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            return bos.toString("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (printWriter != null) {
                printWriter.close();
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

    /**
     * 从网络获取json数据,(String byte[})

     * @param path
     * @return
     */
    public static String getJsonByInternet(String path){
        try {
            URL url = new URL(path.trim());
            //打开连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            if(200 == urlConnection.getResponseCode()){
                //得到输入流
                InputStream is =urlConnection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while(-1 != (len = is.read(buffer))){
                    baos.write(buffer,0,len);
                    baos.flush();
                }
                return baos.toString("utf-8");
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
