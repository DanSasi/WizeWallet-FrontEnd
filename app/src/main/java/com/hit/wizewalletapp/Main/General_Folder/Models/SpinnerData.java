package com.hit.wizewalletapp.Main.General_Folder.Models;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.BalanceParentModel;
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
    public static List<SpinnerModel> getSpinnerListKids() {
        List<SpinnerModel> spinnerModelList = new ArrayList<>();

        SpinnerModel dan = new SpinnerModel();
         dan.setName("Dan");
        dan.setImage(R.drawable.dan_photo);
        spinnerModelList.add(dan);

        SpinnerModel michal = new SpinnerModel();
        michal.setName("Michael");
        michal.setImage(R.drawable.michal_photo);
        spinnerModelList.add(michal);

        SpinnerModel alon = new SpinnerModel();
        alon.setName("Alon");
        alon.setImage(R.drawable.alon_photo);
        spinnerModelList.add(alon);

        SpinnerModel maor = new SpinnerModel();
        maor.setName("Maor");
        maor.setImage(R.drawable.maor_photo);
        spinnerModelList.add(maor);

        SpinnerModel ben = new SpinnerModel();
        ben.setName("Ben");
        ben.setImage(R.drawable.ben_photo);
        spinnerModelList.add(ben);

        SpinnerModel yarden = new SpinnerModel();
        yarden.setName("Yarden");
        yarden.setImage(R.drawable.yarden_photo);
        spinnerModelList.add(yarden);


        return spinnerModelList;

    }

    }
