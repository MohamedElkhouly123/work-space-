package com.example.workspacedeal.view.fragment.splashCycle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.activity.SplashCycleActivity;
import com.example.workspacedeal.view.activity.UserCycleActivity;
import com.example.workspacedeal.view.fragment.BaSeFragment;
import com.example.workspacedeal.view.fragment.userCycle.splash2;


import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentAboutApp extends BaSeFragment {
    @BindView(R.id.about_app_slide4_btn_begin)
    Button aboutAppSlide4BtnBegin;
    @BindView(R.id.skip_splash)
    TextView skipSplash;
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;


    public FragmentAboutApp() {

    }

    @Override
    public void onBack() {
      getActivity().finish();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_about_us, container, false);
        ButterKnife.bind(this, root);
        viewPager = (ViewPager) root.findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) root.findViewById(R.id.layoutDots);

        layouts = new int[]{
                R.layout.about_slide1,
                R.layout.about_slide2,
                R.layout.about_slide3,
        };
        addBottomDots(0);
        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        aboutAppSlide4BtnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });

        return root;
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getActivity());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }
    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }
    private void launchHomeScreen(){
        startActivity(new Intent(getActivity(), UserCycleActivity.class));
        getActivity().finish();
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                aboutAppSlide4BtnBegin.setText(getString(R.string.end));
                // btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                aboutAppSlide4BtnBegin.setText(getString(R.string.next));
                //  btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };


public class MyViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;

    public MyViewPagerAdapter() {
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(layouts[position], container, false);
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}}