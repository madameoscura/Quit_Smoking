package com.example.quitsmoking.gui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.quitsmoking.R;
import com.example.quitsmoking.logic.FirstFragmentListener;

public class FirstFragment extends Fragment {

   FirstFragmentListener firstFragmentListener;
    public View view;
    public TextView txt_cigarettesConsumed, txt_moneyConsumed, txt_timeConsumed, txt_TarConsumed;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first, container, false);

        txt_cigarettesConsumed = view.findViewById(R.id.txt_cigarettesConsumed);
        txt_moneyConsumed = view.findViewById(R.id.txt_moneyConsumed);
        txt_timeConsumed = view.findViewById(R.id.txt_timeConsumed);
        txt_TarConsumed = view.findViewById(R.id.txt_TarConsumed);

        firstFragmentListener = new FirstFragmentListener(this);

        return view;
    }

}
