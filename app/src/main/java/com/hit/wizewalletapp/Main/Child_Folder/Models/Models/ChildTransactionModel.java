package com.hit.wizewalletapp.Main.Child_Folder.Models.Models;

public class ChildTransactionModel {
    String desc;
    String amount;

    public ChildTransactionModel(Integer amount,String desc){
        this.amount=amount.toString();
        this.desc=desc;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
