package com.hit.wizewalletapp.Activities.Parent_Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.Adapters.Parent_Adapters.BalanceListParentAdapter;
import com.hit.wizewalletapp.Models.BalanceParentModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;

public class ParentTransactionHistoryActivity extends AppCompatActivity {

    BalanceListParentAdapter balanceListAdapter;
    ArrayList<BalanceParentModel> bData;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_parent_history);

        recyclerView = findViewById(R.id.rv_transactionHistory);
        getData();
        setDataAdapter();

    }
    private void setDataAdapter() {
        balanceListAdapter = new BalanceListParentAdapter(ParentTransactionHistoryActivity.this, bData);
        recyclerView.setAdapter(balanceListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getData() {
        bData = new ArrayList<>();
        bData.add(new BalanceParentModel(R.drawable.grocery_icon, "Dec 21","Birthday gift", "300", "Happy Birthday!" ));
        bData.add(new BalanceParentModel(R.drawable.entertainment_icon, "Jan 22","HomeWork", "60", "Math" ));
        bData.add(new BalanceParentModel(R.drawable.equipment_icon, "Feb 22","Allowance", "200", "Enjoy" ));
        bData.add(new BalanceParentModel(R.drawable.officeitem_icon, "March 21","new ball", "50", "Basketball" ));
    }
}