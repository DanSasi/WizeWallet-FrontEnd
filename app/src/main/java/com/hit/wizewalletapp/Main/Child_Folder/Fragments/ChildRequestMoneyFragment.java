package com.hit.wizewalletapp.Main.Child_Folder.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hit.wizewalletapp.R;


public class ChildRequestMoneyFragment extends Fragment {
    EditText requestMoneyAmount;
    EditText requestMoneyDesc;
    Button sendRequestBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_child_request_money, container, false);
        requestMoneyAmount = view.findViewById(R.id.child_request_payment_amount_et);
        requestMoneyDesc = view.findViewById(R.id.child_request_payment_desc_et);
        sendRequestBtn = view.findViewById(R.id.child_request_payment_btn);


        sendRequestBtn.setOnClickListener(v-> save());


        return view;
    }

    private void save() {
        String amount = requestMoneyAmount.getText().toString();
        String desc = requestMoneyDesc.getText().toString();
    }
}

