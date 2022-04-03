package com.hit.wizewalletapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BalanceScreen extends AppCompatActivity implements BalanceListAdapter.BalanceViewHolder.RecycleViewClickListener{
    BalanceListAdapter balanceListAdapter;
    ArrayList<BalanceModel> bData;
    RecyclerView recyclerView;
    private BalanceListAdapter.BalanceViewHolder.RecycleViewClickListener clickListener;

    ImageView transfer, topup, more;
    TextView transferText, topupText, moreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_screen);

        transfer = findViewById(R.id.imageView4);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTransfer = new Intent(BalanceScreen.this,ContactListScreen.class);
                startActivity(gotoTransfer);
            }
        });

        topup = findViewById(R.id.imageView5);
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTopup = new Intent(BalanceScreen.this,TopUpScreen.class);
                startActivity(gotoTopup);
            }
        });

        more = findViewById(R.id.imageView8);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMore = new Intent(BalanceScreen.this,MenuScreen.class);
                startActivity(gotoMore);
            }
        });

        transferText = findViewById(R.id.textView6);
        transferText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTransferText = new Intent(BalanceScreen.this, ContactListScreen.class);
                startActivity(gotoTransferText);
            }
        });

        topupText = findViewById(R.id.textView7);
        topupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTopupText = new Intent(BalanceScreen.this, TopUpScreen.class);
                startActivity(gotoTopupText);
            }
        });

        moreText = findViewById(R.id.text_more);
        moreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMore = new Intent(BalanceScreen.this, MenuScreen.class);
                startActivity(gotoMore);
            }
        });

        recyclerView = findViewById(R.id.rv_balance);
        getData();
        setDataAdapter();

        bData = new ArrayList<BalanceModel>();
    }

    private void setDataAdapter() {
        balanceListAdapter = new BalanceListAdapter(BalanceScreen.this, bData);
        recyclerView.setAdapter(balanceListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getData() {
        bData = new ArrayList<>();
        bData.add(new BalanceModel(R.drawable.grocery_icon, "Dec 21","Birthday gift", "300", "Happy Birthday!" ));
        bData.add(new BalanceModel(R.drawable.entertainment_icon, "Jan 22","HomeWork", "60", "Math" ));
        bData.add(new BalanceModel(R.drawable.equipment_icon, "Feb 22","Allowance", "200", "Enjoy" ));
        bData.add(new BalanceModel(R.drawable.officeitem_icon, "March 21","new ball", "50", "Basketball" ));
    }

    @Override
    public void recycleViewClick(int position) {
        Intent intent = new Intent(BalanceScreen.this, TransactionHistoryActivity.class);
        startActivity(intent);
    }
}