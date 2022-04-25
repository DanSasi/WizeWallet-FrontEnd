package com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels;

import java.util.LinkedList;
import java.util.List;

import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.MenuParentModel;
import com.hit.wizewalletapp.R;



public class MenuParentListModel {
    public static final MenuParentListModel instance = new MenuParentListModel();

    MenuParentListModel(){
        MenuParentModel history_Transaction = new MenuParentModel("1", R.drawable.icon5, "History Transaction");
        MenuParentModel send_Money = new MenuParentModel("2", R.drawable.icon, "Send Money");
        MenuParentModel request_Payment = new MenuParentModel("3" , R.drawable.icon6, "Request Payment");
        MenuParentModel settings = new MenuParentModel("4", R.drawable.icon7, "Settings");
        MenuParentModel logout = new MenuParentModel("5",R.drawable.icon_logout,"Logout");

        menuParentModelData.add(history_Transaction);
        menuParentModelData.add(send_Money);
        menuParentModelData.add(request_Payment);
        menuParentModelData.add(settings);
        menuParentModelData.add(logout);
    }
    List<MenuParentModel> menuParentModelData = new LinkedList<MenuParentModel>();

    public List<MenuParentModel> getAllData(){
        return menuParentModelData;
    }

    public MenuParentModel getMenuById(String menuId) {

        for (MenuParentModel s : menuParentModelData) {
            if (s.getId().equals(menuId)) {
                return s;
            }
        }
        return null;
    }
}
