package com.example.workspacedeal.view.fragment.userCycle;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.activity.HomeCycleActivity;
import com.example.workspacedeal.view.activity.UserCycleActivity;
import com.example.workspacedeal.view.fragment.BaSeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.workspacedeal.utils.HelperMethod.replaceFragment;


public class splash2 extends BaSeFragment {
    @BindView(R.id.fragment_solash2_login_btu)
    Button fragmentSolash2LoginBtu;
    @BindView(R.id.fragment_solash2_rejester_btu)
    Button fragmentSolash2RejesterBtu;
    @BindView(R.id.Fragment_splash2_skip)
    TextView FragmentSplash2Skip;

    public splash2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getActivity().getWindow().getDecorView(); // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(uiOptions);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.black));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_splash2, container, false);
        ButterKnife.bind(this, root);

        return root;

    }

    @OnClick({R.id.fragment_solash2_login_btu, R.id.fragment_solash2_rejester_btu,R.id.Fragment_splash2_skip})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_solash2_login_btu:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.user_cycle_activity_fram, new LoginFragment());
                break;
            case R.id.fragment_solash2_rejester_btu:
                replaceFragment(getActivity().getSupportFragmentManager(), R.id.user_cycle_activity_fram, new RegisterFragment());

                break;
            case R.id.Fragment_splash2_skip:
                startActivity(new Intent(getActivity(),HomeCycleActivity.class));
                getActivity().finish();
                break;
        }
    }

    @Override
    public void onBack() {
        getActivity().finish();

    }


}