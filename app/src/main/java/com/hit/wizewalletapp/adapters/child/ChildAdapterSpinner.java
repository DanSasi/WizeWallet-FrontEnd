package com.hit.wizewalletapp.adapters.child;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;

public class ChildAdapterSpinner extends BaseAdapter {

    private final List<ChildModel> childList = new ArrayList<>();
    private Context mContext;

    public ChildAdapterSpinner(Context context) {
        mContext = context;
    }


    @Override
    public int getCount() {
        return childList.size();
    }

    @Override
    public Object getItem(int i) {
       return childList.get(i).get_id();
    }







    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_childs, viewGroup, false);
        TextView balanceTxt=rootView.findViewById(R.id.parent_request_balance_tv);
        TextView nameTxt = rootView.findViewById(R.id.spinner_gender_name_tv);

        ImageView boyImage = rootView.findViewById(R.id.boy_image_icon);
        ImageView girlImage = rootView.findViewById(R.id.girl_image_icon);
        String gender = childList.get(i).getImg_url();
        if(gender!= null){
            if(gender.equals("Boy")){
                girlImage.setVisibility(View.GONE);
            }else if(gender.equals("Girl")){
                boyImage.setVisibility(View.GONE);
            }
        }
        nameTxt.setText("Name: "+ childList.get(i).getmName());
        balanceTxt.setText("Balance: "+String.valueOf(childList.get(i).getBalance()));


//        photo = rootView.findViewById(R.id.spinner_photo_item);
//        nameTxt.setText(childList.get(i).getName());
//        photo.setImageResource(childList.get(i).getPhoto());


        return rootView;
    }

    public void updateList(List<ChildModel> response) {
        childList.clear();
        childList.addAll(response);
        notifyDataSetChanged();
    }
}
