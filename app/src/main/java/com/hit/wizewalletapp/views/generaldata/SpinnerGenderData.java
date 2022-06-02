package com.hit.wizewalletapp.views.generaldata;

import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerGenderData {
    public static List<SpinnerModel> getSpinnerGenderList() {
        List<SpinnerModel> spinnerModelList = new ArrayList<>();


        SpinnerModel parentUser = new SpinnerModel();
        parentUser.setName("Boy");
        parentUser.setImage(R.drawable.child_icon_new);
        spinnerModelList.add(parentUser);

        SpinnerModel childUser = new SpinnerModel();
        childUser.setName("Girl");
        childUser.setImage(R.drawable.girl_icon);
        spinnerModelList.add(childUser);


        return spinnerModelList;
    }
}
