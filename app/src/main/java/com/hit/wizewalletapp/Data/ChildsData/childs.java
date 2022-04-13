package com.hit.wizewalletapp.Data.ChildsData;

import java.io.Serializable;

public class childs implements Serializable {

    private String name;
    private int image;
    private String Bank;

    public childs(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }
}
