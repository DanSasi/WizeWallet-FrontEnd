package com.hit.wizewalletapp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.hit.wizewalletapp.Activities.General_Activites.RetrofitInterface;
import com.hit.wizewalletapp.Activities.Parent_Folder.Activities.MainActivity;
import com.hit.wizewalletapp.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupTabFragment extends Fragment {


    private EditText userEmail, userPassword, userFullName;

    private Button userSignUpButton;
    float v = 0;

    //Retrofit, the URL is the phone emulator + server port
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        //Retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        userFullName = root.findViewById(R.id.fullname);
        userEmail = root.findViewById(R.id.etrEmail);
        userPassword = root.findViewById(R.id.compassword);
        userSignUpButton = root.findViewById(R.id.SignUp);


        userSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the user mail and password put in map and send to server
                HashMap<String, String> userRegisterMap = new HashMap<>();
                userRegisterMap.put("email", userEmail.getText().toString());
                userRegisterMap.put("password", userPassword.getText().toString());

                //send the request to the server side
                Call<Void> call = retrofitInterface.executeRegister(userRegisterMap);

                //get the response from server side
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        //code 200 is OK , 400 not
                        if (response.code() == 200) {
                            Toast.makeText(v.getContext(), "register OK", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else if (response.code() == 400) {
                            Toast.makeText(v.getContext(), "wrong email or password/already have user", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(v.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        return root;
    }


}