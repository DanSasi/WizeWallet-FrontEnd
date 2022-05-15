package com.hit.wizewalletapp.Main.Child_Folder.Models.Models;

public class ChildTransactionModel {
    String description;
    int amount;

    public ChildTransactionModel(Integer amount,String desc){
        this.amount=amount;
        this.description=desc;
    }
    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
