package com.vladscaesteanu.licenta.initscreen;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vladscaesteanu.licenta.R;
import com.vladscaesteanu.licenta.loginscreen.LoginFragment;

import me.relex.circleindicator.CircleIndicator;

public class InitActivity extends AppCompatActivity {

    private static String TAG = InitActivity.class.getSimpleName();
    FragmentPagerAdapter adapterViewPager;
    ViewPager viewPager;
    boolean tutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        tutorial = prefs.getBoolean("tutorial", true);

        if (tutorial) {
            viewPager = (ViewPager) findViewById(R.id.viewPager);
            adapterViewPager = new InitPagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(adapterViewPager);
            CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
            indicator.setViewPager(viewPager);
        } else {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_init, LoginFragment.newInstance());
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (!tutorial) {
            super.onBackPressed();
        }
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}
