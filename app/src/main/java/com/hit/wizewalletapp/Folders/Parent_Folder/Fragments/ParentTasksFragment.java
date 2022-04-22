package com.hit.wizewalletapp.Folders.Parent_Folder.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.hit.wizewalletapp.R;

public class ParentTasksFragment extends Fragment {


    ImageView backArrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks_parent_screen, container, false);

        backArrow = view.findViewById(R.id.topuparrow);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_parentTasksScreen_to_homeParentFragment);
            }
        });
        return view;
    }


}