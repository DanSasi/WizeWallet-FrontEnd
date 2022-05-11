package com.hit.wizewalletapp.adapters.child;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTaskModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;


    public class ChildTaskListAdapter extends RecyclerView.Adapter<ChildTaskListAdapter.MyViewHolder>{


        private final List<ChildTaskModel> childList = new ArrayList<>();
        private OnItemClickListener listener;


        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

        public void updateList(List<ChildTaskModel> listToAdd){
            childList.clear();
            childList.addAll(listToAdd);
            notifyDataSetChanged();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
            TextView kidId_VH_Tv;
            TextView amount_VH_Tv;
            TextView message_Vh_Tv;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                kidId_VH_Tv = itemView.findViewById(R.id.parent_task_kidid_tv);
                amount_VH_Tv = itemView.findViewById(R.id.parent_task_messageTv);
                message_Vh_Tv = itemView.findViewById(R.id.parent_task_amout_tv);
            }

        }

        public interface OnItemClickListener{
            void onItemClick(ChildTaskModel childModel);
        }


        @NonNull
        @Override
        public ChildTaskListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
            return new ChildTaskListAdapter.MyViewHolder(view);
        }



        @Override
        public void onBindViewHolder(@NonNull ChildTaskListAdapter.MyViewHolder holder, int position) {
            final ChildTaskModel childModel = childList.get(position);
            holder.kidId_VH_Tv.setText(String.valueOf(childModel.getmId()));
            holder.message_Vh_Tv.setText(String.valueOf(childModel.getMessage()));
            holder.amount_VH_Tv.setText(String.valueOf(childModel.getmAmount()));
            //holder.nameTxt.setText(String.valueOf(childModel.getmId()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(childModel);
                }
            });

        }

        @Override
        public int getItemCount() {
            return childList.size();
        }


}
