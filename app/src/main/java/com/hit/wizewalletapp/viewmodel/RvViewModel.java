package com.hit.wizewalletapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hit.wizewalletapp.model.ChildModel;
import com.hit.wizewalletapp.model.Model;

import java.util.List;

public class RvViewModel extends ViewModel {
    LiveData<List<ChildModel>> data;

    public RvViewModel(){
        data = Model.instance.getAllChildren();
    }
}
