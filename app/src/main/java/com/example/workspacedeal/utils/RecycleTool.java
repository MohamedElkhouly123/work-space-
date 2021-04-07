package com.example.workspacedeal.utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.workspacedeal.view.activity.BaseActivity;


public class RecycleTool {

    public static void setRecycleTool(BaseActivity baseActivity, View subView, ImageView errorImage, TextView errorTitle, TextView errorAction
            , int drawable, String title, String actionTitle, View.OnClickListener action) {

        subView.setVisibility(View.VISIBLE);

        errorImage.setImageResource(drawable);

        errorTitle.setText(title);
        errorAction.setText(actionTitle);

        errorAction.setOnClickListener(action);

    }

}
