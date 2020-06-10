package com.example.imymemine;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class AttendanceActivity extends AppCompatActivity {

    //widget
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        mButton = (Button) findViewById(R.id.attendance_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"출석을 시작합니다",Toast.LENGTH_LONG).show();

                new Thread() {
                    public void run() {
                        postWithApi("IMYMEMINE","JONGHAPARK","IMYMEMINE-0","2020-06-10","SUCCESS");
                        //getWithApi();
                        Bundle bun = new Bundle();
                        bun.putString("result","good");
                        Message msg = handler.obtainMessage();
                        msg.setData(bun);
                        handler.sendMessage(msg);
                    }
                }.start();
            }
        });

    }
    @Override
    public void onStop() {
        super.onStop();
    }
    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void postWithApi(String deviceid, String userid, String verifierid, String date, String result) {

        try {
            //data
            String url = "http://203.233.111.7:5050/push_ledger";
//            Map<String, Object> params = new LinkedHashMap<>(); // 파라미터 세팅
//            params.put("device_id", deviceid);
//            params.put("user_id", userid);
//            params.put("verifier_id", verifierid);
//            params.put("date", date);
//            params.put("result", result);
//            StringBuilder postData = new StringBuilder();
//            for (Map.Entry<String, Object> param : params.entrySet()) {
//                if (postData.length() != 0) postData.append('&');
//                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//                postData.append('=');
//                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//            }
//            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            //set data
            String json = "";
            //build json object
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("device_id", deviceid);
            jsonObject.accumulate("user_id", userid);
            jsonObject.accumulate("verifier_id", verifierid);
            jsonObject.accumulate("date", date);
            jsonObject.accumulate("result", result);
            //convert json to string
            json = jsonObject.toString();

            //open the connection
            URL mUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) mUrl.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(10000);
            conn.setDoInput(true);
            conn.setDoOutput(true); // 서버로 쓰기 모드 지정
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(json.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();

            System.out.println("응답코드 : " + conn.getResponseMessage());

            conn.disconnect();
        } catch (IOException | JSONException e){
            e.printStackTrace();
        }
    }
    private void getWithApi() throws IOException {
        String url = "http://203.233.111.7:5050/get_ledger";
        URL mUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) mUrl.openConnection();
        conn.setRequestMethod("GET");

        InputStream is = conn.getInputStream();
        System.out.println("응답코드 : " + conn.getResponseMessage());

        // Get the stream
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        String result= builder.toString();
        System.out.println(result);

        conn.disconnect();


    }
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @SuppressLint("ResourceType")
        public void handleMessage(Message msg) {
            Bundle bun = msg.getData();
            String set = bun.getString("result");
            System.out.println(set);
        }
    };
}
