package com.hit.wizewalletapp.Activities.Parent_Folder.Fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.hit.wizewalletapp.Adapters.Parent_Adapters.ChildListAdapter;
import com.hit.wizewalletapp.Adapters.Parent_Adapters.ChildsModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;

public class ChildListScreen extends Fragment implements ChildListAdapter.RecyclerViewClickListener{

    RecyclerView recyclerView;
    ArrayList<ChildsModel> newUserArrayList;
    Button addChildBtn ;
    ChildListAdapter contactListAdapter;
    String[] childName;
    String[] accNo;
    int[] childImg;
    private ChildListAdapter.RecyclerViewClickListener listener;
    ImageButton backArrow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_child_list_screen, container, false);

        //backArrow
        backArrow = view.findViewById(R.id.img_back_arrow_contact);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Navigation.findNavController(view).navigate(R.id.action_childListScreen_to_homeParentFragment);
            }
        });

        recyclerView = view.findViewById(R.id.contact_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        newUserArrayList = new ArrayList<ChildsModel>();

        contactListAdapter = new ChildListAdapter(getContext(),newUserArrayList,this::onClick);
        recyclerView.setAdapter(contactListAdapter);

        addChildBtn = view.findViewById(R.id.add_child_Btn);
        addChildBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(v).navigate(R.id.action_childListScreen_to_addChildFragment);
            }
        });

        childName = new String[]{
                "Dan",
                "Michael",
                "Yarden",
                "Ben",
                "Alon",
                "Maor",

        };

        accNo = new String[]{
                "Bank - 1",
                "Bank - 2",
                "Bank - 3",
                "Bank - 4",
                "Bank - 5",
                "Bank - 6",

        };

        childImg = new int[]{
                R.drawable.imageprofile,
                R.drawable.imageprofile,
                R.drawable.imageprofile,
                R.drawable.imageprofile,
                R.drawable.imageprofile,
                R.drawable.imageprofile,
        };

        getData();
        return view;
    }

    private void getData() {
        for(int i=0; i<childName.length; i++){
            ChildsModel contacts = new ChildsModel(childName[i],accNo[i],childImg[i]);
            newUserArrayList.add(contacts);
        }

        contactListAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getActivity(), SendMoneyScreen.class);
        startActivity(intent);
    }
}