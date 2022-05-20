package com.hit.wizewalletapp.model.child;

import com.hit.wizewalletapp.R;

import java.util.LinkedList;
import java.util.List;

public class MenuChildListModel {
    public static final MenuChildListModel instance = new MenuChildListModel();

    MenuChildListModel(){
        ChildMenuModel request_Payment = new ChildMenuModel("1" , R.drawable.money_request, "Request Payment");
        ChildMenuModel settings = new ChildMenuModel("4", R.drawable.settings_icon_two, "Settings");
        ChildMenuModel logout = new ChildMenuModel("5",R.drawable.logout_icon_two,"Logout");

        menuChildListModels.add(request_Payment);
        menuChildListModels.add(settings);
        menuChildListModels.add(logout);
    }

    List<ChildMenuModel> menuChildListModels = new LinkedList<ChildMenuModel>();

    public List<ChildMenuModel> getAllData(){
        return menuChildListModels;
    }

    public ChildMenuModel getMenuById(String menuId) {

        for (ChildMenuModel s : menuChildListModels) {
            if (s.getId().equals(menuId)) {
                return s;
            }
        }
        return null;
    }

}
