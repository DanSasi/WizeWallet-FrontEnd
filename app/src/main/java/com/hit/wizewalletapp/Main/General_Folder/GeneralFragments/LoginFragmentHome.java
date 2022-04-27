package com.hit.wizewalletapp.Main.General_Folder.GeneralFragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.hit.wizewalletapp.Adapters.General_Adapters.SpinnerUserAdater;
import com.hit.wizewalletapp.Main.General_Folder.GeneralActivites.LoginResult;
import com.hit.wizewalletapp.Main.General_Folder.GeneralActivites.RetrofitInterface;
import com.hit.wizewalletapp.Main.General_Folder.Models.SpinnerData;
import com.hit.wizewalletapp.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("ALL")
public class LoginFragmentHome extends Fragment {

//    Button loginButton;


    View myFragmet;
    EditText email;
    EditText password;
    Spinner userSpinner;
    TextView forgetPass;
    TextView regisger;
    Button login;
    SpinnerUserAdater adapter;


    //Retrofit, the URL is the phone emulator + server port
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    float v = 0;





    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savadInstanceState) {
        myFragmet = inflater.inflate(R.layout.fragment_login_home, container, false);

        email = myFragmet.findViewById(R.id.fragment_home_email_et);
        password = myFragmet.findViewById(R.id.fragment_home_password_et);
        forgetPass = myFragmet.findViewById(R.id.fragment_home_forgetpass_tv);
        regisger = myFragmet.findViewById(R.id.fragment_home_register_tv);
        userSpinner = myFragmet.findViewById(R.id.fragment_home_spinner);
        login = myFragmet.findViewById(R.id.fragment_home_login_btn);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);


        adapter = new SpinnerUserAdater(getContext(), SpinnerData.getSpinnerList());
        userSpinner.setAdapter(adapter);


        regisger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loginFragmentHome_to_signupTabFragment);
            }
        });

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

                            String item = userSpinner.getSelectedItem().toString();
                            if (item.equals("Parent")) {
                                //how to pass data to fragment in the nav grahf
                                Navigation.findNavController(v).navigate(LoginFragmentHomeDirections.actionLoginFragmentHomeToHomeParentFragment(refreshToken));

                            } else if (item.equals("Child")) {
                                Navigation.findNavController(v).navigate(LoginFragmentHomeDirections.actionLoginFragmentHomeToChildBalanceHomeScreenFragment(refreshToken));
                            } else {
                                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                            }

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

        return myFragmet;
    }





}