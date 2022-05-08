package com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.BalanceParentModel;
import com.hit.wizewalletapp.api.RetrofitInterface;

import java.util.LinkedList;
import java.util.List;
import com.hit.wizewalletapp.R;
import retrofit2.Retrofit;

public class ChildListModel {


    public static final ChildListModel instance = new ChildListModel();
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
        private String BASE_URL = "http://10.0.2.2:3000";

        private ChildListModel(){
                ChildModel dan = new ChildModel(R.drawable.dan_photo,"2OO","Dan","313369423","1234");
                ChildModel michael = new ChildModel(R.drawable.michal_photo,"2OO","Michael","2","1234");
                ChildModel alon = new ChildModel(R.drawable.alon_photo,"2OO","Alon","2","1234");
                ChildModel maor = new ChildModel(R.drawable.maor_photo,"2OO","Maor","3","1234");
                ChildModel ben = new ChildModel(R.drawable.ben_photo,"2OO","Ben","4","1234");
                ChildModel yarden =new ChildModel(R.drawable.yarden_photo,"2OO","Yarden","209329416","1234");
                childModelsData.add(dan);
                childModelsData.add(michael);
                childModelsData.add(alon);
                childModelsData.add(maor);
                childModelsData.add(ben);
                childModelsData.add(yarden);
            getAllData();
            //TODO get the data from the link api for the current parent user

        }

        List<ChildModel> childModelsData = new LinkedList<ChildModel>();

        public List<ChildModel> getAllData(){
            return childModelsData;
        }



        public ChildModel getChildById(String childId) {
            for (ChildModel s: childModelsData) {
                if (s.getId().equals(childId)){
                    return s;
                }
            }
            return null;
        }

        public void addChild(ChildModel childModel){

//                //Retrofit instance
//                retrofit = new Retrofit.Builder()
//                        .baseUrl(BASE_URL)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                retrofitInterface = retrofit.create(RetrofitInterface.class);
//
//                //get the user mail and password put in map and send to server
//                HashMap<String, String> userRegisterMap = new HashMap<>();
//                userRegisterMap.put("email", childModel.getName());
//                userRegisterMap.put("password", childModel.getPassword());
//                userRegisterMap.put("_id", childModel.getId());
//                userRegisterMap.put("balance", childModel.getBalance());


//                //send the request to the server side
//                Call<Void> call = retrofitInterface.executeRegister(userRegisterMap);
//
//                //get the response from server side
//                call.enqueue(new Callback<Void>() {
//                    @Override
//                    public void onResponse(Call<Void> call, Response<Void> response) {
//                        //code 200 is OK , 400 not
//                        if (response.code() == 200) {
//                            // Toast.makeText(getContext(), "register OK", Toast.LENGTH_LONG).show();
//                            //Navigation.findNavController(v).navigate(SignupTabFragmentDirections.actionSignupTabFragmentToLoginFragmentHome());
//                        } else if (response.code() == 400) {
//                            //Toast.makeText(getContext(), "wrong email or password/alre have user", Toast.LENGTH_LONG).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Void> call, Throwable t) {
//                        //  Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });

            childModelsData.add(childModel);


        }



}
