package com.example.quitsmoking.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.quitsmoking.R;
import com.example.quitsmoking.logic.MainActivityListener;
import com.example.quitsmoking.logic.Utility;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Utility utility;
    MainActivityListener mainActivityListener;

    public Toolbar toolbar_main;
    public TextView txt_noCigarettesDay, txt_nicotine, txt_tar, txt_carbonMonoxide, txt_pricePerPack, txt_noCigarettesPack, txt_yearsSmoked, txt_dateOfQuitting;
    public FloatingActionButton btnMinusNoCigarettesDay, btnPlusNoCigarettesDay, btnMinusNicotine, btnPlusNicotine, btnMinusTar, btnPlusTar, btnMinusCarbonMonoxide,
            btnPlusCarbonMonoxide, btnMinusNoCigarettesPack, btnPlusNoCigarettesPack, btnMinusYearsSmoked, btnPlusYearsSmoked;
    public Button btnChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar_main = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar_main);
        txt_noCigarettesDay = findViewById(R.id.txt_noCigarettesDay);
        txt_nicotine = findViewById(R.id.txt_nicotine);
        txt_tar = findViewById(R.id.txt_tar);
        txt_carbonMonoxide = findViewById(R.id.txt_carbonMonoxide);
        txt_pricePerPack = findViewById(R.id.txt_pricePerPack);
        txt_noCigarettesPack = findViewById(R.id.txt_noCigarettesPack);
        txt_yearsSmoked = findViewById(R.id.txt_yearsSmoked);
        txt_dateOfQuitting = findViewById(R.id.txt_dateOfQuitting);

        btnMinusNoCigarettesDay = findViewById(R.id.btnMinusNoCigarettesDay);
        btnPlusNoCigarettesDay = findViewById(R.id.btnPlusNoCigarettesDay);
        btnMinusNicotine = findViewById(R.id.btnMinusNicotine);
        btnPlusNicotine = findViewById(R.id.btnPlusNicotine);
        btnMinusTar = findViewById(R.id.btnMinusTar);
        btnPlusTar = findViewById(R.id.btnPlusTar);
        btnMinusCarbonMonoxide = findViewById(R.id.btnMinusCarbonMonoxide);
        btnPlusCarbonMonoxide = findViewById(R.id.btnPlusCarbonMonoxide);
        btnMinusNoCigarettesPack = findViewById(R.id.btnMinusNoCigarettesPack);
        btnPlusNoCigarettesPack = findViewById(R.id.btnPlusNoCigarettesPack);
        btnMinusYearsSmoked = findViewById(R.id.btnMinusYearsSmoked);
        btnPlusYearsSmoked = findViewById(R.id.btnPlusYearsSmoked);
        btnChoose = findViewById(R.id.btnChoose);

        mainActivityListener = new MainActivityListener(this);

        btnMinusNoCigarettesDay.setOnClickListener(mainActivityListener);
        btnPlusNoCigarettesDay.setOnClickListener(mainActivityListener);
        btnMinusNicotine.setOnClickListener(mainActivityListener);
        btnPlusNicotine.setOnClickListener(mainActivityListener);
        btnMinusTar.setOnClickListener(mainActivityListener);
        btnPlusTar.setOnClickListener(mainActivityListener);
        btnMinusCarbonMonoxide.setOnClickListener(mainActivityListener);
        btnPlusCarbonMonoxide.setOnClickListener(mainActivityListener);
        btnMinusNoCigarettesPack.setOnClickListener(mainActivityListener);
        btnPlusNoCigarettesPack.setOnClickListener(mainActivityListener);
        btnMinusYearsSmoked.setOnClickListener(mainActivityListener);
        btnPlusYearsSmoked.setOnClickListener(mainActivityListener);
        btnChoose.setOnClickListener(mainActivityListener);

        txt_pricePerPack.addTextChangedListener(mainActivityListener);
    }

    @Override
    protected void onResume() {
        super.onResume();

        boolean isFirstTime = Utility.isFirst(MainActivity.this);
        if (isFirstTime == false) {
            final Intent intent = new Intent(this, SecondActivity.class);
            this.startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return mainActivityListener.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mainActivityListener.onOptionsItemSelected(item);
    }
}
