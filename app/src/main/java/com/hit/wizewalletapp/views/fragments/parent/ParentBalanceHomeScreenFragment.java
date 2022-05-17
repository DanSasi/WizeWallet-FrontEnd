package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTransactionModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.ChildListModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildAdapterSpinner;
import com.hit.wizewalletapp.adapters.child.ChildTransListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;


import java.util.List;


public class ParentBalanceHomeScreenFragment extends Fragment  implements  ChildTransListAdapter.OnItemClickListener{



    static List<ChildModel> childList;


    ImageView childs, task, more, tips;
    TextView childText, taskText, moreText, tipText, helloText ;
    Spinner spinner;
    TextView nameTxt;
    ImageView photo;
    String refreshToken ="";
    private RecyclerView rv;
    private final ChildTransListAdapter childTransListAdapter= new ChildTransListAdapter();

    private ChildAdapterSpinner childAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parent_balance_home, container, false);
        helloText = view.findViewById(R.id.user_name);
        helloText.setText(String.format("Hello %s",ParentBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getName()));
        refreshToken = ParentBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken();

        childAdapter = new ChildAdapterSpinner(getContext());

        /////////////////////////////////////////////////////////////Childs/////////////////////////////////////////////////////////////

        childs = view.findViewById(R.id.imageView4);
        childs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeParentFragment_to_childListScreen);
            }
        });
        childText = view.findViewById(R.id.textView6);
        childText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeParentFragment_to_childListScreen);
            }
        });


        ////////////////////////////////////////////////////////////Tasks///////////////////////////////////////////////////////////////

        task = view.findViewById(R.id.imageView5);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeParentFragment_to_parentTasksScreen);
            }
        });
        taskText = view.findViewById(R.id.textView7);
        taskText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeParentFragment_to_parentTasksScreen);
            }
        });


        /////////////////////////////////////////////////////////////Tips/////////////////////////////////////////////////////////////

        tips = view.findViewById(R.id.imageView6);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeParentFragment_to_parentTipsScreen);
            }
        });

        tipText = view.findViewById(R.id.textView8);
        tipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeParentFragment_to_parentTipsScreen);
            }
        });

        /////////////////////////////////////////////////////////////More/////////////////////////////////////////////////////////////


        more = view.findViewById(R.id.imageView8);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(ParentBalanceHomeScreenFragmentDirections.actionHomeParentFragmentToParentMenuScreen(refreshToken));
            }
        });



        moreText =view.findViewById(R.id.text_more);
        moreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeParentFragment_to_parentMenuScreen);
            }
        });
        childList = ChildListModel.instance.getAllData();
        spinner = view.findViewById(R.id.fragment_Parent_spinner);

        spinner.setAdapter(childAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectChildId = String.valueOf(childAdapter.getItem(position));
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
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(childTransListAdapter);
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
//                childTransListAdapter.updateTransList(response);
//            }
//
//            @Override
//            public void onFailure(String msg) {
//
//            }
//        });
//
//    }
//
//
//
    @Override
    public void onItemClick(ChildTransactionModel childModel) {
        Navigation.findNavController(requireActivity(),R.id.nav_host).navigate(ParentBalanceHomeScreenFragmentDirections.actionHomeParentFragmentToChildTransDetailsFragment(childModel.getDesc(),childModel.getAmount()));
    }
//



}