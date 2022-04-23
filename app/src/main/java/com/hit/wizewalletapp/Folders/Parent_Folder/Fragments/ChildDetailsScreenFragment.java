package com.hit.wizewalletapp.Folders.Parent_Folder.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.Models.ChildModel;
import com.hit.wizewalletapp.Models.Model;
import com.hit.wizewalletapp.R;


public class ChildDetailsScreenFragment extends Fragment {

    TextView childBalanceTv,childUsernameTv,childIdTv,childPasswordTv;
    ImageView childImageView;
    Button arrowBack,EditButton,DeleteButton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_child_details, container, false);
        String childId = ChildDetailsScreenFragmentArgs.fromBundle(getArguments()).getChildId();
        ChildModel childModel = Model.instance.getChildById(childId);
        childBalanceTv= view.findViewById(R.id.child_details_balance);
        childUsernameTv = view.findViewById(R.id.details_chaild_username);
        childImageView = view.findViewById(R.id.details_chaild_image);
        childIdTv = view.findViewById(R.id.details_chaild_id);
        childPasswordTv =view.findViewById(R.id.details_chaild_password);



        childIdTv.setText(childModel.getId());
        childUsernameTv.setText(childModel.getName());
        childBalanceTv.setText(childModel.getBalance());
        childPasswordTv.setText(childModel.getPassword());
        childImageView.setImageResource(childModel.getPhoto());



//        arrowBack = view.findViewById(R.id.details_arrow_back);
//        arrowBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(v).navigateUp();
//            }
//        });


        return view;
    }
}