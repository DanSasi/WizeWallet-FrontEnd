package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.model.child.ChildRequestModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildAdapterSpinner;
import com.hit.wizewalletapp.adapters.child.ChildRequestListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.List;


public class ParentMoneyRequestsFragment extends Fragment implements ChildRequestListAdapter.OnItemClickListener {
    Spinner spinner;
    RecyclerView rv;
    ImageView arrowBack;
    private final ChildRequestListAdapter listAdapter = new ChildRequestListAdapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_parent_money_requests, container, false);

        rv =view.findViewById(R.id.parent_requests_rv);
        initRecyclerView(view);
        arrowBack = view.findViewById(R.id.child_task_back_arrow);
        arrowBack.setOnClickListener(v-> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());
        spinner =view.findViewById(R.id.parent_request_spinner);
        setSpinner(spinner);

        return view;
    }
    private void initRecyclerView(View view) {
        rv =view.findViewById(R.id.parent_requests_rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(this);

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
                    fetchRequestsForChild(selectChildId);
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

    }
    private void fetchRequestsForChild(String selectChildId) {
        String token= CacheUtilities.getAcssesToken(requireContext());
        ApiCallsHelper.performGetAllChildRequests(token, selectChildId, new CustomCallBack<List<ChildRequestModel>>() {
            @Override
            public void onSuccesses(List<ChildRequestModel> response) {
                listAdapter.updateRequestList(response);
            }

            @Override
            public void onFailure(String msg) {

            }
        });

    }




    @Override
    public void onItemClick(ChildRequestModel childModel) {
        Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentMoneyRequestsFragmentDirections
                        .actionParentMoneyRequestsToAcceptOrRejectFragment(childModel.getmMessage(),childModel.getmAmount(), childModel.get_id()));

    }
}