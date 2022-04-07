package com.hit.wizewalletapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.hit.wizewalletapp.Activities.BalanceScreen;
import com.hit.wizewalletapp.Activities.SendMoneyScreen;
import com.hit.wizewalletapp.Adapters.MembersAdapter;
import com.hit.wizewalletapp.Adapters.UserMembersAdapter;
import com.hit.wizewalletapp.Data.ContactsData.Data;
import com.hit.wizewalletapp.Data.UsersMembersData.UserData;
import com.hit.wizewalletapp.Data.UsersMembersData.UserMembers;
import com.hit.wizewalletapp.Models.CustomSpinner;
import com.hit.wizewalletapp.R;

public class LoginTabFragment extends Fragment  implements CustomSpinner.OnSpinnerEventsListener {

    TextView email;

    TextView password;
    TextView logAs;
    CustomSpinner userSpinner;
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
        userSpinner= root.findViewById(R.id.logfrag_userSpinner);
        logAs = root.findViewById(R.id.text_changeUser);


        userSpinner.setSpinnerEventsListener(this);
        adapter = new UserMembersAdapter(getActivity(), UserData.getUsersDataList());
        userSpinner.setAdapter(adapter);


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


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BalanceScreen.class);
                intent.putExtra("value", 1);
                startActivity(intent);
            }
        });

        return root;


    }

    @Override
    public void onPopupWindowOpened(Spinner spinner) {

    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {

    }
}
