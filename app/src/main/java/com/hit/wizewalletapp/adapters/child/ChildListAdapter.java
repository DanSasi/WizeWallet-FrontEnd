package com.hit.wizewalletapp.adapters.child;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;

public class ChildListAdapter extends RecyclerView.Adapter<ChildListAdapter.MyViewHolder>{


    private final List<ChildModel> childList = new ArrayList<>();
    private OnItemClickListener listener;


    public void setOnItemClickListener(ChildListAdapter.OnItemClickListener listener){
        this.listener = listener;
    }

    public void updateList(List<ChildModel> listToAdd){
        childList.clear();
        childList.addAll(listToAdd);
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTxt;
        ImageView imageView,boyImage,girlImage;
        TextView balanceTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.spinner_gender_name_tv);
            balanceTv=itemView.findViewById(R.id.parent_request_balance_tv);
            boyImage = itemView.findViewById(R.id.boy_image_icon);
            girlImage = itemView.findViewById(R.id.girl_image_icon);
        }

    }

    public interface OnItemClickListener{
        void onItemClick(ChildModel childModel);
    }


    @NonNull
    @Override
    public ChildListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_childs,parent,false);
        return new ChildListAdapter.MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ChildListAdapter.MyViewHolder holder, int position) {
        final ChildModel childModel = childList.get(position);
        String gender = childModel.getImg_url();
        holder.nameTxt.setText("Name: "+childModel.getmName());
        holder.balanceTv.setText("Balance: "+String.valueOf(childModel.getBalance()));
        if(gender != null){
            if(gender.equals("Boy")){
                holder.girlImage.setVisibility(View.GONE);
            }else if(gender.equals("Girl"))
            {
                holder.boyImage.setVisibility(View.GONE);
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int photo = childList.get(position).getPhoto();
                listener.onItemClick(childModel);
                //holder.nameTxt.setText(name);
                //holder.photo.setImageResource(photo);
            }
        });



    }

    @Override
    public int getItemCount() {
        return childList.size();
    }


}
