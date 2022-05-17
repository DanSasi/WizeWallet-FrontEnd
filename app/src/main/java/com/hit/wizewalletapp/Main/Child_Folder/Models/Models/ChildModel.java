package com.hit.wizewalletapp.Main.Child_Folder.Models.Models;

import java.util.List;

public class ChildModel {
     int photo ;
    String mBalance ="";
    String username ="";
    String mId = "";
    String mPassword = "";
    String mAmount = "";
    String mMessage = "";


    String mName = "";



    List<ChildTransactionModel> mChildTransactionModelList;



    public ChildModel(Integer id, List<ChildTransactionModel> childTransactionModelList){
        mId = id.toString();
        mChildTransactionModelList = childTransactionModelList;

    }
    public ChildModel() {

    }

    public ChildModel(Integer id , Integer amount , String message ){
        mId = id.toString();
        mAmount = amount.toString();
        mMessage = message;
    }

    public ChildModel(Integer photo, String balance, String username, String id, String password,String name) {
        this.photo = photo;
        this.mBalance = balance;
        this.username = username ;
        this.mId = id;
        this.mPassword = password;
        this.mName = name ;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getUserName() {
        return username;
    }
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
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

    public List<ChildTransactionModel> getmChildTransactionModelList() {
        return mChildTransactionModelList;
    }

    public void setmChildTransactionModelList(List<ChildTransactionModel> mChildTransactionModelList) {
        this.mChildTransactionModelList = mChildTransactionModelList;
    }
    public void setmMessage(String mMessage) { this.mMessage = mMessage; }}
