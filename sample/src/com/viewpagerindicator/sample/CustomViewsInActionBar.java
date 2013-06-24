package com.viewpagerindicator.sample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.viewpagerindicator.CustomViewPageIndicator;

public class CustomViewsInActionBar extends BaseSampleActivity {

    TestSpinnerFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_icons);

        mAdapter = new TestSpinnerFragmentAdapter(getSupportFragmentManager(), this);
        mAdapter.setSize(10);

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CustomViewPageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
}
