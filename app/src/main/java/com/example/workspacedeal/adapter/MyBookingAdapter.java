package com.example.workspacedeal.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workspacedeal.R;
import com.example.workspacedeal.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyBookingAdapter extends RecyclerView.Adapter<MyBookingAdapter.ViewHolder> {
//    private final DialogAdapterCallback dialogAdapterCallback;

    private BaseActivity activity;
    private Context context;
    private List<String> list= new ArrayList<>();
    //    private List<String> hotelImages= new ArrayList<>();
    private NavController navController;
    public MyBookingAdapter(
            Context context, Activity activity, List<String> getservicesItemsListData, NavController navController) {
        this.activity = (BaseActivity) activity;
        this.context = context;
        this.navController = navController;

        this.list = getservicesItemsListData;
    }








    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.card_item_my_booking,
                parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }
    private void setData(ViewHolder holder, int position) {

//        final int itemType = getItemViewType(position);



    }

    private void setAction(ViewHolder holder, int position) {
//
//        holder.cardMyStoreOrderItemLy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle bundle = new Bundle();
//
//                bundle.putString("myServiceOrMentaimnanceOrAqar","aqar");
//
//                navController.navigate(R.id.action_myBookingsVendorsMentainanceFragment_to_subStoreDetailsFragment,bundle);
//
//
//
//
//
//            }
//        });
    }


    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //        @BindView(R.id.cardview_general_vert_hajj_and_hotels_item_title_tv)
//        TextView cardviewGeneralVertHajjAndHotelsItemTitleTv;

        @BindView(R.id.cared_item_my_booking_booked)
        TextView caredItemMyBookingBookedTv;
        @BindView(R.id.cared_item_my_booking_booked_exprired)
        TextView caredItemMyBookingBookedExprirdTv;
        @BindView(R.id.cared_item_my_booking_name_tv)
        TextView caredItemMyBookingNameTv;
        @BindView(R.id.cared_item_my_booking_state_tv)
        TextView caredItemMyBookingStateTv;
        @BindView(R.id.cared_item_my_booking_rating_bar)
        RatingBar caredItemMyBookingRatingTv;
        @BindView(R.id.cared_item_my_booking_type)
        TextView caredItemMyBookingTypeTv;
  @BindView(R.id.cared_item_my_booking_calender_tv)
        TextView caredItemMyBookingCalenderTv;

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
