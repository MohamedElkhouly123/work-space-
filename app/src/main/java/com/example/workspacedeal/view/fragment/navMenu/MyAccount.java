package com.example.workspacedeal.view.fragment.navMenu;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.BaSeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyAccount extends BaSeFragment {
    @BindView(R.id.fragment_my_account_mybookings_tv)
    TextView fragmentMyAaccountMybookingsTv;
    @BindView(R.id.fragment_my_account_edit_personal_profile_tv)
    TextView fragmentMyAaccountEditPersonalProfileTv;
    @BindView(R.id.fragment_my_account_change_password_tv)
    TextView fragmentMyAaccountChangePasswordTv;
    private NavController navController;

    public MyAccount() {
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
        View root = inflater.inflate(R.layout.fragment_my_account, container, false);
        ButterKnife.bind(this, root);
        return root;

    }

    @Override
    public void onBack() {
        navController.navigate(R.id.homeFragment);
    }

    @OnClick({R.id.fragment_my_account_mybookings_tv,R.id.fragment_my_account_back_img, R.id.fragment_my_account_edit_personal_profile_tv, R.id.fragment_my_account_change_password_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_my_account_mybookings_tv:


                        navController.navigate(R.id.action_myAccount_to_myBookings);

                        break;

            case R.id.fragment_my_account_edit_personal_profile_tv:
                navController.navigate(R.id.editPersonalDetails);
                break;
            case R.id.fragment_my_account_change_password_tv:
                navController.navigate(R.id.changePassword);
                break;
                case R.id.fragment_my_account_back_img:
                navController.navigate(R.id.homeFragment);
                break;
        }
    }
}