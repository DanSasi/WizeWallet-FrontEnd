package com.hit.wizewalletapp.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class CacheUtilities {
    public static final String MY_PREF = "mypref";

    public static final String REFRESH_TOKEN_KEY = "REFRESH_TOKEN";
    public static final String ACSSES_TOKEN_KEY = "ACSSES_TOKEN";

    public static void saveToken(Context context ,String refreshToken, String accsesToken){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(REFRESH_TOKEN_KEY,refreshToken);
        editor.putString(ACSSES_TOKEN_KEY,accsesToken);
        editor.apply();
    }

    public static String getRefreshToken(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF,Context.MODE_PRIVATE);
        return sharedPreferences.getString(REFRESH_TOKEN_KEY,"");
    }

    public static String getAcssesToken(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF,Context.MODE_PRIVATE);
        return sharedPreferences.getString(ACSSES_TOKEN_KEY,"");
    }




}
