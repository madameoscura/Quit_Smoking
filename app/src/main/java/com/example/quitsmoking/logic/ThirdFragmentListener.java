package com.example.quitsmoking.logic;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;

import com.example.quitsmoking.R;
import com.example.quitsmoking.gui.MainActivity;
import com.example.quitsmoking.gui.SecondActivity;
import com.example.quitsmoking.gui.ThirdFragment;

import java.util.Calendar;
import java.util.Date;

public class ThirdFragmentListener implements View.OnClickListener, TextWatcher {

    private ThirdFragment thirdFragment;
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
    SharedPreferences.Editor editor;

    public ThirdFragmentListener(ThirdFragment thirdFragment) {
        this.thirdFragment = thirdFragment;
        thirdFragment.txt_dateOfQuitting.setFocusable(false);
        initializeSharedPrefs();
        editor = sharedPreferences.edit();
    }

    @Override
    public void onClick(View v) {
        int count;
        String nicotineCount;

        switch (v.getId()) {
            case R.id.btnMinusNoCigarettesDay:
                count = Integer.parseInt(thirdFragment.txt_noCigarettesDay.getText().toString()) - 1;
                thirdFragment.txt_noCigarettesDay.setText(String.valueOf(count));
                String noCigarettesDay = String.valueOf(count);
                editor.putString(prefNoCigarettesDay, noCigarettesDay);
                break;
            case R.id.btnPlusNoCigarettesDay:
                count = Integer.parseInt(thirdFragment.txt_noCigarettesDay.getText().toString()) + 1;
                thirdFragment.txt_noCigarettesDay.setText(String.valueOf(count));
                noCigarettesDay = String.valueOf(count);
                editor.putString(prefNoCigarettesDay, noCigarettesDay);
                break;
            case R.id.btnMinusNicotine:
                nicotineCount = String.format("%.1f", Double.parseDouble(thirdFragment.txt_nicotine.getText().toString()) - 0.1);
                thirdFragment.txt_nicotine.setText(nicotineCount);
                editor.putString(prefNicotine, nicotineCount);
                break;
            case R.id.btnPlusNicotine:
                nicotineCount = String.format("%.1f", Double.parseDouble(thirdFragment.txt_nicotine.getText().toString()) + 0.1);
                thirdFragment.txt_nicotine.setText(nicotineCount);
                editor.putString(prefNicotine, nicotineCount);
                break;
            case R.id.btnMinusTar:
                count = Integer.parseInt(thirdFragment.txt_tar.getText().toString()) - 1;
                thirdFragment.txt_tar.setText(String.valueOf(count));
                String tar = String.valueOf(count);
                editor.putString(prefTar, tar);
                break;
            case R.id.btnPlusTar:
                count = Integer.parseInt(thirdFragment.txt_tar.getText().toString()) + 1;
                thirdFragment.txt_tar.setText(String.valueOf(count));
                tar = String.valueOf(count);
                editor.putString(prefTar, tar);
                break;
            case R.id.btnMinusCarbonMonoxide:
                count = Integer.parseInt(thirdFragment.txt_carbonMonoxide.getText().toString()) - 1;
                thirdFragment.txt_carbonMonoxide.setText(String.valueOf(count));
                String carbonMonoxide = String.valueOf(count);
                editor.putString(prefCarbonMonoxide, carbonMonoxide);
                break;
            case R.id.btnPlusCarbonMonoxide:
                count = Integer.parseInt(thirdFragment.txt_carbonMonoxide.getText().toString()) + 1;
                thirdFragment.txt_carbonMonoxide.setText(String.valueOf(count));
                carbonMonoxide = String.valueOf(count);
                editor.putString(prefCarbonMonoxide, carbonMonoxide);
                break;
            case R.id.btnMinusNoCigarettesPack:
                count = Integer.parseInt(thirdFragment.txt_noCigarettesPack.getText().toString()) - 1;
                thirdFragment.txt_noCigarettesPack.setText(String.valueOf(count));
                String noCigarettesPack = String.valueOf(count);
                editor.putString(prefNoCigarettesPack, noCigarettesPack);
                break;
            case R.id.btnPlusNoCigarettesPack:
                count = Integer.parseInt(thirdFragment.txt_noCigarettesPack.getText().toString()) + 1;
                thirdFragment.txt_noCigarettesPack.setText(String.valueOf(count));
                noCigarettesPack = String.valueOf(count);
                editor.putString(prefNoCigarettesPack, noCigarettesPack);
                break;
            case R.id.btnMinusYearsSmoked:
                count = Integer.parseInt(thirdFragment.txt_yearsSmoked.getText().toString()) - 1;
                thirdFragment.txt_yearsSmoked.setText(String.valueOf(count));
                String yearsSmoked = String.valueOf(count);
                editor.putString(prefyearsSmoked, yearsSmoked);
                break;
            case R.id.btnPlusYearsSmoked:
                count = Integer.parseInt(thirdFragment.txt_yearsSmoked.getText().toString()) + 1;
                thirdFragment.txt_yearsSmoked.setText(String.valueOf(count));
                yearsSmoked = String.valueOf(count);
                editor.putString(prefyearsSmoked, yearsSmoked);
                break;
            case R.id.btnChoose:
                setQuittingDate();
                break;
        }
        editor.apply();
    }

