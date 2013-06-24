package com.viewpagerindicator;

import android.view.View;

public interface CustomViewPagerAdapter {
    /**
     * Get icon representing the page at {@code index} in the adapter.
     */
    View getSpinnerView(int index);

    // From PagerAdapter
    int getCount();
}
