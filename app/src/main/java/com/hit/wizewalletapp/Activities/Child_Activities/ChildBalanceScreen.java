package com.hit.wizewalletapp.Activities.Child_Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.Adapters.Parent_Adapters.BalanceListParentAdapter;
import com.hit.wizewalletapp.Models.BalanceParentModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;

public class ChildBalanceScreen extends AppCompatActivity implements BalanceListParentAdapter.BalanceViewHolder.RecycleViewClickListener {
    BalanceListParentAdapter balanceListAdapter;
    ArrayList<BalanceParentModel> bData;
    RecyclerView recyclerView;
    private BalanceListParentAdapter.BalanceViewHolder.RecycleViewClickListener clickListener;

    ImageView transfer, topup, more , tips;
    TextView transferText, topupText, moreText , tipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_child_screen);

//        transfer = findViewById(R.id.imageView4);
//        transfer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent gotoTransfer = new Intent(ChildBalanceScreen.this, ContactListScreen.class);
//                startActivity(gotoTransfer);
//            }
//        });

        topup = findViewById(R.id.imageView5);
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTopup = new Intent(ChildBalanceScreen.this, ChildTasksScreen.class);
                startActivity(gotoTopup);
            }
        });
        tips = findViewById(R.id.imageView6);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTips = new Intent(ChildBalanceScreen.this, ChildTipsScreen.class);
                startActivity(gotoTips);

            }
        });

        more = findViewById(R.id.imageView8);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMore = new Intent(ChildBalanceScreen.this, ChildMenuScreen.class);
                startActivity(gotoMore);
            }
        });

//        transferText = findViewById(R.id.textView6);
//        transferText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent gotoTransferText = new Intent(ChildBalanceScreen.this, ChildBalanceScreen.class);
//                startActivity(gotoTransferText);
//            }
//        });

        topupText = findViewById(R.id.textView7);
        topupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTopupText = new Intent(ChildBalanceScreen.this, ChildTasksScreen.class);
                startActivity(gotoTopupText);
            }
        });

        tipText = findViewById(R.id.textView8);
        tipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTipText = new Intent(ChildBalanceScreen.this, ChildTipsScreen.class);
                startActivity(gotoTipText);
            }
        });

        moreText = findViewById(R.id.text_more);
        moreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMore = new Intent(ChildBalanceScreen.this, ChildMenuScreen.class);
                startActivity(gotoMore);
            }
        });

        recyclerView = findViewById(R.id.rv_balance);
        getData();
        setDataAdapter();

        bData = new ArrayList<BalanceParentModel>();
    }

    private void setDataAdapter() {
        balanceListAdapter = new BalanceListParentAdapter(ChildBalanceScreen.this, bData);
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

    @Override
    public void recycleViewClick(int position) {
        Intent intent = new Intent(ChildBalanceScreen.this, ChildTransactionHistoryActivity.class);
        startActivity(intent);
    }
}