package com.example.workspacedeal.view.fragment.HomeCycle2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.workspacedeal.R;
import com.example.workspacedeal.adapter.HomeAdapter;
import com.example.workspacedeal.utils.OnEndLess;
import com.example.workspacedeal.view.fragment.BaSeFragment;
import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeFragment extends BaSeFragment {
    NavController navController ;

@BindView(R.id.fragment_home_recycler_view)
RecyclerView fragmentServicesRv;
    private List<String> list= new ArrayList<>() ;
//    private ViewModelGetLists viewModel;
//    @BindView(R.id.fragment_home_sr_refresh)
//    SwipeRefreshLayout fragmentSCRefresh;
//    private NavController navController;
    public Integer maxPage = 0;
    private OnEndLess onEndLess;
    @BindView(R.id.load_more)
    RelativeLayout loadMore;
    HomeAdapter homeAdapter;
    private LinearLayoutManager lLayout;


    @BindView(R.id.fragmeny_home_drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.fragment_home_navmenu)
    NavigationView nav;
//    @BindView(R.id.nav_view)
    ActionBarDrawerToggle toggle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    // TODO: Rename and change types of parameters


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onBack() {
        if(drawerLayout.isOpen()){
           drawerLayout.closeDrawer(GravityCompat.START);

        }else {

        super.onBack();}
    }
    void setData(){

        list.add("d");
        list.add("d"); list.add("d");
        list.add("d"); list.add("d");
        list.add("d");



    }
    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        setUpActivity();

        ButterKnife.bind(this, root);
        fragmentServicesRv.setNestedScrollingEnabled(false);
        setData();
        initRS();

//        NavHostFragment navHostFragmentWorker = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.home_activity_fragment_normal);
//        NavigationUI.setupWithNavController(navView, navHostFragmentWorker.getNavController());
        baseActivity.setSupportActionBar(toolbar);
        toggle=new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.blue_header));
        }
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);

//        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);



        nav. setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            Fragment temp;
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_MyAccount :

                        navController.navigate(R.id.myAccount);

                        break;
                    case R.id.menu_AboutUs :
//                    navView.setVisibility(View.GONE);
                        navController.navigate(R.id.aboutUs_Fragment);

                        break;
                    case R.id.menu_ContactUs :

                        navController.navigate(R.id.contact_us_Fragment);

//                    navView.setVisibility(View.GONE);

                        break; case R.id.menu_RateUs :

                    break;
                    case R.id.menu_Share :
//                    navView.setVisibility(View.GONE);
                        navController.navigate(R.id.favoret_Fragment);

                        break;
                    case R.id.menu_Logout :

//                    navView.setVisibility(View.GONE);
                        break;
                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_fragment_normal,temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        // Inflate the layout for this fragment
        return root;
    }


    @OnClick({R.id.favoret_bt,R.id.fragment_home_search_Et,R.id.fragment_home_show_all_listes})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.favoret_bt:
                navController.navigate(R.id.favoret_Fragment);

                break;
//                case R.id.fragment_home_header_navigation_view_image_icon:
//
//                drawerLayout.openDrawer(GravityCompat.START);
//
//                break;
                case R.id.fragment_home_search_Et:
                    Bundle bundle = new Bundle();

                    bundle.putString("filterPage","Home");

                    navController.navigate(R.id.action_homeFragment_to_filterFragment,bundle);
                break;
                case R.id.fragment_home_show_all_listes:
                navController.navigate(R.id.action_homeFragment_to_filterFragment);

                break;
        }}






