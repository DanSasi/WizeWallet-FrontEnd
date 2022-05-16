package com.hit.wizewalletapp.views.fragments.parent;

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

import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.ChildListModel;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.utilities.Utilities;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;


@SuppressWarnings("ALL")
public class AddChildScreenFragment extends Fragment {

    private final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;

    private EditText addChildEmailEt, addChildPasswordET, addChildIdEt, addChildBalanceEt;
    private Button addChildButton;
    private ImageFilterButton addChildImageFilterButton;
    private ImageView addChildImageView;
    private Bitmap imageBitmap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parrent_add_child_fragment, container, false);
        initViews(view);
        addChildButton.setOnClickListener(v -> save());
        addChildImageFilterButton.setOnClickListener(v -> openGallery());
        return view;
    }

    private void initViews(View view) {
        addChildPasswordET = view.findViewById(R.id.add_child_password_et);
        addChildEmailEt = view.findViewById(R.id.add_child_username_et);
        addChildButton = view.findViewById(R.id.add_child_btn);
        addChildIdEt = view.findViewById(R.id.parent_add_task_id_et);
        addChildImageFilterButton = view.findViewById(R.id.add_child_img_filter_btn);
        addChildImageView = view.findViewById(R.id.add_child_imgv);
        addChildBalanceEt = view.findViewById(R.id.parent_add_task_amount_et);
    }

    private void openGallery() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, REQUEST_IMAGE_PICK);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
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


    private void save() {
        String userEmail = addChildEmailEt.getText().toString();
        String password = addChildPasswordET.getText().toString();
        String id = addChildIdEt.getText().toString();
        Integer imageView = addChildImageView.getImageAlpha();
        String balance = addChildBalanceEt.getText().toString();
        if (Utilities.verifyAllTextNotEmpty(userEmail, password, id, balance)) {
            HashMap<String, String> userRegisterMap = new HashMap<>();
            userRegisterMap.put("email", userEmail);
            userRegisterMap.put("password", password);
            userRegisterMap.put("_id", id);
            userRegisterMap.put("balance", balance);
            ApiCallsHelper.performRegister(userRegisterMap, new CustomCallBack<Void>() {
                @Override
                public void onSuccesses(Void response) {
                    ChildModel childModel = new ChildModel(imageView, balance, userEmail, id, password);
                    ChildListModel.instance.addChild(childModel);
                    Navigation.findNavController(getActivity(), R.id.nav_host).navigate(AddChildScreenFragmentDirections.actionAddChildFragmentToChildListScreen());
                }
                @Override
                public void onFailure(String msg) {
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                }
            });
        } else {

        }
    }

}
