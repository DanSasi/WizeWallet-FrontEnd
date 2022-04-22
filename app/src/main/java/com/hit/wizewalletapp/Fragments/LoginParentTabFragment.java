package com.hit.wizewalletapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.hit.wizewalletapp.Activities.General_Activites.LoginResult;
import com.hit.wizewalletapp.Activities.General_Activites.RetrofitInterface;
import com.hit.wizewalletapp.Activities.Parent_Folder.Activities.MainActivity;
import com.hit.wizewalletapp.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginParentTabFragment extends Fragment  {

    TextView email;
    TextView password;
    TextView logAs;
    Spinner userSpinner;
    TextView forgetPass;
    Button login;

    //Retrofit, the URL is the phone emulator + server port
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    //    CustomSpinner spinner;
    float v = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savadInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_parent_fragment, container, false);

        //Retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        email = root.findViewById(R.id.child_username);
        password = root.findViewById(R.id.password);
        forgetPass = root.findViewById(R.id.forgetPass);
        login = root.findViewById(R.id.login);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the user mail and password put in map and send to server
                HashMap<String, String> userLoginMap = new HashMap<>();
                userLoginMap.put("email", email.getText().toString());
                userLoginMap.put("password", password.getText().toString());

                //send the request to the server side
                Call<LoginResult> call = retrofitInterface.executeLogin(userLoginMap);

                //get the response from server side
                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        //code 200 is OK , 400 not
                        if (response.code() == 200) {
                            //get the result from the response body
                            //check if we get tha token right
                            LoginResult loginResult = response.body();
                            String accessToken = loginResult.getAccessToken();
                            String refreshToken = loginResult.getRefreshToken();

                            Log.d("TAG",accessToken);
                            Log.d("TAG",refreshToken);
                            login.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getActivity(), MainActivity.class);
                                    startActivity(intent);
                                }
                            });

                            Toast.makeText(v.getContext(), "Login OK", Toast.LENGTH_LONG).show();
                        } else if (response.code() == 400) {
                            Toast.makeText(v.getContext(), "wrong email or password/already have user", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        Toast.makeText(v.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String item = userSpinner.getSelectedItem().toString();
//                if (item.equals("Parent")) {
//                    Intent intent = new Intent(getActivity(), SendMoneyScreen.class);
//                    startActivity(intent);
//                } else if (item.equals("Child")) {
//                    Intent intent = new Intent(getActivity(), BalanceScreen.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });


        email.setTranslationX(800);
        password.setTranslationX(800);
        forgetPass.setTranslationX(800);
        login.setTranslationX(800);



        email.setAlpha(v);
        password.setAlpha(v);
        forgetPass.setAlpha(v);
        login.setAlpha(v);


        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();


        return root;


    }


}
