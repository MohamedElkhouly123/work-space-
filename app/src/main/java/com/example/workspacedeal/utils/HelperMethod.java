package com.example.workspacedeal.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.workspacedeal.R;
import com.example.workspacedeal.data.model.DateTxt;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.AlbumFile;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class HelperMethod {
    public static ProgressDialog progressDialog;
    public static androidx.appcompat.app.AlertDialog alertDialog;

    public static void replaceFragment(FragmentManager getChildFragmentManager, int id, Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public static void replaceFragment2(FragmentManager getChildFragmentManager, int id, Fragment fragment) {
        Handler handler = new Handler();
        FragmentTransaction transaction = getChildFragmentManager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack(null);
//        transaction.commit();
        Runnable r = new Runnable() {
            public void run() {
                if (!getChildFragmentManager.isDestroyed()) {
                    transaction.commit();
                }
            }
        };
        handler.postDelayed(r, 500);
    }

    public static void replaceFragmentWithAnimation(FragmentManager getChildFragmentManager, int id, Fragment fragment, String fromWhere) {

            FragmentTransaction transaction = getChildFragmentManager.beginTransaction();
            if (fromWhere == "l") {
//            android.R.anim.slide_in_left
                transaction.setCustomAnimations(R.anim.slide_in_left,
                        R.anim.slide_out_right);
            }
            if (fromWhere == "r") {
                transaction.setCustomAnimations(R.anim.enter_from_right,
                        R.anim.exit_to_left);
            }
            if (fromWhere == "t") {
                transaction.setCustomAnimations(R.anim.slide_out_down, R.anim.slide_in_down);
            }
            if (fromWhere == "b") {
                transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            }
//        if(fromWhere=="rr"){
//            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.slide_in_left, R.anim.slide_out_right);}
//        if(fromWhere=="t"){
//            transaction.setCustomAnimations(R.anim.slide_in_down, R.anim.slide_out_up);}
//        if(fromWhere=="b"){
//            transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down);}
            transaction.replace(id, fragment);
            transaction.addToBackStack(null);

                    transaction.commit();

//            }
//        }
    }

    public static void replaceFragmentWithAnimation2(FragmentManager getChildFragmentManager, int id, Fragment fragment, String fromWhere) {
//        if (fragment != null) {
        Handler handler = new Handler();

        FragmentTransaction transaction = getChildFragmentManager.beginTransaction();
        if (fromWhere == "l") {
//            android.R.anim.slide_in_left
            transaction.setCustomAnimations(R.anim.slide_in_left,
                    R.anim.slide_out_right);
        }
        if (fromWhere == "r") {
            transaction.setCustomAnimations(R.anim.enter_from_right,
                    R.anim.exit_to_left);
        }
        if (fromWhere == "t") {
            transaction.setCustomAnimations(R.anim.slide_out_down, R.anim.slide_in_down);
        }
        if (fromWhere == "b") {
            transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
        }
//        if(fromWhere=="rr"){
//            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.slide_in_left, R.anim.slide_out_right);}
//        if(fromWhere=="t"){
//            transaction.setCustomAnimations(R.anim.slide_in_down, R.anim.slide_out_up);}
//        if(fromWhere=="b"){
//            transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down);}
        transaction.replace(id, fragment);
        transaction.addToBackStack(null);
        Runnable r = new Runnable() {
            public void run() {
                if (!getChildFragmentManager.isDestroyed()) {
                    transaction.commit();
                }
            }
        };
        handler.postDelayed(r, 500);
//            }
//        }
    }

    public static void setInitRecyclerViewAsGridLayoutManager(Activity activity, RecyclerView recyclerView, GridLayoutManager gridLayoutManager, int numberOfColumns) {
        gridLayoutManager = new GridLayoutManager(activity, numberOfColumns);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        private final EditText editText;

        public TimePickerFragment(EditText editText) {
            this.editText=editText;
        }



        public static BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
            Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
            vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
            Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//            Bitmap smallMarker = Bitmap.createScaledBitmap(bitmap, width, height, false);
            Canvas canvas = new Canvas(bitmap);
            vectorDrawable.draw(canvas);
            return BitmapDescriptorFactory.fromBitmap(bitmap);
        }
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog=new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));

            // Create a new instance of TimePickerDialog and return it
            return timePickerDialog;
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            editText.setText(hourOfDay+":"+minute);
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        private final EditText editText;
        private Calendar minDate;
        int year ,month,day;
        public DatePickerFragment(EditText editText) {
            this.editText=editText;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
             year = c.get(Calendar.YEAR);
             month = c.get(Calendar.MONTH);
             day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), this, year, month, day);
            // Create a new instance of DatePickerDialog and return it
            minDate = Calendar.getInstance();
            minDate.set(year, month-1, day);//Year,Mounth -1,Day
            datePickerDialog.getDatePicker().setMinDate(minDate.getTimeInMillis());
            return datePickerDialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user

            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
            DecimalFormat mFormat = new DecimalFormat("00", symbols);
            String data = year + "-" + mFormat.format(Double.valueOf((month + 1))) + "-" + mFormat.format(Double.valueOf(day));
            editText.setText(data);

        }
    }

    public static void showCalender(Context context, String title, final TextView text_view_data, final DateTxt data1) {
        DatePickerDialog mDatePicker = new DatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
//                datepicker.setMaxDate();
                DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
                DecimalFormat mFormat = new DecimalFormat("00", symbols);

                String data = selectedYear + "-" + mFormat.format(Double.valueOf((selectedMonth + 1))) + "-" + mFormat.format(Double.valueOf(selectedDay));
                data1.setDate_txt(data);
                data1.setDay(mFormat.format(Double.valueOf(selectedDay)));
                data1.setMonth(mFormat.format(Double.valueOf(selectedMonth + 1)));
                data1.setYear(String.valueOf(selectedYear));
                text_view_data.setText(data);
            }
        }, Integer.parseInt(data1.getYear()), Integer.parseInt(data1.getMonth()) - 1, Integer.parseInt(data1.getDay()));
