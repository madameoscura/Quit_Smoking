package com.example.quitsmoking.gui;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.quitsmoking.R;
import com.example.quitsmoking.logic.MainActivityListener;
import com.example.quitsmoking.logic.SecondActivityListener;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {

    SecondActivityListener secondActivityListener;
    public Toolbar toolbar;
    FrameLayout simpleFrameLayout;
    TabLayout tabLayout;
    TabItem statisticsFragment, bodyFragment, settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        simpleFrameLayout = findViewById(R.id.simpleFrameLayout);
        tabLayout = findViewById(R.id.simpleTabLayout);
        statisticsFragment= findViewById(R.id.tabItem_1);
        bodyFragment = findViewById(R.id.tabItem_2);
        settingsFragment = findViewById(R.id.tabItem_3);

        secondActivityListener = new SecondActivityListener(this);
        tabLayout.addOnTabSelectedListener(secondActivityListener);

    }

    public void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.simpleFrameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}
