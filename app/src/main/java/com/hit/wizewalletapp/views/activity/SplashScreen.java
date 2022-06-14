package com.hit.wizewalletapp.views.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.hit.wizewalletapp.R;

public class SplashScreen extends AppCompatActivity {


    //variables
    Animation topAnim;
    ImageView image;

    float v = 0;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView);
        animationView.onStartTemporaryDetach();




        topAnim = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.top_animation);

        image = findViewById(R.id.imageView);
        image.setAnimation(topAnim);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);

                finish();
            }
        },3000);


    }
}