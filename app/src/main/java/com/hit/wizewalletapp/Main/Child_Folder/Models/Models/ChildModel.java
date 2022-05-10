package com.hit.wizewalletapp.Main.Child_Folder.Models.Models;

public class ChildModel {
     int photo ;
    String  balance ="", username =""
            , mId = "",password = "";


    public ChildModel(Integer id){
        mId = id.toString();
    }

    public ChildModel(Integer photo, String balance, String username, String id, String password) {
        this.photo = photo;
        this.balance = balance;
        this.username = username ;
        this.mId = id;
        this.password = password;
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
