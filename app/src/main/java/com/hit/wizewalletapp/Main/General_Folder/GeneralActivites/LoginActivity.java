package com.hit.wizewalletapp.Main.General_Folder.GeneralActivites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;

import android.os.Bundle;

import com.hit.wizewalletapp.R;


public class LoginActivity extends AppCompatActivity {
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        NavHost navHost =  (NavHost) getSupportFragmentManager().findFragmentById(R.id.nav_host);
        navController = navHost.getNavController();
    }
}
