package com.example.quitsmoking.gui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.quitsmoking.R;
import com.example.quitsmoking.logic.SecondFragmentListener;

public class SecondFragment extends Fragment {

 SecondFragmentListener secondFragmentListener;

    public View view;
    public TextView txt_smelltaste, txt_nicotineInBlood, txt_heartDisease, txt_skin, txt_breath, txt_cancerRisk;
    public ProgressBar pb_smelltaste, pb_nicotineInBlood, pb_heartDisease, pb_skin, pb_breath, pb_cancerRisk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_second, container, false);

        txt_smelltaste = view.findViewById(R.id.txt_smelltaste);
        txt_nicotineInBlood = view.findViewById(R.id.txt_nicotineInBlood);
        txt_heartDisease = view.findViewById(R.id.txt_heartDisease);
        txt_skin = view.findViewById(R.id.txt_skin);
        txt_breath = view.findViewById(R.id.txt_breath);
        txt_cancerRisk = view.findViewById(R.id.txt_cancerRisk);

        pb_smelltaste = view.findViewById(R.id.pb_smelltaste);
        pb_nicotineInBlood = view.findViewById(R.id.pb_nicotineInBlood);
        pb_heartDisease = view.findViewById(R.id.pb_heartDisease);
        pb_skin = view.findViewById(R.id.pb_skin);
        pb_breath = view.findViewById(R.id.pb_breath);
        pb_cancerRisk =  view.findViewById(R.id.pb_cancerRisk);

        secondFragmentListener = new SecondFragmentListener(this);

        return view;
    }
}
