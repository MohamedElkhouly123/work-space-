package com.example.workspacedeal.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.activity.BaseActivity;
import com.google.android.gms.location.places.AddPlaceRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
//    private final DialogAdapterCallback dialogAdapterCallback;

    private BaseActivity activity;
    private Context context;
    private String pageType;
    int flage=0;
    private List<String> list= new ArrayList<>();
    //    private List<String> hotelImages= new ArrayList<>();
    private NavController navController;
    public HomeAdapter(
            Context context, Activity activity, List<String> getservicesItemsListData, NavController navController,String pageType) {
        this.activity = (BaseActivity) activity;
        this.context = context;
        this.navController = navController;
        this.pageType=pageType;

        this.list = getservicesItemsListData;
    }


    /**
     * Return the view type of the item at <code>position</code> for the purposes
     * of view recycling.
     *
     * <p>The default implementation of this method returns 0, making the assumption of
     * a single view type for the adapter. Unlike ListView adapters, types need not
     * be contiguous. Consider using id resources to uniquely identify item view types.
     *
     * @param position position to query
     * @return integer value identifying the type of the view needed to represent the item at
     * <code>position</code>. Type codes need not be contiguous.
     */
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.card_item,
                parent, false);

        return new ViewHolder(view);
    }


//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
//    {
//        View v = null;
//
//        if (viewType == AD_TYPE)
//        {
//            v =  LayoutInflater.from(activity).inflate(R.layout.card_item,
//                    parent, false);
//            float density = activity.getResources().getDisplayMetrics().density;
//            int height = Math.round(AdSize.BANNER.getHeight() * density);
//            AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT,height);
//            v.setLayoutParams(params);
//
//            AddPlaceRequest adRequest = new AddPlaceRequest().Builder().build();
//            if (adRequest != null && v != null){
//                v.loadAd(adRequest);
//            }
//        }
//        else
//            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false);
//
//        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(v);
//        return viewHolder;
//    }






    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }
    @SuppressLint("ResourceAsColor")
    private void setData(ViewHolder holder, int position) {
//        if (pageType.equals("workSpace") || pageType.equals("sharedOffice") || pageType.equals("meetingRoom")){
//            holder.cardItemFrame.setBackgroundColor(R.color.card_item_color2);
////        final int itemType = getItemViewType(position);
//    }
//else{            holder.cardItemFrame.setBackgroundColor(R.color.card_item_color2);
//
//
//
//        }

    }

    private void setAction(ViewHolder holder, int position) {

        holder.cardItemLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//
//                bundle.putString("myServiceOrMentaimnanceOrAqar","aqar");

//                navController.navigate(R.id.action_myBookingsVendorsMentainanceFragment_to_subStoreDetailsFragment,bundle);
if( holder.cardItemLoveRed.getVisibility()==View.GONE){
    holder.cardItemLoveRed.setVisibility(View.VISIBLE);
    holder.cardItemLoveWhite.setVisibility(View.GONE);


}else {

    holder.cardItemLoveRed.setVisibility(View.GONE);
    holder.cardItemLoveWhite.setVisibility(View.VISIBLE);

}




            }
        });
    }


    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_title_tv)
//        TextView cardviewGeneralVertHajjAndHotelsItemTitleTv;

        @BindView(R.id.card_item_description_tv)
        TextView cardItemTv;
        @BindView(R.id.card_item_location_tv)
        TextView cardItemLocationTv;
        @BindView(R.id.card_items_name_tv)
        TextView cardItemNameTv;
        @BindView(R.id.card_item_state_tv)
        TextView cardItemStateTv;
        @BindView(R.id.card_item_rate_tv)
        TextView cardItemRateTv;
        @BindView(R.id.card_item_type_tv)
        TextView cardItemTypeTv;
        @BindView(R.id.card_item_love)
        FrameLayout cardItemLove;
        @BindView(R.id.card_item_framelayout)
        FrameLayout cardItemFrame;
        @BindView(R.id.card_item_love_img_red)
        ImageView cardItemLoveRed;
        @BindView(R.id.card_item_love_img_white)
        ImageView cardItemLoveWhite;

        //        @BindView(R.id.card_my_store_order_item_img)
//        CircleImageView cardMyStoreOrderItemPhotoCircularImageView;







        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
//            navController = Navigation.findNavController(activity, R.id.home_activity_fragment);

        }
    }
}
