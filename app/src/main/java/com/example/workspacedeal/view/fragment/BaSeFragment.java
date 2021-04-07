package com.example.workspacedeal.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.activity.BaseActivity;
import com.example.workspacedeal.view.activity.HomeCycleActivity;

import java.util.Locale;


public abstract class BaSeFragment extends Fragment {
    public BaseActivity baseActivity;
    public HomeCycleActivity homeCycleActivity;
    private Context activity;


    public void setUpActivity() {
        baseActivity = (BaseActivity) getActivity();
        baseActivity.baseFragment = this;
        try {
            homeCycleActivity = (HomeCycleActivity) getActivity();
        } catch (Exception e) {

        }
    }
    //onBack​
    public void onBack() {
        baseActivity.superBackPressed();
    }
    //​ onStart
    @Override
    public void onStart() {
        super.onStart();
        setUpActivity();
    }
    //​
    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setUpActivity();

        return super.onCreateView(inflater, container, savedInstanceState);
    }
//
//    private void refreshLanguage() {
//        // your language
//        Locale locale = new Locale(languageToLoad);
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        activity.getResources().updateConfiguration(config,
//                activity.getResources().getDisplayMetrics());
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = context;
//        refreshLanguage();

    }

}
