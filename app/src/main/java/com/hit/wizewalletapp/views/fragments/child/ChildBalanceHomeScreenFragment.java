package com.hit.wizewalletapp.views.fragments.child;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView ballance;
    private RecyclerView rv;
    private ProgressBar progressBar;
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
        ballance = view.findViewById(R.id.child_fragment_ballance_tv);

        task.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childTasksScreenFragment));
        taskText = view.findViewById(R.id.textView7);
        taskText.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childTasksScreenFragment));


        /////////////////////////////////////////////////////////////Tips/////////////////////////////////////////////////////////////

        tips = view.findViewById(R.id.imageView6);
        tips.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childTipsFragment));

        tipText = view.findViewById(R.id.textView8);
        tipText.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childTipsFragment));

        /////////////////////////////////////////////////////////////More/////////////////////////////////////////////////////////////


        more = view.findViewById(R.id.imageView8);
        more.setOnClickListener(v -> Navigation.findNavController(v).navigate(ChildBalanceHomeScreenFragmentDirections.actionChildBalanceHomeScreenFragment2ToChildMenuFragment(refreshToken)));

        moreText =view.findViewById(R.id.text_more);
        moreText.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment2_to_childMenuFragment));
        /////////////////////////////////////////////////////////////Transactions/////////////////////////////////////////////////////////////
        transfer=view.findViewById(R.id.imageView4);
        transfer.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_childBalanceHomeScreenFragment_to_child_add_transaction));
        progressBar = view.findViewById(R.id.progressBar);
        /////////////////////////////////////////////////////////////Done/////////////////////////////////////////////////////////////
        initViewRv(view);
        fetchData();

        return view;
    }


    private void initViewRv(View view) {
        rv= view.findViewById(R.id.rv_trans_child);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(childTransListAdapter);
        childTransListAdapter.setOnItemClickListener(this);

    }

    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        String token= CacheUtilities.getAcssesToken(requireContext());
        ApiCallsHelper.performGetAllTransForChild(token, new CustomCallBack<List<ChildTransactionModel>>() {
            @Override
            public void onSuccesses(List<ChildTransactionModel> response) {
                childTransListAdapter.updateTransList(response);
                progressBar.setVisibility(View.GONE);
                rv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });

        ApiCallsHelper.performGetChildBalance(token, new CustomCallBack<String>() {
            @Override
            public void onSuccesses(String response) {
                ballance.setText("Nis: " +response);
            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public void onItemClick(ChildTransactionModel childModel) {

    }
}