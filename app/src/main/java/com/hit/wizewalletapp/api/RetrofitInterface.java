package com.hit.wizewalletapp.api;

import com.hit.wizewalletapp.model.child.ChildRequestModel;
import com.hit.wizewalletapp.model.child.TaskChildModel;
import com.hit.wizewalletapp.api.responses.LoginResponse;
import com.hit.wizewalletapp.api.responses.ServerResponse;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @POST("/auth/login")
    Call<LoginResponse> executeLogin(@Body HashMap<String, Object> map);

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
    Call<List<TaskChildModel>> getChildTaskById(@HeaderMap HashMap<String, String> map);

    @POST("/child/transactions")
    Call<Void> executeChildTransactions(@HeaderMap HashMap<String, String> map1, @Body HashMap<String, Object> map);

    @GET("/child/transactions")
    Call<ServerResponse> getAllTransForChild(@HeaderMap HashMap<String, String> map);

    @GET("/child/balance")
    Call<ServerResponse> getBalanceChild(@HeaderMap HashMap<String,String> map);

    @POST("/child/transactions/parent")
    Call<ServerResponse> getAllTransForChildByParent(@HeaderMap HashMap<String, String> map, @Body HashMap<String, Object> map2);

    @POST("/task/parent")
    Call<List<TaskChildModel>> getAllTasksForChildByParent(@HeaderMap HashMap<String, String> map, @Body HashMap<String, Object> map2);

    @POST("/child/sendmoney")
    Call<Void> addChildBalance(@HeaderMap HashMap<String,String> map,@Body HashMap<String,Object> map2);

    @POST("/auth/register/child")
    Call<Void> registerChild(@HeaderMap HashMap<String,String> map,@Body HashMap<String,Object> map2);

    @POST("/task/completed")
    Call<Void> onCompletedTask(@HeaderMap HashMap<String,String> map,@Body HashMap<String,Object> map2);

    @POST("/task/parentaccept")
    Call<Void> onAcceptedTask(@HeaderMap HashMap<String,String> map,@Body HashMap<String,Object> map2);

    @POST("/request")
    Call<Void> addChildRequestAmount(@HeaderMap HashMap<String,String> map ,@Body HashMap<String,Object> map2);

   @POST("/request/getparent")
    Call<List<ChildRequestModel>> getAllChildRequest(@HeaderMap HashMap<String,String> map, @Body HashMap<String,Object> map2 );

    @POST("/request/delete")
    Call<Void> onRejectChildRequest(@HeaderMap HashMap<String,String> map,@Body HashMap<String,Object> map2);

    @POST("/request/accept")
    Call<Void> onAcceptChildRequest(@HeaderMap HashMap<String,String> map,@Body HashMap<String,Object> map2);

    @POST("/auth/changepassword")
    Call<Void> onChangePassword(@HeaderMap HashMap<String,String> map,@Body HashMap<String,String> map2);

    @POST("auth/refreshToken")
    Call<LoginResponse> getRefreshToken(@HeaderMap HashMap<String,String> map2);

}

