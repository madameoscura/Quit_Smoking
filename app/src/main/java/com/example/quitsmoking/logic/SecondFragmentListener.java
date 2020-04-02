package com.example.quitsmoking.logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;

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
        secondFragment.txt_nicotineInBlood.setText(String.valueOf(utility.progressToRegenerate(dateOfQuitting, 2)) + " %");


        if (secondFragment.pb_nicotineInBlood.getProgress() == 100) {
            secondFragment.pb_nicotineInBlood.setProgressTintList(ColorStateList.valueOf(Color.rgb(00,157,00)));
        }
        //2 days for smell and taste regeneration
        secondFragment.pb_smelltaste.setProgress(utility.progressToRegenerate(dateOfQuitting, 2));
        secondFragment.txt_smelltaste.setText(String.valueOf(utility.progressToRegenerate(dateOfQuitting, 2)) + " %");

        if (secondFragment.pb_smelltaste.getProgress() == 100) {
            secondFragment.pb_smelltaste.setProgressTintList(ColorStateList.valueOf(Color.rgb(00,157,00)));
        }
        //31 days for skin regeneration
        secondFragment.pb_skin.setProgress(utility.progressToRegenerate(dateOfQuitting, 31));
        secondFragment.txt_skin.setText(String.valueOf(utility.progressToRegenerate(dateOfQuitting, 31)) + " %");

        if (secondFragment.pb_skin.getProgress() == 100) {
            secondFragment.pb_skin.setProgressTintList(ColorStateList.valueOf(Color.rgb(00,157,00)));
        }
        //42 days for shortness of breath regeneration
        secondFragment.pb_breath.setProgress(utility.progressToRegenerate(dateOfQuitting, 42));
        secondFragment.txt_breath.setText(String.valueOf(utility.progressToRegenerate(dateOfQuitting, 42)) + " %");

        if (secondFragment.pb_breath.getProgress() == 100) {
            secondFragment.pb_breath.setProgressTintList(ColorStateList.valueOf(Color.rgb(00,157,00)));
        }
        //365 days for 50% risk reduction of coronary heart diseases
        secondFragment.pb_heartDisease.setProgress(utility.progressToRegenerate(dateOfQuitting, 365));
        secondFragment.txt_heartDisease.setText(String.valueOf(utility.progressToRegenerate(dateOfQuitting, 365)) + " %");

        if (secondFragment.pb_heartDisease.getProgress() == 100) {
            secondFragment.pb_heartDisease.setProgressTintList(ColorStateList.valueOf(Color.rgb(00,157,00)));
        }
        //1825 days (5 years) for 50% cancer risk reduction
        secondFragment.pb_cancerRisk.setProgress(utility.progressToRegenerate(dateOfQuitting, 1825));
        secondFragment.txt_cancerRisk.setText(String.valueOf(utility.progressToRegenerate(dateOfQuitting, 1825)) + " %");

        if (secondFragment.pb_cancerRisk.getProgress() == 100) {
            secondFragment.pb_cancerRisk.setProgressTintList(ColorStateList.valueOf(Color.rgb(00,157,00)));
        }
    }
}

