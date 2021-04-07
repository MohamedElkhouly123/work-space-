package com.example.workspacedeal.view.fragment.HomeCycle2;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.fragment.BaSeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.workspacedeal.R.color.white;

public class FilterFragment extends BaSeFragment {
    @BindView(R.id.fragment_filter_category_tv)
    TextView fragmentFilterCategoryTv;
    @BindView(R.id.fragment_filter_Location_tv)
    TextView fragmentFilterLocationTv;
    @BindView(R.id.fragment_filter_Price_range_tv)
    TextView fragmentFilterPriceRangeTv;
    @BindView(R.id.fragment_filter_ratting_tv)
    TextView fragmentFilterRattingTv;
    @BindView(R.id.fragment_filter_animation_tv)
    TextView fragmentFilterAnimationTv;
    @BindView(R.id.fragment_filter_category_linear)
    LinearLayout fragmentFilterCategoryLinear;
    @BindView(R.id.fragment_filter_location_linear)
    LinearLayout fragmentFilterLocationLinear;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.fragment_filter_price_range_linear)
    LinearLayout fragmentFilterPriceRangeLinear;
    @BindView(R.id.fragment_filter_animation_linear)
    LinearLayout fragmentFilterAnimationLinear;
    @BindView(R.id.fragment_filter_search_btu)
    Button fragmentChangePasswordSaveBtu;
    private NavController navController;
    private String  backdestination;

    public FilterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onBack() {
if(backdestination.equals("home"))
    navController.navigate(R.id.action_filter_fragmet_to_home_fragment);
if(backdestination.equals("SharedOffice"))
    navController.navigate(R.id.action_filter_fragmet_to_sharedOffice_fragment);
if(backdestination.equals("MeetingRoom"))
    navController.navigate(R.id.action_filter_fragmet_to_meetingRoom_fragment);
if(backdestination.equals("WorkSpace"))
    navController.navigate(R.id.action_filter_fragmet_to_workSpace);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }
        if (this.getArguments() != null) {


            backdestination = this.getArguments().getString("filterPage");


            }
        View root=inflater.inflate(R.layout.fragment_filter, container, false);
        ButterKnife.bind(this, root); navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);
        return root;
    }

    @OnClick({R.id.fragment_filter_category_tv,R.id.fragment_filter_image_back_btn,R.id.fragment_filter_search_btu, R.id.fragment_filter_Location_tv, R.id.fragment_filter_Price_range_tv, R.id.fragment_filter_ratting_tv, R.id.fragment_filter_animation_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_filter_image_back_btn:
                navController.navigate(R.id.action_filter_fragmet_to_home_fragment);

                break;
                case R.id.fragment_filter_category_tv:
                fragmentFilterCategoryLinear.setVisibility(View.VISIBLE);
                fragmentFilterLocationLinear.setVisibility(View.GONE);
                fragmentFilterPriceRangeLinear.setVisibility(View.GONE);
                fragmentFilterAnimationLinear.setVisibility(View.GONE);
                break;
            case R.id.fragment_filter_Location_tv:
                fragmentFilterCategoryLinear.setVisibility(View.GONE);
                fragmentFilterLocationLinear.setVisibility(View.VISIBLE);
                fragmentFilterPriceRangeLinear.setVisibility(View.GONE);
                fragmentFilterAnimationLinear.setVisibility(View.GONE);
                break;
            case R.id.fragment_filter_Price_range_tv:
                fragmentFilterCategoryLinear.setVisibility(View.GONE);
                fragmentFilterLocationLinear.setVisibility(View.GONE);
                fragmentFilterPriceRangeLinear.setVisibility(View.VISIBLE);
                fragmentFilterAnimationLinear.setVisibility(View.GONE);
                break;
            case R.id.fragment_filter_ratting_tv:
                fragmentFilterCategoryLinear.setVisibility(View.VISIBLE);
                fragmentFilterLocationLinear.setVisibility(View.GONE);
                fragmentFilterPriceRangeLinear.setVisibility(View.GONE);
                fragmentFilterAnimationLinear.setVisibility(View.GONE);
                break;
            case R.id.fragment_filter_animation_tv:
                fragmentFilterCategoryLinear.setVisibility(View.GONE);
                fragmentFilterLocationLinear.setVisibility(View.GONE);
                fragmentFilterPriceRangeLinear.setVisibility(View.GONE);
                fragmentFilterAnimationLinear.setVisibility(View.VISIBLE);
                break;
                case R.id.fragment_filter_search_btu:

                    Bundle bundle = new Bundle();

                    bundle.putString("filterPage",backdestination);

                    navController.navigate(R.id.action_filter_fragmet_to_search_fragment,bundle);
                break;
        }
    }
}