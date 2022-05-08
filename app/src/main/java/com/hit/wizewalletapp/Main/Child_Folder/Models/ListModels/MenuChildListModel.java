package com.hit.wizewalletapp.Main.Child_Folder.Models.ListModels;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildMenuModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.MenuParentListModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.MenuParentModel;
import com.hit.wizewalletapp.R;

import java.util.LinkedList;
import java.util.List;

public class MenuChildListModel {
    public static final MenuChildListModel instance = new MenuChildListModel();

    MenuChildListModel(){
        ChildMenuModel history_Transaction = new ChildMenuModel("1", R.drawable.icon5, "History Transaction");
        ChildMenuModel request_Payment = new ChildMenuModel("2" , R.drawable.icon6, "Request Payment");
        ChildMenuModel settings = new ChildMenuModel("4", R.drawable.icon7, "Settings");
        ChildMenuModel logout = new ChildMenuModel("5",R.drawable.icon_logout,"Logout");

        menuChildListModels.add(history_Transaction);
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
