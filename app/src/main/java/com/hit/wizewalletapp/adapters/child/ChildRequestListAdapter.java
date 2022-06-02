package com.hit.wizewalletapp.adapters.child;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.model.child.ChildRequestModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;

public class ChildRequestListAdapter extends RecyclerView.Adapter<ChildRequestListAdapter.MyViewHolder> {
    private final List<ChildRequestModel> list = new ArrayList<ChildRequestModel>();
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(ChildRequestModel childModel);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void updateRequestList(List<ChildRequestModel> childRequestList) {
        list.clear();
        list.addAll(childRequestList);
        notifyDataSetChanged();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView amount_VH_Tv;
        TextView message_Vh_Tv;
        Button cancel_Vh_Btn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amount_VH_Tv = itemView.findViewById(R.id.parent_request_amount_tv);
            message_Vh_Tv = itemView.findViewById(R.id.spinner_gender_name_tv);
        }
    }
    @NonNull
    @Override
    public ChildRequestListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_request, parent, false);
        return new ChildRequestListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildRequestListAdapter.MyViewHolder holder, int position) {
        final ChildRequestModel childModel = list.get(position);
        holder.message_Vh_Tv.setText(String.valueOf(childModel.getmMessage()));
        holder.amount_VH_Tv.setText(String.valueOf(childModel.getmAmount()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onItemClick(childModel);
                }
            }
        });


    }

    private void onRejectRequst() {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}