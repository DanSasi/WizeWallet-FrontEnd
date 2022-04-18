package com.hit.wizewalletapp.Adapters.Parent_Adapters;

public class ChildsModel {
    String childName, accNo;
    int childImage;

    public ChildsModel(String userName, String accNo, int userImage) {
        this.childName = userName;
        this.accNo = accNo;
        this.childImage = userImage;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getChildImage() {
        return childImage;
    }

    public void setChildImage(int childImage) {
        this.childImage = childImage;
    }
}
