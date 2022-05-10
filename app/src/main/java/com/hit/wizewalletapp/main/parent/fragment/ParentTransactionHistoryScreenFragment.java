package com.hit.wizewalletapp.main.parent.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.adapters.parentadapters.BalanceListParentAdapter;
import com.hit.wizewalletapp.model.ParentModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.model.TransactionModel;

import java.util.ArrayList;

public class ParentTransactionHistoryScreenFragment extends Fragment {

    BalanceListParentAdapter balanceListAdapter;
    ArrayList<TransactionModel> bData;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaction_parent_history, container, false);

        recyclerView = view.findViewById(R.id.rv_transactionHistory);
//        getData();
        setDataAdapter();
        return view;
    }
    private void setDataAdapter() {
        balanceListAdapter = new BalanceListParentAdapter(getActivity(), bData);
        recyclerView.setAdapter(balanceListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
//
//    private void getData() {
//
//    }
}