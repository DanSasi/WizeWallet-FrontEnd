package com.hit.wizewalletapp.api;

import com.hit.wizewalletapp.api.responses.LoginResponse;
import com.hit.wizewalletapp.api.responses.ServerResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/auth/login")
    Call<LoginResponse> executeLogin(@Body HashMap<String, String> map);

    @POST("/auth/register")
    Call<Void> executeRegister(@Body HashMap<String, String> map);

    @POST("/auth/logout")
    Call<Void> executeLogout(@HeaderMap HashMap<String, String> map);

    @POST("/link")
    Call<ServerResponse> executeLinkChildToParent(@HeaderMap HashMap<String, String> map,@Body HashMap<String, Object> map2);

    @GET("/link")
    Call<ServerResponse> getAllKidsForParent(@HeaderMap HashMap<String, String> map);

    @POST("/task")
    Call<Void> executeAddTasks(@HeaderMap HashMap<String,String> map1 ,@Body HashMap<String, Object> map2);

    @GET("/task/kid")
    Call<ServerResponse> getChildTaskById(@HeaderMap HashMap<String, String> map);

    @POST("/child/transactions")
    Call<Void> executeChildTransactions(@HeaderMap HashMap<String, String> map1, @Body HashMap<String, Object> map);

    @GET("/child/transactions")
    Call<ServerResponse> getAllTransForChild(@HeaderMap HashMap<String, String> map);

    @POST("/child/transactions/parent")
    Call<ServerResponse> getAllTransForChildByParent(@HeaderMap HashMap<String, String> map, @Body HashMap<String, Object> map2);

}

