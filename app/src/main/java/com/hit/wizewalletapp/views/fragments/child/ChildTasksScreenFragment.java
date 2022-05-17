package com.hit.wizewalletapp.views.fragments.child;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.TaskChildModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildTaskListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.List;

public class ChildTasksScreenFragment extends Fragment implements ChildTaskListAdapter.OnItemClickListener {

    private ImageView back_arrow;
    private RecyclerView childTaskRv;
    private final ChildTaskListAdapter listAdapter = new ChildTaskListAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tasks_child_screen, container, false);
        initRecyclerView(view);
        fetchData();
        back_arrow = view.findViewById(R.id.child_task_back_arrow);
        back_arrow.setOnClickListener(v-> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());

        return view;
    }

    private void initRecyclerView(View view) {
        childTaskRv = view.findViewById(R.id.child_task_rv);
        childTaskRv.setHasFixedSize(true);
        childTaskRv.setLayoutManager(new LinearLayoutManager(getContext()));
        childTaskRv.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(this);

    }



    private void fetchData() {

        String token = CacheUtilities.getAcssesToken(requireContext());
        ApiCallsHelper.performChildGetTaskById(token, new CustomCallBack<List<TaskChildModel>>() {
            @Override
            public void onSuccesses(List<TaskChildModel> response) {
                listAdapter.updateTaskList(response);
                childTaskRv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(String msg) {
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onItemClick(TaskChildModel childModel) {
        Navigation.findNavController(requireActivity(),R.id.nav_host).
                navigate(ChildTasksScreenFragmentDirections.actionChildTasksScreenFragmentToChildTaskDetailsFragment(childModel.getMessage()));

    }
}

