package com.hit.wizewalletapp.Models.ParentModels;

public class MenuParentModelClass {
    String id;
    int img;
    String item_name;

    public MenuParentModelClass(String id, int img, String item_name) {
        this.id = id;
        this.img = img;
        this.item_name = item_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }


}
