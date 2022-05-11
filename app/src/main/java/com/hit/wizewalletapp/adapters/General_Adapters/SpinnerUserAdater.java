package com.hit.wizewalletapp.adapters.General_Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.Main.General_Folder.Models.SpinnerModel;

import com.hit.wizewalletapp.R;
import java.util.List;


public class SpinnerUserAdater extends BaseAdapter {

    private Context context;
    private List<SpinnerModel> spinnerModelList;

    public SpinnerUserAdater(Context context, List<SpinnerModel> spinnerModels){
        this.context = context;
        this.spinnerModelList = spinnerModels ;
    }
    @Override
    public int getCount() {
        return spinnerModelList != null ? spinnerModelList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return spinnerModelList.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.spinner_member_item, parent, false);

        TextView txtName = rootView.findViewById(R.id.parent_task_kidid_tv);
        ImageView image = rootView.findViewById(R.id.spinner_photo_item);

        txtName.setText(spinnerModelList.get(position).getName());
        image.setImageResource(spinnerModelList.get(position).getImage());
        return rootView;
    }
}
