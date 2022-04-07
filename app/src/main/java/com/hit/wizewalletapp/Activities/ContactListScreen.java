package com.hit.wizewalletapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.hit.wizewalletapp.Adapters.ContactListAdapter;
import com.hit.wizewalletapp.Adapters.Contacts;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;

public class ContactListScreen extends AppCompatActivity implements ContactListAdapter.RecyclerViewClickListener{

    RecyclerView recyclerView;
    ArrayList<Contacts> newUserArrayList;
    ContactListAdapter contactListAdapter;
    String[] userName;
    String[] accNo;
    int[] userImg;
    private ContactListAdapter.RecyclerViewClickListener listener;
    ImageButton backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list_screen);

        //backArrow
        backArrow = findViewById(R.id.img_back_arrow_contact);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactListScreen.this, BalanceScreen.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.contact_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        newUserArrayList = new ArrayList<Contacts>();

        contactListAdapter = new ContactListAdapter(this,newUserArrayList,this::onClick);
        recyclerView.setAdapter(contactListAdapter);

        userName = new String[]{
                "Dan",
                "Michael",
                "Yarden",
                "Ben",
                "Alon",
                "Maor",

        };

        accNo = new String[]{
                "Bank - 1234",
                "Bank - 1234",
                "Bank - 1234",
                "Bank - 1234",
                "Bank - 1234",
                "Bank - 1234",

        };

        userImg = new int[]{
                R.drawable.imageprofile,
                R.drawable.imageprofile,
                R.drawable.imageprofile,
                R.drawable.imageprofile,
                R.drawable.imageprofile,
                R.drawable.imageprofile,
        };

        getData();
    }

    private void getData() {
        for(int i=0; i<userName.length; i++){
            Contacts contacts = new Contacts(userName[i],accNo[i],userImg[i]);
            newUserArrayList.add(contacts);
        }

        contactListAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(int position) {
        Intent intent = new Intent(ContactListScreen.this, SendMoneyScreen.class);
        startActivity(intent);
    }
}