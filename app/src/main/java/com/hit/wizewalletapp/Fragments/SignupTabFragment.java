package com.hit.wizewalletapp.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hit.wizewalletapp.Activities.LoginActivity;
import com.hit.wizewalletapp.R;

public class SignupTabFragment extends Fragment {



    private EditText userEmail,userPassword,userFullName;

    private Button userSignUpButton;
    float v = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        userFullName=root.findViewById(R.id.fullname);
        userEmail=root.findViewById(R.id.email);
        userPassword=root.findViewById(R.id.password);
        userSignUpButton = root.findViewById(R.id.SignUp);


        return root;
    }
}