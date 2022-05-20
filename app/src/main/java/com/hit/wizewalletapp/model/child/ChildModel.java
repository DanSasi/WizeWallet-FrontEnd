package com.hit.wizewalletapp.model.child;

import java.util.List;

public class ChildModel {
     int photo ;
    Integer balance = 0;
    String email ="";
    String _id = "";
    String password = "";
    String mAmount = "";
    String mMessage = "";
    String name = "";

    List<ChildTransactionModel> mChildTransactionModelList;



    public ChildModel(Integer id,String username,Integer balance,String name, List<ChildTransactionModel> childTransactionModelList){
        _id = id.toString();
        email = username;
        this.balance = balance;
        this.name = name;
        mChildTransactionModelList = childTransactionModelList;

    }
    public ChildModel() {

    }

    public ChildModel(Integer id , Integer amount , String message ){
        _id = id.toString();
        mAmount = amount.toString();
        mMessage = message;
    }

    public ChildModel(Integer photo, String balance, String username, String id, String password,String name) {
        this.photo = photo;
        this.balance = Integer.valueOf(balance);
        this.email = username ;
        this._id = id;
        this.password = password;
        this.name = name ;
    }

    public void setUserName(String username) {
        this.email = username;
    }

    public String getUserName() {
        return email;
    }
    public String getmName() {
        return name;
    }

    public void setmName(String mName) {
        this.name = mName;
    }


    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
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


    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
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
