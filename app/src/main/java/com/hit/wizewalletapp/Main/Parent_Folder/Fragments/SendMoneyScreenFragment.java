package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.ChildListModel;
import com.hit.wizewalletapp.adapters.child.ChildAdapterSpinner;
import com.hit.wizewalletapp.adapters.child.ChildTaskListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.api.responses.ServerResponse;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.utilities.Utilities;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.R;

import java.util.HashMap;
import java.util.List;


public class SendMoneyScreenFragment extends Fragment {

    private final ChildTaskListAdapter listAdapter = new ChildTaskListAdapter();
    //private static ChildListScreenFragment.MyChildAdapter adapter;
    ImageView arr;
    static List<ChildModel> childList;
    TextView nameTxt;
    ImageView photo;
    TextView bankTxt;
    Spinner spinner;
    EditText amountEt,descriptionEt;
    Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        childList = ChildListModel.instance.getAllData();
        View view = inflater.inflate(R.layout.fragment_send_money_screen, container, false);


        spinner = view.findViewById(R.id.send_money_spinner);


        setSpinner(spinner);
        amountEt = view.findViewById(R.id.send_money_editText);
        descriptionEt=view.findViewById(R.id.send_money_description_editText);

        arr = view.findViewById(R.id.IV01);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireActivity(), R.id.nav_host).navigateUp();
            }
        });
        saveButton = view.findViewById(R.id.send_money_btn);

        saveButton.setOnClickListener(v -> save());


        return view;
    }


    private void setSpinner(Spinner spinner) {
        ChildAdapterSpinner childAdapter = new ChildAdapterSpinner(getContext());
        spinner.setAdapter(childAdapter);
        ApiCallsHelper.performGetAllChilds(CacheUtilities.getAcssesToken(requireContext()), new CustomCallBack<List<ChildModel>>() {
            @Override
            public void onSuccesses(List<ChildModel> response) {
                childAdapter.updateList(response);
            }

            @Override
            public void onFailure(String msg) {
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectChildId = String.valueOf(childAdapter.getItem(position));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void save() {

        String amount = amountEt.getText().toString();
        String _id = spinner.getSelectedItem().toString();
        String description=descriptionEt.getText().toString();
        if (Utilities.verifyAllTextNotEmpty(amount,_id,description)) {
            String token = CacheUtilities.getAcssesToken(requireContext());
            HashMap<String, Object> userTaskMap = new HashMap<>();
            userTaskMap.put("_id",_id);
            userTaskMap.put("amount", amount);
            userTaskMap.put("description",description);
            ApiCallsHelper.performAddBalanceForChild(token,userTaskMap, new CustomCallBack<Void>() {
                @Override
                public void onSuccesses(Void response) {
                    Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp();
                }

                @Override
                public void onFailure(String msg) {
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                }
            });

        }


    }
}