package com.hit.wizewalletapp.Activities.Parent_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.hit.wizewalletapp.Activities.Child_Activities.ChildBalanceScreen;
import com.hit.wizewalletapp.R;

public class ParentTipsScreen extends AppCompatActivity {

        ImageView backArrow;
        private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_parent_screen);


        backArrow = findViewById(R.id.backArrow);
        button = findViewById( R.id.con_btn);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                continueBtn();
//
//            }
//        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent( ParentTipsScreen.this, ChildBalanceScreen.class);
                startActivity(intent);
            }
        });


        }
//        public  void continueBtn(){
//        Intent intent= new Intent(this, PaymentSummaryScreen.class);
//        startActivity(intent);
//        }




    }
