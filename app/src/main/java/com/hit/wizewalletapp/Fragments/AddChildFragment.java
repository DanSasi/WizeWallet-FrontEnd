package com.hit.wizewalletapp.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.hit.wizewalletapp.R;


public class AddChildFragment extends Fragment {


    EditText childNameEt;
    EditText childPassword;
    Button addChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_child_fragment, container, false);

        childPassword = view.findViewById(R.id.add_child_password);
        childNameEt = view.findViewById(R.id.add_child_username);
        addChild = view.findViewById(R.id.add_child_Btn);
        return view;
    }
}