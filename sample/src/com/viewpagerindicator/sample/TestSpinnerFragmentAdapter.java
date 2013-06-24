package com.viewpagerindicator.sample;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.viewpagerindicator.CustomViewPagerAdapter;

import java.util.ArrayList;

class TestSpinnerFragmentAdapter extends FragmentPagerAdapter implements CustomViewPagerAdapter {
    protected static final String[] CONTENT = new String[] { "This", "Is", "A", "Test", };
    protected ArrayList<View> views = new ArrayList<View>();

    private int mCount = CONTENT.length;
    private Context mContext;

    public TestSpinnerFragmentAdapter(FragmentManager fm, Context c) {
        super(fm);
        mContext = c;
        mCount = 0;
    }

    public void setSize(int size) {
        mCount = size;
        for (int x=0; x < size; x++) {
            Spinner spinner = new Spinner(mContext);
            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item, CONTENT);
            spinner.setAdapter(spinnerArrayAdapter);
            views.add(x, spinner);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
    }

    @Override
    public View getSpinnerView(int index) {
        return views.get(index);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return TestSpinnerFragmentAdapter.CONTENT[position % CONTENT.length];
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}