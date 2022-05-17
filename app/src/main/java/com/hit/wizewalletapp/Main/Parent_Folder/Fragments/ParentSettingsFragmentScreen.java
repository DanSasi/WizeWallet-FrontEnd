package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.hit.wizewalletapp.R;


public class ParentSettingsFragmentScreen extends Fragment {

    ImageButton back_arrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_parent_settings_screen, container, false);
        back_arrow = view.findViewById(R.id.img_back_arrow_contact);
        back_arrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());
        return view;
    }
}