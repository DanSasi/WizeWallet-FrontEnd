package com.hit.wizewalletapp.model.child;

public class ChildTaskModel {

     int mId;
     String message;
     int mAmount;

    public ChildTaskModel(Integer mAmount,String message){
        this.mAmount = mAmount;
        this.message = message;
    }

    public ChildTaskModel(int id , String message , Integer amount){
        this.mId = id;
        this.message = message;
        this.mAmount = amount;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
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
