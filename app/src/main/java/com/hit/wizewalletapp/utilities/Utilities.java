package com.hit.wizewalletapp.utilities;

import android.text.TextUtils;

import com.google.android.gms.maps.model.LatLng;

import org.jetbrains.annotations.Nullable;

public class Utilities {

    public static boolean verifyAllTextNotEmpty(String ... strings){
        if(strings != null && strings.length > 0){
            for (String string : strings) {
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Nullable
    public static LatLng getLatLng(String latitude,String longitude){
        if(!TextUtils.isEmpty(latitude) &&!TextUtils.isEmpty(longitude)){
            return new LatLng(Double.parseDouble(latitude),Double.parseDouble(latitude));
        }
        return null;
    }
}
