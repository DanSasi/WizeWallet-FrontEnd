package com.hit.wizewalletapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.hit.wizewalletapp.Activities.BalanceScreen;
import com.hit.wizewalletapp.Activities.LoginActivity;
import com.hit.wizewalletapp.Activities.SendMoneyScreen;
import com.hit.wizewalletapp.Activities.TipsScreen;
import com.hit.wizewalletapp.Adapters.UserMembersAdapter;
import com.hit.wizewalletapp.Data.UsersMembersData.UserData;
import com.hit.wizewalletapp.Data.UsersMembersData.UserMembers;
import com.hit.wizewalletapp.Models.CustomSpinner;
import com.hit.wizewalletapp.R;

import java.io.BufferedReader;
import java.util.Objects;
import java.util.Scanner;

public class LoginTabFragment extends Fragment  implements CustomSpinner.OnSpinnerEventsListener {

    TextView email;

    TextView password;
    TextView logAs;
    Spinner userSpinner;
    UserMembersAdapter adapter;
    TextView forgetPass;
    Button login;




//    CustomSpinner spinner;
    float v=0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savadInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);
        
        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        forgetPass = root.findViewById(R.id.forgetPass);
        login = root.findViewById(R.id.login);
        userSpinner= (Spinner) root.findViewById(R.id.logfrag_userSpinner);
        logAs = root.findViewById(R.id.text_changeUser);

        adapter = new UserMembersAdapter(getActivity(), UserData.getUsersDataList());
        userSpinner.setAdapter(adapter);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String item = userSpinner.getSelectedItem().toString();
              if(item.equals("Parent")){
                  Intent intent = new Intent(getActivity(),SendMoneyScreen.class);
                  startActivity(intent);
              }else if(item.equals("Child")){
                  Intent intent = new Intent(getActivity(), BalanceScreen.class);
                  startActivity(intent);
              }else{
                  Toast.makeText(getContext(),"Error", Toast.LENGTH_SHORT).show();
              }

            }
        });




        email.setTranslationX(800);
        password.setTranslationX(800);
        forgetPass.setTranslationX(800);
        login.setTranslationX(800);
        userSpinner.setTranslationX(800);
        logAs.setTranslationX(800);


        email.setAlpha(v);
        password.setAlpha(v);
        forgetPass.setAlpha(v);
        login.setAlpha(v);
        userSpinner.setAlpha(v);
        logAs.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        logAs.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        userSpinner.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();




        return root;


    }

    @Override
    public void onPopupWindowOpened(Spinner spinner) {

    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {

    }
}
