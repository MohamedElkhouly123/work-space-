package com.example.workspacedeal.view.fragment.splashCycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.activity.SplashCycleActivity;
import com.example.workspacedeal.view.activity.UserCycleActivity;
import com.example.workspacedeal.view.fragment.BaSeFragment;
import com.example.workspacedeal.view.fragment.userCycle.splash2;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.workspacedeal.data.local.SharedPreferencesManger.LoadBoolean;
import static com.example.workspacedeal.data.local.SharedPreferencesManger.LoadUserData;
import static com.example.workspacedeal.data.local.SharedPreferencesManger.REMEMBER_ME;
import static com.example.workspacedeal.utils.HelperMethod.replaceFragment;
import static com.example.workspacedeal.utils.HelperMethod.replaceFragment2;
import static com.example.workspacedeal.utils.HelperMethod.replaceFragmentWithAnimation2;


public class SplashFragment extends BaSeFragment {
    @BindView(R.id.fragment_splash_logo)
    ImageView fragmentSplashLogo;
    Animation topAnimation, buttomAnimation;
    private boolean isTransactionSafe;
    private boolean first=true;

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_splash, container, false);
        ButterKnife.bind(this, root);
        topAnimation= AnimationUtils.loadAnimation(getContext(),R.anim.top_animation);
        buttomAnimation= AnimationUtils.loadAnimation(getContext(),R.anim.button_animation);
        fragmentSplashLogo.setAnimation(buttomAnimation);
//        StartSplash();

        return root;



    }

//    public void StartSplash(){
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                first=false;
//                if(isTransactionSafe) {
//                    replaceFragment2(getActivity().getSupportFragmentManager(), R.id.splash_activity_fram, new FragmentAboutApp());
//
////                    replaceFragmentWithAnimation2(getActivity().getSupportFragmentManager(), R.id.splash_activity_fram, new FragmentAboutApp(), "b");
//                }
//
//            }
//        },3000);
//    }


    @Override
    public void onBack() {
        getActivity().finish();
    }
}