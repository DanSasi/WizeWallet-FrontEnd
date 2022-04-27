package com.hit.wizewalletapp.Main.Child_Folder.Fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.Main.Child_Folder.Models.ListModels.MenuChildListModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildMenuModel;
import com.hit.wizewalletapp.Main.General_Folder.GeneralActivites.RetrofitInterface;
import com.hit.wizewalletapp.Main.Parent_Folder.Fragments.ParentMenuScreenFragment;
import com.hit.wizewalletapp.Main.Parent_Folder.Fragments.ParentMenuScreenFragmentArgs;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.MenuParentListModel;
import com.hit.wizewalletapp.R;



import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.Adapters.Child_Adapters.ChildMenuAdapterClass;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.MenuParentModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChildMenuScreenFragment extends Fragment  {

    static List<ChildMenuModel> menu_items;
    RecyclerView recyclerView;
    ImageView arr;

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_child_screen, container, false);
        //get refreshToken
        String refreshToken = ChildMenuScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken();

        menu_items = MenuChildListModel.instance.getAllData();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //Retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyChildMenuAdapter myChildMenuAdapter = new MyChildMenuAdapter();
        recyclerView.setAdapter(myChildMenuAdapter);
        arr = view.findViewById(R.id.arrow);
        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Navigation.findNavController(v).navigate(R.id.action_parentMenuScreen_to_homeParentFragment);
            }
        });

        myChildMenuAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String id = menu_items.get(position).getId();
                switch (id){
                    case "1":
                        Navigation.findNavController(v).navigate(R.id.action_childMenuFragment_to_childTransactionHistoryFragment);
                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":
                        HashMap<String,String> map = new HashMap<>();
                        String tokenToSend = "authorization " + refreshToken;
                        map.put("authorization",tokenToSend);
                        Call<Void> call = retrofitInterface.executeLogout(map);

                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if (response.code() == 200){
                                    Log.d("TAG","logout user");
                                    Navigation.findNavController(v).navigate(ChildMenuScreenFragmentDirections.actionChildMenuFragmentToLoginFragmentHome());
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {

                            }
                        });
                        break;
                    case "6":


                        break;
                }

            }
        });


        return view;
    }

    @SuppressWarnings("deprecation")
    static class MyMenuChildViewHolder extends RecyclerView.ViewHolder {

        TextView menuTextItem;
        ImageView menuPothoItem;


        public MyMenuChildViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            menuPothoItem = itemView.findViewById(R.id.menu_parent_img);
            menuTextItem = itemView.findViewById(R.id.menu_parent_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(v, pos);
                }
            });

        }
    }

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

        static class MyChildMenuAdapter extends RecyclerView.Adapter<MyMenuChildViewHolder> {

        OnItemClickListener listener;

        public  void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }


        @NonNull

        @Override
        public MyMenuChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_menu_screen_child_list1,parent,false);
            MyMenuChildViewHolder holder = new MyMenuChildViewHolder(view,listener);
            return holder;
        }


        @Override
        public void onBindViewHolder(@NonNull MyMenuChildViewHolder holder, int position) {
            String name = menu_items.get(position).getItem_name();
            int photo = menu_items.get(position).getImg();
            holder.menuTextItem.setText(name);
            holder.menuPothoItem.setImageResource(photo);
        }

        @Override
        public int getItemCount() {
            return menu_items.size();
        }


    }



}
