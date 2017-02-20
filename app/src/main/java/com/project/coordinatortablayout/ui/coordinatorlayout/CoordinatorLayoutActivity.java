package com.project.coordinatortablayout.ui.coordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.project.coordinatortablayout.R;
import com.project.coordinatortablayout.ui.coordinatorlayout.adapter.MyFragmentAdapter;
import com.project.coordinatortablayout.ui.toolbar.config.BaseTransparentBarActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.CoordinatorLayout +AppBarLayout  的使用
 * 2,tablayout+viewpager+fragment的使用
 * 3.nestedScroolview与recyclerview的使用
 */
public class CoordinatorLayoutActivity extends BaseTransparentBarActivity implements ViewPager.OnPageChangeListener,TabLayout.OnTabSelectedListener{

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> fragments;
    private String[]  titles=new String[]{"tab1","tab2"};
    private MyFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        //初始化组件
        initView();
        //初始化数据
        initData();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        mViewPager=(ViewPager) findViewById(R.id.fragment_left_viewpagwe);
        mTabLayout= (TabLayout) findViewById(R.id.fragment_left_tablayout);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        fragments=new ArrayList<>();
        fragments.add(LeftFragment.newInstance());
        fragments.add(RightFragment.newInstance());
        mAdapter=new MyFragmentAdapter(getSupportFragmentManager(),fragments,titles);
        mTabLayout.addOnTabSelectedListener(this);
        mViewPager.setOnPageChangeListener(this);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
