package com.hit.wizewalletapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.hit.wizewalletapp.Adapters.MenuAdapterClass;
import com.hit.wizewalletapp.Models.MenuModelClass;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuScreen extends AppCompatActivity implements MenuAdapterClass.ListViewHolder.RecycleViewClickListener {
    MenuAdapterClass menuAdapterClass;
    ArrayList<MenuModelClass> menu_items;
    RecyclerView recyclerView;
    ImageView arr;

    //Retrofit, the URL is the phone emulator + server port
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);




        //Retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        recyclerView = findViewById(R.id.recyclerView);
        getData();
        setAdapter();

        arr = findViewById(R.id.arrow);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuScreen.this, BalanceScreen.class);
                startActivity(intent);
            }
        });
    }

    private void setAdapter() {
        menuAdapterClass = new MenuAdapterClass(MenuScreen.this, menu_items, this::onClicklistener);
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
                Intent intent = new Intent(MenuScreen.this, SendMoneyScreen.class);
                startActivity(intent);
                break;


            case 3:
                Intent intent2 = new Intent(MenuScreen.this, TransactionHistoryActivity.class);
                startActivity(intent2);
                break;


            case 6:
                //get the refresh token send it with key put in map
                //map is like json
                HashMap<String,String>map = new HashMap<>();
                String refreshToken = getIntent().getStringExtra("refresh");
                String tokenToSend = "authorization " + refreshToken;
                map.put("authorization",tokenToSend);
                Call<Void> call = retrofitInterface.executeLogout(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.code() == 200){
                            Log.d("TAG","logout user");
                            Intent intent4 = new Intent(MenuScreen.this, LoginActivity.class);
                            startActivity(intent4);
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });


                break;
        }

    }

}
