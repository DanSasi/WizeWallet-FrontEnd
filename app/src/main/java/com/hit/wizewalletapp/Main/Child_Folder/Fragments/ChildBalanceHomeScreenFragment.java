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

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTransactionModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildTransListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.List;


public class ChildBalanceHomeScreenFragment extends Fragment implements  ChildTransListAdapter.OnItemClickListener  {




    ImageView transfer, task, more, tips;
    TextView transferText, taskText, moreText, tipText, hellowText;
    private RecyclerView rv;
    private final ChildTransListAdapter childTransListAdapter= new ChildTransListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_balance_home, container, false);

        //get the refresh token
        String refreshToken = ChildBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken();


        ////////////////////////////////////////////////////////////Tasks///////////////////////////////////////////////////////////////

        task = view.findViewById(R.id.imageView5);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childTasksScreenFragment);
            }
        });
        taskText = view.findViewById(R.id.textView7);
        taskText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childTasksScreenFragment);
            }
        });


        /////////////////////////////////////////////////////////////Tips/////////////////////////////////////////////////////////////

        tips = view.findViewById(R.id.imageView6);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childTipsFragment);
            }
        });

        tipText = view.findViewById(R.id.textView8);
        tipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childTipsFragment);
            }
        });

        /////////////////////////////////////////////////////////////More/////////////////////////////////////////////////////////////


        more = view.findViewById(R.id.imageView8);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(ChildBalanceHomeScreenFragmentDirections.actionChildBalanceHomeScreenFragment2ToChildMenuFragment(refreshToken));

            }
        });



        moreText =view.findViewById(R.id.text_more);
        moreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childMenuFragment);
            }
        });
        /////////////////////////////////////////////////////////////Transactions/////////////////////////////////////////////////////////////
        transfer=view.findViewById(R.id.imageView4);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment_to_child_add_transaction);
            }
        });

        /////////////////////////////////////////////////////////////Done/////////////////////////////////////////////////////////////
        initViewRv(view);
        fetchData();




        return view;
    }
//
    private void initViewRv(View view) {
        rv= view.findViewById(R.id.rv_trans_child);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(childTransListAdapter);
        childTransListAdapter.setOnItemClickListener(this);

    }

    private void fetchData() {
        String token= CacheUtilities.getAcssesToken(requireContext());
        ApiCallsHelper.performGetAllTransForChild(token, new CustomCallBack<List<ChildTransactionModel>>() {
            @Override
            public void onSuccesses(List<ChildTransactionModel> response) {
                childTransListAdapter.updateTransList(response);
            }

            @Override
            public void onFailure(String msg) {

            }
        });

    }



    @Override
    public void onItemClick(ChildTransactionModel childModel) {

    }
}