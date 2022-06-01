package com.hit.wizewalletapp.views.fragments.child;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.utilities.Utilities;


public class ChildTransDetailsFragment extends Fragment {

    TextView amount, desc, date;
    ImageButton back_arrow_btn;
    private GoogleMap mGoogleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_trans_details, container, false);
        initViews(view);
        initMap(view);
        return view;
    }

    private void initMap(View view) {
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(googleMap -> {
            mGoogleMap = googleMap;
            String lat = ChildTransDetailsFragmentArgs.fromBundle(getArguments()).getLatitude();
            String lng = ChildTransDetailsFragmentArgs.fromBundle(getArguments()).getLongtitude();
            LatLng latLng = Utilities.getLatLng(lat, lng);
            if (latLng != null) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title("Test");
                mGoogleMap.clear();
                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f));
                mGoogleMap.addMarker(markerOptions);
            } else {
                view.findViewById(R.id.map).setVisibility(View.GONE);
            }
        });

    }

    private void initViews(View view) {
        desc = view.findViewById(R.id.child_trans_description_tv);
        amount = view.findViewById(R.id.child_amount_trans_amount);
        back_arrow_btn = view.findViewById(R.id.img_back_arrow_trans_details);
        date = view.findViewById(R.id.child_trans_date);
        String message_desc = ChildTransDetailsFragmentArgs.fromBundle(getArguments()).getDescription();
        desc.setText(message_desc);
        Integer amount_details = ChildTransDetailsFragmentArgs.fromBundle(getArguments()).getAmount();
        amount.setText(amount_details.toString());
        String dateDetails = ChildTransDetailsFragmentArgs.fromBundle(getArguments()).getDate();
        desc.setText(message_desc);
        date.setText(dateDetails);

        back_arrow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireActivity(), R.id.nav_host).navigateUp();
            }
        });

    }
}