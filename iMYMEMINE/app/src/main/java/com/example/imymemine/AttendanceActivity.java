package com.example.imymemine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class AttendanceActivity extends AppCompatActivity {
    String TAG = "AttendanceActivity";
    //Firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    //widget
    private Button mButton;
    private TextView mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        mName = (TextView) findViewById(R.id.attendance_name);

        //firebase get current user
        setupFirebaseAuth();

        FirebaseDatabase.getInstance().getReference()
                .child("users")
                .child(mAuth.getCurrentUser().getUid())
                .child("Name")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                         mName.setText(snapshot.getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        mButton = (Button) findViewById(R.id.attendance_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "출석을 시작합니다", Toast.LENGTH_LONG).show();

                SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
                Date time = new Date();
                final String time1 = format1.format(time);
                new Thread() {
                    public void run() {
                        postWithApi("IMYMEMINE-tesing", mName.getText().toString(), "IMYMEMINE-0", time1, "SUCCESS");
                        //getWithApi();
                        Bundle bun = new Bundle();
                        bun.putString("result", "good");
                        Message msg = handler.obtainMessage();
                        msg.setData(bun);
                        handler.sendMessage(msg);
                    }
                }.start();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListener);
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
        } catch (IOException | JSONException e) {
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
        String result = builder.toString();
        System.out.println(result);

        conn.disconnect();


    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @SuppressLint("ResourceType")
        public void handleMessage(Message msg) {
            Bundle bun = msg.getData();
            String set = bun.getString("result");
            if (set.equals("good")) {
                Toast.makeText(getApplicationContext(), "출석이 성공적으로 확인되었습니다 !", Toast.LENGTH_LONG).show();
            }
        }
    };

    /**
     * Setup the firebase auth object
     */
    private void setupFirebaseAuth() {

        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth.");

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                checkCurrentUser(user);

                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    /**
     * checks to see if the @param 'user' is logged in
     *
     * @param user
     */
    private void checkCurrentUser(FirebaseUser user) {
        Log.d(TAG, "checkCurrentUser: checking if user is logged in.");

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
/*            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);*/
            startActivity(intent);
            finish();
        }
    }
}
