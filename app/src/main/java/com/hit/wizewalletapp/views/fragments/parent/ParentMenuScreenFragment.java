package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.api.RetrofitInterface;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.MenuParentListModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.MenuParentModel;
import com.hit.wizewalletapp.R;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("ALL")
public class ParentMenuScreenFragment extends Fragment {
    static List<MenuParentModel> menu_items;
    RecyclerView recyclerView;
    ImageView arr;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_parent_screen, container, false);
        //how to get data from fragment in the nav grahf, need to add the args in the nev grahf first

        menu_items = MenuParentListModel.instance.getAllData();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyMenuAdapter myMenuAdapter = new MyMenuAdapter();
        recyclerView.setAdapter(myMenuAdapter);
        arr = view.findViewById(R.id.arrow);
        arr.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());

        myMenuAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String id = menu_items.get(position).getId();
                switch (id){
                    case "1":
                   //    Navigation.findNavController(v).navigate(R.id.action_parentMenuScreen_to_childTransactionHistoryScreenFragment);
                        break;
                    case "2":
                        Navigation.findNavController(requireActivity(),R.id.nav_host).navigate(ParentMenuScreenFragmentDirections.actionParentMenuScreenToSendMoneyScreen());
                        break;
                    case "3":
                        Navigation.findNavController(requireActivity(),R.id.nav_host).navigate(ParentMenuScreenFragmentDirections.actionParentMenuScreenToParentMoneyRequests());

                        break;
                    case "4":
                        Navigation.findNavController(requireActivity(),R.id.nav_host).navigate(ParentMenuScreenFragmentDirections.actionParentMenuScreenToParentSettingsFragmentScreen());
                        break;
                    case "5":
                        Navigation.findNavController(requireActivity(),R.id.nav_host).navigate(ParentMenuScreenFragmentDirections.actionParentMenuScreenToChildLinkFragmentScreen());

                        break;
                    case "6":
                        String tokenToSend = "authorization " +  ParentMenuScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken();
                        ApiCallsHelper.performLogout(tokenToSend, new CustomCallBack<Void>() {
                            @Override
                            public void onSuccesses(Void response) {
                                Navigation.findNavController(requireActivity(), R.id.nav_host).navigate(ParentMenuScreenFragmentDirections.actionParentMenuScreenToLoginFragmentHome());
                            }
                            @Override
                            public void onFailure(String msg) {

                            }
                        });
                        break;
                }

            }
        });


        return view;
    }

    static class MyParentMenuViewHolder extends RecyclerView.ViewHolder {

        TextView menuTextItem;
        ImageView menuPothoItem;


        public MyParentMenuViewHolder(@NonNull View itemView, OnItemClickListener listener) {
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

    static class MyMenuAdapter extends RecyclerView.Adapter<MyParentMenuViewHolder> {

        OnItemClickListener listener;

        public void setOnItemClickListener( OnItemClickListener listener) {
            this.listener = listener;
        }


        @NonNull
        @Override
        public MyParentMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_menu_screen_parent_list1,parent,false);
            MyParentMenuViewHolder holder = new MyParentMenuViewHolder(view,listener);
            return holder;
        }


        @Override
        public void onBindViewHolder(@NonNull MyParentMenuViewHolder holder, int position) {
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












