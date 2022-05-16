package com.hit.wizewalletapp.Main.Child_Folder.Fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.TaskChildModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildTaskListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.List;

public class ChildTasksScreenFragment extends Fragment implements  ChildTaskListAdapter.OnItemClickListener {


    private RecyclerView childTaskRv;
    private final ChildTaskListAdapter listAdapter = new ChildTaskListAdapter();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tasks_child_screen, container, false);

        initRecyclerView(view);
        fetchData();

        return view;
    }

    private void initRecyclerView(View view) {
        childTaskRv = view.findViewById(R.id.child_task_rv);
        childTaskRv.setHasFixedSize(true);
        childTaskRv.setLayoutManager(new LinearLayoutManager(getContext()));
        childTaskRv.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(this);

    }


    //
    private void fetchData() {
//        progressBar.setVisibility(View.VISIBLE);
        String token = CacheUtilities.getAcssesToken(requireContext());
        ApiCallsHelper.performChildGetTaskById(token, new CustomCallBack<List<TaskChildModel>>() {
            @Override
            public void onSuccesses(List<TaskChildModel> response) {
                listAdapter.updateTaskList(response);
//                progressBar.setVisibility(View.GONE);
                childTaskRv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                //  progressBar.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onItemClick(TaskChildModel childModel) {

    }
}

