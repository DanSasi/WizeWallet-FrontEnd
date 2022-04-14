package com.hit.wizewalletapp.Adapters.Parent_Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.hit.wizewalletapp.Data.ChildsData.childs;
import com.hit.wizewalletapp.R;

import java.util.List;

public class ChildMembersAdapter extends BaseAdapter {



    private Context context;
    private List<childs> MembersList;

    public ChildMembersAdapter(Context context, List<childs> MembersList) {
        this.context = context;
        this.MembersList = MembersList;
    }

    @Override
    public int getCount() {
        return MembersList != null ? MembersList.size() : 0;
    }

    @Override
    public Object getItem(int i) {

        return MembersList.get(i).getName();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_members, viewGroup, false);


        TextView txtName = rootView.findViewById(R.id.user_name_tv);
        ImageView image = rootView.findViewById(R.id.image);
        TextView txtBank = rootView.findViewById(R.id.Bank);


        txtName.setText(MembersList.get(i).getName());
        image.setImageResource(MembersList.get(i).getImage());
        txtBank.setText(MembersList.get(i).getBank());

        return rootView;
    }
}
