package com.hit.wizewalletapp.model;

import android.graphics.Bitmap;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.model.child.ChildRequestModel;
import com.hit.wizewalletapp.model.child.ChildTaskModel;
import com.hit.wizewalletapp.model.child.ChildTransactionModel;
import com.hit.wizewalletapp.api.RetrofitInterface;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Retrofit;

public class ChildListModel {


    public static final ChildListModel instance = new ChildListModel();
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
        private String BASE_URL = "http://10.0.2.2:3000";

        private ChildListModel(){
//                ChildModel dan = new ChildModel(R.drawable.dan_photo,"2OO","Dan","313369423","1234");
//                ChildModel michael = new ChildModel(R.drawable.michal_photo,"2OO","Michael","2","1234");
//                ChildModel alon = new ChildModel(R.drawable.alon_photo,"2OO","Alon","2","1234");
//                ChildModel maor = new ChildModel(R.drawable.maor_photo,"2OO","Maor","3","1234");
//                ChildModel ben = new ChildModel(R.drawable.ben_photo,"2OO","Ben","4","1234");
//                ChildModel yarden =new ChildModel(R.drawable.yarden_photo,"2OO","Yarden","209329416","1234");
//                childModelsData.add(dan);
//                childModelsData.add(michael);
//                childModelsData.add(alon);
//                childModelsData.add(maor);
//                childModelsData.add(ben);
//                childModelsData.add(yarden);
            getAllData();
            //TODO get the data from the link api for the current parent user

        }

        List<ChildModel> childModelsData = new LinkedList<ChildModel>();
        List<ChildTaskModel> childTransData = new LinkedList<ChildTaskModel>();
        List<ChildTransactionModel> childTransactionData =new LinkedList<ChildTransactionModel>();
        List<ChildRequestModel> childRequestModelList = new LinkedList<ChildRequestModel>();

        public List<ChildModel> getAllData(){
            return childModelsData;
        }



        public ChildModel getChildById(String childId) {
            for (ChildModel s: childModelsData) {
                if (s.get_id().equals(childId)){
                    return s;
                }
            }
            return null;
        }
        public void childAddTran(ChildTransactionModel childTransactionModel){
            childTransactionData.add(childTransactionModel);
        }

        public void addTran(ChildTaskModel childModel){

            childTransData.add(childModel);
        }
        public void addChild(ChildModel childModel){

            childModelsData.add(childModel);

        }

        public void addChildRequst(ChildRequestModel childRequestModel){
            childRequestModelList.add(childRequestModel);
        }

    public interface saveImageListener {
        void onComplete(String url);
    }




}