//        mDatePicker.getDatePicker().setMinDate(minDate.getTimeInMillis());
//        mDatePicker.getDatePicker().setMaxDate(maxDate.getTimeInMillis());
        mDatePicker.setTitle(title);
        mDatePicker.show();
    }

    public static MultipartBody.Part convertFileToMultipart(String pathImageFile, String Key, FragmentActivity activity) {


        if (pathImageFile != null) {
            File file = new File(pathImageFile);
            RequestBody reqFileselect = RequestBody.create(MediaType.parse("*/*"), file);
//            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("photo", file.getName(), reqFileselect);

//            RequestBody reqFileselect = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part Imagebody = MultipartBody.Part.createFormData(Key, file.getName(), reqFileselect);
//            MultipartBody.Part Imagebody = MultipartBody.Part.createFormData("photo3", file.getName(), reqFileselect);
//            showToast(activity, String.valueOf(Imagebody));

            return Imagebody;
        } else {
            return null;
        }
    }

//    public static MultipartBody.Part convertFileToMultipart(String pathImageFile, String Key) {
//        if (pathImageFile != null) {
//            File file = new File(pathImageFile);
////            RequestBody reqFileselect = RequestBody.create(MediaType.parse("image/*"), file);
//            RequestBody reqFileselect = RequestBody.create(MediaType.parse("*/*"), file);
////            MultipartBody.Part Imagebody = MultipartBody.Part.createFormData(Key, file.getName(), reqFileselect);
//            MultipartBody.Part Imagebody = MultipartBody.Part.createFormData(Key, file.getName(), reqFileselect);
//            return Imagebody;
//        } else {
//            return null;
//        }
//    }

