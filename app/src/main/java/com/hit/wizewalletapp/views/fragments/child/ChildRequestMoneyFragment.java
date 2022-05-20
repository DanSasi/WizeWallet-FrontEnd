package com.hit.wizewalletapp.views.fragments.child;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.hit.wizewalletapp.model.child.ChildRequestModel;
import com.hit.wizewalletapp.model.ChildListModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.utilities.Utilities;

import java.util.HashMap;


public class ChildRequestMoneyFragment extends Fragment {
    EditText requestMoneyAmount;
    EditText requestMoneyMessage;
    Button sendRequestBtn;
    ImageView arrowBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_child_request_money, container, false);
        requestMoneyAmount = view.findViewById(R.id.child_request_payment_amount_et);
        requestMoneyMessage = view.findViewById(R.id.child_request_payment_desc_et);
        sendRequestBtn = view.findViewById(R.id.child_request_payment_btn);


        sendRequestBtn.setOnClickListener(v-> save());

        arrowBack = view.findViewById(R.id.child_request_imgbtn_backarrow);

        arrowBack.setOnClickListener(v->Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());


        return view;
    }

    private void save() {

        String amount = requestMoneyAmount.getText().toString();
        String message = requestMoneyMessage.getText().toString();
        if(Utilities.verifyAllTextNotEmpty(amount,message)){
            String token = CacheUtilities.getAcssesToken(requireContext());
            HashMap<String,Object> bodyRequest = new HashMap<>();
            bodyRequest.put("message",message);
            bodyRequest.put("amount",Integer.parseInt(amount));
            ApiCallsHelper.performChildRequestAmount(token, bodyRequest, new CustomCallBack<Void>() {
                @Override
                public void onSuccesses(Void response) {
                    ChildRequestModel childRequestModel = new ChildRequestModel(message,Integer.parseInt(amount));
                    ChildListModel.instance.addChildRequst(childRequestModel);
                    Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp();
                }

                @Override
                public void onFailure(String msg) {
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}

