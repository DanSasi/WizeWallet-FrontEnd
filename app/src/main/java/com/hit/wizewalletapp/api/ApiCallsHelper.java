package com.hit.wizewalletapp.api;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.model.child.ChildRequestModel;
import com.hit.wizewalletapp.model.child.ChildTransactionModel;
import com.hit.wizewalletapp.model.child.TaskChildModel;
import com.hit.wizewalletapp.api.responses.LoginResponse;
import com.hit.wizewalletapp.api.responses.ServerResponse;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallsHelper {

    private static final String TAG = "ApiCall";

    public static void performLogin(String email, String password ,boolean isChild, CustomCallBack<LoginResponse> callback){
        Call<LoginResponse> call = RetrofitInstance.retrofitInterface.executeLogin(getAuthBody(email, password,isChild));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(response.body());
                } else if (response.code() == 400) {
                    callback.onFailure("wrong email or password");
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
                    callback.onFailure("wrong email or password");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }


    public static HashMap<String,Object> getAuthBody(String email, String password,boolean isChild){
        HashMap<String, Object> userLoginMap = new HashMap<>();
        userLoginMap.put("email",email );
        userLoginMap.put("password",password);
        userLoginMap.put("is_child",isChild);
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
                    callback.onFailure("wrong email or password");
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
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {
                    //5. Post the data to the caller
                    callback.onSuccesses(response.body().children);
                } else if (response.code() == 400) {
                    //5. Post Error the data to the caller
                    callback.onFailure("wrong email or password");
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
                    callback.onFailure("wrong email or password");
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
                    callback.onFailure("wrong email or password");
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
                    callback.onFailure("wrong email or password");
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

                }
            }

            @Override
            public void onFailure(Call<List<TaskChildModel>> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }


        });
    }

    public static void performGetChildBalance(String token, CustomCallBack<Integer> callback) {
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
                    callback.onSuccesses(response.body().balance);
                } else if (response.code() == 400) {
                    //5. Post Error the data to the caller
                    callback.onFailure("wrong email or password");
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

        public static void performAddBalanceForChild(String token,HashMap<String,Object> map, CustomCallBack<Void> callBack){
        HashMap<String,String> headerMap=new HashMap<>();
        headerMap.put("authorization",token);

        Call<Void> call = RetrofitInstance.retrofitInterface.addChildBalance(headerMap,map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful() && response.code() == 200){
                    callBack.onSuccesses(null);
                }else if(response.code() == 400){
                    callBack.onFailure("wrong");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callBack.onFailure(t.getLocalizedMessage());

            }
        });
    }


    public static void performRegisterChild(String token,HashMap<String,Object> map,CustomCallBack<Void> callback) {
        HashMap<String,String> headerMap=new HashMap<>();
        headerMap.put("authorization",token);
        Call<Void> call = RetrofitInstance.retrofitInterface.registerChild(headerMap,map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("wrong email or password");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }

    public static void onCompletedTask(String token,HashMap<String,Object> map,CustomCallBack<Void> callback) {
        HashMap<String,String> headerMap=new HashMap<>();
        headerMap.put("authorization",token);
        Call<Void> call = RetrofitInstance.retrofitInterface.onCompletedTask(headerMap,map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("error 400");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }

    public static void onAcceptedTask(String token,HashMap<String,Object> map,CustomCallBack<Void> callback) {
        HashMap<String,String> headerMap=new HashMap<>();
        headerMap.put("authorization",token);
        Call<Void> call = RetrofitInstance.retrofitInterface.onAcceptedTask(headerMap,map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("error 400");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }

    public static void performChildRequestAmount(String token , HashMap<String,Object> map ,CustomCallBack<Void> callback){
        HashMap<String,String> headerMap = new HashMap<>();
        headerMap.put("authorization", token);
        Call<Void> call = RetrofitInstance.retrofitInterface.addChildRequestAmount(headerMap,map);
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
                callback.onFailure("error 400");callback.onFailure("error 400");
            }
        });
    }

    public static void performGetAllChildRequests(String token,String childId,CustomCallBack<List<ChildRequestModel>> callback) {
        //1.Set headers to hashmap
        HashMap<String,String> map = new HashMap<>();
        map.put("authorization",token);

        HashMap<String,Object> body = new HashMap<>();
        body.put("_id",Integer.valueOf(childId));
//        HashMap<String,Object> bodyMap = new HashMap<>();
//        bodyMap.put("transactions",list);
        //2.preapre retrofit request
        Call<List<ChildRequestModel>> call = RetrofitInstance.retrofitInterface.getAllChildRequest(map,body);

        //3.execute the request
        call.enqueue(new Callback<List<ChildRequestModel>>() {
            @Override
            public void onResponse(Call<List<ChildRequestModel>> call, Response<List<ChildRequestModel>> response) {
                if (response.isSuccessful()  && response.body() != null && response.code() == 200) {

                    //5. Post the data to he caller
                    callback.onSuccesses(response.body());
                } else {
                    //5. Post Error the data to the caller

                }
            }

            @Override
            public void onFailure(Call<List<ChildRequestModel>> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }


        });
    }

    public static void onRejectChildRequest(String token,HashMap<String,Object> map,CustomCallBack<Void> callback) {
        HashMap<String,String> headerMap=new HashMap<>();
        headerMap.put("authorization",token);
        Call<Void> call = RetrofitInstance.retrofitInterface.onRejectChildRequest(headerMap,map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("error 400");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }

    public static void onAcceptChildRequest(String token,HashMap<String,Object> map,CustomCallBack<Void> callback) {
        HashMap<String,String> headerMap=new HashMap<>();
        headerMap.put("authorization",token);
        Call<Void> call = RetrofitInstance.retrofitInterface.onAcceptChildRequest(headerMap,map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("error 400");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());

            }
        });
    }

    public static void performOnChangePassword(String token,HashMap<String,String> map,CustomCallBack<Void> callback) {
        HashMap<String,String> headerMap=new HashMap<>();
        headerMap.put("authorization",token);

        Call<Void> call = RetrofitInstance.retrofitInterface.onChangePassword(headerMap,map);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("error 400");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });

    }




    public static void performGetRefreshToken(HashMap<String ,String> headerMap ,CustomCallBack<LoginResponse> callback ) {
        Call<LoginResponse> call = RetrofitInstance.retrofitInterface.getRefreshToken(headerMap);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    callback.onSuccesses(null);
                } else if (response.code() == 400) {
                    callback.onFailure("error 400");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }

        });
    }




}
