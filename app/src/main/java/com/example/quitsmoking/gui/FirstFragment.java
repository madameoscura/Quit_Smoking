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
    public TextView txt_daysNotSmoked, txt_moneySaved, txt_cigarettesNotSmoked, txt_lifetimeSaved, txt_cigarettesConsumed, txt_moneyConsumed, txt_timeConsumed, txt_TarConsumed, txt_carbonMonoxideConsumed, txt_nicotineConsumed,
            txt_moneyPerWeek, txt_moneyPerMonth, txt_moneyPerYear, txt_moneyPer5Years, txt_moneyPer10Years, txt_moneyPer20Years;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first, container, false);

        txt_daysNotSmoked = view.findViewById(R.id.txt_daysNotSmoked);
        txt_moneySaved = view.findViewById(R.id.txt_moneySaved);
        txt_cigarettesNotSmoked = view.findViewById(R.id.txt_cigarettesNotSmoked);
        txt_lifetimeSaved = view.findViewById(R.id.txt_lifetimeSaved);

        txt_cigarettesConsumed = view.findViewById(R.id.txt_cigarettesConsumed);
        txt_moneyConsumed = view.findViewById(R.id.txt_moneyConsumed);
        txt_timeConsumed = view.findViewById(R.id.txt_timeConsumed);
        txt_TarConsumed = view.findViewById(R.id.txt_TarConsumed);
        txt_carbonMonoxideConsumed = view.findViewById(R.id.txt_carbonMonoxideConsumed);
        txt_nicotineConsumed = view.findViewById(R.id.txt_nicotineConsumed);

        txt_moneyPerWeek = view.findViewById(R.id.txt_moneyPerWeek);
        txt_moneyPerMonth = view.findViewById(R.id.txt_moneyPerMonth);
        txt_moneyPerYear = view.findViewById(R.id.txt_moneyPerYear);
        txt_moneyPer5Years = view.findViewById(R.id.txt_moneyPer5Years);
        txt_moneyPer10Years = view.findViewById(R.id.txt_moneyPer10Years);
        txt_moneyPer20Years = view.findViewById(R.id.txt_moneyPer20Years);

        firstFragmentListener = new FirstFragmentListener(this);

        return view;
    }

}
