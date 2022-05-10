package com.hit.wizewalletapp.model;


import com.hit.wizewalletapp.model.TransactionModel;

import java.util.List;


public class ChildModel {
    String  balance , username = "",password , id;
    String avatarUrl;
    List<TransactionModel> transactionModelList;


    public ChildModel( String balance, String username, String id, String password,List<TransactionModel> transactionModelList) {

        this.balance = balance;
        this.username = username ;
        this.id = id;
        this.password = password;
        this.transactionModelList = transactionModelList;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getName() {
        return username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setAvatarUrl(String url) {
        avatarUrl = url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public List<TransactionModel> getTransactionModelList() {
        return transactionModelList;
    }

    public void setTransactionModelList(List<TransactionModel> transactionModelList) {
        this.transactionModelList = transactionModelList;
    }



}
