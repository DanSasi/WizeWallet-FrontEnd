package com.hit.wizewalletapp.api.responses;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTaskModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTransactionModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.TaskChildModel;

import java.util.HashMap;
import java.util.List;

public class ServerResponse {
    public String status;
    public String message;



    public List<ChildModel> children;
    public Integer kidId;
    public Integer amount;


    public Integer balance;

    public List<ChildTransactionModel> transactions;
    public List<TaskChildModel> taskChildModels;


    public List<ChildTransactionModel> getChildTransModels() {
        return transactions;
    }

    public void setChildTransModels(List<ChildTransactionModel> childTransModels) {
        this.transactions = childTransModels;
    }
    public List<ChildModel> getChilds() {
        return children;
    }

    public List<ChildTaskModel> tasks;


    public List<ChildTaskModel> getChildTaskModels()
    {
        return tasks;
    }

    public List<TaskChildModel> getTaskChildModels() {
        return taskChildModels;
    }

    public void setTaskChildModels(List<TaskChildModel> taskChildModels) {
        this.taskChildModels = taskChildModels;
    }


    public void setChildTaskModels(List<ChildTaskModel> childTaskModels) {
        this.tasks = childTaskModels;
    }
}
