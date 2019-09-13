package com.example.bokjirock;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * FragmentPagerAdapter 를 상속받는 어댑터를 정의한다.
 */
public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] VIEW_MAPNTOP_TITLES = {"인기순","최신순"};
    private ArrayList<Fragment> fList;

    // 아답터 생성자
    public CustomFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fList) {
        super(fm);
        this.fList = fList;
    }

    // tab title를 반환 함수.
    @Override
    public CharSequence getPageTitle(int position) {

        return VIEW_MAPNTOP_TITLES[position];

    }

    // 해당 프라그먼트 호출 함수.
    @Override
    public Fragment getItem(int position) {
        return this.fList.get(position);
    }

    @Override
    public int getCount() {
        return fList.size();
    }
}