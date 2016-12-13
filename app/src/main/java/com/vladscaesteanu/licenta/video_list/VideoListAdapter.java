package com.vladscaesteanu.licenta.video_list;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vladscaesteanu.licenta.R;
import com.vladscaesteanu.licenta.model.Video;

import java.util.List;

public class VideoListAdapter extends BaseAdapter {

    private Activity context;
    private List<Video> videoList;

    static class ViewHolder {
        public TextView title;
        public TextView description;
        public ImageView image;
    }

    public VideoListAdapter(Activity context, List<Video> videoList) {
        this.context = context;
        this.videoList = videoList;
    }

    @Override
    public int getCount() {
        return videoList.size();
    }

    @Override
    public Object getItem(int position) {
        return videoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return videoList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.video_list_layout, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = (TextView) rowView.findViewById(R.id.list_movie_title);
            viewHolder.description = (TextView) rowView.findViewById(R.id.list_movie_desc);
            viewHolder.image = (ImageView) rowView.findViewById(R.id.list_movie_bitmap);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Video video = videoList.get(position);
        holder.title.setText(video.getName());
        holder.description.setText(video.getDescription());

        holder.image.setTransitionName("image" + position);
        holder.title.setTransitionName("title" + position);

        return rowView;
    }
}
