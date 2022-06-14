package com.hit.wizewalletapp.views.fragments.parent;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.model.child.ChildTransactionModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildAdapterSpinner;
import com.hit.wizewalletapp.adapters.child.ChildTransListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.views.fragments.child.ChildBalanceHomeScreenFragmentDirections;


import java.util.List;


public class ParentBalanceHomeScreenFragment extends Fragment  implements  ChildTransListAdapter.OnItemClickListener{

    ImageView childs, task, more, tips;
    TextView childText, taskText, moreText, tipText, helloText ;
    Spinner spinner;
    TextView nameTxt;
    ImageView photo;
    String refreshToken ="";
    private static int selectedPosition = 0;
    ProgressBar progressBar ;
    private RecyclerView rv;
    private final ChildTransListAdapter childTransListAdapter= new ChildTransListAdapter();

    private ChildAdapterSpinner childAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parent_balance_home, container, false);
        helloText = view.findViewById(R.id.user_name);
        progressBar = view.findViewById(R.id.progressBar_balane_parent);
        helloText.setText(String.format("Hello %s",ParentBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getName()));
        refreshToken = ParentBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken();

        childAdapter = new ChildAdapterSpinner(getContext());


        /////////////////////////////////////////////////////////////Childs/////////////////////////////////////////////////////////////

        childs = view.findViewById(R.id.imageView4);
        childs.setOnClickListener(v->
                Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentBalanceHomeScreenFragmentDirections.
                        actionHomeParentFragmentToChildListScreen()));


        childText = view.findViewById(R.id.textView6);
        childText.setOnClickListener(v->Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentBalanceHomeScreenFragmentDirections.
                        actionHomeParentFragmentToChildListScreen()));


        ////////////////////////////////////////////////////////////Tasks///////////////////////////////////////////////////////////////

        task = view.findViewById(R.id.imageView5);
        task.setOnClickListener(v->Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentBalanceHomeScreenFragmentDirections.
                        actionHomeParentFragmentToParentTasksScreen()));

        taskText = view.findViewById(R.id.textView7);
        taskText.setOnClickListener(v->Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentBalanceHomeScreenFragmentDirections
                        .actionHomeParentFragmentToParentTasksScreen()));


        /////////////////////////////////////////////////////////////Tips/////////////////////////////////////////////////////////////

        tips = view.findViewById(R.id.imageView6);
        tips.setOnClickListener( v-> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentBalanceHomeScreenFragmentDirections
                        .actionHomeParentFragmentToParentTipsScreen()));

        tipText = view.findViewById(R.id.textView8);
        tipText.setOnClickListener(v-> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentBalanceHomeScreenFragmentDirections
                        .actionHomeParentFragmentToParentTipsScreen()));

        /////////////////////////////////////////////////////////////More/////////////////////////////////////////////////////////////


        more = view.findViewById(R.id.imageView8);
        more.setOnClickListener(v-> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentBalanceHomeScreenFragmentDirections
                        .actionHomeParentFragmentToParentMenuScreen(refreshToken)));



        moreText =view.findViewById(R.id.text_more);
        moreText.setOnClickListener(v-> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentBalanceHomeScreenFragmentDirections
                        .actionHomeParentFragmentToParentMenuScreen(refreshToken)));

        /////////////////////////////////////////////////Done//////////////////////////////////////////////////

        spinner = view.findViewById(R.id.fragment_Parent_spinner);


        spinner.setAdapter(childAdapter);
        spinner.setSelection(selectedPosition);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectChildId = String.valueOf(childAdapter.getItem(position));
                selectedPosition = position;
                fetchTransactionsForChild(selectChildId);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ApiCallsHelper.performGetAllChilds( CacheUtilities.getAcssesToken(requireContext()), new CustomCallBack<List<ChildModel>>() {
            @Override
            public void onSuccesses(List<ChildModel> response) {
                childAdapter.updateList(response);
            }
            @Override
            public void onFailure(String msg) {
            }
        });
//
        initViewRv(view);
//        fetchData();

//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });


        /////////////////////////////////////////////////////////////Done/////////////////////////////////////////////////////////////



        return view;
    }

    private void fetchTransactionsForChild(String selectChildId) {
        String token= CacheUtilities.getAcssesToken(requireContext());
        ApiCallsHelper.performGetAllTransForChildByParent(token,selectChildId, new CustomCallBack<List<ChildTransactionModel>>() {
            @Override
            public void onSuccesses(List<ChildTransactionModel> response) {
                childTransListAdapter.updateTransList(response);
               // progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
                //progressBar.setVisibility(View.GONE);
            }
        });

    }

//
//
    private void initViewRv(View view) {
        rv= view.findViewById(R.id.rv_trans_child);
        rv.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(childTransListAdapter);
        childTransListAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(ChildTransactionModel childModel) {

            Navigation.findNavController(requireActivity(), R.id.nav_host).navigate(ParentBalanceHomeScreenFragmentDirections.
                   actionHomeParentFragmentToChildTransDetailsFragment(childModel.getDesc(), childModel.getAmount(), childModel.getLatitude(), childModel.getLongitude(), childModel.getDate()));
    }
//
//    private void fetchData() {
////        List<ChildTransactionModel> list= (List<ChildTransactionModel>) rv.getAdapter();
//
//
//        String token= CacheUtilities.getAcssesToken(requireContext());
//        ApiCallsHelper.performGetAllTransForChild(token,new CustomCallBack<List<ChildTransactionModel>>() {
//            @Override
//            public void onSuccesses(List<ChildTransactionModel> response) {
//                chi bn

}