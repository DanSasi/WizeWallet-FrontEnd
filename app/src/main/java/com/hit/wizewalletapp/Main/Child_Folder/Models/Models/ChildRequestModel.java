package com.hit.wizewalletapp.Main.Child_Folder.Models.Models;

public class ChildRequestModel {



    public String message;
    public Integer amount;
    public String _id;

    public ChildRequestModel(String mMessage, Integer mAmount){
        message = mMessage;
        amount = mAmount;
    }

    public String getmMessage() {
        return message;
    }

    public void setmMessage(String mMessage) {
        this.message = mMessage;
    }

    public Integer getmAmount() {
        return amount;
    }
    public String get_id() {
        return _id;
    }

    public void setmAmount(Integer mAmount) {
        this.amount = mAmount;
    }

}
