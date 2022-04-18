package com.hit.wizewalletapp.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.hit.wizewalletapp.R;


public class AddChildFragment extends AppCompatActivity {


    ImageView childImageView ;
    EditText childNameEt;
    EditText childPassword;
    Button addChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_child_fragment);

        childPassword = findViewById(R.id.add_child_password);
        childNameEt = findViewById(R.id.add_child_name);
        addChild = findViewById(R.id.add_child_Btn);

    }
}