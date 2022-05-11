package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildAdapterSpinner;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.views.fragments.parent.ParentChildsFragmentDirections;

import java.util.List;

public class ParentTasksScreenFragment extends Fragment {



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
        taskParentRv = view.findViewById(R.id.child_task_rv);
        backArrow.setOnClickListener(v -> Navigation.findNavController(getActivity(), R.id.nav_host).navigateUp());

        Spinner childrenTaskSpinner = view.findViewById(R.id.parent_task_spinner);
        setRecycleView(taskParentRv);
        setSpinner(childrenTaskSpinner);

    }

    private void setRecycleView(RecyclerView taskParentRv) {

    }

    private void setSpinner(Spinner childrenTaskSpinner) {
        ChildAdapterSpinner childAdapter = new ChildAdapterSpinner(getContext());
        childrenTaskSpinner.setAdapter(childAdapter);
        ApiCallsHelper.performGetAllChilds( CacheUtilities.getAcssesToken(requireContext()), new CustomCallBack<List<ChildModel>>() {
            @Override
            public void onSuccesses(List<ChildModel> response) {
                childAdapter.updateList(response);
            }
            @Override
            public void onFailure(String msg) {
            }
        });
    }


}