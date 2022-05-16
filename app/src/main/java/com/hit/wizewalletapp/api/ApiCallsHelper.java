package com.hit.wizewalletapp.api;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTaskModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTransactionModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.TaskChildModel;
import com.hit.wizewalletapp.api.responses.LoginResponse;
import com.hit.wizewalletapp.api.responses.ServerResponse;
import com.hit.wizewalletapp.utilities.CacheUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

    public static void performGetAllChilds(String token, CustomCallBack<List<ChildModel>> callback) {
        //1.Set headers to hashmap
        HashMap<String,String> map = new HashMap<>();
        map.put("authorization",token);
        //2.preapre retrofit request
        Call<ServerResponse> call = RetrofitInstance.retrofitInterface.getAllKidsForParent(map);

        //3.execute the request
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                //4.SUCSSES (HANDLE DATA)
                if (response.isSuccessful() && response.code() == 200) {
                    List<Integer> childIdList = response.body().kidID;
                    final List<ChildModel>childModelToReturn = new ArrayList<>();
                    if(childIdList != null){
                        for(Integer ptr : childIdList){
                            childModelToReturn.add( new ChildModel(ptr,null));
                        }
                    }
                    //5. Post the data to the caller
                    callback.onSuccesses(childModelToReturn);
                } else if (response.code() == 400) {
                    //5. Post Error the data to the caller
                    callback.onFailure("wrong email or password/already have user");
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                //4.FAILURE

                //5. Post Error the data to the caller
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public static void performChildGetTaskById(String token,CustomCallBack<List<TaskChildModel>> callback) {
        HashMap<String,String> map = new HashMap<>();
        map.put("authorization",token);
//        HashMap<String,Object> bodyMap = new HashMap<>();
//        bodyMap.put("transactions",list);
        //2.preapre retrofit request
        Call<List<TaskChildModel>> call = RetrofitInstance.retrofitInterface.getChildTaskById(map);
        call.enqueue(new Callback<List<TaskChildModel>>() {
            @Override
            public void onResponse(Call<List<TaskChildModel>> call, Response<List<TaskChildModel>> response) {
                if (response.isSuccessful()  && response.body() != null && response.code() == 200) {
                    callback.onSuccesses(response.body());
                } else if (response.code() == 400) {
                    //5. Post Error the data to the caller
                    callback.onFailure("wrong email or password/already have user");
                }
            }

            @Override
            public void onFailure(Call<List<TaskChildModel>> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
        //3.execute the request

    }

    public static void performAddTasks(String token,HashMap<String,Object> map,CustomCallBack<Void> callback) {
        HashMap<String,String> headerMap = new HashMap<>();
        headerMap.put("authorization",token);
        Call<Void> call = RetrofitInstance.retrofitInterface.executeAddTasks(headerMap,map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("wrong");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }
    public static void performChildTransaction(String token,HashMap<String,Object> map,CustomCallBack<Void> callback) {
        HashMap<String,String> headerMap = new HashMap<>();
        headerMap.put("authorization",token);
        Call<Void> call = RetrofitInstance.retrofitInterface.executeChildTransactions(headerMap,map);
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
    public static void performGetAllTransForChild(String token,CustomCallBack<List<ChildTransactionModel>> callback) {
        //1.Set headers to hashmap
        HashMap<String,String> map = new HashMap<>();
        map.put("authorization",token);
//        HashMap<String,Object> bodyMap = new HashMap<>();
//        bodyMap.put("transactions",list);
        //2.preapre retrofit request
        Call<ServerResponse> call = RetrofitInstance.retrofitInterface.getAllTransForChild(map);

        //3.execute the request
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                //4.SUCSSES (HANDLE DATA)
                if (response.isSuccessful()  && response.body() != null && response.code() == 200) {
                    List<ChildTransactionModel> childList=response.body().getChildTransModels();
                    //5. Post the data to he caller
                    callback.onSuccesses(childList);
                } else if (response.code() == 400) {
                    //5. Post Error the data to the caller
                    callback.onFailure("wrong email or password/already have user");
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                //4.FAILURE

                //5. Post Error the data to the caller
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public static void performGetAllTransForChildByParent(String token,String childId,CustomCallBack<List<ChildTransactionModel>> callback) {
        //1.Set headers to hashmap
        HashMap<String,String> map = new HashMap<>();
        map.put("authorization",token);

        HashMap<String,Object> body = new HashMap<>();
        body.put("id",childId);
//        HashMap<String,Object> bodyMap = new HashMap<>();
//        bodyMap.put("transactions",list);
        //2.preapre retrofit request
        Call<ServerResponse> call = RetrofitInstance.retrofitInterface.getAllTransForChildByParent(map,body);

        //3.execute the request
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                //4.SUCSSES (HANDLE DATA)
                if (response.isSuccessful()  && response.body() != null && response.code() == 200) {
                    List<ChildTransactionModel> childList=response.body().getChildTransModels();
                    //5. Post the data to he caller
                    callback.onSuccesses(childList);
                } else {
                    //5. Post Error the data to the caller
                    callback.onFailure("asdasdsadsadsa");
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                //4.FAILURE

                //5. Post Error the data to the caller
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }
    public static void performGetAllTaskForChildByParent(String token,String childId,CustomCallBack<List<TaskChildModel>> callback) {
        //1.Set headers to hashmap
        HashMap<String,String> map = new HashMap<>();
        map.put("authorization",token);

        HashMap<String,Object> body = new HashMap<>();
        body.put("kidid",Integer.valueOf(childId));
//        HashMap<String,Object> bodyMap = new HashMap<>();
//        bodyMap.put("transactions",list);
        //2.preapre retrofit request
        Call<List<TaskChildModel>> call = RetrofitInstance.retrofitInterface.getAllTasksForChildByParent(map,body);

        //3.execute the request
        call.enqueue(new Callback<List<TaskChildModel>>() {
            @Override
            public void onResponse(Call<List<TaskChildModel>> call, Response<List<TaskChildModel>> response) {
                if (response.isSuccessful()  && response.body() != null && response.code() == 200) {

                    //5. Post the data to he caller
                    callback.onSuccesses(response.body());
                } else {
                    //5. Post Error the data to the caller
                    callback.onFailure("asdasdsadsadsa");
                }
            }

            @Override
            public void onFailure(Call<List<TaskChildModel>> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }


        });
    }

    public static void performGetChildBalance(String token, CustomCallBack<String> callback) {
        //1.Set headers to hashmap
        HashMap<String,String> map = new HashMap<>();
        map.put("authorization",token);
        //2.preapre retrofit request
        Call<ServerResponse> call = RetrofitInstance.retrofitInterface.getBalanceChild(map);

        //3.execute the request
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                //4.SUCSSES (HANDLE DATA)
                if (response.isSuccessful() && response.body() != null &&  response.code() == 200) {
                    callback.onSuccesses(response.body().balance.toString());
                } else if (response.code() == 400) {
                    //5. Post Error the data to the caller
                    callback.onFailure("wrong email or password/already have user");
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

}
