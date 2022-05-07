package com.hit.wizewalletapp.api;

import com.hit.wizewalletapp.api.responses.LoginResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/auth/login")
    Call<LoginResponse> executeLogin(@Body HashMap<String,String> map);

    @POST("/auth/register")
    Call<Void> executeRegister(@Body HashMap<String,String> map);

    @POST("/auth/logout")
    Call<Void> executeLogout(@HeaderMap HashMap<String,String>map);





}

