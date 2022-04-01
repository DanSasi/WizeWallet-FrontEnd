package com.hit.digitalwallethitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.hit.digitalwallethitapp.ContactMembers.members;

import java.util.List;

public class MembersAdapter extends BaseAdapter {



    private Context context;
    private List<members> MembersList;

    public MembersAdapter(Context context, List<members> MembersList) {
        this.context = context;
        this.MembersList = MembersList;
    }

    @Override
    public int getCount() {
        return MembersList != null ? MembersList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_members, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.name);
        ImageView image = rootView.findViewById(R.id.image);
        TextView txtBank = rootView.findViewById(R.id.Bank);


        txtName.setText(MembersList.get(i).getName());
        image.setImageResource(MembersList.get(i).getImage());
        txtBank.setText(MembersList.get(i).getBank());

        return rootView;
    }
}
