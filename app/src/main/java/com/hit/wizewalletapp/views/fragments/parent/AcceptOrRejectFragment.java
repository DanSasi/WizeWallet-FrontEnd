package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.Date;
import java.util.HashMap;


public class AcceptOrRejectFragment extends Fragment {
    TextView message_Tv;
    TextView amount_Tv,date_Tv;
    Button accept_Btn;
    Button reject_Btn;
    ImageButton backButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_accept_or_reject, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        accept_Btn = view.findViewById(R.id.child_accecpt_request);
        reject_Btn = view.findViewById(R.id.child_reject_request);
        message_Tv = view.findViewById(R.id.child_request_message_tv);
        amount_Tv = view.findViewById(R.id.child_request_details_amount_tv);
        backButton = view.findViewById(R.id.img_back_arrow_task_details);
        String message_desc = AcceptOrRejectFragmentArgs.fromBundle(getArguments()).getMessage();
        message_Tv.setText(message_desc);
        Integer amount_desc = AcceptOrRejectFragmentArgs.fromBundle(getArguments()).getAmount();
        amount_Tv.setText(amount_desc.toString());
        backButton.setOnClickListener(v -> Navigation.findNavController(getActivity(), R.id.nav_host).navigateUp());

        accept_Btn.setVisibility(View.VISIBLE);
        reject_Btn.setVisibility(View.VISIBLE);
        reject_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = CacheUtilities.getAcssesToken(requireContext());
                HashMap<String, Object> bodyMap = new HashMap<>();
                bodyMap.put("_id",AcceptOrRejectFragmentArgs.fromBundle(getArguments()).getId());
                ApiCallsHelper.onRejectChildRequest(token, bodyMap, new CustomCallBack<Void>() {
                    @Override
                    public void onSuccesses(Void response) {
                        Navigation.findNavController(requireActivity(), R.id.nav_host).navigate(AcceptOrRejectFragmentDirections.
                               actionAcceptOrRejectFragmentToRejectSplashFragment());
                    }

                    @Override
                    public void onFailure(String msg) {
                        Toast.makeText(requireContext(), "Error" + msg, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        accept_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = CacheUtilities.getAcssesToken(requireContext());
                HashMap<String, Object> bodyMap = new HashMap<>();
                bodyMap.put("_id",AcceptOrRejectFragmentArgs.fromBundle(getArguments()).getId());
                ApiCallsHelper.onAcceptChildRequest(token, bodyMap, new CustomCallBack<Void>() {
                    @Override
                    public void onSuccesses(Void response) {
                        Navigation.findNavController(requireActivity(), R.id.nav_host).navigate(AcceptOrRejectFragmentDirections
                                .actionAcceptOrRejectFragmentToAcceptedSplashFragment());
                    }

                    @Override
                    public void onFailure(String msg) {
                        Toast.makeText(requireContext(), "Error" + msg, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }


}