package com.hit.wizewalletapp.Adapters.General_Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.Data.UsersMembersData.UserData;
import com.hit.wizewalletapp.Data.UsersMembersData.UserMembers;
import com.hit.wizewalletapp.R;

import java.util.List;

public class UserMembersAdapter extends BaseAdapter {

    private Context context;
    private List<UserMembers> UserMemberList;
    private TextView txtName;
    private ImageView image;

    public UserMembersAdapter(Context context, List<UserMembers> MembersList) {
        this.context = context;
        this.UserMemberList = MembersList;
    }

    @Override
    public int getCount() {
        return UserMemberList != null ? UserMemberList.size() : 0;
    }



    @Override
    public Object getItem(int i) {
        return UserMemberList.get(i).getName();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_user_members, viewGroup, false);

         txtName = rootView.findViewById(R.id.user_name_tv);
         image = rootView.findViewById(R.id.image);


        txtName.setText(UserMemberList.get(i).getName());
        image.setImageResource(UserMemberList.get(i).getImage());
        return rootView;
    }
}
