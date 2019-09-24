package com.example.bokjirock;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {
    MenuItem item1, item2, item3, item4;
    //private TextView mTextMessage;
    //Fragment 매니저 선언
    private FragmentManager fragmentManager = getSupportFragmentManager();
    //Page에 대한 Activity 선언
    private HomeActivity fragmentHome = new HomeActivity();
    private searchActivity fragmentSearch = new searchActivity();
    private categoryActivity fragmentCategory = new categoryActivity();
    private locationActivity fragmentLocation = new locationActivity();

    @Override   //하단바 메뉴에 대한 intent 설정
    public boolean onMenuItemClick(MenuItem menuItem) {
//        if(menuItem.getItemId() == R.id.navigation_home){   //1번째 하단바 메뉴
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//        }
        if(menuItem.getItemId() == R.id.navigation_dashboard){  //2번째 하단바 메뉴
            Intent intent = new Intent(this, searchActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId() == R.id.navigation_notifications){  //3번째 하단바 메뉴
            //Intent intent = new Intent(this, CategoryActivity.class);
            Intent intent=new Intent(this, categoryActivity.class);
            startActivity(intent);
        }
        if (menuItem.getItemId() == R.id.navigation_search) {   //4번째 하단바 메뉴
            Intent intent = new Intent(this, locationActivity.class);
            startActivity(intent);
            //    finish();
            return true;
        }
        return false;
    }

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            onMenuItemClick(item);
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
//                    setContentView(R.layout.activity_main);
                    return true;
                case R.id.navigation_dashboard:
                    transaction.replace(R.id.frameLayout, fragmentSearch).commitAllowingStateLoss();
//                    container.setBackgroundColor(Color.YELLOW);
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.frameLayout, fragmentCategory).commitAllowingStateLoss();
//                    container.setBackgroundColor(Color.BLUE);
                    return true;
                case R.id.navigation_search:
                    transaction.replace(R.id.frameLayout, fragmentLocation).commitAllowingStateLoss();
//                    mTextMessage.setText("Login");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();

        //하단바 액션 불구설정
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);  //하단바 리스너 설정
        BottomNavigationViewHelper.disableShiftMode(navigation);    //하단바 viewHelper 설정
    }
    //onCreate 끝

}
