package com.hit.wizewalletapp.adapters.child;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hit.wizewalletapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.model.child.ChildTransactionModel;

import java.util.ArrayList;
import java.util.List;

public class ChildTransListAdapter extends RecyclerView.Adapter<ChildTransListAdapter.MyViewHolder>{
    private final List<ChildTransactionModel> list=new ArrayList<>();

    private OnItemClickListener listener;


    public interface OnItemClickListener{
        void onItemClick(ChildTransactionModel childModel);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }

    public void updateTransList(List<ChildTransactionModel> childTransList){
        list.clear();
        list.addAll(childTransList);
        notifyDataSetChanged();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView amount_tv,desc_tv,date_tv;
        ImageView up_arrow,down_arrow,spinner_parent_item,spinner_photo_item;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            amount_tv= itemView.findViewById(R.id.parent_request_amount_tv);
            desc_tv=itemView.findViewById(R.id.spinner_gender_name_tv);
            date_tv=itemView.findViewById(R.id.parent_request_date_tv);
            up_arrow = itemView.findViewById(R.id.up_arrow);
            down_arrow = itemView.findViewById(R.id.down_arrow);
            spinner_parent_item = itemView.findViewById(R.id.spinner_parent_item);
            spinner_photo_item = itemView.findViewById(R.id.spinner_gender_image);

        }

    }

    @NonNull
    @Override
    public ChildTransListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trans,parent,false);
        return new ChildTransListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ChildTransactionModel childTransactionModel=list.get(position);
        String date = childTransactionModel.getDate();
        holder.desc_tv.setText(String.valueOf(childTransactionModel.getDesc()));
        holder.amount_tv.setText(String.valueOf(childTransactionModel.getAmount()));
        if(date != null){
            holder.date_tv.setText(String.valueOf(childTransactionModel.getDate()));
            holder.down_arrow.setVisibility(View.VISIBLE);
            holder.spinner_photo_item.setVisibility(View.VISIBLE);
            holder.spinner_parent_item.setVisibility(View.GONE);

        }
        else {
            holder.date_tv.setVisibility(View.GONE);
            holder.spinner_parent_item.setVisibility(View.VISIBLE);
            holder.up_arrow.setVisibility(View.VISIBLE);
            holder.spinner_photo_item.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(v -> listener.onItemClick(childTransactionModel));

    }

    @Override
    public int getItemCount() { return list.size();
    }





}
