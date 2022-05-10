package com.hit.wizewalletapp.main.parent.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.hit.wizewalletapp.model.ChildModel;
import com.hit.wizewalletapp.model.Model;
import com.hit.wizewalletapp.model.TransactionModel;
import com.hit.wizewalletapp.main.child.fragment.ChildTransactionHistoryScreenFragment;
import com.hit.wizewalletapp.adapters.parentadapters.BalanceListParentAdapter;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;


public class ParentBalanceHomeScreenFragment extends Fragment implements BalanceListParentAdapter.BalanceViewHolder.RecycleViewClickListener {

    BalanceListParentAdapter balanceListAdapter;
    ArrayList<TransactionModel> bData;
    List<ChildModel> childList;
    RecyclerView recyclerView;

    private BalanceListParentAdapter.BalanceViewHolder.RecycleViewClickListener clickListener;

    ImageView childs, task, more, tips;
    TextView childText, taskText, moreText, tipText, helloText ;
    Spinner spinner;
    TextView nameTxt;
    ImageView photo;
    String refreshToken ="";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parent_balance_home, container, false);
//        if(ParentBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken()!=null){
//            refreshToken = ParentBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken();
//            Log.d("Tag",refreshToken);
//        }

        refreshToken = ParentBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken();
        Log.d("Tag",refreshToken);

//        String refreshToken = ParentBalanceHomeScreenFragmentArgs.fromBundle(getArguments()).getRefreshToken();
//        Log.d("Tag",refreshToken);

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
        childList = (List<ChildModel>) Model.instance.getAllChildren();
        spinner = view.findViewById(R.id.fragment_Parent_spinner);
        ChildAdapter childAdapter = new ChildAdapter(getContext(),childList);
        spinner.setAdapter(childAdapter);



        /////////////////////////////////////////////////////////////Done/////////////////////////////////////////////////////////////
        bData = new ArrayList<TransactionModel>();
        recyclerView = view.findViewById(R.id.rv_balance);
        setDataAdapter();

        return view;
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
    public class ChildAdapter extends BaseAdapter {


            private Context context;
            private List<ChildModel> childModels;

            public ChildAdapter(Context context, List<ChildModel> childModels) {
                this.context = context;
                this.childModels = childModels;
            }

            @Override
            public int getCount() {
                return childModels != null ? childModels.size() : 0;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View rootView = LayoutInflater.from(context)
                        .inflate(R.layout.item_childs, viewGroup, false);


                nameTxt = rootView.findViewById(R.id.spinner_name_tv);
                photo = rootView.findViewById(R.id.spinner_photo_item);
                nameTxt.setText(childList.get(i).getName());



                return rootView;
            }
    }
}