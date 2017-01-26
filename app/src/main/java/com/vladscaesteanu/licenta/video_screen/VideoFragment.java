package com.vladscaesteanu.licenta.video_screen;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.vladscaesteanu.licenta.R;

public class VideoFragment extends Fragment {

    String transitionName, imageBitmap, transText;

    public VideoFragment() {
        // Required empty public constructor
    }

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        setRetainInstance(true);
        Bundle bundle = getArguments();
        if (bundle != null) {
            transitionName = bundle.getString("TRANS_NAME");
            imageBitmap = bundle.getParcelable("IMAGE");
            transText = bundle.getString("TRANS_TEXT");
        }
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        VideoView videoView = (VideoView) view.findViewById(R.id.videoViewElement);
        MediaController vidControl = new MediaController(this.getActivity());
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);
        String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
        Uri vidUri = Uri.parse(vidAddress);
        videoView.setVideoURI(vidUri);
        videoView.start();
//TODO orientarea!
        return view;
    }

    @Override
    public void onDestroy() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        super.onDestroy();
    }
}
