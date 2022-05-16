package com.hit.wizewalletapp.adapters.child;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.TaskChildModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;


public class ChildTaskListAdapter extends RecyclerView.Adapter<ChildTaskListAdapter.MyViewHolder> {
    private final List<TaskChildModel> list = new ArrayList<TaskChildModel>();
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(TaskChildModel childModel);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void updateTaskList(List<TaskChildModel> childTaskList) {
        list.clear();
        list.addAll(childTaskList);
        notifyDataSetChanged();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView amount_VH_Tv;
        TextView message_Vh_Tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amount_VH_Tv = itemView.findViewById(R.id.child_task_amount_kid_tv);
            message_Vh_Tv = itemView.findViewById(R.id.parent_task_task_tv);
        }

    }

    @NonNull
    @Override
    public ChildTaskListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new ChildTaskListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildTaskListAdapter.MyViewHolder holder, int position) {
        final TaskChildModel childModel = list.get(position);
        holder.message_Vh_Tv.setText(String.valueOf(childModel.getMessage()));
        // holder.amount_VH_Tv.setText(String.valueOf(childModel.getmAmount()));
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
        return list.size();
    }


}
