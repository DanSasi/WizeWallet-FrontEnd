package com.hit.wizewalletapp.Main.Child_Folder.Models.Models;

public class ChildTaskModel {

    public String mId;
    public String message;
    public String mAmount;

    public ChildTaskModel(Integer id, String message , Integer amount){
        this.mId = id.toString();
        this.message = message;
        this.mAmount = amount.toString();
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getmAmount() {
        return mAmount;
    }

    public void setmAmount(String mAmount) {
        this.mAmount = mAmount;
    }
}
