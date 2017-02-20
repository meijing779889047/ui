package com.project.coordinatortablayout.ui.coordinatorlayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by meijing on 2017/2/7.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private  List<Fragment>  list;
    private  String[] titles;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment>  list,String[] titles) {
        super(fm);
        this.list=list;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
