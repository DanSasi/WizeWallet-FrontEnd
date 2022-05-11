package com.hit.wizewalletapp.Main.Child_Folder.Fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTaskModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildTaskListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.List;

public class ChildTasksScreenFragment extends Fragment {


    private RecyclerView childTaskRv;
    private final ChildTaskListAdapter listAdapter = new ChildTaskListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tasks_child_screen, container, false);

        fetchData();
        initRecyclerView(view);

        return view;
    }

    private void initRecyclerView(View view) {
        childTaskRv = view.findViewById(R.id.child_task_rv);
        childTaskRv.setHasFixedSize(true);
        childTaskRv.setLayoutManager(new LinearLayoutManager(getContext()));
        childTaskRv.setAdapter(listAdapter);
    }


    //
    private void fetchData() {

        String token = CacheUtilities.getAcssesToken(requireContext());
            ApiCallsHelper.performChildGetTaskById(token, new CustomCallBack<List<ChildTaskModel>>() {
            @Override
            public void onSuccesses(List<ChildTaskModel> response) {
                listAdapter.updateList(response);
            }

            @Override
            public void onFailure(String msg) {
                //....
            }
        });


    }

}

