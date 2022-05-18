package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildAdapterSpinner;
import com.hit.wizewalletapp.adapters.child.ChildTaskListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.List;


public class ParentMoneyRequests extends Fragment {
    Spinner spinner;
    RecyclerView rv;
    private final ChildTaskListAdapter listAdapter = new ChildTaskListAdapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_parent_money_requests, container, false);

        rv =view.findViewById(R.id.parent_requests_rv);
        spinner =view.findViewById(R.id.parent_request_spinner);
        setSpinner(spinner);
        return view;
    }
    private void initRecyclerView(View view) {
        rv =view.findViewById(R.id.parent_requests_rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(listAdapter);
      //  rv.setOnItemClickListener(this);

    }

    private void setSpinner(Spinner spinner) {
            ChildAdapterSpinner childAdapter = new ChildAdapterSpinner(getContext());
            spinner.setAdapter(childAdapter);
            ApiCallsHelper.performGetAllChilds( CacheUtilities.getAcssesToken(requireContext()), new CustomCallBack<List<ChildModel>>() {
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
                  //  fetchRequestsForChild(selectChildId);
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

    }
    private void fetchRequestsForChild(String selectChildId) {
    }



}