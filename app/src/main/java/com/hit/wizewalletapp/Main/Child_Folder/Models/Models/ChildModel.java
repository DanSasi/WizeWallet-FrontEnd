package com.hit.wizewalletapp.Main.Child_Folder.Models.Models;

public class ChildModel {
     int photo ;
    String mBalance ="";
    String username ="";
    String mId = "";
    String mPassword = "";
    String mAmount = "";
    String mMessage = "";



    public ChildModel(Integer id){
        mId = id.toString();
    }

    public ChildModel(Integer id , Integer amount , String message ){
        mId = id.toString();
        mAmount = amount.toString();
        mMessage = message;
    }

    public ChildModel(Integer photo, String balance, String username, String id, String password) {
        this.photo = photo;
        this.mBalance = balance;
        this.username = username ;
        this.mId = id;
        this.mPassword = password;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getName() {
        return username;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmId() {
        return mId;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmPassword() {
        return mPassword;
    }

    public Integer getPhoto(){
        return photo;
    }
    public void setPhoto(Integer photo){
        this.photo = photo;
    }


    public String getmBalance() {
        return mBalance;
    }

    public void setmBalance(String mBalance) {
        this.mBalance = mBalance;
    }

    public String getmAmount() {return mAmount; }

    public void setmAmount(String mAmount) { this.mAmount = mAmount; }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) { this.mMessage = mMessage; }}
