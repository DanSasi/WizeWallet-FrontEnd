package com.hit.wizewalletapp.Main.Child_Folder.Models.Models;

public class TaskChildModel {


    String message;
    int mAmount;

    public TaskChildModel(Integer mAmount, String message){
        this.mAmount = mAmount;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getmAmount() {
        return mAmount;
    }

    public void setmAmount(int mAmount) {
        this.mAmount = mAmount;
    }
}
