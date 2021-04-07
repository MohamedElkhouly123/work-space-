package com.example.workspacedeal.view.fragment.navMenu;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.BaSeFragment;

import butterknife.OnClick;

public class ChangePassword extends BaSeFragment {
    private NavController navController;
    public ChangePassword() {
        // Required empty public constructor
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.blue_header));
        }
        // Inflate the layout for this fragment
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);
        View root=inflater.inflate(R.layout.fragment_change_password, container, false);
        return root;
    }

    @Override
    public void onBack() {
        navController.navigate(R.id.myAccount);

    }


    @OnClick({R.id.fragment_change_password_back_img})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.fragment_change_password_back_img:
                onBack();
                break;
        }}



}