package com.hit.wizewalletapp.views.fragments.child.needapi;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.hit.wizewalletapp.R;

public class ChildTipsScreenFragment extends Fragment {

        ImageView backArrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tips_child_screen, container, false);



        backArrow = view.findViewById(R.id.details_arrow_back);



        backArrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());

            return view;
        }

    }
