package com.example.workspacedeal.view.fragment.navMenu;

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

import static com.example.workspacedeal.R.color.white;


public class ContactUsDirectly extends BaSeFragment {
    private NavController navController;
    public ContactUsDirectly() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(white);
        }
        // Inflate the layout for this fragment
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);
        return inflater.inflate(R.layout.fragment_contact_us_directly, container, false);
    }

    @Override
    public void onBack() {
        navController.navigate(R.id.contact_us_Fragment);

    }
    @OnClick({R.id.fragment_contact_us_back_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_contact_us_back_btn:


                onBack();

                break;
}}


}