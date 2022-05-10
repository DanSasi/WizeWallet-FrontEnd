package com.hit.wizewalletapp.main.child.fragment;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hit.wizewalletapp.adapters.parentadapters.BalanceListParentAdapter;
import com.hit.wizewalletapp.model.ParentModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.model.TransactionModel;

import java.util.ArrayList;

public class ChildTransactionHistoryScreenFragment extends Fragment {

    BalanceListParentAdapter balanceListAdapter;
    ArrayList<TransactionModel> bData;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaction_child_history, container, false);

        recyclerView = view.findViewById(R.id.rv_transactionHistory);
        //getData();
        setDataAdapter();
        return view;

    }
    private void setDataAdapter() {
        balanceListAdapter = new BalanceListParentAdapter(getActivity(), bData);
        recyclerView.setAdapter(balanceListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

//    private void getData() {
//        bData = new ArrayList<>();
//        bData.add(new ParentModel(R.drawable.grocery_icon, "Dec 21","Birthday gift", "300", "Happy Birthday!" ));
//        bData.add(new ParentModel(R.drawable.entertainment_icon, "Jan 22","HomeWork", "60", "Math" ));
//        bData.add(new ParentModel(R.drawable.equipment_icon, "Feb 22","Allowance", "200", "Enjoy" ));
//        bData.add(new ParentModel(R.drawable.officeitem_icon, "March 21","new ball", "50", "Basketball" ));
//    }
}