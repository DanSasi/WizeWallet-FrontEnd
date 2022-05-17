package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.TaskChildModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.ChildListModel;
import com.hit.wizewalletapp.adapters.child.ChildAdapterSpinner;
import com.hit.wizewalletapp.adapters.child.ChildTaskListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.views.activity.PaymentSplashScreen;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.R;

import java.util.List;


public class SendMoneyScreenFragment extends Fragment {

    private final ChildTaskListAdapter listAdapter = new ChildTaskListAdapter();
    //private static ChildListScreenFragment.MyChildAdapter adapter;
    ImageView arr;
    static List<ChildModel> childList;
    TextView nameTxt;
    ImageView photo;
    TextView bankTxt;
    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        childList = ChildListModel.instance.getAllData();
        View view = inflater.inflate(R.layout.fragment_send_money_screen, container, false);




        SwipeButton swipeButton = view.findViewById(R.id.swipeId);
        spinner = view.findViewById(R.id.send_money_spinner);
        ChildAdapter childAdapter = new ChildAdapter(getContext(),childList);



        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                startActivity(new Intent(getActivity(), PaymentSplashScreen.class ));
            }
        });
        setSpinner(spinner);



        arr = view.findViewById(R.id.IV01);

        arr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp();
            }
        });

        return view;
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


            nameTxt = rootView.findViewById(R.id.parent_task_task_tv);
            photo = rootView.findViewById(R.id.spinner_photo_item);
            nameTxt.setText(childList.get(i).getName());
            photo.setImageResource(childList.get(i).getPhoto());


            return rootView;
        }
    }
    private void setSpinner(Spinner spinner) {
        ChildAdapterSpinner childAdapter = new ChildAdapterSpinner(getContext());
        spinner.setAdapter(childAdapter);
        ApiCallsHelper.performGetAllChilds( CacheUtilities.getAcssesToken(requireContext()), new CustomCallBack<List<ChildModel>>() {
            @Override
            public void onSuccesses(List<ChildModel> response) {
                childAdapter.updateList(response);
            }
            @Override
            public void onFailure(String msg) {
            }
        });
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
    }

    private void fetchTransactionsForChild(String selectChildId) {
        String token= CacheUtilities.getAcssesToken(requireContext());
        ApiCallsHelper.performGetAllTaskForChildByParent(token, selectChildId, new CustomCallBack<List<TaskChildModel>>() {
            @Override
            public void onSuccesses(List<TaskChildModel> response) {
                listAdapter.updateTaskList(response);
            }

            @Override
            public void onFailure(String msg) {

            }
        });


    }


}