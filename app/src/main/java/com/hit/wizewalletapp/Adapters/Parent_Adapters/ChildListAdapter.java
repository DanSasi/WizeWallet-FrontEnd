package com.hit.wizewalletapp.Adapters.Parent_Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;

public class ChildListAdapter extends RecyclerView.Adapter<ChildListAdapter.MyViewHolder> {

    Context context;
    ArrayList<ChildsModel> newUserArrayList;
    private  RecyclerViewClickListener clicklistener;

    public ChildListAdapter(Context context, ArrayList<ChildsModel> newUserArrayList, RecyclerViewClickListener listener) {
        this.context = context;
        this.newUserArrayList = newUserArrayList;
        this.clicklistener =listener;
    }


    @NonNull
    @Override
    public ChildListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.child_list_item, parent, false);

        return new MyViewHolder(v,clicklistener);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildListAdapter.MyViewHolder holder, int position) {

        ChildsModel contactList = newUserArrayList.get(position);
        holder.img_user.setImageResource(contactList.childImage);
        holder.tv_user_name.setText(contactList.childName);
        holder.tv_acc_no.setText(contactList.accNo);


    }

    @Override
    public int getItemCount() {
        return newUserArrayList.size();
    }

    @SuppressWarnings("deprecation")
    public  static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_user_name;
        TextView tv_acc_no;
        ShapeableImageView img_user;
        RecyclerViewClickListener recyclerViewClickListener;

        public MyViewHolder(@NonNull View itemView,RecyclerViewClickListener onClickListener) {
            super(itemView);
            tv_user_name = itemView.findViewById(R.id.tv_user_name);
            tv_acc_no = itemView.findViewById(R.id.tv_acc_no);
            img_user = itemView.findViewById(R.id.img_user);
            this.recyclerViewClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recyclerViewClickListener.onClick(getAdapterPosition());
        }


    }
    public interface RecyclerViewClickListener{
        void onClick(int position);
    }
}
