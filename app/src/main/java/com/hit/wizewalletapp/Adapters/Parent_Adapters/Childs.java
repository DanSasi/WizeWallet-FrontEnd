package com.hit.wizewalletapp.Adapters.Parent_Adapters;

public class Childs {
    String userName, accNo;
    int userImage;

    public Childs(String userName, String accNo, int userImage) {
        this.userName = userName;
        this.accNo = accNo;
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }
}
