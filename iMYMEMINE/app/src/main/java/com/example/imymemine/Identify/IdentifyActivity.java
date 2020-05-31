package com.example.imymemine.Identify;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.imymemine.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class IdentifyActivity extends AppCompatActivity {

    //@param
    private FrameLayout mFrameLayout;
    private BottomNavigationView mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);

        mFrameLayout = (FrameLayout) findViewById(R.id.main_content);
        mBottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigationbar);
        mBottomNavigation.setSelectedItemId(R.id.item_personalID);
        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_personalID:
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.main_content, new IdentifyPersonalFragment());
                        fragmentTransaction.commit();
                        return true;
                    case R.id.item_passport:
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.main_content, new IdentifyPassportFragment());
                        fragmentTransaction1.commit();
                        return true;
                    case R.id.item_studentID:
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.replace(R.id.main_content, new IdentifyStudentFragment());
                        fragmentTransaction2.commit();
                        return true;
                }
                return false;
            }
        });

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.main_content, new IdentifyFragment());
//        fragmentTransaction.commit();
    }
}
