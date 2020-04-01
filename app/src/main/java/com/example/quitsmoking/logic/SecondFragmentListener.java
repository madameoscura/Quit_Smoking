package com.example.quitsmoking.logic;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.quitsmoking.gui.SecondFragment;

public class SecondFragmentListener {
    SecondFragment secondFragment;
    private Utility utility;
    private SharedPreferences sharedPreferences;

    private static final String myPreference = "myPreference";
    private static final String prefDateOfQuitting = "dateOfQuittingKey";

    public SecondFragmentListener(SecondFragment secondFragment) {
        this.secondFragment = secondFragment;
        this.utility = new Utility();
        initializeSharedPrefs();
    }

    public void initializeSharedPrefs() {
        sharedPreferences = secondFragment.getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);
        String dateOfQuitting = sharedPreferences.getString(prefDateOfQuitting, "");

        //2 days for nicotine in blood to vanish
        secondFragment.pb_nicotineInBlood.setProgress(utility.progressToRegenerate(dateOfQuitting, 2));
        //2 days for smell and taste regeneration
        secondFragment.pb_smelltaste.setProgress(utility.progressToRegenerate(dateOfQuitting, 2));
        //31 days for skin regeneration
        secondFragment.pb_skin.setProgress(utility.progressToRegenerate(dateOfQuitting, 31));
        //42 days for shortness of breath regeneration
        secondFragment.pb_breath.setProgress(utility.progressToRegenerate(dateOfQuitting, 42));
        //365 days for 50% risk reduction of coronary heart diseases
        secondFragment.pb_heartDisease.setProgress(utility.progressToRegenerate(dateOfQuitting, 365));
        //1825 days (5 years) for 50% cancer risk reduction
        secondFragment.pb_cancerRisk.setProgress(utility.progressToRegenerate(dateOfQuitting, 1825));
    }
}