//    private void initListener() {
//
//        viewModel = ViewModelProviders.of(this).get(ViewModelGetLists.class);
//
//        viewModel.makeGetCustomerPromoCodesDataList().observe(getViewLifecycleOwner(), new Observer<CustomerPromoCodesResponce>() {
//            @Override
//            public void onChanged(@Nullable CustomerPromoCodesResponce response) {
//                try {
//                    if (response != null) {
////                        if (response.getStatus().equals("success")) {
//
////                                showToast(getActivity(), "max="+maxPage);
//
//                        if (response.getCustomerPromocodes() != null) {
//                            customerPromocodeList.clear();
//                            customerPromocodeList.addAll(response.getCustomerPromocodes());
////                                showToast(getActivity(), "list="+clientrestaurantsListData.get(1));
//
//                            homePromoCodeVrRvAdapter.notifyDataSetChanged();
////                                if(getHotelsItemsListData.size()){
//                            maxPage++;
////                                }
//                            noResultErrorTitle.setVisibility(View.GONE);
//
//                        } else {
//                            noResultErrorTitle.setVisibility(View.VISIBLE);
//                        }
////                                showToast(getActivity(), "success1");
//
////                        }
//                    } else {
//
//                    }
//
//                } catch (Exception e) {
//                }
//            }
//        });
//
//    }

    private void initRS() {
        lLayout = new LinearLayoutManager(getActivity());
//     gLayout = new GridLayoutManager(getContext(), 2);
        fragmentServicesRv.setLayoutManager(lLayout);

        onEndLess = new OnEndLess(lLayout, 1) {
            @Override
            public void onLoadMore(int current_page) {
                if (current_page <= maxPage) {
                    if (maxPage != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;
                        loadMore.setVisibility(View.VISIBLE);
//                        if (Filter) {
//                            getHajjAndUmrahListByFilter(current_page);
//                        } else {
                        getallProductsList(current_page);
//                        }

                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                } else {
                    onEndLess.current_page = onEndLess.previous_page;
                }
            }
        };
        fragmentServicesRv.addOnScrollListener(onEndLess);

        homeAdapter = new HomeAdapter(getContext(), getActivity(),list ,navController,"home");
        fragmentServicesRv.setAdapter(homeAdapter);
//            showToast(getActivity(), "success adapter");


//        if (customerPromocodeList.size() == 0) {
//            getallProductsList(0);
//        }
//        else {
//            clientAndRestaurantHomeFragmentSFlShimmer.stopShimmer();
//            clientAndRestaurantHomeFragmentSFlShimmer.setVisibility(View.GONE);
//        }

//        fragmentSCRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                maxPage = 0;
////                if (Filter) {
////                    getHajjAndUmrahListByFilter(0);
////                } else {
//                getallProductsList(0);
////                }
//
//            }
//        });
    }

//    private void getHajjAndUmrahListByFilter(int page) {
//
//        Filter = true;
//        if(page == 0){ maxPage=0;}
////        keyword = topPartInNavGenralPartSearchTil.getEditText().getText().toString().trim();
////        keyword="jfk";
//        Call<GetAllproductsResponce> getUmrahAndHujjResponceCall;
//        getUmrahAndHujjResponceCall = getApiClient().getAllProductsData();
////        getUmrahAndHujjResponceCall = getApiClient().getHajjAndUmrahItemListByFilter("hajj", page,keyword);
////        startShimmer(page);
//        viewModel.getAllProductsDataList(getActivity(), errorSubView, getUmrahAndHujjResponceCall,fragmentAllProductsSrRefresh, loadMore);
//
//
//    }

    private void getallProductsList(int page) {
//        Filter = false;
        if (page == 0) {
            maxPage = 0;
        }
//        Call<CustomerPromoCodesResponce> getAllproductsResponceCall;

//        startShimmer(page);

        reInit();
//        getAllproductsResponceCall = getApiClient().customerPromoCodes(userData.getUserId());

//            clientRestaurantsCall = getApiClient().getRestaurantsWithoutFiltter(page);
//        viewModel.getCustomerPromoCodesDataList(getActivity(), errorSubView, getAllproductsResponceCall, fragmentPromoCodeSrRefresh, loadMore);
//            showToast(getActivity(), "success without fillter");


    }


    private void reInit() {
        onEndLess.previousTotal = 0;
        onEndLess.current_page = 1;
        onEndLess.previous_page = 1;
//        customerPromocodeList = new ArrayList<>();
//        homePromoCodeVrRvAdapter = new HomePromoCodeVrRvAdapter(getContext(), getActivity(), customerPromocodeList, navController);
//        fragmentPromoCodeRecyclerView.setAdapter(homePromoCodeVrRvAdapter);

        homeAdapter = new HomeAdapter(getContext(), getActivity(),list ,navController,"home");
        fragmentServicesRv.setAdapter(homeAdapter);
    }


    public void setError(String errorTitleTxt) {
        View.OnClickListener action = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (Filter) {
//                    getHajjAndUmrahListByFilter(0);
//                } else {
//                getallProductsList(0);
//                }

            }
        };
//        errorSubView.setVisibility(View.VISIBLE);
//        errorTitle.setText(errorTitleTxt);

    }




}