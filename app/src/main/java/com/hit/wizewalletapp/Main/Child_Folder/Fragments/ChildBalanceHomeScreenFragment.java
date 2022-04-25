package com.hit.wizewalletapp.Main.Child_Folder.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.Adapters.Parent_Adapters.BalanceListParentAdapter;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.BalanceParentModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;


public class ChildBalanceHomeScreenFragment extends Fragment implements  BalanceListParentAdapter.BalanceViewHolder.RecycleViewClickListener {


    BalanceListParentAdapter balanceListAdapter;
    ArrayList<BalanceParentModel> bData;
    RecyclerView recyclerView;
    private BalanceListParentAdapter.BalanceViewHolder.RecycleViewClickListener clickListener;

    ImageView transfer, task, more, tips;
    TextView transferText, taskText, moreText, tipText, hellowText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_balance_home, container, false);




        ////////////////////////////////////////////////////////////Tasks///////////////////////////////////////////////////////////////

        task = view.findViewById(R.id.imageView5);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeFragment_to_childTasksFragment);
            }
        });
        taskText = view.findViewById(R.id.textView7);
        taskText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeFragment_to_childTasksFragment);
            }
        });


        /////////////////////////////////////////////////////////////Tips/////////////////////////////////////////////////////////////

        tips = view.findViewById(R.id.imageView6);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeFragment_to_childTipsFragment);
            }
        });

        tipText = view.findViewById(R.id.textView8);
        tipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeFragment_to_childTipsFragment);
            }
        });

        /////////////////////////////////////////////////////////////More/////////////////////////////////////////////////////////////


        more = view.findViewById(R.id.imageView8);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeFragment_to_childMenuFragment);
            }
        });



        moreText =view.findViewById(R.id.text_more);
        moreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeFragment_to_childMenuFragment);
            }
        });

        /////////////////////////////////////////////////////////////Done/////////////////////////////////////////////////////////////
        bData = new ArrayList<BalanceParentModel>();
        recyclerView = view.findViewById(R.id.rv_balance);
        getData();
        setDataAdapter();

        return view;
    }

    private void getData() {
        bData = new ArrayList<>();
        bData.add(new BalanceParentModel(R.drawable.grocery_icon, "Dec 21", "Birthday gift", "300", "Happy Birthday!"));
        bData.add(new BalanceParentModel(R.drawable.entertainment_icon, "Jan 22", "HomeWork", "60", "Math"));
        bData.add(new BalanceParentModel(R.drawable.equipment_icon, "Feb 22", "Allowance", "200", "Enjoy"));
        bData.add(new BalanceParentModel(R.drawable.officeitem_icon, "March 21", "new ball", "50", "Basketball"));
    }

    private void setDataAdapter() {
        balanceListAdapter = new BalanceListParentAdapter(getActivity(), bData);
        recyclerView.setAdapter(balanceListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void recycleViewClick(int position) {
        Intent intent = new Intent(getActivity(), ChildTransactionHistoryScreenFragment.class);
        startActivity(intent);
    }
}