package com.hit.wizewalletapp.Models.ParentModels;

import java.util.LinkedList;
import java.util.List;
import com.hit.wizewalletapp.R;



public class MenuParentListModel {
    public static final MenuParentListModel instance = new MenuParentListModel();

    MenuParentListModel(){
        MenuParentModelClass history_Transaction = new MenuParentModelClass("1", R.drawable.icon5, "History Transaction");
        MenuParentModelClass send_Money = new MenuParentModelClass("2", R.drawable.icon, "Send Money");
        MenuParentModelClass request_Payment = new MenuParentModelClass("3" , R.drawable.icon6, "Request Payment");
        MenuParentModelClass settings = new MenuParentModelClass("4", R.drawable.icon7, "Settings");
        MenuParentModelClass logout = new MenuParentModelClass("5",R.drawable.icon_logout,"Logout");

        menuParentModelData.add(history_Transaction);
        menuParentModelData.add(send_Money);
        menuParentModelData.add(request_Payment);
        menuParentModelData.add(settings);
        menuParentModelData.add(logout);
    }
    List<MenuParentModelClass> menuParentModelData = new LinkedList<MenuParentModelClass>();

    public List<MenuParentModelClass> getAllData(){
        return menuParentModelData;
    }

    public MenuParentModelClass getMenuById(String menuId) {

        for (MenuParentModelClass s : menuParentModelData) {
            if (s.getId().equals(menuId)) {
                return s;
            }
        }
        return null;
    }
}
