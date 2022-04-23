package com.hit.wizewalletapp.Folders.Child_Folder.Fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hit.wizewalletapp.R;

public class ChildTasksScreenFragment extends Fragment {


    ImageView backArrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks_child_screen, container, false);
        backArrow = view.findViewById(R.id.topuparrow);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_childTasksFragment_to_childBalanceHomeFragment);
            }
        });
        return view;
    }


}