package com.hit.wizewalletapp.Folders.Child_Folder.Fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hit.wizewalletapp.Adapters.Child_Adapters.ChildMenuAdapterClass;
import com.hit.wizewalletapp.Models.MenuModelClass;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;

public class ChildMenuFragment extends Fragment implements ChildMenuAdapterClass.ListViewHolder.RecycleViewClickListener {
    ChildMenuAdapterClass menuAdapterClass;
    ArrayList<MenuModelClass> menu_items;
    RecyclerView recyclerView;
    ImageView arr;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_child_screen, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        getData();
        setAdapter();

        arr = view.findViewById(R.id.arrow);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_childMenuFragment_to_childBalanceHomeFragment);
            }
        });
        return view;
    }

    private void setAdapter() {
        menuAdapterClass = new ChildMenuAdapterClass(getActivity(), menu_items,this::onClicklistener);
        recyclerView.setAdapter(menuAdapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    private void getData() {
        menu_items = new ArrayList<>();
//        menu_items.add(new MenuModelClass(1, R.drawable.icon, "Send Money"));
        menu_items.add(new MenuModelClass(3, R.drawable.icon5, "History Transaction"));
        menu_items.add(new MenuModelClass(4, R.drawable.icon6, "Request Payment"));
        menu_items.add(new MenuModelClass(5, R.drawable.icon7, "Settings"));
        menu_items.add(new MenuModelClass(6, R.drawable.icon_logout, "Logout"));
    }


    @Override
    public void onClicklistener(int position) {


        int id = menu_items.get(position).getId();

       switch (id) {
//
//            case 1:
//                Intent intent = new Intent(ChildMenuScreen.this, SendMoneyScreenFragment.class);
//                startActivity(intent);
//                break;
//
//
//            case 3:
//                Intent intent2 = new Intent(ChildMenuScreen.this, ChildTransactionHistoryActivity.class);
//                startActivity(intent2);
//                break;
//
//
//            case 6:
//                Intent intent4 = new Intent(ChildMenuScreen.this, LoginActivity.class);
//                startActivity(intent4);
//               break;
        }

        }

    }
