package com.hit.wizewalletapp.Models.ParentModels;

import android.graphics.Bitmap;

public class ChildModel {
     int photo ;
    String  balance ="", username =""
            , id = "",password = "";




    public ChildModel(Integer photo, String balance, String username, String id, String password) {
        this.photo = photo;
        this.balance = balance;
        this.username = username ;
        this.id = id;
        this.password = password;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getName() {
        return username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPhoto(){
        return photo;
    }
    public void setPhoto(Integer photo){
        this.photo = photo;
    }


    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


}
