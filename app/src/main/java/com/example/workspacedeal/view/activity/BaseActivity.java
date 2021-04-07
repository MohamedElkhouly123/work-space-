package com.example.workspacedeal.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.workspacedeal.view.fragment.BaSeFragment;


public class BaseActivity extends AppCompatActivity {
    public static String languageToLoad ="";

    public BaSeFragment baseFragment;
//    ​

    @Override
    public void onBackPressed() {
        baseFragment.onBack();
    }
//​


    public void superBackPressed() {
        super.onBackPressed();
    }
}

