package com.hit.wizewalletapp.Activities.Parent_Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;


import com.ebanx.swipebtn.SwipeButton;
import com.hit.wizewalletapp.Adapters.Parent_Adapters.ChildMembersAdapter;
import com.hit.wizewalletapp.Data.ChildsData.Data;
import com.hit.wizewalletapp.Models.CustomSpinner;
import com.hit.wizewalletapp.R;


public class SendMoneyScreen extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener {


    private Spinner spinner_members;
//    ArrayList<Contacts> newUserArrayList;


    ImageView arr;

    private ChildMembersAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money_screen);


//        String name = getIntent().getExtras().getString("arraylist","no");


        spinner_members = findViewById(R.id.spinner_mambers);
        adapter = new ChildMembersAdapter(SendMoneyScreen.this, Data.getMembersList());
        spinner_members.setAdapter(adapter);


        SwipeButton swipeButton =findViewById(R.id.swipeId);
//
        String item = spinner_members.getSelectedItem().toString();


        arr = findViewById(R.id.IV01);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoneyScreen.this, ChildListScreen.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onPopupWindowOpened(Spinner spinner) {

     spinner_members.setBackground(getResources().getDrawable(R.drawable.bg_spinner_members_up));
    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {

     spinner_members.setBackground(getResources().getDrawable(R.drawable.bg_spinner_members));
    }
}