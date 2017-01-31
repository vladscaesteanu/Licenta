package com.vladscaesteanu.licenta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

        listView = (ListView) findViewById(R.id.movie_list);
        adapter = new VideoListAdapter(this, test());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView movieImage = (ImageView) findViewById(R.id.list_movie_bitmap);
                TextView movieTitle = (TextView) findViewById(R.id.list_movie_title);
                TextView movieDesc = (TextView) findViewById(R.id.list_movie_desc);
                Bundle bundle = new Bundle();
                String imageTransitionName = movieImage.getTransitionName();
                String titleTransitionName = movieTitle.getTransitionName();
                bundle.putString("TRANS_NAME", imageTransitionName);
                bundle.putString("TRANS_TITLE", titleTransitionName);
                Fragment fragment = VideoFragment.newInstance();
                fragment.setArguments(bundle);
                Transition changeTransform = TransitionInflater.from(MainActivity.this).
                        inflateTransition(R.transition.change_image_transform);
                Transition explodeTransform = TransitionInflater.from(MainActivity.this).
                        inflateTransition(android.R.transition.fade);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                fragment.setSharedElementEnterTransition(changeTransform);
                fragment.setEnterTransition(explodeTransform);
                ft.addToBackStack(fragment.getTag());
                ft.addSharedElement(movieImage, "image");
                ft.addSharedElement(movieTitle, "title");
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
        ft.add(R.id.activity_container, fragment, fragment.getClass().getSimpleName());
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
        List<Video> list = new ArrayList<Video>();
        list.add(new Video(1, "Bau1", "bau1", ""));
        list.add(new Video(2, "Bau2", "bau2", ""));
        list.add(new Video(3, "Bau3", "bau3", ""));
        list.add(new Video(4, "Bau4", "bau4",""));
        list.add(new Video(5, "Bau5", "bau5",""));
        return list;
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
