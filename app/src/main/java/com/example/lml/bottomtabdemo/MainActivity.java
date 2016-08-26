package com.example.lml.bottomtabdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }


    private void initViews() {

        mTablayout= (TabLayout) findViewById(R.id.tabLayout);
        mViewPager= (ViewPager) findViewById(R.id.viewPager);

        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {

            private String[] mTitles = new String[]{"唐僧", "大师兄", "二师兄","沙师弟"};

            @Override
            public Fragment getItem(int position) {
                if (position == 1) {
                    return new FragmentTwo();
                } else if (position == 2) {
                    return new FragmentThree();
                }else if (position==3){
                    return new FragmentFour();
                }
                return new FragmentOne();
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

        });

        mTablayout.setupWithViewPager(mViewPager);

        one = mTablayout.getTabAt(0);
        two = mTablayout.getTabAt(1);
        three = mTablayout.getTabAt(2);
        four = mTablayout.getTabAt(3);

        one.setIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp1));
        two.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
        three.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
        four.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));

    }






    /**
     * 初始化监听事件
     */
    private void initEvents() {

        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == mTablayout.getTabAt(0)) {
                    one.setIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp1));
                    mViewPager.setCurrentItem(0);
                } else if (tab == mTablayout.getTabAt(1)) {
                    two.setIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp1));
                    mViewPager.setCurrentItem(1);
                } else if (tab == mTablayout.getTabAt(2)) {
                    three.setIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp1));
                    mViewPager.setCurrentItem(2);
                }else if (tab == mTablayout.getTabAt(3)){
                    four.setIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp1));
                    mViewPager.setCurrentItem(3);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == mTablayout.getTabAt(0)) {
                    one.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                } else if (tab == mTablayout.getTabAt(1)) {
                    two.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                } else if (tab == mTablayout.getTabAt(2)) {
                    three.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                }else if (tab == mTablayout.getTabAt(3)){
                    four.setIcon(getResources().getDrawable(R.mipmap.ic_launcher));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
