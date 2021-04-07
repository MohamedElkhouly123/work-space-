package com.example.workspacedeal.view.fragment.navMenu;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.BaSeFragment;

import butterknife.OnClick;

public class EditPersonalDetails extends BaSeFragment {
    private NavController navController;
    public EditPersonalDetails() {
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

        View root=inflater.inflate(R.layout.fragment_edit_personal_details, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);
        return root;
    }
    @Override
    public void onBack() {

        navController.navigate(R.id.action_editPersonalDetails_to_myAccount2);
    }
    @OnClick({R.id.fragment_edit_personal_back_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_edit_personal_back_img:
                onBack();
                break;
        }}

}