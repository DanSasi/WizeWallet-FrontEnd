package com.hit.wizewalletapp.Activities;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface RetrofitInterface {
    //give here the root in the server side
    //in the body we give map, is like json object

    @POST("/auth/login")
    Call<LoginResult> executeLogin(@Body HashMap<String,String> map);

    @POST("/auth/register")
    Call<Void> executeRegister(@Body HashMap<String,String> map);

    //here we send the header to logout, header is like json
    @POST("/auth/logout")
    Call<Void> executeLogout(@HeaderMap HashMap<String,String>map);

}
