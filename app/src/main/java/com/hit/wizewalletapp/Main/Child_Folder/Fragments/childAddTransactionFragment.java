package com.hit.wizewalletapp.Main.Child_Folder.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hit.wizewalletapp.R;


public class childAddTransactionFragment extends Fragment {
    EditText amount_et,description_et;
    Button save_btn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_child_add_transaction, container, false);
        initViews(view);




        return view;
    }
    private void initViews(View view) {
        amount_et= view.findViewById(R.id.parent_add_transaction_amount_et);
        description_et=view.findViewById(R.id.add_transaction_description_et);
        save_btn=view.findViewById(R.id.add_transaction_btn);
    }

 }
