package com.hit.wizewalletapp.Activities.Parent_Folder.Fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;


import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.hit.wizewalletapp.Activities.General_Activites.PaymentSplashScreen;
import com.hit.wizewalletapp.Adapters.Parent_Adapters.ChildMembersAdapter;
import com.hit.wizewalletapp.Data.ChildsData.Data;
import com.hit.wizewalletapp.R;


public class SendMoneyScreen extends Fragment {


    private Spinner spinner_members;
//    ArrayList<Contacts> newUserArrayList;


    ImageView arr;

    private ChildMembersAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_send_money_screen, container, false);


//        String name = getIntent().getExtras().getString("arraylist","no");


        spinner_members = view.findViewById(R.id.spinner_mambers);
        adapter = new ChildMembersAdapter(getActivity(), Data.getMembersList());
        spinner_members.setAdapter(adapter);


        SwipeButton swipeButton = view.findViewById(R.id.swipeId);
//
        String item = spinner_members.getSelectedItem().toString();


        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                startActivity(new Intent(getActivity(), PaymentSplashScreen.class ));
            }
        });


        arr = view.findViewById(R.id.IV01);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_sendMoneyScreen_to_childListScreen);
            }
        });

        return view;
    }


}