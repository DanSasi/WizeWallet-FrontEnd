package com.hit.wizewalletapp.Folders.Parent_Folder.Fragments;

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

import com.hit.wizewalletapp.Models.ParentModels.BalanceParentModel;
import com.hit.wizewalletapp.Models.ParentModels.ChildListModel;
import com.hit.wizewalletapp.Models.ParentModels.ChildModel;
import com.hit.wizewalletapp.R;

import java.io.FileNotFoundException;
import java.io.InputStream;


@SuppressWarnings("ALL")
public class AddChildScreenFragment extends Fragment {



    EditText addChildUserNameEt ,addChildPasswordET , addChildIdEt ,addChildBalanceEt ;
    Button addChildButton;
    ImageFilterButton addChildImageFilterButton;
    ImageView addChildImageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parrent_add_child_fragment, container, false);

        addChildPasswordET = view.findViewById(R.id.add_child_password_et);
        addChildUserNameEt = view.findViewById(R.id.add_child_username_et);
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
        String userName = addChildUserNameEt.getText().toString();
        String password = addChildPasswordET.getText().toString();
        String id = addChildIdEt.getText().toString();
        Integer imageView = addChildImageView.getImageAlpha();
        String balance = addChildBalanceEt.getText().toString();
        //int photo,String balance,String username, String id, String password
        ChildModel childModel = new ChildModel(imageView, balance, userName, id, password);
        ChildListModel.instance.addChild(childModel);
        Navigation.findNavController(addChildUserNameEt).navigateUp();


    }

}