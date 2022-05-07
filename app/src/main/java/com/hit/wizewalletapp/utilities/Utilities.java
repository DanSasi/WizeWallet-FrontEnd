package com.hit.wizewalletapp.utilities;

import android.text.TextUtils;

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
}
