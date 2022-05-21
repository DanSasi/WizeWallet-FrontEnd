package com.hit.wizewalletapp.model.child;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

public class ChildTransactionModel {
    String description;
    int amount;

    public String getLatitude() {
        return latitude == null? "" : latitude;
    }

    public String getLongitude() {
        return longitude == null? "" : longitude;
    }

    String latitude;
    String longitude;


    public ChildTransactionModel(Integer amount,String desc){
        this.amount=amount;
        this.description=desc;
    }
    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



}
