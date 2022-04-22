package com.hit.wizewalletapp.Activities.Parent_Folder.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;

import android.os.Bundle;

import com.hit.wizewalletapp.R;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHost navHostFragment =
                (NavHost) getSupportFragmentManager().findFragmentById(R.id.nav_host_parent);
        navController = navHostFragment.getNavController();
    }
}