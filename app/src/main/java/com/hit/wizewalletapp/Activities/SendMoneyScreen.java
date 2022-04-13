package com.hit.wizewalletapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;


import com.ebanx.swipebtn.SwipeButton;
import com.hit.wizewalletapp.Adapters.MembersAdapter;
import com.hit.wizewalletapp.Data.ContactsData.Data;
import com.hit.wizewalletapp.Models.CustomSpinner;
import com.hit.wizewalletapp.R;


public class SendMoneyScreen extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener {


    private CustomSpinner spinner_members;
//    ArrayList<Contacts> newUserArrayList;


    ImageView arr;

    private MembersAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money_screen);

        String refreshToken = getIntent().getStringExtra("refresh");

//        String name = getIntent().getExtras().getString("arraylist","no");


        spinner_members = findViewById(R.id.spinner_mambers);
        spinner_members.setSpinnerEventsListener(this);
        adapter = new MembersAdapter(SendMoneyScreen.this, Data.getMembersList());
        spinner_members.setAdapter(adapter);


        SwipeButton swipeButton =findViewById(R.id.swipeId);
//
//        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
//            @Override
//            public void onStateChange(boolean active) {
//                startActivity(new Intent(SendMoneyScreen.this, PaymentSummaryScreen.class ));
//            }
//        });

        arr = findViewById(R.id.IV01);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoneyScreen.this, ContactListScreen.class);
                intent.putExtra("refresh",refreshToken);
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