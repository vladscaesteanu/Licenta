package com.vladscaesteanu.licenta.initscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class InitPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    public InitPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return InitFragmentOne.newInstance();
            case 1:
                return InitFragmentTwo.newInstance();
            case 2: 
                return InitFragmentThree.newInstance();
            default:
                return null;
        }
    }

}