package com.example.quitsmoking.logic;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;

import com.example.quitsmoking.R;
import com.example.quitsmoking.gui.MainActivity;
import com.example.quitsmoking.gui.SecondActivity;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivityListener implements View.OnClickListener, TextWatcher {

    MainActivity mainActivity;
    DatePickerDialog picker;
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
    //  DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    //   String date = df.format(Calendar.getInstance().getTime());


    public MainActivityListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        mainActivity.txt_noCigarettesDay.setText(String.valueOf(10));
        mainActivity.txt_nicotine.setText(String.valueOf(0.9));
        mainActivity.txt_tar.setText(String.valueOf(10));
        mainActivity.txt_carbonMonoxide.setText(String.valueOf(14));
    //    mainActivity.txt_pricePerPack.setText(String.valueOf(5.50));
        mainActivity.txt_noCigarettesPack.setText(String.valueOf(19));
        mainActivity.txt_yearsSmoked.setText(String.valueOf(1));
        mainActivity.txt_dateOfQuitting.setFocusable(false);
        //     mainActivity.txt_dateOfQuitting.setText(String.valueOf(date));
        initializeSharedPrefs();
    }

    @Override
    public void onClick(View v) {
        int count;
        String nicotineCount;
        //  DecimalFormat df = new DecimalFormat("#.#");

        switch (v.getId()) {
            case R.id.btnMinusNoCigarettesDay:
                count = Integer.parseInt(mainActivity.txt_noCigarettesDay.getText().toString()) - 1;
                mainActivity.txt_noCigarettesDay.setText(String.valueOf(count));
                break;
            case R.id.btnPlusNoCigarettesDay:
                count = Integer.parseInt(mainActivity.txt_noCigarettesDay.getText().toString()) + 1;
                mainActivity.txt_noCigarettesDay.setText(String.valueOf(count));
                break;
            case R.id.btnMinusNicotine:
                //         String.format("%.0f", doubleValue);
                nicotineCount = String.format("%.1f", Double.parseDouble(mainActivity.txt_nicotine.getText().toString()) - 0.1);
                mainActivity.txt_nicotine.setText(nicotineCount);
                break;
            case R.id.btnPlusNicotine:
                nicotineCount = String.format("%.1f", Double.parseDouble(mainActivity.txt_nicotine.getText().toString()) + 0.1);
                mainActivity.txt_nicotine.setText(nicotineCount);
                break;
            case R.id.btnMinusTar:
                count = Integer.parseInt(mainActivity.txt_tar.getText().toString()) - 1;
                mainActivity.txt_tar.setText(String.valueOf(count));
                break;
            case R.id.btnPlusTar:
                count = Integer.parseInt(mainActivity.txt_tar.getText().toString()) + 1;
                mainActivity.txt_tar.setText(String.valueOf(count));
                break;
            case R.id.btnMinusCarbonMonoxide:
                count = Integer.parseInt(mainActivity.txt_carbonMonoxide.getText().toString()) - 1;
                mainActivity.txt_carbonMonoxide.setText(String.valueOf(count));
                break;
            case R.id.btnPlusCarbonMonoxide:
                count = Integer.parseInt(mainActivity.txt_carbonMonoxide.getText().toString()) + 1;
                mainActivity.txt_carbonMonoxide.setText(String.valueOf(count));
                break;
            case R.id.btnMinusNoCigarettesPack:
                count = Integer.parseInt(mainActivity.txt_noCigarettesPack.getText().toString()) - 1;
                mainActivity.txt_noCigarettesPack.setText(String.valueOf(count));
                break;
            case R.id.btnPlusNoCigarettesPack:
                count = Integer.parseInt(mainActivity.txt_noCigarettesPack.getText().toString()) + 1;
                mainActivity.txt_noCigarettesPack.setText(String.valueOf(count));
                break;
            case R.id.btnMinusYearsSmoked:
                count = Integer.parseInt(mainActivity.txt_yearsSmoked.getText().toString()) - 1;
                mainActivity.txt_yearsSmoked.setText(String.valueOf(count));
                break;
            case R.id.btnPlusYearsSmoked:
                count = Integer.parseInt(mainActivity.txt_yearsSmoked.getText().toString()) + 1;
                mainActivity.txt_yearsSmoked.setText(String.valueOf(count));
                break;
            case R.id.btnChoose:
                setQuittingDate();
                break;
        }
    }

    private void setQuittingDate() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);

        // date picker dialog
        picker = new DatePickerDialog(mainActivity,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            mainActivity.txt_dateOfQuitting.setText(dayOfMonth + "." + (month + 1) + "." + year);
                    }
                }, year, month, day);
        picker.getDatePicker().setMaxDate(new Date().getTime());
        picker.show();
    }

    private void initializeSharedPrefs() {
        sharedPreferences = mainActivity.getSharedPreferences(myPreference, Context.MODE_PRIVATE);

      /*  if (sharedPreferences.contains(prefName))
            mainActivity.etName.setText(sharedPreferences.getString(prefName, ""));
        if (sharedPreferences.contains(prefEmail))
            mainActivity.etEmail.setText(sharedPreferences.getString(prefEmail, "")); */
    }


    private void doneDialog() {
        String noCigarettesDay = mainActivity.txt_noCigarettesDay.getText().toString();
        String nicotine = mainActivity.txt_nicotine.getText().toString();
        String tar = mainActivity.txt_tar.getText().toString();
        String carbonMonoxide = mainActivity.txt_carbonMonoxide.getText().toString();
        String pricePerPack = mainActivity.txt_pricePerPack.getText().toString();
        String noCigarettesPack = mainActivity.txt_noCigarettesPack.getText().toString();
        String yearsSmoked = mainActivity.txt_yearsSmoked.getText().toString();
        String dateOfQuitting = mainActivity.txt_dateOfQuitting.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(prefNoCigarettesDay, noCigarettesDay);
        editor.putString(prefTar, tar);
        editor.putString(prefCarbonMonoxide, carbonMonoxide);
        editor.putString(prefPricePerPack, pricePerPack);
        editor.putString(prefNoCigarettesPack, noCigarettesPack);
        editor.putString(prefyearsSmoked, yearsSmoked);
        editor.putString(prefDateOfQuitting, dateOfQuitting);
        editor.putString(prefNicotine, nicotine);
        editor.apply();

        Intent changeActivityIntent = new Intent(mainActivity, SecondActivity.class);
        mainActivity.startActivity(changeActivityIntent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        mainActivity.getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_done:
                doneDialog();
                break;
        }
        return true;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mainActivity.txt_pricePerPack.hasFocus()) {
            mainActivity.txt_pricePerPack.setCursorVisible(true);
            String temp = s.toString();
            int posDot = temp.indexOf(".");

            if (posDot <= 0) {
                return;
            }
            if (temp.length() - posDot - 1 > 2) {
                s.delete(posDot + 3, posDot + 4);
            }
        } else if(!mainActivity.txt_pricePerPack.hasFocus()) {
            hideSoftKeyboard();

        }
    }

    private void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) mainActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(mainActivity.getCurrentFocus().getWindowToken(), 0);
        mainActivity.txt_pricePerPack.setCursorVisible(false);
    }
}