package com.example.quitsmoking.gui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.quitsmoking.R;
import com.example.quitsmoking.logic.MainActivityListener;
import com.example.quitsmoking.logic.ThirdFragmentListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ThirdFragment extends Fragment {

    ThirdFragmentListener thirdFragmentListener;

    public View view;
    public TextView txt_noCigarettesDay, txt_nicotine, txt_tar, txt_carbonMonoxide, txt_pricePerPack, txt_noCigarettesPack, txt_yearsSmoked, txt_dateOfQuitting;
    public FloatingActionButton btnMinusNoCigarettesDay, btnPlusNoCigarettesDay, btnMinusNicotine, btnPlusNicotine, btnMinusTar, btnPlusTar, btnMinusCarbonMonoxide,
            btnPlusCarbonMonoxide, btnMinusNoCigarettesPack, btnPlusNoCigarettesPack, btnMinusYearsSmoked, btnPlusYearsSmoked;
    public Button btnChoose;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_third, container, false);

        txt_noCigarettesDay = view.findViewById(R.id.txt_noCigarettesDay);
        txt_nicotine = view.findViewById(R.id.txt_nicotine);
        txt_tar = view.findViewById(R.id.txt_tar);
        txt_carbonMonoxide = view.findViewById(R.id.txt_carbonMonoxide);
        txt_pricePerPack = view.findViewById(R.id.txt_pricePerPack);
        txt_noCigarettesPack = view.findViewById(R.id.txt_noCigarettesPack);
        txt_yearsSmoked = view.findViewById(R.id.txt_yearsSmoked);
        txt_dateOfQuitting = view.findViewById(R.id.txt_dateOfQuitting);

        btnMinusNoCigarettesDay = view.findViewById(R.id.btnMinusNoCigarettesDay);
        btnPlusNoCigarettesDay = view.findViewById(R.id.btnPlusNoCigarettesDay);
        btnMinusNicotine = view.findViewById(R.id.btnMinusNicotine);
        btnPlusNicotine = view.findViewById(R.id.btnPlusNicotine);
        btnMinusTar = view.findViewById(R.id.btnMinusTar);
        btnPlusTar = view.findViewById(R.id.btnPlusTar);
        btnMinusCarbonMonoxide = view.findViewById(R.id.btnMinusCarbonMonoxide);
        btnPlusCarbonMonoxide = view.findViewById(R.id.btnPlusCarbonMonoxide);
        btnMinusNoCigarettesPack = view.findViewById(R.id.btnMinusNoCigarettesPack);
        btnPlusNoCigarettesPack = view.findViewById(R.id.btnPlusNoCigarettesPack);
        btnMinusYearsSmoked = view.findViewById(R.id.btnMinusYearsSmoked);
        btnPlusYearsSmoked = view.findViewById(R.id.btnPlusYearsSmoked);
        btnChoose = view.findViewById(R.id.btnChoose);

        thirdFragmentListener = new ThirdFragmentListener(this);

        btnMinusNoCigarettesDay.setOnClickListener(thirdFragmentListener);
        btnPlusNoCigarettesDay.setOnClickListener(thirdFragmentListener);
        btnMinusNicotine.setOnClickListener(thirdFragmentListener);
        btnPlusNicotine.setOnClickListener(thirdFragmentListener);
        btnMinusTar.setOnClickListener(thirdFragmentListener);
        btnPlusTar.setOnClickListener(thirdFragmentListener);
        btnMinusCarbonMonoxide.setOnClickListener(thirdFragmentListener);
        btnPlusCarbonMonoxide.setOnClickListener(thirdFragmentListener);
        btnMinusNoCigarettesPack.setOnClickListener(thirdFragmentListener);
        btnPlusNoCigarettesPack.setOnClickListener(thirdFragmentListener);
        btnMinusYearsSmoked.setOnClickListener(thirdFragmentListener);
        btnPlusYearsSmoked.setOnClickListener(thirdFragmentListener);
        btnChoose.setOnClickListener(thirdFragmentListener);

        txt_pricePerPack.addTextChangedListener(thirdFragmentListener);
        return view;
    }
}
