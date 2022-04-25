package com.hit.wizewalletapp.Main.Parent_Folder.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;

import android.os.Bundle;

import com.hit.wizewalletapp.R;

public class ParentBalanceActivity extends AppCompatActivity {
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_balance);
        NavHost navHostFragment =
                (NavHost) getSupportFragmentManager().findFragmentById(R.id.nav_host_parent);
        navController = navHostFragment.getNavController();
    }
}