    private void setQuittingDate() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);

        // date picker dialog
        DatePickerDialog picker = new DatePickerDialog(thirdFragment.getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        thirdFragment.txt_dateOfQuitting.setText(dayOfMonth + "." + (month + 1) + "." + year);
                        String dateOfQuitting = dayOfMonth + "." + (month + 1) + "." + year;
                        editor.putString(prefDateOfQuitting, dateOfQuitting);
                        editor.apply();
                    }
                }, year, month, day);
        picker.getDatePicker().setMaxDate(new Date().getTime());
        picker.show();
    }

    public void initializeSharedPrefs() {
       sharedPreferences = thirdFragment.getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(prefNoCigarettesDay))
            thirdFragment.txt_noCigarettesDay.setText(sharedPreferences.getString(prefNoCigarettesDay, ""));
        if (sharedPreferences.contains(prefNicotine))
            thirdFragment.txt_nicotine.setText(sharedPreferences.getString(prefNicotine, ""));
        if (sharedPreferences.contains(prefTar))
            thirdFragment.txt_tar.setText(sharedPreferences.getString(prefTar, ""));
        if (sharedPreferences.contains(prefCarbonMonoxide))
            thirdFragment.txt_carbonMonoxide.setText(sharedPreferences.getString(prefCarbonMonoxide, ""));
        if (sharedPreferences.contains(prefPricePerPack))
            thirdFragment.txt_pricePerPack.setText(sharedPreferences.getString(prefPricePerPack, ""));
        if (sharedPreferences.contains(prefNoCigarettesPack))
            thirdFragment.txt_noCigarettesPack.setText(sharedPreferences.getString(prefNoCigarettesPack, ""));
        if (sharedPreferences.contains(prefyearsSmoked))
            thirdFragment.txt_yearsSmoked.setText(sharedPreferences.getString(prefyearsSmoked, ""));
        if (sharedPreferences.contains(prefDateOfQuitting))
            thirdFragment.txt_dateOfQuitting.setText(sharedPreferences.getString(prefDateOfQuitting, ""));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (thirdFragment.txt_pricePerPack.hasFocus()) {
            thirdFragment.txt_pricePerPack.setCursorVisible(true);
            String temp = s.toString();
            int posDot = temp.indexOf(".");

            if (posDot <= 0) {
                return;
            }
            if (temp.length() - posDot - 1 > 2) {
                s.delete(posDot + 3, posDot + 4);
            }
        } else if(!thirdFragment.txt_pricePerPack.hasFocus()) {
            hideSoftKeyboard();

        }
        String pricePerPack = thirdFragment.txt_pricePerPack.getText().toString();
        editor.putString(prefPricePerPack, pricePerPack);
        editor.apply();
    }

    private void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) thirdFragment.getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(thirdFragment.getActivity().getCurrentFocus().getWindowToken(), 0);
        thirdFragment.txt_pricePerPack.setCursorVisible(false);
    }
}
