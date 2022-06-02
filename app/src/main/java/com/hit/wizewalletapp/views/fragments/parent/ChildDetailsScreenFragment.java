package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hit.wizewalletapp.R;


public class ChildDetailsScreenFragment extends Fragment {

    TextView childBalanceTv,childUsernameTv,childIdTv,childNameTv;
    ImageView boyImageView, girlImageView;
    ImageView arrowBack;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_children_details, container, false);
        String childId = ChildDetailsScreenFragmentArgs.fromBundle(getArguments()).getChildId();
        String email = ChildDetailsScreenFragmentArgs.fromBundle(getArguments()).getEmail();

        String childName = ChildDetailsScreenFragmentArgs.fromBundle(getArguments()).getName();
        String childBalance = ChildDetailsScreenFragmentArgs.fromBundle(getArguments()).getChildBalance();
        //ChildModel childModel = ChildListModel.instance.getChildById(childId);
        childBalanceTv= view.findViewById(R.id.parent_add_task_amount_et);
        childUsernameTv = view.findViewById(R.id.add_child_username_et);

        childIdTv = view.findViewById(R.id.parent_add_task_id_et);
        childNameTv =view.findViewById(R.id.add_child_password_et);
        arrowBack =view.findViewById(R.id.details_arrow_back);
        childUsernameTv.setText(email);
        childIdTv.setText(childId);
        childBalanceTv.setText(childBalance);
        childNameTv.setText(childName);
        boyImageView = view.findViewById(R.id.add_child_imgv);
        girlImageView = view.findViewById(R.id.girl_image_view);
        String gender = ChildDetailsScreenFragmentArgs.fromBundle(getArguments()).getImageUrl();
        if(gender!= null ){
            if(gender.equals("Boy")){
                girlImageView.setVisibility(View.GONE);
            }else if(gender.equals("Girl")){
                boyImageView.setVisibility(View.GONE);
            }
        }

        arrowBack.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());
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