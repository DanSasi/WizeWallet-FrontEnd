package com.hit.wizewalletapp.Main.General_Folder.GeneralActivites;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface RetrofitInterface {
    //give here the root in the server side
    //in the body we give map, is like json object

    @POST("/auth/login")
    Call<LoginResult> executeLogin(@Body HashMap<String,String> map);

    @POST("/auth/register")
    Call<Void> executeRegister(@Body HashMap<String,String> map);

    @POST("/auth/logout")
    Call<Void> executeLogout(@HeaderMap HashMap<String,String>map);


}
