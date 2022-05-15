package com.hit.wizewalletapp.api.responses;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTaskModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTransactionModel;

import java.util.HashMap;
import java.util.List;

public class ServerResponse {
    public String status;
    public String message;
    public List<Integer> kidID;
    public Integer kidId;
    public Integer amount;


    public List<ChildTransactionModel> transactions;

    public List<ChildTransactionModel> getChildTransModels() {
        return transactions;
    }

    public void setChildTransModels(List<ChildTransactionModel> childTransModels) {
        this.transactions = childTransModels;
    }




    public List<ChildTaskModel> childTaskModels;

    public List<ChildTaskModel> getChildTaskModels()
    {
        return childTaskModels;
    }

    public void setChildTaskModels(List<ChildTaskModel> childTaskModels) {
        this.childTaskModels = childTaskModels;
    }
}
