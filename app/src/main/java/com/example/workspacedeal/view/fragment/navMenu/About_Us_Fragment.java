package com.example.workspacedeal.view.fragment.navMenu;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.PagerAdapter;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.BaSeFragment;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.tmall.ultraviewpager.UltraViewPager;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.workspacedeal.R.color.blue;
import static com.example.workspacedeal.R.color.white;


public class About_Us_Fragment extends BaSeFragment implements YouTubePlayer.OnInitializedListener{
    private NavController navController;

    @BindView(R.id.fragment_about_us_youtube_player_view)
    YouTubePlayerView youTubePlayerView;


    // TODO: Rename and change types of parameters


    public About_Us_Fragment() {
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
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);


        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_aboutUs, container, false);
        View root = inflater.inflate(R.layout.fragmrnt_aboutus, container, false);

        ButterKnife.bind(this, root);
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);

        setScrolImagesAndData();
        return root;


    }

    @Override
    public void onBack() {
        navController.navigate(R.id.action_to_homeFragment);
    }








    @OnClick({R.id.fragment_about_us_image_back_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_about_us_image_back_btn:
                navController.navigate(R.id.action_to_homeFragment);
                break;
        }}







    private void setScrolImagesAndData() {

//        fragmentStoreDetailsVideoYoutubeMvMap.initialize(PlayerConfig.YOUTUBE_API_KEY, this);


//        bd=new ProgressDialog(getActivity());
//        bd.setMessage("Wait");
//        bd.show();
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NotNull com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);

//                youTubePlayer.loadVideo("Mrl0qms8UJ4",1);
                String videoId = "zyROV29y2-Y";
                onVideoId(youTubePlayer,videoId);
                youTubePlayer.loadVideo(videoId,0);
                youTubePlayer.play();


//                bd.dismiss();
            }

            @Override
            public void onStateChange(@NotNull com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer, @NotNull PlayerConstants.PlayerState state) {
                super.onStateChange(youTubePlayer, state);

            }

            @Override
            public void onVideoDuration(@NotNull com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer, float duration) {
                super.onVideoDuration(youTubePlayer, duration);
            }

            @Override
            public void onVideoId(@NotNull com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer youTubePlayer, @NotNull String videoId) {

            }



        });



    }



    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b ) {
        if (!b) {
//            youTubePlayer.cueVideo("fhWaJi1Hsfo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
//            youTubePlayer.loadVideo("Hce74cEAAaE");
//            youTubePlayer.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
//        if (errorReason.isUserRecoverableError()) {
//            errorReason.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
//        } else {
////            String error = String.format(getString(R.string.player_error), errorReason.toString());
//            Toast.makeText(getActivity(), "error", Toast.LENGTH_LONG).show();
//        }
    }



}