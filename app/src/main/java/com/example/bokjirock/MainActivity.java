package com.example.bokjirock;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {
    MenuItem item1, item2, item3, item4;
    //private TextView mTextMessage;

    private ViewPager tabViewPager; //tab이 들어갈 view pager
    ActionBar actionBar;    //swipe할 수 있게 해주는 액션바
    private FragmentManager fm;
    private ArrayList<Fragment> fList;  //각 탭에 들어갈 fragment list
    CustomFragmentPagerAdapter pagerAdapter;


    @Override   //하단바 메뉴에 대한 intent 설정
    public boolean onMenuItemClick(MenuItem menuItem) {
//        if(menuItem.getItemId() == R.id.navigation_home){   //1번째 하단바 메뉴
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//        }
        if (menuItem.getItemId() == R.id.navigation_dashboard) {  //2번째 하단바 메뉴
            Intent intent = new Intent(this, searchActivity.class);
            startActivity(intent);
        }
        if (menuItem.getItemId() == R.id.navigation_notifications) {  //3번째 하단바 메뉴
            //Intent intent = new Intent(this, CategoryActivity.class);
            Intent intent = new Intent(this, categoryActivity.class);
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
            onMenuItemClick(item);
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    setContentView(R.layout.activity_main);
//                    return true;
//                case R.id.navigation_dashboard:
//                    container.setBackgroundColor(Color.YELLOW);
//                    return true;
//                case R.id.navigation_notifications:
//                    container.setBackgroundColor(Color.BLUE);
//                    return true;
//                case R.id.navigation_search:
//                    mTextMessage.setText("Login");
//                    return true;
//            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabViewPager = (ViewPager) findViewById(R.id.pager);

        pagerAdapter = new CustomFragmentPagerAdapter(
                getSupportFragmentManager()
        );
        tabViewPager.setAdapter(pagerAdapter);
        TabLayout mTab = (TabLayout) findViewById(R.id.tabMode);
        mTab.setupWithViewPager(tabViewPager);

        //하단바 액션 불구설정
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);  //하단바 리스너 설정
//        BottomNavigationViewHelper.disableShiftMode(navigation);    //하단바 viewHelper 설정

        tabViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 1:
                        refresh();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void refresh(){
        Log.e("확인1","탭1");
        pagerAdapter.notifyDataSetChanged();
        return;
    }

}
