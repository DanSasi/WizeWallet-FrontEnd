package com.hit.wizewalletapp.Main.Child_Folder.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTransactionModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.ChildListModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.utilities.Utilities;

import java.util.HashMap;
import java.util.Map;


public class ChildAddTransactionFragment extends Fragment {
    EditText amount_et,description_et;
    Button save_btn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_child_add_transaction, container, false);
        initViews(view);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });



        return view;
    }

    private void save() {
        String amount=amount_et.getText().toString();
        String desc=description_et.getText().toString();
        if(Utilities.verifyAllTextNotEmpty(amount,desc)) {
            String token = CacheUtilities.getAcssesToken(requireContext());
            HashMap<String, Object> map = new HashMap<>();
            map.put("amount",amount);
            map.put("description",desc);
            ApiCallsHelper.performChildTransaction(token,map, new CustomCallBack<Void>() {
                @Override
                public void onSuccesses(Void response) {
                    ChildTransactionModel childTransactionModel=new ChildTransactionModel(Integer.parseInt(amount),desc);
                    ChildListModel.instance.childAddTran(childTransactionModel);
                    Navigation.findNavController(getActivity(),R.id.nav_host).navigateUp();
                }

                @Override
                public void onFailure(String msg) {

                }
            });

        }

    }

    private void initViews(View view) {
        amount_et= view.findViewById(R.id.parent_add_transaction_amount_et);
        description_et=view.findViewById(R.id.add_transaction_description_et);
        save_btn=view.findViewById(R.id.add_transaction_btn);
    }

 }
