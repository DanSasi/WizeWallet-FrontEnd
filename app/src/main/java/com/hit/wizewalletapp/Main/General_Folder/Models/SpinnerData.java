package com.hit.wizewalletapp.Main.General_Folder.Models;

import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerData {

    public static List<SpinnerModel> getSpinnerList(){
        List<SpinnerModel> spinnerModelList = new ArrayList<>();


        SpinnerModel parentUser = new SpinnerModel();
        parentUser.setName("Parent");
        parentUser.setImage(R.drawable.facetherface);
        spinnerModelList.add(parentUser);

        SpinnerModel childUser = new SpinnerModel();
        childUser.setName("Child");
        childUser.setImage(R.drawable.childface);
        spinnerModelList.add(childUser);


        return spinnerModelList;

    }
}
