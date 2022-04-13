package com.hit.wizewalletapp.Activities.General_Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.AdapterView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.hit.wizewalletapp.Adapters.General_Adapters.LoginAdapter;
import com.hit.wizewalletapp.Fragments.LoginTabFragment;
import com.hit.wizewalletapp.Fragments.SignupTabFragment;
import com.hit.wizewalletapp.R;

@SuppressWarnings("ALL")
public class LoginActivity extends AppCompatActivity  {

//    Button loginButton;
    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fb,google,twitter;
    float v=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_Pager);
        fb = findViewById(R.id.fab_fb);
        google = findViewById(R.id.fab_google);
        twitter = findViewById(R.id.fab_twitter);


        tabLayout.setupWithViewPager(viewPager);

        LoginAdapter loginAdapter = new LoginAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        loginAdapter.addFragment(new LoginTabFragment(),"LOG IN");
        loginAdapter.addFragment(new SignupTabFragment(),"SIGN UP");
        viewPager.setAdapter(loginAdapter);


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





    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub

    }

}