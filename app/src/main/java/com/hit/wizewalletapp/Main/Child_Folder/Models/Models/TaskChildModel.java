package com.hit.wizewalletapp.Main.Child_Folder.Models.Models;

public class TaskChildModel {

//"_id": "627bec9a48d58675332cbb82",
//        "kidid": 333,
//        "message": "maef",
//        "amount": 200,
//        "sender": "625d271ff5bababc722a539b",
//        "isCompleted": false,
//        "__v": 0


    boolean isCompleted;
    String message;
    int amount;

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getKidid() {
        return kidid;
    }

    public void setKidid(int kidid) {
        this.kidid = kidid;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    String sender;
    int kidid;
    String _id;
    int __v;


}
