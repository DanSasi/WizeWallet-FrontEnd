package com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels;

import java.util.LinkedList;
import java.util.List;

import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.MenuParentModel;
import com.hit.wizewalletapp.R;



public class MenuParentListModel {
    public static final MenuParentListModel instance = new MenuParentListModel();

    MenuParentListModel(){
        MenuParentModel send_Money = new MenuParentModel("2", R.drawable.moneytransfler_icon, "Send Money");
        MenuParentModel request_Payment = new MenuParentModel("3" , R.drawable.money_request, "Children Requests Payment");
        MenuParentModel settings = new MenuParentModel("4", R.drawable.settings_icon_two, "Settings");
        MenuParentModel child_link = new MenuParentModel("5", R.drawable.icon_link, "Child Link");
        MenuParentModel logout = new MenuParentModel("6",R.drawable.logout_icon_two,"Logout");


        menuParentModelData.add(send_Money);
        menuParentModelData.add(request_Payment);
        menuParentModelData.add(settings);
        menuParentModelData.add(child_link);
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
