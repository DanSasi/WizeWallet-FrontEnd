package com.hit.wizewalletapp.Main.Child_Folder.Fragments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.hit.wizewalletapp.R;

public class ChildPaymentFragment extends Fragment {

    Button btScan;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.activity_child_payment_fragment, container, false);

        btScan = view.findViewById(R.id.bt_scan);

        btScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(
                        getActivity()
                );
                // set promp text
                intentIntegrator.setPrompt("For flash use volume up key");
                // set beep

                intentIntegrator.setBeepEnabled(true);
                // locked orianted
                intentIntegrator.setOrientationLocked(true);
                //set capture activity
                intentIntegrator.setCaptureActivity(Capture.class);
                // Init Scan

                intentIntegrator.initiateScan();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Init intent result
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode, data);
        // check condition
        if (intentResult.getContents()!= null) {
            // init alert
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    getContext()
            );
            //set title
            builder.setTitle("Result");
            //set message
            builder.setMessage(intentResult.getContents());
            //set positive
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //dismiss dialog
                    dialogInterface.dismiss();
                }
            });
            // show alert dialog
            builder.show();
        }else{
            //WHEN RESULT CONTENT IS NULL
            Toast.makeText(getContext(), "OOPS... You did not scan anything", Toast.LENGTH_SHORT).show();
        }
    }
}