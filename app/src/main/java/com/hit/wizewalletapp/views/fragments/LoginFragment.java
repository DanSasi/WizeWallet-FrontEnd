package com.hit.wizewalletapp.views.fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.hit.wizewalletapp.adapters.General_Adapters.SpinnerUserAdater;
import com.hit.wizewalletapp.Main.General_Folder.Models.SpinnerData;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.api.responses.LoginResponse;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.utilities.Utilities;

@SuppressWarnings("ALL")
public class LoginFragment extends Fragment {

    private EditText emailEditText, passwordEditText;
    private Spinner userSpinner;
    private TextView forgetPass;
    private TextView logas;
    private TextView regisger , wellcomTv;
    private Button login;
    private ImageView mainIconIv;
    private SpinnerUserAdater adapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savadInstanceState) {
        View myFragmet = inflater.inflate(R.layout.fragment_login_home, container, false);
        initViews(myFragmet);
        regisger.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host)
                .navigate(LoginFragmentDirections
                        .actionLoginFragmentHomeToSignupTabFragment()));

        login.setOnClickListener(v -> preformLogin());
        return myFragmet;
    }

    private void preformLogin() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if (Utilities.verifyAllTextNotEmpty(email, password)) {
            ApiCallsHelper.performLogin(email, password, new CustomCallBack<LoginResponse>() {
                @Override
                public void onSuccesses(LoginResponse response) {
                    CacheUtilities.saveToken(getContext(),"authorization "+response.getRefreshToken(),"authorization "+response.getAccessToken());
                    String item = userSpinner.getSelectedItem().toString();
                    if (item.equals("Parent")) {
                        Navigation.findNavController(getActivity(), R.id.nav_host)
                                .navigate(LoginFragmentDirections
                                .actionLoginFragmentHomeToHomeParentFragment(response.getRefreshToken(),email));
                    } else if (item.equals("Child")) {
                        Navigation.findNavController(getActivity(), R.id.nav_host)
                                .navigate(LoginFragmentDirections
                                        .actionLoginFragmentHomeToChildBalanceHomeScreenFragment(response.getRefreshToken()));
                    }
                }

                @Override
                public void onFailure(String msg) {
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Toast.makeText(getActivity(), "Please fill fields", Toast.LENGTH_LONG).show();
        }
    }

    private void initViews(View fragment) {
        float v = 0 ;
        emailEditText = fragment.findViewById(R.id.fragment_home_email_et);
        passwordEditText = fragment.findViewById(R.id.fragment_home_password_et);
        forgetPass = fragment.findViewById(R.id.fragment_home_forgetpass_tv);
        regisger = fragment.findViewById(R.id.fragment_home_register_tv);
        userSpinner = fragment.findViewById(R.id.fragment_home_spinner);
        login = fragment.findViewById(R.id.fragment_home_login_btn);
        mainIconIv = fragment.findViewById(R.id.fragment_loging_icon_imgv);
        wellcomTv = fragment.findViewById(R.id.fragment_login_man_tv);
        logas = fragment.findViewById(R.id.fragment_home_log_as);
        adapter = new SpinnerUserAdater(getContext(), SpinnerData.getSpinnerList());
        userSpinner.setAdapter(adapter);

        emailEditText.setTranslationX(50);
        passwordEditText.setTranslationX(50);
        forgetPass.setTranslationX(50);
        userSpinner.setTranslationX(50);
        login.setTranslationX(50);
        mainIconIv.setTranslationX(50);
        wellcomTv.setTranslationX(50);
        logas.setTranslationX(50);

        emailEditText.setAlpha(v);
        passwordEditText.setAlpha(v);
        forgetPass.setAlpha(v);
        userSpinner.setAlpha(v);
        login.setAlpha(v);
        mainIconIv.setAlpha(v);
        logas.setAlpha(v);
        wellcomTv.setAlpha(v);

        emailEditText.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        passwordEditText.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        forgetPass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        userSpinner.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        mainIconIv.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        wellcomTv.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        logas.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
    }




}