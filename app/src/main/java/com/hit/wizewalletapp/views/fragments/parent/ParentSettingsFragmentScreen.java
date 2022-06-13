package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.HashMap;


public class ParentSettingsFragmentScreen extends Fragment {

    ImageButton back_arrow;

    EditText currentPasswordEt;
    EditText newPasswordEt;
    Button saveNewPasswordBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_parent_settings_screen, container, false);
        back_arrow = view.findViewById(R.id.img_back_arrow_contact);
        back_arrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());
        initView(view);
        return view;
    }

    private void initView(View view) {

        currentPasswordEt = view.findViewById(R.id.setting_current_password_et);
        newPasswordEt = view.findViewById(R.id.setting_new_password_et);
        saveNewPasswordBtn = view.findViewById(R.id.setting_save_password_Btn);

        saveNewPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token = CacheUtilities.getAcssesToken(requireContext());
                String old_password = currentPasswordEt.getText().toString();
                String new_password = newPasswordEt.getText().toString();
                HashMap<String, String> bodyMap = new HashMap<>();
                bodyMap.put("oldpassword",old_password);
                bodyMap.put("newpassword",new_password);
                ApiCallsHelper.performOnChangePassword(token, bodyMap, new CustomCallBack<Void>() {
                    @Override
                    public void onSuccesses(Void response) {
                        Toast.makeText(requireActivity(),"Password changed successfully!",Toast.LENGTH_LONG).show();
                        Navigation.findNavController(requireActivity(), R.id.nav_host).navigateUp();
                    }

                    @Override
                    public void onFailure(String msg) {
                        Toast.makeText(getActivity(), "You typed wrong the current password", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}