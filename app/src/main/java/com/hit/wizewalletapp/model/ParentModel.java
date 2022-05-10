package com.hit.wizewalletapp.model;

import com.hit.wizewalletapp.model.ChildModel;

import java.util.List;

public class ParentModel {
    String name ;
    String id ;
    String email ;
    String password;
    String imageUrl;
    List<ChildModel> childModelList;

    public ParentModel(String id ,String name,String email , String password, List<ChildModel> childModelList) {
        this.id = id;
        this.name = name ;
        this.email = email;
        this.password = password;
        this.childModelList = childModelList;
    }


    public List<ChildModel> getChildModelList() {
        return childModelList;
    }

    public void setChildModelList(List<ChildModel> childModelList) {
        this.childModelList = childModelList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }




}
