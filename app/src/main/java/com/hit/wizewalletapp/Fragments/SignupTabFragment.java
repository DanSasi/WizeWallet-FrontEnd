package com.hit.wizewalletapp.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hit.wizewalletapp.Activities.LoginActivity;
import com.hit.wizewalletapp.R;

public class SignupTabFragment extends Fragment {

//    Button login;

    View objectSignUpFragment;
    private FirebaseAuth objectFirebaseAuth;
    private EditText userEmail,userPassword,firstName,lastName;

    private Button login;
    public void createUser ()
    {
        try{
            if(!userEmail.getText().toString().isEmpty() && !userPassword.getText().toString().isEmpty())
            {

                objectFirebaseAuth.createUserWithEmailAndPassword(userEmail.getText().toString(),
                        userPassword.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(getContext(),"User Created...",Toast.LENGTH_SHORT).show();
                                if(objectFirebaseAuth.getCurrentUser()!=null)
                                {
                                    objectFirebaseAuth.getCurrentUser();
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });

            }
            else
            {
                Toast.makeText(getContext(),"Please fill in the fields First...!",Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private void  attachToXML()
    {
        try {

            userEmail=objectSignUpFragment.findViewById(R.id.email);
            userPassword=objectSignUpFragment.findViewById(R.id.password);
            firstName=objectSignUpFragment.findViewById(R.id.fullname);
            lastName =objectSignUpFragment.findViewById(R.id.lastname);

            objectFirebaseAuth=FirebaseAuth.getInstance();
            login = objectSignUpFragment.findViewById(R.id.SignUp);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createUser();
                }
            });


        }
        catch (Exception e)
        {
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);


        login = root.findViewById(R.id.SignUp);

        login.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ( (LoginActivity)getActivity()).setCurrentItem(0);
            }
        });
        return root;
//        */
//        objectSignUpFragment =  (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);
//
//        attachToXML();
//        return objectSignUpFragment;
//        */
    }
}