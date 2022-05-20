package com.hit.wizewalletapp.api.responses;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.model.child.ChildTaskModel;
import com.hit.wizewalletapp.model.child.ChildTransactionModel;
import com.hit.wizewalletapp.model.child.TaskChildModel;

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
