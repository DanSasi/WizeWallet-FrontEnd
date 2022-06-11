package com.hit.wizewalletapp.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.api.RetrofitInterface;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.utilities.Utilities;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupFragment extends Fragment {

    private EditText emailEditText, passwordEditText, userFullName;
    private Button userSignUpButton;
    private ProgressBar progressBar_signUp;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);
        initViews(root);
        userSignUpButton.setOnClickListener( v -> preformSignUp());
        return root;
    }

    private void initViews(View root) {
        userFullName = root.findViewById(R.id.fullname);
        emailEditText = root.findViewById(R.id.etrEmail);
        passwordEditText = root.findViewById(R.id.compassword);
        userSignUpButton = root.findViewById(R.id.SignUp);
        progressBar_signUp = root.findViewById(R.id.progressBar3);
    }

    private void preformSignUp() {
        String name = userFullName.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        progressBar_signUp.setVisibility(View.VISIBLE);
        if (Utilities.verifyAllTextNotEmpty(email, password,name)) {
            HashMap<String, String> bodyMap = new HashMap<>();
            bodyMap.put("email",email );
            bodyMap.put("password",password);
            bodyMap.put("name",name);
            ApiCallsHelper.performRegister(bodyMap, new CustomCallBack<Void>() {
                @Override
                public void onSuccesses(Void response) {
                    Navigation.findNavController(requireActivity(), R.id.nav_host).navigateUp();

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
}