package com.hit.wizewalletapp.adapters.child;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
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
        ImageView photo;
        TextView bankTxt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.parent_trns_kidid_tv);
            photo = itemView.findViewById(R.id.spinner_photo_item);

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
        holder.nameTxt.setText(String.valueOf(childModel.getmId()));
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
