package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hit.wizewalletapp.Main.General_Folder.GeneralActivites.RetrofitInterface;
import com.hit.wizewalletapp.Main.General_Folder.GeneralFragments.SignupTabFragmentDirections;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.Model.BalanceParentModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@SuppressWarnings("ALL")
public class AddChildScreenFragment extends Fragment {



    EditText addChildEmailEt,addChildPasswordET , addChildIdEt ,addChildBalanceEt ;
    Button addChildButton;
    ImageFilterButton addChildImageFilterButton;
    ImageView addChildImageView;

    //Retrofit, the URL is the phone emulator + server port
    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parrent_add_child_fragment, container, false);

        //Retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        addChildPasswordET = view.findViewById(R.id.add_child_password_et);
        addChildEmailEt = view.findViewById(R.id.add_child_username_et);
        addChildButton = view.findViewById(R.id.add_child_btn);
        addChildIdEt = view.findViewById(R.id.add_child_id_et);
        addChildImageFilterButton = view.findViewById(R.id.add_child_img_filter_btn);
        addChildImageView = view.findViewById(R.id.add_child_imgv);
        addChildBalanceEt = view.findViewById(R.id.add_child_balance_et);

        addChildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        addChildImageFilterButton.setOnClickListener(v -> openGallery());

        return view;
    }
    private final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;

    private void openGallery() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, REQUEST_IMAGE_PICK);
    }
    Bitmap imageBitmap;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                if (resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    imageBitmap = (Bitmap) extras.get("data");
                    addChildImageView.setImageBitmap(imageBitmap);


                }
            } else if (requestCode == REQUEST_IMAGE_PICK) {
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = data.getData();
                        final InputStream imageStream = getContext().getContentResolver().openInputStream(imageUri);
                        imageBitmap = BitmapFactory.decodeStream(imageStream);
                        addChildImageView.setImageBitmap(imageBitmap);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }

                }
            }
        }

    }


    private void save(){
        String userEmail = addChildEmailEt.getText().toString();
        String password = addChildPasswordET.getText().toString();
        String id = addChildIdEt.getText().toString();
        Integer imageView = addChildImageView.getImageAlpha();
        String balance = addChildBalanceEt.getText().toString();
        //int photo,String balance,String username, String id, String password

        //Retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        //get the user mail and password put in map and send to server
        HashMap<String, String> userRegisterMap = new HashMap<>();
        userRegisterMap.put("email", userEmail);
        userRegisterMap.put("password", password);
        userRegisterMap.put("_id", id);
        userRegisterMap.put("balance", balance);


        //send the request to the server side
        Call<Void> call = retrofitInterface.executeRegister(userRegisterMap);

        //get the response from server side
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                //code 200 is OK , 400 not
                if (response.code() == 200) {
                    // Toast.makeText(getContext(), "register OK", Toast.LENGTH_LONG).show();
                    //Navigation.findNavController(v).navigate(SignupTabFragmentDirections.actionSignupTabFragmentToLoginFragmentHome());
                } else if (response.code() == 400) {
                    //Toast.makeText(getContext(), "wrong email or password/alre have user", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                //  Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        ChildModel childModel = new ChildModel(imageView, balance, userEmail, id, password);
        BalanceParentModel.ChildListModel.instance.addChild(childModel);
        //Navigation.findNavController(addChildEmailEt).navigateUp();
        Navigation.findNavController(addChildEmailEt).navigate(AddChildScreenFragmentDirections.actionAddChildFragmentToChildListScreen());


    }

}
