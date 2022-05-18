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
import android.widget.Toast;

import com.hit.wizewalletapp.Main.Parent_Folder.Fragments.ChildDetailsScreenFragmentArgs;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.HashMap;


public class ChildTaskDetailsFragment extends Fragment {

    TextView amount, desc;
    Button finish_btn,accept_btn;
    ImageButton back_arrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_task_details, container, false);
        back_arrow = view.findViewById(R.id.img_back_arrow_task_details);
        back_arrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(), R.id.nav_host).navigateUp());
        initViews(view);

        return view;
    }

    private void initViews(View view) {
        accept_btn = view.findViewById(R.id.accept_task_button);
        finish_btn = view.findViewById(R.id.finish_task_btn);
        amount = view.findViewById(R.id.child_amount_task_tv);
        desc = view.findViewById(R.id.child_task_description_tv);
        if (!ChildTaskDetailsFragmentArgs.fromBundle(getArguments()).getIsParent()) {
            finish_btn.setVisibility(View.VISIBLE);
            finish_btn.setOnClickListener(v -> {
                String token = CacheUtilities.getAcssesToken(requireContext());
                HashMap<String, Object> bodyMap = new HashMap<>();
                bodyMap.put("_id", ChildTaskDetailsFragmentArgs.fromBundle(getArguments()).getId());
                ApiCallsHelper.onCompletedTask(token, bodyMap, new CustomCallBack<Void>() {
                    @Override
                    public void onSuccesses(Void response) {
                        Navigation.findNavController(requireActivity(), R.id.nav_host).navigateUp();
                    }

                    @Override
                    public void onFailure(String msg) {
                        Toast.makeText(requireContext(), "Error" + msg, Toast.LENGTH_LONG).show();
                    }
                });
            });
        }else{
            accept_btn.setVisibility(View.VISIBLE);
            accept_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        String message_desc = ChildTaskDetailsFragmentArgs.fromBundle(getArguments()).getDescription();
        desc.setText(message_desc);
        Integer message_amount = ChildTaskDetailsFragmentArgs.fromBundle(getArguments()).getAmount();
        amount.setText(message_amount.toString());

    }


}