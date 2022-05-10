package com.hit.wizewalletapp.model;

public class TransactionModel {

    String topic , cost , id , imageUrl , description ;
    ChildModel childModel;


    public TransactionModel(String id,String topic , String cost ,String description , ChildModel childModel){
        this.id = id ;
        this.topic = topic;
        this.cost = cost;
        this.description = description;
        this.childModel = childModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }

    public String getCost() { return cost; }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public ChildModel getChildModel() {
        return childModel;
    }

    public void setChildModel(ChildModel childModel) {
        this.childModel = childModel;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }


}
