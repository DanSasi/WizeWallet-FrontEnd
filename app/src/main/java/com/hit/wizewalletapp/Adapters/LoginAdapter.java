package com.hit.wizewalletapp.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.hit.wizewalletapp.Fragments.LoginTabFragment;
import com.hit.wizewalletapp.Fragments.SignupTabFragment;

import java.util.ArrayList;


@SuppressWarnings("ALL")
public class LoginAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    public LoginAdapter(@NonNull FragmentManager fm, int behavor) {
        super(fm,behavor);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
       return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment, String title){
        fragmentArrayList.add(fragment);
        fragmentTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return fragmentTitle.get(position);
    }
}


