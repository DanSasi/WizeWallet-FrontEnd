//package com.hit.digitalwallethitapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//
//import com.ebanx.swipebtn.OnStateChangeListener;
//import com.ebanx.swipebtn.SwipeButton;
//
//public class PaymentSummaryScreen extends AppCompatActivity {
//
//    ImageView backArrow;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_payment_summary_screen);
//
//        SwipeButton swipeButton = findViewById(R.id.swipeId);
//
//        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
//            @Override
//            public void onStateChange(boolean active) {
//                startActivity(new Intent(PaymentSummaryScreen.this, WithdrawScreen.class));
//            }
//        });
//
//        backArrow = findViewById(R.id.btn1);
//
//        backArrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(PaymentSummaryScreen.this,SendMoneyScreen.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//}