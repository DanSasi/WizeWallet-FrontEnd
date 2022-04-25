package com.hit.wizewalletapp.Folders.Parent_Folder.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.Models.ParentModels.BalanceParentModel;
import com.hit.wizewalletapp.Models.ParentModels.ChildListModel;
import com.hit.wizewalletapp.Models.ParentModels.ChildModel;
import com.hit.wizewalletapp.R;

import java.util.List;

@SuppressWarnings("ALL")
public class ChildListScreenFragment extends Fragment {

    static List<ChildModel> childList;
    RecyclerView recyclerView;
    Button addChildBtn ;

    ImageButton backArrow;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_list_screen, container, false);
        childList = ChildListModel.instance.getAllData();
        recyclerView = view.findViewById(R.id.child_recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyChildAdapter adapter = new MyChildAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String childId =childList.get(position).getId();
                Navigation.findNavController(v).navigate(ChildListScreenFragmentDirections.actionChildListScreenToChildDetailsScreenFragment(childId));
            }
        });
        //backArrow
        backArrow = view.findViewById(R.id.img_back_arrow_contact);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Navigation.findNavController(view).navigate(R.id.action_childListScreen_to_homeParentFragment);
            }
        });


        addChildBtn = view.findViewById(R.id.add_child_Btn);
        addChildBtn.setOnClickListener(Navigation.createNavigateOnClickListener(ChildListScreenFragmentDirections.actionChildListScreenToAddChildFragment()));

        return view;

    }



    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTxt;
        ImageView photo;
        TextView bankTxt;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.child_name_item);
            photo = itemView.findViewById(R.id.child_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(v,pos);
                }
            });

        }
    }

    interface OnItemClickListener{
        void onItemClick(View v,int position);
    }

    static class MyChildAdapter extends RecyclerView.Adapter<MyViewHolder>{

        OnItemClickListener listener;
        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_childs,parent,false);
            MyViewHolder holder = new MyViewHolder(view,listener);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            String name = childList.get(position).getName();
            int photo = childList.get(position).getPhoto();
            holder.nameTxt.setText(name);
            holder.photo.setImageResource(photo);
        }

        @Override
        public int getItemCount() {
            return childList.size();
        }
    }





}



