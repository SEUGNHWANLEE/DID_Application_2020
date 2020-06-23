package com.example.imymemine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.DeadSystemException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.imymemine.Identify.IdentifyActivity;
import com.example.imymemine.Intro.IntroFirstFragment;
import com.example.imymemine.Intro.IntroSecondFragment;
import com.example.imymemine.Intro.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    String TAG = "Main Activity";

    //Firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    //widget
    private ViewPager mViewpager;
    private Button mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Firebase
        setupFirebaseAuth();

        mViewpager = (ViewPager)findViewById(R.id.view_pager_desc);
        mStart = (Button)findViewById(R.id.btn_start);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(  FirebaseAuth.getInstance().getCurrentUser() != null) {
                    Intent intent = new Intent(MainActivity.this, IdentifyActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        //Viewpager Setting
        ViewpagerAdapter mAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewpager, true);
        mAdapter.addItem(new IntroFirstFragment());
        //mAdapter.addItem(new IntroSecondFragment());
        mViewpager.setAdapter(mAdapter);
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if(mAuthListener != null)
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

    /**
     * Setup the firebase auth object
     */
    private void setupFirebaseAuth(){

        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth.");

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

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

}