package com.hit.wizewalletapp.Data.UsersMembersData;

import com.hit.wizewalletapp.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserData implements Serializable {
 public static List<UserMembers> getUsersDataList() {

  List<UserMembers> usersMembersList = new ArrayList<>();
     UserMembers Admin = new UserMembers();
     Admin.setName("Parent");
     Admin.setImage(R.drawable.facetherface);
     usersMembersList.add(Admin);

     UserMembers User = new UserMembers();
     User.setName("Child");
     User.setImage(R.drawable.childface);
     usersMembersList.add(User);


     return usersMembersList;

 }

}
