package com.hit.wizewalletapp.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.hit.wizewalletapp.Fragments.LoginTabFragment;
import com.hit.wizewalletapp.Fragments.SignupTabFragment;



public class LoginAdapter extends FragmentStatePagerAdapter {


    private Context context;
    int totalTabs;

    public LoginAdapter(FragmentManager fm,Context context, int totalTabs){
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
                LoginTabFragment loginTabFragment = new LoginTabFragment();
                return loginTabFragment;

            case 1:
                SignupTabFragment signupTabFragment = new SignupTabFragment();
                return signupTabFragment;

            default:
                return null;
        }
    }
}

