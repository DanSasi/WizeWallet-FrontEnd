package com.hit.wizewalletapp.Main.General_Folder.GeneralActivites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hit.wizewalletapp.Main.General_Folder.GeneralFragments.LoginFragmentHome;
import com.hit.wizewalletapp.R;

public class PaymentSplashScreen extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView power;
    LinearLayout name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image = findViewById(R.id.imageView);
        name = findViewById(R.id.lin2);
        power = findViewById(R.id.payment_text3);

        image.setAnimation(topAnim);
        name.setAnimation(bottomAnim);
        power.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(PaymentSplashScreen.this, LoginFragmentHome.class);
                startActivity(i);

                finish();
            }
        },3000);


    }
}