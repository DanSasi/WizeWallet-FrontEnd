package com.hit.wizewalletapp.Activities.Parent_Folder.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;

import com.hit.wizewalletapp.R;

public class ParentBalanceScreen extends AppCompatActivity {

    NavController navCtl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_parent_screen);

        NavHost navHostFragment =
                (NavHost) getSupportFragmentManager().findFragmentById(R.id.nav_host_parent);
        navCtl = navHostFragment.getNavController();
    }

}