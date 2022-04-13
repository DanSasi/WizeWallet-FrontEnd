package com.hit.wizewalletapp.Activities.ParentFolder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.Activities.ContactListScreen;
import com.hit.wizewalletapp.Activities.MenuScreen;
import com.hit.wizewalletapp.Activities.TasksScreen;
import com.hit.wizewalletapp.Activities.TipsScreen;
import com.hit.wizewalletapp.Activities.TransactionHistoryActivity;
import com.hit.wizewalletapp.Adapters.BalanceListParentAdapter;
import com.hit.wizewalletapp.Models.BalanceParentModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;

public class ParentBalanceScreen extends AppCompatActivity implements BalanceListParentAdapter.BalanceViewHolder.RecycleViewClickListener {
    BalanceListParentAdapter balanceListAdapter;
    ArrayList<BalanceParentModel> bData;
    RecyclerView recyclerView;
    private BalanceListParentAdapter.BalanceViewHolder.RecycleViewClickListener clickListener;

    ImageView transfer, topup, more , tips;
    TextView transferText, topupText, moreText , tipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_parent_screen);

        transfer = findViewById(R.id.imageView4);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTransfer = new Intent(ParentBalanceScreen.this, ContactListScreen.class);
                startActivity(gotoTransfer);
            }
        });

        topup = findViewById(R.id.imageView5);
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTopup = new Intent(ParentBalanceScreen.this, TasksScreen.class);
                startActivity(gotoTopup);
            }
        });
        tips = findViewById(R.id.imageView6);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTips = new Intent(ParentBalanceScreen.this, TipsScreen.class);
                startActivity(gotoTips);

            }
        });

        more = findViewById(R.id.imageView8);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMore = new Intent(ParentBalanceScreen.this, MenuScreen.class);
                startActivity(gotoMore);
            }
        });

        transferText = findViewById(R.id.textView6);
        transferText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTransferText = new Intent(ParentBalanceScreen.this, ParentBalanceScreen.class);
                startActivity(gotoTransferText);
            }
        });

        topupText = findViewById(R.id.textView7);
        topupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTopupText = new Intent(ParentBalanceScreen.this, TasksScreen.class);
                startActivity(gotoTopupText);
            }
        });

        tipText = findViewById(R.id.textView8);
        tipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTipText = new Intent(ParentBalanceScreen.this, TipsScreen.class);
                startActivity(gotoTipText);
            }
        });

        moreText = findViewById(R.id.text_more);
        moreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMore = new Intent(ParentBalanceScreen.this, MenuScreen.class);
                startActivity(gotoMore);
            }
        });

        recyclerView = findViewById(R.id.rv_balance);
        getData();
        setDataAdapter();

        bData = new ArrayList<BalanceParentModel>();
    }

    private void setDataAdapter() {
        balanceListAdapter = new BalanceListParentAdapter(ParentBalanceScreen.this, bData);
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
        Intent intent = new Intent(ParentBalanceScreen.this, TransactionHistoryActivity.class);
        startActivity(intent);
    }
}