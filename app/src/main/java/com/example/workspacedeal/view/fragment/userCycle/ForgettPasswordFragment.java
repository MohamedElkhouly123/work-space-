package com.example.workspacedeal.view.fragment.userCycle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.BaSeFragment;


public class ForgettPasswordFragment extends BaSeFragment {

    public ForgettPasswordFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_forgett_password, container, false);
        return root;
    }

    @Override
    public void onBack() {
        super.onBack();
    }
}