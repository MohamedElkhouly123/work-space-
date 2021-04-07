package com.example.workspacedeal.view.fragment.HomeCycle2;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.workspacedeal.R;
import com.example.workspacedeal.adapter.HomeAdapter;
import com.example.workspacedeal.utils.OnEndLess;
import com.example.workspacedeal.view.fragment.BaSeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Search_Fragment extends BaSeFragment {
    NavController navController ;

    @BindView(R.id.fragment_search__recycler_view)
    RecyclerView fragmentServicesRv;
    private List<String> list= new ArrayList<>() ;
    //    private ViewModelGetLists viewModel;
    @BindView(R.id.fragment_search__sr_refresh)
    SwipeRefreshLayout fragmentSCRefresh;
    //    private NavController navController;
    public Integer maxPage = 0;
    private OnEndLess onEndLess;
    @BindView(R.id.load_more)
    RelativeLayout loadMore;
    HomeAdapter homeAdapter;
    private LinearLayoutManager lLayout;
    private String backdestination;
    public Search_Fragment() {
        // Required empty public constructor
    }
    void setData(){

        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (this.getArguments() != null) {


            backdestination = this.getArguments().getString("filterPage");


        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);}

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getActivity().getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.WHITE);}

        View root =inflater.inflate(R.layout.fragment_search, container, false);

        ButterKnife.bind(this, root);
        //
        setData();
        initRS();
        fragmentServicesRv.setNestedScrollingEnabled(false);
        navController = Navigation.findNavController(getActivity(), R.id.home_activity_fragment_normal);
        // Inflate the layout for this fragment
        return root;
    }

    @Override
    public void onBack() {


        Bundle bundle = new Bundle();

        bundle.putString("filterPage",backdestination);

        navController.navigate(R.id.action_search_fragment_to_filter_fragment,bundle);

        super.onBack();
    }


    @OnClick({R.id.fragment_search_image_back_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_search_image_back_btn:
                onBack();
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

        onEndLess = new OnEndLess(lLayout, 2) {
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

        homeAdapter = new HomeAdapter(getContext(), getActivity(),list ,navController,"search");
        fragmentServicesRv.setAdapter(homeAdapter);
//            showToast(getActivity(), "success adapter");


//        if (customerPromocodeList.size() == 0) {
//            getallProductsList(0);
//        }
//        else {
//            clientAndRestaurantHomeFragmentSFlShimmer.stopShimmer();
//            clientAndRestaurantHomeFragmentSFlShimmer.setVisibility(View.GONE);
//        }

        fragmentSCRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                maxPage = 0;
//                if (Filter) {
//                    getHajjAndUmrahListByFilter(0);
//                } else {
                getallProductsList(0);
//                }

            }
        });
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

        homeAdapter = new HomeAdapter(getContext(), getActivity(),list ,navController,"search");
        fragmentServicesRv.setAdapter(homeAdapter);
    }


    public void setError(String errorTitleTxt) {
        View.OnClickListener action = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (Filter) {
//                    getHajjAndUmrahListByFilter(0);
//                } else {
                getallProductsList(0);
//                }

            }
        };
//        errorSubView.setVisibility(View.VISIBLE);
//        errorTitle.setText(errorTitleTxt);

    }




}
