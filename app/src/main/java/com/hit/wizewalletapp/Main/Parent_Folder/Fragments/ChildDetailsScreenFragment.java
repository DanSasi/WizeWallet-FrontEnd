package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.ChildListModel;
import com.hit.wizewalletapp.R;


public class ChildDetailsScreenFragment extends Fragment {

    TextView childBalanceTv,childUsernameTv,childIdTv,childPasswordTv;
    ImageView childImageView;
    Button arrowBack,EditButton,DeleteButton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_children_details, container, false);
        String childId = ChildDetailsScreenFragmentArgs.fromBundle(getArguments()).getChildId();
        //ChildModel childModel = ChildListModel.instance.getChildById(childId);
        childBalanceTv= view.findViewById(R.id.add_child_balance_et);
        childUsernameTv = view.findViewById(R.id.add_child_username_et);
        childImageView = view.findViewById(R.id.add_child_imgv);
        childIdTv = view.findViewById(R.id.add_child_id_et);
        childPasswordTv =view.findViewById(R.id.add_child_password_et);



        childIdTv.setText(childId);
//        childUsernameTv.setText(childModel.getName());
//        childBalanceTv.setText(childModel.getBalance());
//        childPasswordTv.setText(childModel.getPassword());
//        childImageView.setImageResource(childModel.getPhoto());



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