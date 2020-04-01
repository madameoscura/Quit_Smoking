package com.example.quitsmoking.logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private static final String myPreference = "myPreference";
    private static final String prefNoCigarettesDay = "noCigarettesDayKey";
    private static final String prefNicotine = "nicotineKey";
    private static final String prefTar = "tarKey";
    private static final String prefCarbonMonoxide = "carbonMonoxideKey";
    private static final String prefPricePerPack = "pricePerPackKey";
    private static final String prefNoCigarettesPack = "noCigarettesPackKey";
    private static final String prefyearsSmoked = "yearsSmokedKey";
    private static final String prefDateOfQuitting = "dateOfQuittingKey";

    public static boolean isFirst(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(myPreference, Context.MODE_PRIVATE);
        final boolean first = sharedPreferences.getBoolean("is_first", true);
        if (first) {
            final SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("is_first", false);
            editor.commit();
        }
        return first;
    }

    public Integer noCigarettesSmoked(Integer noOfYears, Integer noCigarettesDay) {
        Integer cigarettesSmoked = noOfYears * noCigarettesDay * 365;
        return cigarettesSmoked;
    }

    public String moneyConsumed(Integer noOfYears, Integer noCigarettesDay, Double pricePerPack, Integer noOfCigarettesPack) {
        DecimalFormat df = new DecimalFormat("0.00");
        Double moneyConsumed = noOfYears * noCigarettesDay * 365 * (pricePerPack / noOfCigarettesPack);
        String moneyConsumedRounded = df.format(moneyConsumed);
        return moneyConsumedRounded;
    }

    public Integer minutesSmoked(Integer noOfYears, Integer noCigarettesDay) {
        Integer minutesSmoked = noOfYears * noCigarettesDay * 365 * 5;
        return minutesSmoked;
    }

    public Integer tarConsumed(Integer noOfYears, Integer noCigarettesDay, Integer tar) {
        Integer tarConsumed = noOfYears * noCigarettesDay * 365 * tar;
        return tarConsumed;
    }

    public String nicotineConsumed(Integer noOfYears, Integer noCigarettesDay, Double nicotine) {
        DecimalFormat df = new DecimalFormat("0");
        Double nicotineConsumed = noOfYears * noCigarettesDay * 365 * nicotine;
        String nicotineConsumedRounded = df.format(nicotineConsumed);
        return nicotineConsumedRounded;
    }

    public Integer carbonMonoxideConsumed(Integer noOfYears, Integer noCigarettesDay, Integer carbonMonoxide) {
        Integer carbonMonoxideConsumed = noOfYears * noCigarettesDay * 365 * carbonMonoxide;
        return carbonMonoxideConsumed;
    }

    public Integer getDateDifference(String oldDateString) {
        //    String oldDateString = sharedPreferences.getString(prefDateOfQuitting, "");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        int diffDays = 0;
        try {
            Date oldDate = dateFormat.parse(oldDateString);
            String dateString = dateFormat.format(new Date());
            Date currentDate = dateFormat.parse(dateString);

            long diff = currentDate.getTime() - oldDate.getTime();

            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            diffDays = (int) (days);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diffDays;
    }

    public String moneySaved(String oldDateString, Integer noCigarettesDay, Double pricePerPack, Integer noOfCigarettesPack) {
        DecimalFormat df = new DecimalFormat("0.00");
        Double moneySaved = getDateDifference(oldDateString) * noCigarettesDay * (pricePerPack / noOfCigarettesPack);
        String moneySavedRounded = df.format(moneySaved);
        return moneySavedRounded;
    }

    public Integer cigarettesNotSmoked(String oldDateString, Integer noCigarettesDay) {
        Integer cigarettesNotSmoked = getDateDifference(oldDateString) * noCigarettesDay;
        return cigarettesNotSmoked;
    }

    public Integer lifetimeSaved(String oldDateString, Integer noCigarettesDay) {
        Integer lifetimeSaved = getDateDifference(oldDateString) * noCigarettesDay * 7;
        return lifetimeSaved;
    }

    public String moneySavedPerTimeFrame(Integer days, Integer noCigarettesDay, Double pricePerPack, Integer noOfCigarettesPack) {
        DecimalFormat df = new DecimalFormat("0.00");
        Double moneySaved = days * noCigarettesDay * (pricePerPack / noOfCigarettesPack);
        String moneySavedRounded = df.format(moneySaved);
        return moneySavedRounded;
    }
}
