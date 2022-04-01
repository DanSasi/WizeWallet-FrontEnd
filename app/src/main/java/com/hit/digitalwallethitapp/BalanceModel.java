package com.hit.digitalwallethitapp;

public class BalanceModel {
    int photo;
    String date, topic, balance, description;

    public BalanceModel(int photo, String date, String topic, String balance, String description) {
        this.photo = photo;
        this.date = date;
        this.topic = topic;
        this.balance = balance;
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
