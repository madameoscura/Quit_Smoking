package com.example.quitsmoking.logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;

import com.example.quitsmoking.R;
import com.example.quitsmoking.gui.FirstFragment;
import com.example.quitsmoking.gui.ThirdFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstFragmentListener {
    private FirstFragment firstFragment;
    private Utility utility;
    private SharedPreferences sharedPreferences;
    private static final String myPreference = "myPreference";
    private static final String prefNoCigarettesDay = "noCigarettesDayKey";
    private static final String prefNicotine = "nicotineKey";
    private static final String prefTar = "tarKey";
    private static final String prefCarbonMonoxide = "carbonMonoxideKey";
    private static final String prefPricePerPack = "pricePerPackKey";
    private static final String prefNoCigarettesPack = "noCigarettesPackKey";
    private static final String prefyearsSmoked = "yearsSmokedKey";
    private static final String prefDateOfQuitting = "dateOfQuittingKey";

    public FirstFragmentListener(FirstFragment firstFragment) {
        this.firstFragment = firstFragment;
        this.utility = new Utility();
        initializeSharedPrefs();
    }


    public void initializeSharedPrefs() {
        sharedPreferences = firstFragment.getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);

        String dateOfQuitting = sharedPreferences.getString(prefDateOfQuitting, "");
        Integer noCigarettesDay = Integer.valueOf(sharedPreferences.getString(prefNoCigarettesDay, ""));
        Double nicotine = Double.valueOf(sharedPreferences.getString(prefNicotine, ""));
        Integer tar = Integer.valueOf(sharedPreferences.getString(prefTar, ""));
        Integer carbonMonoxide = Integer.valueOf(sharedPreferences.getString(prefCarbonMonoxide, ""));
        Double pricePerPack = Double.valueOf(sharedPreferences.getString(prefPricePerPack, ""));
        Integer noCigarettesPack = Integer.valueOf(sharedPreferences.getString(prefNoCigarettesPack, ""));
        Integer yearsSmoked = Integer.valueOf(sharedPreferences.getString(prefyearsSmoked, ""));

        firstFragment.txt_daysNotSmoked.setText(String.valueOf(utility.getDateDifference(dateOfQuitting)) + " " + firstFragment.getActivity().getString(R.string.txt_days));
        firstFragment.txt_moneySaved.setText(String.valueOf(utility.moneySaved(dateOfQuitting, noCigarettesDay, pricePerPack, noCigarettesPack)) + " €");
        firstFragment.txt_cigarettesNotSmoked.setText(String.valueOf(utility.cigarettesNotSmoked(dateOfQuitting, noCigarettesDay)));
        firstFragment.txt_lifetimeSaved.setText(String.valueOf(utility.lifetimeSaved(dateOfQuitting, noCigarettesDay)) + " " + firstFragment.getActivity().getString(R.string.txt_minutes));

        firstFragment.txt_cigarettesConsumed.setText(String.valueOf(utility.noCigarettesSmoked(yearsSmoked, noCigarettesDay)) + " " + firstFragment.getActivity().getString(R.string.txt_cigarettes));
        firstFragment.txt_moneyConsumed.setText(utility.moneyConsumed(yearsSmoked, noCigarettesDay, pricePerPack, noCigarettesPack) + " €");
        firstFragment.txt_timeConsumed.setText(String.valueOf(utility.minutesSmoked(yearsSmoked, noCigarettesDay)) + " " + firstFragment.getActivity().getString(R.string.txt_minutes));
        firstFragment.txt_TarConsumed.setText(String.valueOf(utility.tarConsumed(yearsSmoked, noCigarettesDay, tar)) + " " + firstFragment.getActivity().getString(R.string.txt_mgtar));

        firstFragment.txt_nicotineConsumed.setText(utility.nicotineConsumed(yearsSmoked, noCigarettesDay, nicotine) + " " + firstFragment.getActivity().getString(R.string.txt_mgnicotine));

        firstFragment.txt_carbonMonoxideConsumed.setText(String.valueOf(utility.carbonMonoxideConsumed(yearsSmoked, noCigarettesDay, carbonMonoxide)) + " mg CO");

        firstFragment.txt_moneyPerWeek.setText(utility.moneySavedPerTimeFrame(7, noCigarettesDay, pricePerPack, noCigarettesPack) + " €");
        firstFragment.txt_moneyPerMonth.setText(utility.moneySavedPerTimeFrame(30, noCigarettesDay, pricePerPack, noCigarettesPack) + " €");
        firstFragment.txt_moneyPerYear.setText(utility.moneySavedPerTimeFrame(365, noCigarettesDay, pricePerPack, noCigarettesPack) + " €");
        firstFragment.txt_moneyPer5Years.setText(utility.moneySavedPerTimeFrame(1825, noCigarettesDay, pricePerPack, noCigarettesPack) + " €");
        firstFragment.txt_moneyPer10Years.setText(utility.moneySavedPerTimeFrame(3650, noCigarettesDay, pricePerPack, noCigarettesPack) + " €");
        firstFragment.txt_moneyPer20Years.setText(utility.moneySavedPerTimeFrame(7300, noCigarettesDay, pricePerPack, noCigarettesPack) + " €");
    }


}
