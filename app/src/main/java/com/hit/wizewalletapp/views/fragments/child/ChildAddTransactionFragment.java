package com.hit.wizewalletapp.views.fragments.child;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hit.wizewalletapp.model.child.ChildTransactionModel;
import com.hit.wizewalletapp.model.ChildListModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.utilities.Utilities;

import java.security.Provider;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;


@SuppressWarnings("deprecation")
public class ChildAddTransactionFragment extends Fragment {
    EditText amount_et, description_et;
    TextView date_Tv;
    Button save_btn;
    ImageButton backButton;
    Geocoder geocoder;
    private final int REQUEST_CODE = 111;


    private FusedLocationProviderClient fusedLocationClient;

    private GoogleMap mGoogleMap;
    private LocationCallback locationCallback;
    private LocationRequest locationRequest;
    private Location lastLocation;
    LocationProvider provider;
    LocationManager locationManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_add_transaction, container, false);
        initViews(view);
        save_btn.setOnClickListener(v -> save());
        backButton.setOnClickListener(v -> Navigation.findNavController(getActivity(), R.id.nav_host).navigateUp());
        initMap();
        return view;
    }

    private void initMap() {
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(googleMap -> {
            mGoogleMap = googleMap;
            initGoogleLocationApi();
        });

    }


    @SuppressLint("MissingPermission")
    private void initGoogleLocationApi() {
        if (fusedLocationClient == null) {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());
            locationRequest = LocationRequest.create().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).setInterval(2000).setFastestInterval(2000);
            locationCallback = new LocationCallback() {
                @Override
                public void onLocationResult(@NonNull LocationResult locationResult) {
                    super.onLocationResult(locationResult);
                    if (locationResult.getLocations().size() > 0) {
                        lastLocation = locationResult.getLocations().get(locationResult.getLocations().size() - 1);
                        setGoogleMapsAndEditText(new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude()));
                    }
                }
            };


        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
    }



    private void setGoogleMapsAndEditText(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Israel");
        mGoogleMap.clear();
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f));
        mGoogleMap.addMarker(markerOptions);

    }




    private void save() {
        Integer amount = Integer.valueOf(amount_et.getText().toString());
        String desc = description_et.getText().toString();
        Date date = new Date();
        String stringDate = DateFormat.getDateInstance().format(date);
        date_Tv.setText(stringDate);

        if (Utilities.verifyAllTextNotEmpty(amount.toString(), desc,stringDate)) {
            String token = CacheUtilities.getAcssesToken(requireContext());
            HashMap<String, Object> map = new HashMap<>();
            map.put("amount", amount);
            map.put("description", desc);
            map.put("createdat", stringDate);

            if(lastLocation != null){

                map.put("latitude",String.valueOf(lastLocation.getLatitude()));
                map.put("longitude",String.valueOf(lastLocation.getLongitude()));
            }
            ApiCallsHelper.performChildTransaction(token, map, new CustomCallBack<Void>() {
                @Override
                public void onSuccesses(Void response) {
                    ChildTransactionModel childTransactionModel = new ChildTransactionModel(amount, desc,stringDate);
                    ChildListModel.instance.childAddTran(childTransactionModel);
                    Toast.makeText(getActivity(),"Transaction Completed", Toast.LENGTH_LONG).show();
                    Navigation.findNavController(getActivity(), R.id.nav_host).navigateUp();
                }

                @Override
                public void onFailure(String msg) {
                    Toast.makeText(getActivity(), "Your balance is not sufficient to confirm the request.", Toast.LENGTH_LONG).show();
                }
            });

        }

    }

    private void initViews(View view) {
        amount_et = view.findViewById(R.id.parent_add_transaction_amount_et);
        description_et = view.findViewById(R.id.add_transaction_description_et);
        save_btn = view.findViewById(R.id.add_transaction_btn);
        backButton = view.findViewById(R.id.img_back_arrow_contact);
        date_Tv = view.findViewById(R.id.child_add_transaction_tv);
    }

}