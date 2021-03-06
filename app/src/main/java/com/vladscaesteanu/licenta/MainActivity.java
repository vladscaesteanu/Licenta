package com.vladscaesteanu.licenta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.vladscaesteanu.licenta.initscreen.InitActivity;
import com.vladscaesteanu.licenta.model.Video;
import com.vladscaesteanu.licenta.video_screen.VideoFragment;
import com.vladscaesteanu.licenta.video_list.VideoListAdapter;
import com.vladscaesteanu.licenta.settings.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ListView listView;
    VideoListAdapter adapter;
    List<Video> videoList;
    FragmentManager fragmentManager;
    String dirPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        fragmentManager = getSupportFragmentManager();
        dirPath = Environment.DIRECTORY_MOVIES;
        listView = (ListView) findViewById(R.id.movie_list);
        adapter = new VideoListAdapter(this, test());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bundle = new Bundle();
                bundle.putString("VID_NAME", videoList.get(position).getName());
                bundle.putString("VID_PATH", videoList.get(position).getPath());
                bundle.putString("VID_DESCRIPTION",videoList.get(position).getDescription());
                Fragment fragment = VideoFragment.newInstance();
                fragment.setArguments(bundle);
                Transition explodeTransform = TransitionInflater.from(MainActivity.this).
                        inflateTransition(android.R.transition.fade);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                fragment.setEnterTransition(explodeTransform);
                ft.addToBackStack(fragment.getTag());
                ft.add(R.id.activity_container, fragment, fragment.getClass().getSimpleName());
                ft.commit();
                Log.d(TAG, "Fragment no is"+fragmentManager.getBackStackEntryCount());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            addFragment(SettingsFragment.newInstance());
            return true;
        }
        if(id == R.id.action_logout) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            prefs.edit().putBoolean("logged", false).apply();
            Intent intent = new Intent(this, InitActivity.class);
            this.finish();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void addFragment(Fragment fragment) {
        Transition changeTransform = TransitionInflater.from(this).
                inflateTransition(R.transition.change_image_transform);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.activity_container, fragment, fragment.getClass().getSimpleName());
        ft.addToBackStack(fragment.getTag());
        ft.commit();
        Log.d(TAG, "Fragment no is"+fragmentManager.getBackStackEntryCount());
    }

    private void removeFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
        fragmentManager.popBackStack();
    }

    private List<Video> test() {
        videoList = new ArrayList<Video>();
        videoList.add(new Video(1, "UNIX talkshow", "Debating the UNIX platform",
                "https://ia802302.us.archive.org/27/items/UNIX1985/UNIX1985_512kb.mp4",
                BitmapFactory.decodeResource(getResources(), R.drawable.one)));
        videoList.add(new Video(2, "Master the internet", "How to become an internet master",
                "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4",
                BitmapFactory.decodeResource(getResources(), R.drawable.two)));
        videoList.add(new Video(3, "Windows 95", "Discover the new Windows",
                "https://ia902505.us.archive.org/10/items/Windows4/Windows4_512kb.mp4",
                BitmapFactory.decodeResource(getResources(), R.drawable.three)));
        videoList.add(new Video(4, "Commodore 64", "Exclusive new tech",
                "https://ia800301.us.archive.org/5/items/CC517_commodore_64/CC517_commodore_64_512kb.mp4",
                BitmapFactory.decodeResource(getResources(), R.drawable.four)));
        videoList.add(new Video(5, "Computer networks", "Learn what's new in networks",
                "https://ia601404.us.archive.org/24/items/Computer1985_3/Computer1985_3_512kb.mp4",
                BitmapFactory.decodeResource(getResources(), R.drawable.five)));
        return videoList;
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "Fragment is " + getCurrentFragment());
        if(getCurrentFragment() == null ) {
            super.onBackPressed();
        } else {
            removeFragment(getCurrentFragment());
        }
    }

    private Fragment getCurrentFragment() {
        if (this.fragmentManager.getBackStackEntryCount() == 0) {
            return null;
        }
        return this.fragmentManager.findFragmentByTag(this.fragmentManager.getBackStackEntryAt(this.fragmentManager.getBackStackEntryCount() - 1).getName());
    }


}
