package com.vladscaesteanu.licenta.movie_details;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vladscaesteanu.licenta.R;

public class VideoFragment extends Fragment {


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
        Bundle bundle = getArguments();
        if (bundle != null) {
           // transitionName = bundle.getString("TRANS_NAME");
          //  imageBitmap = bundle.getParcelable("IMAGE");
          //  transText = bundle.getString("TRANS_TEXT");
        }

        return view;
    }

}