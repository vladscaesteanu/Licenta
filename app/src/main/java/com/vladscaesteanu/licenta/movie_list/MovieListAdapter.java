package com.vladscaesteanu.licenta.movie_list;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vladscaesteanu.licenta.R;
import com.vladscaesteanu.licenta.model.Movie;

import java.util.List;

public class MovieListAdapter extends BaseAdapter {

    private Activity context;
    private List<Movie> movieList;

    static class ViewHolder {
        public TextView title;
        public TextView description;
        public ImageView image;
    }

    public MovieListAdapter(Activity context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movieList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.movie_list_layout, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = (TextView) rowView.findViewById(R.id.list_movie_title);
            viewHolder.description = (TextView) rowView.findViewById(R.id.list_movie_desc);
            viewHolder.image = (ImageView) rowView.findViewById(R.id.list_movie_bitmap);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getName());
        holder.description.setText(movie.getDescription());

        holder.image.setTransitionName("image" + position);
        holder.title.setTransitionName("title" + position);

        return rowView;
    }
}
