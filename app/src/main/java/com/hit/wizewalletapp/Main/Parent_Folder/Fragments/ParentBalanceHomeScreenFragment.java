package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

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

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.ChildListModel;
import com.hit.wizewalletapp.adapters.General_Adapters.SpinnerUserAdater;
import com.hit.wizewalletapp.Main.Child_Folder.Fragments.ChildTransactionHistoryScreenFragment;
import com.hit.wizewalletapp.adapters.Parent_Adapters.BalanceListParentAdapter;
import com.hit.wizewalletapp.Main.General_Folder.Models.SpinnerData;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.BalanceParentModel;
import com.hit.wizewalletapp.R;

import java.util.ArrayList;
import java.util.List;


public class ParentBalanceHomeScreenFragment extends Fragment implements BalanceListParentAdapter.BalanceViewHolder.RecycleViewClickListener {

    BalanceListParentAdapter balanceListAdapter;
    ArrayList<BalanceParentModel> bData;
    static List<ChildModel> childList;
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
        childList = ChildListModel.instance.getAllData();
        spinner = view.findViewById(R.id.fragment_Parent_spinner);
        ChildAdapter childAdapter = new ChildAdapter(getContext(),childList);
        spinner.setAdapter(childAdapter);



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
                photo.setImageResource(childList.get(i).getPhoto());


                return rootView;
            }
    }
}