package com.hit.wizewalletapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

//    Button loginButton;
    TabLayout tabLayout;
    ViewPager viewPager;
    CustomSpinner userSpinner;
    FloatingActionButton fb,google,twitter;
    private List<String> categories;
    private Spinner spinnerCategories;
    float v=0;

    private String [] user = {"Parent","Child"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//
//        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
//        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(LoginTabFragment.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Spinner_items));
//        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(myAdapter);

//        spinner.setOnItemClickListener(this);
//
//        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,user);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(aa);


        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_Pager);
        fb = findViewById(R.id.fab_fb);
        google = findViewById(R.id.fab_google);
        twitter = findViewById(R.id.fab_twitter);


        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("SignUp"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        userSpinner = findViewById(R.id.spinner);
//        Spinner spinner = findViewById(R.id.spinner1);
////        Spinner spinner = findViewById(R.id.spinner1);
//        ArrayAdapter<CharSequence> adapterUsr = ArrayAdapter.createFromResource(this,R.array.spinner_list, android.R.layout.simple_spinner_item);
//        adapterUsr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapterUsr);
//        spinner.setOnItemClickListener(this);



        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        fb.setTranslationY(300);
        google.setTranslationY(300);
        twitter.setTranslationY(300);
        tabLayout.setTranslationY(300);

        fb.setAlpha(v);
        google.setAlpha(v);
        twitter.setAlpha(v);
        tabLayout.setAlpha(v);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();



    }

    public void setCurrentItem(int which) {
            viewPager.setCurrentItem(which);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, user[position] , Toast.LENGTH_SHORT).show();
    }


    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }

}