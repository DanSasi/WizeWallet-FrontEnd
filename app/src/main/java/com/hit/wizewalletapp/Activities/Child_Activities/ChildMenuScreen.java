package com.hit.wizewalletapp.Activities.Child_Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hit.wizewalletapp.Activities.General_Activites.LoginActivity;
import com.hit.wizewalletapp.Activities.Parent_Folder.Fragments.SendMoneyScreen;
import com.hit.wizewalletapp.Adapters.Child_Adapters.ChildMenuAdapterClass;
import com.hit.wizewalletapp.Models.MenuModelClass;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;

public class ChildMenuScreen extends AppCompatActivity implements ChildMenuAdapterClass.ListViewHolder.RecycleViewClickListener {
    ChildMenuAdapterClass menuAdapterClass;
    ArrayList<MenuModelClass> menu_items;
    RecyclerView recyclerView;
    ImageView arr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_child_screen);

        recyclerView = findViewById(R.id.recyclerView);
        getData();
        setAdapter();

        arr = findViewById(R.id.arrow);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChildMenuScreen.this, ChildBalanceScreen.class);
                startActivity(intent);
            }
        });
    }

    private void setAdapter() {
        menuAdapterClass = new ChildMenuAdapterClass(ChildMenuScreen.this, menu_items,this::onClicklistener);
        recyclerView.setAdapter(menuAdapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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

            case 1:
                Intent intent = new Intent(ChildMenuScreen.this, SendMoneyScreen.class);
                startActivity(intent);
                break;


            case 3:
                Intent intent2 = new Intent(ChildMenuScreen.this, ChildTransactionHistoryActivity.class);
                startActivity(intent2);
                break;
                

            case 6:
                Intent intent4 = new Intent(ChildMenuScreen.this, LoginActivity.class);
                startActivity(intent4);
                break;
        }

        }

    }
