package com.example.workspacedeal.view.fragment.navMenu;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.BaSeFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class Contact_us_fragment extends BaSeFragment {
    private NavController navController;



    // TODO: Rename and change types of parameters


    public Contact_us_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.contactus_fragment, container, false);
        setUpActivity();

        ButterKnife.bind(this, root);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }

        return root;



    }

    @Override
    public void onBack() {

            navController.navigate(R.id.action_to_homeFragment);
    }

    @OnClick({R.id.fargment_contact_us_contact_us_directly_bt,R.id.fragment_contact_us_back_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fargment_contact_us_contact_us_directly_bt:
                navController.navigate(R.id.action_contact_us_Fragment_to_contactUsDirectly);

                break;
                case R.id.fragment_contact_us_back_img:
onBack();
                break;
        }}

}