package com.hit.wizewalletapp.model.child;

public class ChildRequestModel {



    public String message;
    public Integer amount;
    public String _id;
    String createdat;

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

    public String getDate() {
        return createdat;
    }

    public void setDate(String createdat) {
        this.createdat = createdat;
    }



}
