package com.hit.wizewalletapp.adapters.child;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hit.wizewalletapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTransactionModel;

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
        TextView amount_tv,desc_tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            amount_tv= itemView.findViewById(R.id.child_task_amount_kid_tv);
            desc_tv=itemView.findViewById(R.id.parent_task_task_tv);
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
        holder.desc_tv.setText(String.valueOf(childTransactionModel.getDesc()));
        holder.amount_tv.setText(String.valueOf(childTransactionModel.getAmount()));
        holder.itemView.setOnClickListener(v -> listener.onItemClick(childTransactionModel));

    }

    @Override
    public int getItemCount() { return list.size();
    }





}
