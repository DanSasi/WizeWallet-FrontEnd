package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.model.child.TaskChildModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildAdapterSpinner;
import com.hit.wizewalletapp.adapters.child.ChildTaskListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.List;

public class ParentTasksScreenFragment extends Fragment implements ChildTaskListAdapter.OnItemClickListener {


    private final ChildTaskListAdapter listAdapter = new ChildTaskListAdapter();
    private RecyclerView taskParentRv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks_parent_screen, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        ImageView backArrow = view.findViewById(R.id.child_task_back_arrow);
        Button addTaskBtn = view.findViewById(R.id.parent_task_add_btn);
        addTaskBtn.setOnClickListener(Navigation.createNavigateOnClickListener(ParentTasksScreenFragmentDirections
                .actionParentTasksScreenToParentAddTaskFragment()));

        backArrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(), R.id.nav_host).navigateUp());
        Spinner childrenTaskSpinner = (Spinner)view.findViewById(R.id.parent_task_spinner);
        initRecyclerView(view);
        setSpinner(childrenTaskSpinner);


    }

    private void initRecyclerView(View view) {
        taskParentRv = view.findViewById(R.id.child_task_rv);
        taskParentRv.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        taskParentRv.setLayoutManager(linearLayoutManager);
        taskParentRv.setAdapter(listAdapter);
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
                fetchTasksForChild(selectChildId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void fetchTasksForChild(String selectChildId) {
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


    @Override
    public void onItemClick(TaskChildModel childModel) {
        Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(ParentTasksScreenFragmentDirections
                        .actionParentTasksScreenToChildTaskDetailsFragment(childModel.getMessage(),childModel.getAmount(),childModel.get_id(),true));

    }
}