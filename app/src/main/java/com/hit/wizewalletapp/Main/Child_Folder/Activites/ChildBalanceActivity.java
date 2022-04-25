package com.hit.wizewalletapp.Main.Child_Folder.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;

import android.os.Bundle;

import com.hit.wizewalletapp.R;

public class ChildBalanceActivity extends AppCompatActivity{

    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_balance);
        NavHost navHostFragment =
                (NavHost) getSupportFragmentManager().findFragmentById(R.id.nav_host_child);
        navController = navHostFragment.getNavController();
    }


}