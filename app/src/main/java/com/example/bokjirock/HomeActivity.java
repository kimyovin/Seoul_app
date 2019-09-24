package com.example.bokjirock;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends Fragment {

    private ViewPager tabViewPager; //tab이 들어갈 view pager
    private CustomFragmentPagerAdapter pagerAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("cycle", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("cycle", "onCreate");
    }

    @Override
    public void onPause() {
        super.onPause();
//        actionBar.setDisplayShowTitleEnabled(false); //액션바 노출 유무
        Log.i("cycle", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("cycle", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("cycle", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("cycle", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("cycle", "onDetach");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
//        setContentView(R.layout.activity_main);
        Log.i("cycle", "onCreateView");

        tabViewPager = view.findViewById(R.id.pager);    //스와이프할 뷰페이지를 정의
        pagerAdapter = new CustomFragmentPagerAdapter(
                getChildFragmentManager()
        );
        tabViewPager.setAdapter(pagerAdapter);
        TabLayout mTab = (TabLayout) view.findViewById(R.id.tabMode);
        mTab.setupWithViewPager(tabViewPager);

        tabViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 1:
                        refresh();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    private void refresh() {
        Log.e("확인1", "탭1");
        pagerAdapter.notifyDataSetChanged();
        return;
    }

}



