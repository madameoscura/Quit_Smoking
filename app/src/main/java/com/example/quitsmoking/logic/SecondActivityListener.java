package com.example.quitsmoking.logic;

import com.example.quitsmoking.gui.FirstFragment;
import com.example.quitsmoking.gui.SecondActivity;
import com.example.quitsmoking.gui.SecondFragment;
import com.example.quitsmoking.gui.ThirdFragment;
import com.google.android.material.tabs.TabLayout;

public class SecondActivityListener implements TabLayout.OnTabSelectedListener {

    SecondActivity secondActivity;

    public SecondActivityListener(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
        secondActivity.loadFragment(new FirstFragment());

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case 0:
                secondActivity.loadFragment(new FirstFragment());
                break;
            case 1:
                secondActivity.loadFragment(new SecondFragment());
                break;
            case 2:
                secondActivity.loadFragment(new ThirdFragment());
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
