package com.hit.wizewalletapp.views.generaldata;

import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerData {

    public static List<SpinnerModel> getSpinnerList(){
        List<SpinnerModel> spinnerModelList = new ArrayList<>();


        SpinnerModel parentUser = new SpinnerModel();
        parentUser.setName("Parent");
        parentUser.setImage(R.drawable.parent_icon_three);
        spinnerModelList.add(parentUser);

        SpinnerModel childUser = new SpinnerModel();
        childUser.setName("Child");
        childUser.setImage(R.drawable.child_icon_new);
        spinnerModelList.add(childUser);


        return spinnerModelList;

    }


}
