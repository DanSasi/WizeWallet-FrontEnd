package com.hit.digitalwallethitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BalanceListAdapter extends RecyclerView.Adapter<BalanceListAdapter.BalanceViewHolder>{
    Context context;
    List<BalanceModel> bData;
    private BalanceViewHolder.RecycleViewClickListener clickListener;

    public BalanceListAdapter(Context context, List<BalanceModel> bData) {
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
        int photo = bData.get(position).getPhoto();
        String topic = bData.get(position).getTopic().toString();
        String date = bData.get(position).getDate().toString();
        String balance = bData.get(position).getBalance().toString();
        String description = bData.get(position).getDescription().toString();

        holder.img_photo.setImageResource(photo);
        holder.tv_topic.setText(topic);
        holder.tv_date.setText(date);
        holder.tv_balance.setText(balance);
        holder.tv_description.setText(description);
    }

    @Override
    public int getItemCount() {
        return bData.size();
    }

    public static class BalanceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_topic, tv_date, tv_balance, tv_description;
        ImageView img_photo;
        RecycleViewClickListener recycleViewClickListener;

        public BalanceViewHolder(@NonNull View itemView,Context context,List<BalanceModel> bData, RecycleViewClickListener recycleViewClickListener) {
            super(itemView);
            tv_topic = itemView.findViewById(R.id.textTopic);
            tv_date = itemView.findViewById(R.id.textDate);
            tv_balance = itemView.findViewById(R.id.textBalance);
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
