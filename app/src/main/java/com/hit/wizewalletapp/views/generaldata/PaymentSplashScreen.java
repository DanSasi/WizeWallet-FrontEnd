package com.hit.wizewalletapp.views.generaldata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hit.wizewalletapp.views.fragments.LoginFragment;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.views.fragments.parent.ParentBalanceHomeScreenFragment;
import com.hit.wizewalletapp.views.fragments.parent.ParentBalanceHomeScreenFragmentArgs;

import org.w3c.dom.Text;

public class PaymentSplashScreen extends Fragment {

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView power;
    LinearLayout name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_payment_splash_screen,container,false);


        topAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(requireContext(),R.anim.bottom_animation);

        image = view.findViewById(R.id.imageView);
        name = view.findViewById(R.id.lin2);
        power = view.findViewById(R.id.payment_text3);

        image.setAnimation(topAnim);
        name.setAnimation(bottomAnim);
        power.setAnimation(bottomAnim);
        handler_now();
        return view ;



    }

    private void handler_now() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp();

            }
        },3000);
    }
}