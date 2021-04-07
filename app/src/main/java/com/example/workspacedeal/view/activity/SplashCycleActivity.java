package com.example.workspacedeal.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.splashCycle.FragmentAboutApp;
import com.example.workspacedeal.view.fragment.splashCycle.SplashFragment;
import com.example.workspacedeal.view.fragment.userCycle.splash2;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.workspacedeal.data.local.SharedPreferencesManger.LoadBoolean;
import static com.example.workspacedeal.data.local.SharedPreferencesManger.LoadUserData;
import static com.example.workspacedeal.data.local.SharedPreferencesManger.REMEMBER_ME;
import static com.example.workspacedeal.utils.HelperMethod.replaceFragment;
import static com.example.workspacedeal.utils.HelperMethod.replaceFragment2;

public class SplashCycleActivity extends BaseActivity {

    private boolean isTransactionSafe;
    private boolean first=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_cycle);
        replaceFragment(getSupportFragmentManager(), R.id.splash_activity_fram, new SplashFragment());

        StartSplash();




    }
    public void StartSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                first=false;
                if(isTransactionSafe) {
//                if(!isFinishing() && !isDestroyed()) {

                    replaceFragment2(getSupportFragmentManager(), R.id.splash_activity_fram, new FragmentAboutApp());

//                    replaceFragmentWithAnimation2(getActivity().getSupportFragmentManager(), R.id.splash_activity_fram, new FragmentAboutApp(), "b");
                }

            }
        },3000);
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
    }
    public void onPostResume(){
        super.onPostResume();
        isTransactionSafe=true;

    }

    public void onPause(){
        super.onPause();
        isTransactionSafe=false;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isTransactionSafe||!isFinishing() && !isDestroyed()&& !first) {
//            if (!(LoadUserData(getActivity()) != null && LoadBoolean(getActivity(), REMEMBER_ME))) {
//
                StartSplash();
//            }
        }
    }

//    @Override
//    public void onBackPressed() {
////        super.onBackPressed();
//    }
}