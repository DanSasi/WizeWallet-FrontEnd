package com.hit.digitalwallethitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyViewHolder> {

    Context context;
    ArrayList<Contacts> newUserArrayList;
    private  RecyclerViewClickListener clicklistener;

    public ContactListAdapter(Context context, ArrayList<Contacts> newUserArrayList, RecyclerViewClickListener listener) {
        this.context = context;
        this.newUserArrayList = newUserArrayList;
        this.clicklistener =listener;
    }


    @NonNull
    @Override
    public ContactListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.contact_list_item, parent, false);

        return new MyViewHolder(v,clicklistener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListAdapter.MyViewHolder holder, int position) {

        Contacts contactList = newUserArrayList.get(position);
        holder.img_user.setImageResource(contactList.userImage);
        holder.tv_user_name.setText(contactList.userName);
        holder.tv_acc_no.setText(contactList.accNo);


    }

    @Override
    public int getItemCount() {
        return newUserArrayList.size();
    }

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
