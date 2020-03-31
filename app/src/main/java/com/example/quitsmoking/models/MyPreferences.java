package com.example.quitsmoking.models;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences {

    private static final String myPreference = "myPreference";

    public static boolean isFirst(Context context){
        final SharedPreferences reader = context.getSharedPreferences(myPreference, Context.MODE_PRIVATE);
        final boolean first = reader.getBoolean("is_first", true);
        if(first){
            final SharedPreferences.Editor editor = reader.edit();
            editor.putBoolean("is_first", false);
            editor.commit();
        }
        return first;
    }

}
