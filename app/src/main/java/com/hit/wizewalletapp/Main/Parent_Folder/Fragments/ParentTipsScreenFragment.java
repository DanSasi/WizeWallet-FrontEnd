package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.hit.wizewalletapp.R;

public class ParentTipsScreenFragment extends Fragment {

        ImageView backArrow;
        private Button button;

      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tips_parent_screen, container, false);


        backArrow = view.findViewById(R.id.details_arrow_back);
        button = view.findViewById( R.id.con_btn);


        backArrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());
            return view;

        }



}
