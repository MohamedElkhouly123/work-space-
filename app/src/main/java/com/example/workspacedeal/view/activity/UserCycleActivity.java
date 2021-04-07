package com.example.workspacedeal.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.splashCycle.SplashFragment;
import com.example.workspacedeal.view.fragment.userCycle.splash2;

import static com.example.workspacedeal.utils.HelperMethod.replaceFragment;

public class UserCycleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cycle);
        replaceFragment(getSupportFragmentManager(), R.id.user_cycle_activity_fram, new splash2());

    }


}