package com.example.imymemine;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.imymemine.Identify.IdentifyEmailFragment;
import com.example.imymemine.Identify.IdentifyPassportFragment;
import com.example.imymemine.Identify.IdentifyStudentFragment;
import com.example.imymemine.Intro.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class IdentifyActivity extends AppCompatActivity {

    /*
        @param
    */
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);

        mTabLayout = (TabLayout) findViewById(R.id.identify_tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.identify_viewpager);

        ViewpagerAdapter mAdapter = new ViewpagerAdapter(this.getSupportFragmentManager());
        mAdapter.addItem(new IdentifyEmailFragment());
        mAdapter.addItem(new IdentifyPassportFragment());
        mAdapter.addItem(new IdentifyStudentFragment());

        mTabLayout.setupWithViewPager(mViewPager, true);
        mViewPager.setAdapter(mAdapter);
    }
}
