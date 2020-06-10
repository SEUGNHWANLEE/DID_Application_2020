package com.example.imymemine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.imymemine.Intro.IntroFirstFragment;
import com.example.imymemine.Intro.IntroSecondFragment;
import com.example.imymemine.Intro.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //@param
    private ViewPager mViewpager;
    private Button mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewpager = (ViewPager)findViewById(R.id.view_pager_desc);
        mStart = (Button)findViewById(R.id.btn_start);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //Viewpager Setting
        ViewpagerAdapter mAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewpager, true);
        mAdapter.addItem(new IntroFirstFragment());
        mAdapter.addItem(new IntroSecondFragment());
        mViewpager.setAdapter(mAdapter);
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


}