package com.vladscaesteanu.licenta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.vladscaesteanu.licenta.model.Movie;
import com.vladscaesteanu.licenta.movie_details.MovieFragment;
import com.vladscaesteanu.licenta.movie_list.MovieListAdapter;
import com.vladscaesteanu.licenta.reservation.ReservationFragment;
import com.vladscaesteanu.licenta.settings.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MovieListAdapter adapter;
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addFragment(ReservationFragment.newInstance());
                }
            });
        }

        listView = (ListView) findViewById(R.id.movie_list);
        adapter = new MovieListAdapter(this, test());
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
                Fragment fragment = MovieFragment.newInstance();
                fragment.setArguments(bundle);
                Transition changeTransform = TransitionInflater.from(MainActivity.this).
                        inflateTransition(R.transition.change_image_transform);
                Transition explodeTransform = TransitionInflater.from(MainActivity.this).
                        inflateTransition(android.R.transition.fade);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                fragment.setSharedElementEnterTransition(changeTransform);
                fragment.setEnterTransition(explodeTransform);

                ft.addSharedElement(movieImage, "image");
                ft.addSharedElement(movieTitle, "title");
                ft.add(R.id.activity_container, fragment, fragment.getClass().getSimpleName());
                ft.commit();
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

        return super.onOptionsItemSelected(item);
    }

    private void addFragment(Fragment fragment) {
        Transition changeTransform = TransitionInflater.from(this).
                inflateTransition(R.transition.change_image_transform);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.activity_container, fragment, fragment.getClass().getSimpleName());
        ft.commit();
    }

    private List<Movie> test() {
        List<Movie> list = new ArrayList<Movie>();
        list.add(new Movie(1, "Bau1", "bau1"));
        list.add(new Movie(2, "Bau2", "bau2"));
        list.add(new Movie(3, "Bau3", "bau3"));
        list.add(new Movie(4, "Bau4", "bau4"));
        list.add(new Movie(5, "Bau5", "bau5"));
        return list;
    }
}
