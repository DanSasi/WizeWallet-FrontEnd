package com.hit.wizewalletapp.views.generaldata;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.views.fragments.child.ChildTaskDetailsFragment;
import com.hit.wizewalletapp.views.fragments.child.ChildTasksScreenFragmentDirections;
import com.hit.wizewalletapp.views.fragments.parent.AcceptOrRejectFragmentDirections;


public class RejectSplashFragment extends Fragment {

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView power;
    LinearLayout name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reject_splash,container,false);


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

                Navigation.findNavController(requireActivity(),R.id.nav_host).popBackStack();
                Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp();
            }
        },3000);
    }
}