//    public static MultipartBody.Part prepareFilePart(String partName, Uri images){
//
//        List<MultipartBody.Part> listOfImages = new ArrayList<>();
//
//
//        ArrayList<Object> upFileList;
//        for (int i = 0; i < listOfImages.size(); i++){
////            listOfImages.add(prepareFilePart("image[$i]", images[i]));
////            parts.add(prepareFilePart("my_file["+i+"]", (Uri) upFileList.get(i)));
//        }
//
//        File file = new File(partName);
////
//        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
//            return MultipartBody.Part.createFormData(partName, file.getName(),requestBody);
//        }

    public static RequestBody convertToRequestBody(String part) {
        try {
            if (!part.equals("")) {
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), part);
                return requestBody;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }


    public static Date convertDateString(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            Date parse = format.parse(date);

            return parse;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static DateTxt convertStringToDateTxtModel(String date) {
//        try {
//            Date date1 = convertDateString(date);
//            String day = (String) DateFormat.format("dd", date1); // 20
//            String monthNumber = (String) DateFormat.format("MM", date1); // 06
//            String year = (String) DateFormat.format("yyyy", date1); // 2013
//
//            return new DateTxt(day, monthNumber, year, date);
//
//        } catch (Exception e) {
//            return null;
//        }
//    }

    public static void onLoadImageFromUrl(ImageView imageView, String URl, Context context) {
//        Glide.with(context)
//                .load(URl)
//                .into(imageView);

//        Glide.with(context).load(URl)
//                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
//                .into(imageView);
//        Glide.with(imageView.getContext())
//                .setDefaultRequestOptions(new RequestOptions()
//                        .circleCrop())
//                .load(imageURL)
//                .placeholder(R.drawable.loading)
//                .into(imageView);
    }

    public static void onLoadImageFromUrl2(ImageView imageView, String URl, Context context) {
//        Glide.with(context)
//                .load(URl)
//                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
//                .into(imageView);

    }

    public static void onLoadCirImageFromUrl(CircleImageView cirImageView, String URl, Context context) {
//        Glide.with(context)
//                .load(URl)
//                .into(cirImageView);
    }
    public static void onLoadCirImageFromUrl2(CircleImageView cirImageView, String URl, Context context) {
//        Glide.with(context)
//                .load(URl)
//                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
//                .into(cirImageView);
    }

    public static void showProgressDialog(Activity activity, String title) {
        try {

            progressDialog = new ProgressDialog(activity);
            progressDialog.setMessage(title);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);

            progressDialog.show();

        } catch (Exception e) {

        }
    }

    public static void dismissProgressDialog() {
        try {

            progressDialog.dismiss();

        } catch (Exception e) {

        }
    }

//    public static void openGallery(Activity activity) {
//        new ImagePicker.Builder(activity)
//                .mode(ImagePicker.Mode.CAMERA_AND_GALLERY)
//                .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
//                .directory(ImagePicker.Directory.DEFAULT)
////                .extension(ImagePicker.Extension.PNG)
////                .scale(600, 600)
//                .allowMultipleImages(false)
//                .enableDebuggingMode(true)
//                .build();
//    }

    public static void openGalleryِAlpom(Context context, ArrayList<AlbumFile> mAlbumFiles,
                                         Action<ArrayList<AlbumFile>> action, int count) {
        Album.initialize(AlbumConfig.newBuilder(context)
                .setAlbumLoader(new MediaLoader()).build());
        Album.image(context) // Image selection.
                .multipleChoice()
                .camera(true)
                .columnCount(3)
                .selectCount(count)
                .checkedList(mAlbumFiles)
                .onResult(action)
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                    }
                }).start();
    }

    public static void disappearKeypad(Activity activity, View v) {
        try {
            if (v != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        } catch (Exception e) {

        }
    }

    public static void changeLang(Context context, String lang) {
        Resources res = context.getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(lang)); // API 17+ only.
        // Use conf.locale = new Locale(...) if targeting lower versions
        res.updateConfiguration(conf, dm);
    }

    public static void htmlReader(TextView textView, String s) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(s, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(s));
        }
    }

    public static void customToast(Activity activity, String ToastTitle, boolean failed) {

        LayoutInflater inflater = activity.getLayoutInflater();

        int layout_id;

        if (failed) {
            layout_id = R.layout.toast;
        } else {
            layout_id = R.layout.success_toast;
        }

        View layout = inflater.inflate(layout_id,
                (ViewGroup) activity.findViewById(R.id.toast_layout_root));

//        TextView text = layout.findViewById(R.id.toast_txt);
//        text.setText(ToastTitle);

        Toast toast = new Toast(activity);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public static void onPermission(Activity activity) {
        String[] perms = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CALL_PHONE};

        ActivityCompat.requestPermissions(activity,
                perms,
                100);

    }
    public static void showToast(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
    public static void showLongToast(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();

    }

}
