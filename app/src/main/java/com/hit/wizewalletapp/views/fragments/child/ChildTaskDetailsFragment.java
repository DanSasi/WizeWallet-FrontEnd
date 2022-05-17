package com.hit.wizewalletapp.views.fragments.child;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hit.wizewalletapp.Main.Parent_Folder.Fragments.ChildDetailsScreenFragmentArgs;
import com.hit.wizewalletapp.R;


public class ChildTaskDetailsFragment extends Fragment {

    TextView amount, desc;
    Button finish_btn;
    ImageButton back_arrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_task_details, container, false);
        back_arrow = view.findViewById(R.id.img_back_arrow_task_details);
        back_arrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());
        initViews(view);

        return view;
    }

    private void initViews(View view) {

        amount = view.findViewById(R.id.child_amount_task_tv);
        desc = view.findViewById(R.id.child_task_description_tv);
        finish_btn = view.findViewById(R.id.finish_task_btn);
        String message_desc = ChildTaskDetailsFragmentArgs.fromBundle(getArguments()).getDescription();
        desc.setText(message_desc);

    }


}