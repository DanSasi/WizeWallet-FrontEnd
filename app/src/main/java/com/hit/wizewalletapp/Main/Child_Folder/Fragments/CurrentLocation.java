package com.hit.wizewalletapp.Main.Child_Folder.Fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.hit.wizewalletapp.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CurrentLocation extends AppCompatActivity {

    FusedLocationProviderClient fusedLocationProviderClient;
    TextView address, city_loc, country, latitude, longitude;
    Button loc_btn;
    public static final int REQUEST_CODR = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);

        address = findViewById(R.id.address);
        city_loc = findViewById(R.id.city);
        country = findViewById(R.id.country);
        latitude = findViewById(R.id.lattitude);
        longitude = findViewById(R.id.longitude);
        loc_btn = findViewById(R.id.loc_btn);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        loc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindLocation();
            }
        });
    }

    private void FindLocation(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null)
                    {
                        Geocoder geocoder = new Geocoder(CurrentLocation.this, Locale.getDefault());
                        List<Address> addressesList = null;
                        try {
                            addressesList = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                            latitude.setText("Latitude : "+addressesList.get(0).getLatitude());
                            longitude.setText("Longitude : "+addressesList.get(0).getLongitude());
                            city_loc.setText("City : "+addressesList.get(0).getLocality());
                            country.setText("Country : "+addressesList.get(0).getCountryName());
                            address.setText("Address : "+addressesList.get(0).getAddressLine(0));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
        }
        else{
            AskforPermission();
        }
    }

    private void AskforPermission() {
        ActivityCompat.requestPermissions(CurrentLocation.this,new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION
        },REQUEST_CODR);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODR){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                FindLocation();
            }
            else{
                Toast.makeText(CurrentLocation.this, "Permission Required", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}