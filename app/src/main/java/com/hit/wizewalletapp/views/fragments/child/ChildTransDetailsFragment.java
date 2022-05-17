package com.hit.wizewalletapp.views.fragments.child;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hit.wizewalletapp.R;


public class ChildTransDetailsFragment extends Fragment {

    TextView amount,desc;
    ImageButton back_arrow_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_trans_details, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        desc = view.findViewById(R.id.child_trans_description_tv);
        amount = view.findViewById(R.id.child_amount_trans_amount);
        back_arrow_btn = view.findViewById(R.id.img_back_arrow_trans_details);

        String message_desc = ChildTransDetailsFragmentArgs.fromBundle(getArguments()).getDescription();
        desc.setText(message_desc);
        Integer amount_details = ChildTransDetailsFragmentArgs.fromBundle(getArguments()).getAmount();
        amount.setText(amount_details.toString());

        back_arrow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp();
            }
        });

    }
}