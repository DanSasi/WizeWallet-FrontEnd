package com.hit.wizewalletapp.adapters.Child_Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.MenuParentModel;
import com.hit.wizewalletapp.R;

import java.util.List;

public class ChildMenuAdapterClass extends RecyclerView.Adapter<ChildMenuAdapterClass.ListViewHolder>{

    Context context;
    List<MenuParentModel> menu_items;
    private ListViewHolder.RecycleViewClickListener clickListener;

    public ChildMenuAdapterClass(Context context, List<MenuParentModel> menu_items, ChildMenuAdapterClass.ListViewHolder.RecycleViewClickListener listener) {
        this.context = context;
        this.menu_items = menu_items;
        this.clickListener = listener;
    }


//    public MenuAdapterClass(Context context, List<MenuModelClass> menu_items) {
//        this.context = context;
//        this.menu_items = menu_items;
//    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.fragment_menu_screen_child_list1,parent,false);
        return new ListViewHolder(layout,context,menu_items,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
    String items = menu_items.get(position).getItem_name();
    int image = menu_items.get(position).getImg();
//    int image1 = menu_items.get(position).getImg1();

    holder.menu_item.setText(items);
    holder.icon.setImageResource(image);
//    holder.arrow.setImageResource(image1);
    }

    @Override
    public int getItemCount() {
        return menu_items.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView menu_item;
        ImageView icon;
//        ImageView arrow;
        ChildMenuAdapterClass.ListViewHolder.RecycleViewClickListener recycleViewClickListener;

        public ListViewHolder(@NonNull View itemView, Context context, List<MenuParentModel> menu_items, RecycleViewClickListener clickListener) {
            super(itemView);
            menu_item = itemView.findViewById(R.id.menu_parent_text);
            icon = itemView.findViewById(R.id.menu_parent_img);
//            arrow = itemView.findViewById(R.id.img1);
            this.recycleViewClickListener = clickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recycleViewClickListener.onClicklistener(getAdapterPosition());
        }

        public interface RecycleViewClickListener{
            void onClicklistener(int position);
        }
    }
}
