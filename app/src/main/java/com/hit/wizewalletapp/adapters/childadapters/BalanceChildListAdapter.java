package com.hit.wizewalletapp.adapters.childadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.model.TransactionModel;
import com.hit.wizewalletapp.R;

import java.util.List;

public class BalanceChildListAdapter extends RecyclerView.Adapter<BalanceChildListAdapter.BalanceViewHolder>{
    Context context;
    List<TransactionModel> bData;
    private BalanceViewHolder.RecycleViewClickListener clickListener;

    public BalanceChildListAdapter(Context context, List<TransactionModel> bData) {
        this.context = context;
        this.bData = bData;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public BalanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.balancelist_layout, parent, false);
        return new BalanceViewHolder(layout,context,bData,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BalanceViewHolder holder, int position) {

        String topic = bData.get(position).getTopic().toString();
        String cost= bData.get(position).getCost().toString();
        String description = bData.get(position).getDescription().toString();


        holder.tv_topic.setText(topic);
        holder.tv_cost.setText(cost);
        holder.tv_description.setText(description);
    }

    @Override
    public int getItemCount() {
        return bData.size();
    }

    public static class BalanceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_topic, tv_cost, tv_description;
        ImageView img_photo;
        RecycleViewClickListener recycleViewClickListener;

        public BalanceViewHolder(@NonNull View itemView, Context context, List<TransactionModel> bData, RecycleViewClickListener recycleViewClickListener) {
            super(itemView);
            tv_topic = itemView.findViewById(R.id.textTopic);
            tv_cost = itemView.findViewById(R.id.textDate);
            tv_description = itemView.findViewById(R.id.textDescription);
            img_photo = itemView.findViewById(R.id.balanceImage);
            this.recycleViewClickListener = recycleViewClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recycleViewClickListener.recycleViewClick(getAdapterPosition());
        }
        public interface RecycleViewClickListener{
            void recycleViewClick(int position);
        }
    }
}
