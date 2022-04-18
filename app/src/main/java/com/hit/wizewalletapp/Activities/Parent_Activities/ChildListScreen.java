package com.hit.wizewalletapp.Activities.Parent_Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.hit.wizewalletapp.Activities.Child_Activities.ChildBalanceScreen;
import com.hit.wizewalletapp.Adapters.Parent_Adapters.ChildListAdapter;
import com.hit.wizewalletapp.Adapters.Parent_Adapters.ChildsModel;
import com.hit.wizewalletapp.Fragments.AddChildFragment;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;

public class ChildListScreen extends AppCompatActivity implements ChildListAdapter.RecyclerViewClickListener{

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_list_screen);

        addChildBtn = findViewById(R.id.add_child_Btn);
        //backArrow
        backArrow = findViewById(R.id.img_back_arrow_contact);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChildListScreen.this, ParentBalanceScreen.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.contact_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        newUserArrayList = new ArrayList<ChildsModel>();

        contactListAdapter = new ChildListAdapter(this,newUserArrayList,this::onClick);
        recyclerView.setAdapter(contactListAdapter);

        addChildBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildListScreen.this , AddChildFragment.class);
                startActivity(intent);
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
        Intent intent = new Intent(ChildListScreen.this, SendMoneyScreen.class);
        startActivity(intent);
    }
}