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
    public TextView txt_smelltaste, txt_nicotineInBlood, txt_oxygenLevels, txt_skin, txt_breath;
    public ProgressBar pb_smelltaste, pb_nicotineInBlood, pb_oxygenLevels, pb_skin, pb_breath;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_second, container, false);

        txt_smelltaste = view.findViewById(R.id.txt_smelltaste);
        txt_nicotineInBlood = view.findViewById(R.id.txt_nicotineInBlood);
        txt_oxygenLevels = view.findViewById(R.id.txt_oxygenLevels);
        txt_skin = view.findViewById(R.id.txt_skin);
        txt_breath = view.findViewById(R.id.txt_breath);

        pb_smelltaste = view.findViewById(R.id.pb_smelltaste);
        pb_nicotineInBlood = view.findViewById(R.id.pb_nicotineInBlood);
        pb_oxygenLevels = view.findViewById(R.id.pb_oxygenLevels);
        pb_skin = view.findViewById(R.id.pb_skin);
        pb_breath = view.findViewById(R.id.pb_breath);

        secondFragmentListener = new SecondFragmentListener(this);

        return view;
    }
}
