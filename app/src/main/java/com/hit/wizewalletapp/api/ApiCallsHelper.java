package com.hit.wizewalletapp.api;

import com.hit.wizewalletapp.api.responses.LoginResponse;
import com.hit.wizewalletapp.api.responses.ServerResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallsHelper {

    private static final String TAG = "ApiCall";

    public static void performLogin(String email, String password , CustomCallBack<LoginResponse> callback){
        Call<LoginResponse> call = RetrofitInstance.retrofitInterface.executeLogin(getAuthBody(email, password));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(response.body());
                } else if (response.code() == 400) {
                    callback.onFailure("wrong email or password/already have user");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }

    public static void performRegister(HashMap<String,String> map,CustomCallBack<Void> callback) {
        Call<Void> call = RetrofitInstance.retrofitInterface.executeRegister(map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("wrong email or password/already have user");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }


    public static HashMap<String,String> getAuthBody(String email, String password){
        HashMap<String, String> userLoginMap = new HashMap<>();
        userLoginMap.put("email",email );
        userLoginMap.put("password",password);
        return userLoginMap;
    }


    public static void performLogout(String token, CustomCallBack<Void> callback) {
        HashMap<String,String> map = new HashMap<>();
        map.put("authorization",token);
        Call<Void> call = RetrofitInstance.retrofitInterface.executeLogout(map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("wrong email or password/already have user");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }

    public static void preformLinkChildToParent(String token, Integer kidId, CustomCallBack<ServerResponse> callBack) {
        HashMap<String,String> headerMap = new HashMap<>();
        headerMap.put("authorization",token);
        HashMap<String,Object> bodyMap = new HashMap<>();
        bodyMap.put("id",kidId);
        Call<ServerResponse> call = RetrofitInstance.retrofitInterface.executeLinkChildToParent(headerMap,bodyMap);
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callBack.onSuccesses(response.body());
                } else if (response.code() == 400) {
                    callBack.onFailure("");
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                callBack.onFailure(t.getLocalizedMessage());
            }
        });

    }
}