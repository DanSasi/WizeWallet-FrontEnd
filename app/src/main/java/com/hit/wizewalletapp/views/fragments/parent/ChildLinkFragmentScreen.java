package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.api.responses.ServerResponse;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.utilities.Utilities;


public class ChildLinkFragmentScreen extends Fragment {

    private Button sendLinkButton;
    private EditText linkIdEditText;
    private ImageView back_arrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_child_link, container, false);
        initViews(view);
        sendLinkButton.setOnClickListener( v -> linkChildToParent());
        back_arrow = view.findViewById(R.id.img_back_arrow_contact);
        back_arrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());
        return view;

    }

    private void linkChildToParent() {
        String kidId = linkIdEditText.getText().toString();
        if(Utilities.verifyAllTextNotEmpty(kidId)){
            String token = CacheUtilities.getAcssesToken(requireContext());
            ApiCallsHelper.preformLinkChildToParent(token, Integer.parseInt(kidId), new CustomCallBack<ServerResponse>() {
                @Override
                public void onSuccesses(ServerResponse response) {
                    Toast.makeText(requireActivity(), "Kid id: "  +kidId + " " + "was added the Children list!",Toast.LENGTH_LONG).show();
                    Navigation.findNavController(requireActivity(), R.id.nav_host).navigateUp();
                }
                @Override
                public void onFailure(String msg) {
                    Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            Toast.makeText(requireContext(),"Fill fields",Toast.LENGTH_SHORT).show();
        }


    }

    private void initViews(View view) {
        sendLinkButton = view.findViewById(R.id.sendLink);
        linkIdEditText = view.findViewById(R.id.parent_add_task_id_et);
    }
}