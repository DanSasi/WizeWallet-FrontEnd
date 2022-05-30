package com.hit.wizewalletapp.views.fragments.child;

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

import com.hit.wizewalletapp.model.child.ChildTransactionModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildTransListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.views.fragments.parent.ParentBalanceHomeScreenFragmentArgs;

import java.util.List;


public class ChildBalanceHomeScreenFragment extends Fragment implements  ChildTransListAdapter.OnItemClickListener  {

    ImageView transfer, task, more, tips;
    TextView transferText, taskText, moreText, tipText;
    TextView ballance, helloText;
    private RecyclerView rv;
    private ProgressBar progressBar;
    private final ChildTransListAdapter childTransListAdapter= new ChildTransListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_balance_home, container, false);
        helloText = view.findViewById(R.id.child_user_name);
        helloText.setText(String.format("Hello %s", ChildBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getName()));
        //get the refresh token
        String refreshToken = ChildBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken();
        ballance = view.findViewById(R.id.child_fragment_ballance_tv);
        ////////////////////////////////////////////////////////////Tasks///////////////////////////////////////////////////////////////

        task = view.findViewById(R.id.imageView5);
        task.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ChildBalanceHomeScreenFragmentDirections
                        .actionChildBalanceHomeScreenFragment2ToChildTasksScreenFragment()));

        taskText = view.findViewById(R.id.textView7);
        taskText.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host)
                    .navigate(ChildBalanceHomeScreenFragmentDirections
                        .actionChildBalanceHomeScreenFragment2ToChildTasksScreenFragment()));


        /////////////////////////////////////////////////////////////Tips/////////////////////////////////////////////////////////////

        tips = view.findViewById(R.id.imageView6);
        tips.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ChildBalanceHomeScreenFragmentDirections.
                        actionChildBalanceHomeScreenFragment2ToChildTipsFragment()));

        tipText = view.findViewById(R.id.textView8);
        tipText.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ChildBalanceHomeScreenFragmentDirections.
                        actionChildBalanceHomeScreenFragment2ToChildTipsFragment()));

        /////////////////////////////////////////////////////////////More/////////////////////////////////////////////////////////////


        more = view.findViewById(R.id.imageView8);
        more.setOnClickListener(v -> Navigation.findNavController(requireActivity(), R.id.nav_host)
                .navigate(ChildBalanceHomeScreenFragmentDirections.
                        actionChildBalanceHomeScreenFragment2ToChildMenuFragment(refreshToken)));

        moreText =view.findViewById(R.id.text_more);
        moreText.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ChildBalanceHomeScreenFragmentDirections.
                     actionChildBalanceHomeScreenFragment2ToChildMenuFragment(refreshToken)));

        /////////////////////////////////////////////////////////////Transactions/////////////////////////////////////////////////////////////
        transfer=view.findViewById(R.id.imageView4);
        transfer.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ChildBalanceHomeScreenFragmentDirections
                        .actionChildBalanceHomeScreenFragmentToChildAddTransaction()));

        transferText = view.findViewById(R.id.textView6);
        transferText.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host)
                        .navigate(ChildBalanceHomeScreenFragmentDirections
                            .actionChildBalanceHomeScreenFragmentToChildAddTransaction()));


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

        ApiCallsHelper.performGetChildBalance(token, new CustomCallBack<Integer>() {
            @Override
            public void onSuccesses(Integer response) {
                ballance.setText("Your Balance: " + Integer.valueOf(response));
            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public void onItemClick(ChildTransactionModel childModel) {
        Navigation.findNavController(requireActivity(),R.id.nav_host).navigate(ChildBalanceHomeScreenFragmentDirections.
                actionChildBalanceHomeScreenFragmentToChildTransDetailsFragment(childModel.getDesc(),childModel.getAmount(),childModel.getLatitude(),childModel.getLongitude()));
    }
}