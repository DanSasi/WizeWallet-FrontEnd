package com.hit.wizewalletapp.Main.General_Folder.GeneralFragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.hit.wizewalletapp.Main.Child_Folder.Activites.ChildBalanceActivity;
import com.hit.wizewalletapp.Main.General_Folder.GeneralActivites.LoginResult;
import com.hit.wizewalletapp.Main.General_Folder.GeneralActivites.RetrofitInterface;
import com.hit.wizewalletapp.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginChildFragment extends Fragment {
    TextView userName;
    TextView password;
    TextView forgetPass;
    Button login;
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savadInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_child_fragment, container, false);
        userName = root.findViewById(R.id.child_username);
        password = root.findViewById(R.id.password);
        forgetPass = root.findViewById(R.id.forgetPass);
        login = root.findViewById(R.id.login);
        //Retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the user mail and password put in map and send to server
                HashMap<String, String> userLoginMap = new HashMap<>();
                userLoginMap.put("email", userName.getText().toString());
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
                                    Intent intent = new Intent(getActivity(), ChildBalanceActivity.class);
                                    startActivity(intent);
                                }
                            });

                            Toast.makeText(v.getContext(), "Login OK", Toast.LENGTH_LONG).show();
                        } else if (response.code() == 400) {
                            Toast.makeText(v.getContext(), "wrong username or password/already have user", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        Toast.makeText(v.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

        return root;
    }
}