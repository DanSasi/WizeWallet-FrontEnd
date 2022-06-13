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

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.hit.wizewalletapp.adapters.General_Adapters.SpinnerGenderAdapter;
import com.hit.wizewalletapp.adapters.General_Adapters.SpinnerUserAdater;
import com.hit.wizewalletapp.model.ChildListModel;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.utilities.Utilities;
import com.hit.wizewalletapp.views.generaldata.SpinnerData;
import com.hit.wizewalletapp.views.generaldata.SpinnerGenderData;
import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;


@SuppressWarnings("ALL")
public class AddChildScreenFragment extends Fragment {

    private final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;


    private EditText addChildEmailEt, addChildPasswordET, addChildIdEt, addChildBalanceEt,addChildNameEt;
    private Button addChildButton;
    private ImageFilterButton addChildImageFilterButton, addChildCameraFilterButton;
    private ImageView addChildImageView, back_arrow, boyImage,girlImage;
    private Bitmap imageBitmap;
    private Spinner genderSpinner;
    private SpinnerGenderAdapter spinnerGenderAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parrent_add_child_fragment, container, false);
        initViews(view);
        addChildButton.setOnClickListener(v -> save());

        back_arrow = view.findViewById(R.id.add_child_backArrow);
        back_arrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());
        return view;
    }

    private void initViews(View view) {
        addChildPasswordET = view.findViewById(R.id.add_child_password_et);
        addChildEmailEt = view.findViewById(R.id.add_child_username_et);
        addChildButton = view.findViewById(R.id.add_child_btn);
        addChildIdEt = view.findViewById(R.id.parent_add_task_id_et);
        addChildImageView = view.findViewById(R.id.add_child_imgv);
        addChildBalanceEt = view.findViewById(R.id.parent_add_task_amount_et);
        boyImage = view.findViewById(R.id.child_image_spinner);
        girlImage = view.findViewById(R.id.girl_image_spinner);
        addChildNameEt = view.findViewById(R.id.parent_add_task_name_et);
        genderSpinner = view.findViewById(R.id.spinner_gender_add_child);
        spinnerGenderAdapter = new SpinnerGenderAdapter(getContext(), SpinnerGenderData.getSpinnerGenderList());
        genderSpinner.setAdapter(spinnerGenderAdapter);

    }





    private void save() {
        String userEmail = addChildEmailEt.getText().toString();
        String password = addChildPasswordET.getText().toString();
        String id = addChildIdEt.getText().toString();
        String balance = addChildBalanceEt.getText().toString();
        String name = addChildNameEt.getText().toString();
        String gender = genderSpinner.getSelectedItem().toString();
        if (Utilities.verifyAllTextNotEmpty(userEmail, password, id, balance)) {
            String token = CacheUtilities.getAcssesToken(requireContext());
            HashMap<String, Object> userRegisterMap = new HashMap<>();
            userRegisterMap.put("email", userEmail);
            userRegisterMap.put("password", password);
            userRegisterMap.put("_id", id);
            userRegisterMap.put("balance", balance);
            userRegisterMap.put("name",name);
            userRegisterMap.put("img_url",gender);
            ApiCallsHelper.performRegisterChild(token,userRegisterMap, new CustomCallBack<Void>() {
                @Override
                public void onSuccesses(Void response) {
                    ChildModel childModel = new ChildModel(gender, balance, userEmail, id, password,name);
                    ChildListModel.instance.addChild(childModel);
                    Toast.makeText(getActivity(),name + " " + "was added to the Children list", Toast.LENGTH_LONG).show();
                    Navigation.findNavController(getActivity(), R.id.nav_host).navigateUp();
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
