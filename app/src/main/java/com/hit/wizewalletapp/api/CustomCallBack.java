package com.hit.wizewalletapp.api;

public interface CustomCallBack<T> {
    void onSuccesses(T response);
    void onFailure(String msg);
}


