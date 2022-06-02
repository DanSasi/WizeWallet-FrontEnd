package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.List;

@SuppressWarnings("ALL")
public class ParentChildsFragment extends Fragment implements ChildListAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private final ChildListAdapter listAdapter= new ChildListAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_list_screen, container, false);
        initRecyclerView(view);
        initViews(view);
        fetchData();
        ImageButton backArrow = view.findViewById(R.id.img_back_arrow_contact);
        backArrow.setOnClickListener(v->Navigation.findNavController(getActivity(), R.id.nav_host).navigateUp());
        Button addChildBtn = view.findViewById(R.id.add_child_Btn);
        addChildBtn.setOnClickListener(Navigation.createNavigateOnClickListener(ParentChildsFragmentDirections.actionChildListScreenToAddChildFragment()));
        return view;

    }

    private void initViews(View view) {
        ImageButton backArrow = view.findViewById(R.id.img_back_arrow_contact);
        backArrow.setOnClickListener(v ->Navigation.findNavController(getActivity(), R.id.nav_host).navigateUp());
        Button addChildBtn = view.findViewById(R.id.add_child_Btn);
        addChildBtn.setOnClickListener(Navigation.createNavigateOnClickListener(ParentChildsFragmentDirections.actionChildListScreenToAddChildFragment()));
    }

    private void fetchData() {
        String token = CacheUtilities.getAcssesToken(requireContext());
        ApiCallsHelper.performGetAllChilds(token, new CustomCallBack<List<ChildModel>>() {
            @Override
            public void onSuccesses(List<ChildModel> response) {
                listAdapter.updateList(response);
            }
            @Override
            public void onFailure(String msg) {
                    //....
            }
        });
    }

    private void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.child_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(ChildModel childModel) {
        Navigation.findNavController(getActivity(), R.id.nav_host)
                .navigate(ParentChildsFragmentDirections.actionChildListScreenToChildDetailsScreenFragment(
                        childModel.get_id(),
                childModel.getBalance().toString(),childModel.getmName(),childModel.getUserName(),childModel.getImg_url()));
    }
}



