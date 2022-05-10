package com.hit.wizewalletapp.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.hit.wizewalletapp.viewmodel.MyApplication;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Model {
    public static final Model instance = new Model();
    Executor executor = Executors.newFixedThreadPool(1);
    Handler mainThread = HandlerCompat.createAsync(Looper.getMainLooper());

    public enum ChildListLoadingState {
        loading,
        loaded
    }

    MutableLiveData<ChildListLoadingState>
            childListLoadingState = new MutableLiveData<ChildListLoadingState>();

    public LiveData<ChildListLoadingState> getChildListLoadingState() {
        return childListLoadingState;
    }

    private Model() {
        childListLoadingState.setValue(ChildListLoadingState.loaded);
    }

    MutableLiveData<List<ChildModel>> childList = new MutableLiveData<List<ChildModel>>();

    public LiveData<List<ChildModel>> getAllChildren() {

        if (childList.getValue() == null) {

            refreshChilList();
        };
        return childList;
    }




    private void refreshChilList() {
        childListLoadingState.setValue(ChildListLoadingState.loading);

        //get last local update data
        Long lastUpdateDate = MyApplication.getContext().getSharedPreferences("Tag", Context.MODE_PRIVATE).getLong("ChildListLastUpdate", 0);

    }
    public interface AddChildListener{
        void onComplete();
    }

    public void addChild(ChildModel childModel, AddChildListener listener){

    }

    public interface GetChildById{
        void onComplete(ChildModel childModel);
    }
    public ChildModel getChildById(String childId, GetChildById listener) {

        return null ;
    }


    public interface SaveImageListener{
        void onComplete(String url);
    }
    public void saveImage(Bitmap imageBitmap, String imageName, SaveImageListener listener) {

    }
}
