package com.example.workspacedeal.view.fragment.userCycle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.BaSeFragment;

import static com.example.workspacedeal.utils.HelperMethod.replaceFragment;


public class RegisterFragment extends BaSeFragment {


    public RegisterFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_register, container, false);
        return root;
    }

    @Override
    public void onBack() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.user_cycle_activity_fram, new splash2());
    }
}