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

import java.util.ArrayList;

public class HomeActivity extends Fragment {

    private ViewPager tabViewPager; //tab이 들어갈 view pager
    ActionBar actionBar;    //swipe할 수 있게 해주는 액션바
    private FragmentManager fm;
    private ArrayList<Fragment> fList;  //각 탭에 들어갈 fragment list

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("cycle", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("cycle", "onCreate");
        actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();  //액션바 객체 정의

        actionBar.show();
        //리스너있던 자리

    }

    @Override
    public void onPause() {
        super.onPause();
        actionBar.removeAllTabs();
        actionBar.hide();
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
        fm = getFragmentManager();  //fragment Manager 객체 정의

        tabViewPager = view.findViewById(R.id.pager);    //스와이프할 뷰페이지를 정의
        //액션바 속성 정의
        actionBar.setDisplayShowTitleEnabled(true); //액션바 노출 유무
        actionBar.setTitle("정책 소식지");  //액션바 타이틀 라벨

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);    //액션바에 모드 설정; navigation_mode_tabs로 tab모드 설정

        //액션바에 추가될 탭 생성
        ActionBar.Tab tab1 = actionBar.newTab().setText("인기순").setTabListener(tabListener);
        ActionBar.Tab tab2 = actionBar.newTab().setText("최신순").setTabListener(tabListener);

        //액션바에 탭 추가
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);

        //각 탭에 들어갈 fragment 생성 및 추가
        fList = new ArrayList<Fragment>();
        fList.add(Fragment1.newInstance());
        fList.add(Fragment2.newInstance());



        //swipe로 tab을 이동할 viewpager의 리스너 설정
        tabViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //뷰페이져의 adapter 생성, 연결

        CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(fm, fList);

        tabViewPager.setAdapter(adapter);

        return view;
    }

    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            //액션바에서 선택된 탭에 대응되는 페이지를 뷰페이지에서 현재 보여지는 페이지로 변경
            tabViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            //해당 탭을 선택시 처리
            //해당 탭을 선택시 해당 뷰페이져로 이동
//            actionBar.setSelectedNavigationItem(tab.getPosition());
//            tabViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            //해당 탭이 다시 선택됐을때 처리
            //그냥 다시 냅두니 아무코드 X
        }
    };


}
