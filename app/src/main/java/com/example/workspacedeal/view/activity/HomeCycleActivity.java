package com.example.workspacedeal.view.activity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.example.workspacedeal.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeCycleActivity extends BaseActivity {

    @BindView(R.id.nav_view)
    public BottomNavigationView navView;
//    NavigationView nav;
//    ActionBarDrawerToggle toggle;
//
//    DrawerLayout drawerLayout;

    private NavController navController;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }
        setContentView(R.layout.activity_home_cycle);
        ButterKnife.bind(this);
        NavHostFragment navHostFragmentWorker = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.home_activity_fragment_normal);
        NavigationUI.setupWithNavController(navView, navHostFragmentWorker.getNavController());
        navController = Navigation.findNavController(this, R.id.home_activity_fragment_normal);



//        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        nav=(NavigationView)findViewById(R.id.navmenu);
//        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
//
//        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        navView.setVisibility(View.VISIBLE);

//        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
//        nav.setCheckedItem(R.id.menu_home);

//        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//
//            Fragment temp;
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
//            {
//                switch (menuItem.getItemId())
//                {
//                    case R.id.menu_MyAccount :
//
//
//
//                        navView.setVisibility(View.GONE);
//                        navController.navigate(R.id.myAccount);
//
//                        break;
//                    case R.id.menu_AboutUs :
//                        navView.setVisibility(View.GONE);
//                       navController.navigate(R.id.aboutUs_Fragment);
//
//                        break;
//                    case R.id.menu_ContactUs :
//
//                        navController.navigate(R.id.contact_us_Fragment);
//
//                        navView.setVisibility(View.GONE);
//
//                        break; case R.id.menu_RateUs :
//
//                        break;
//                        case R.id.menu_Share :
//                            navView.setVisibility(View.GONE);
//                            navController.navigate(R.id.favoret_Fragment);
//
//                        break;
//                        case R.id.menu_Logout :
//
//                            navView.setVisibility(View.GONE);
//                        break;
//                }
////                getSupportFragmentManager().beginTransaction().replace(R.id.home_activity_fragment_normal,temp).commit();
//                drawerLayout.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });
//










    }




//   public void  showNavigationDrawer() {
//       drawerLayout.openDrawer(GravityCompat.START);
//
//   }   public boolean  showNavigationDrawerisopen() {
//        if(drawerLayout.isOpen())
//return true;
//        else return false;
//   }
//
//   public void  heddinNavigation() {
//       navView.setVisibility(View.GONE);
//
//   }
//   public void  showNavigation() {
//       navView.setVisibility(View.VISIBLE);
//
//   }
// public void  visabbleTitel(){
////       FrameLayout titel1=(FrameLayout)findViewById(R.id.hedder);
////       BottomNavigationView navView1=(BottomNavigationView) findViewById(R.id.nav_view);
//
//        navView.setVisibility(View.VISIBLE);
//
//   }
}