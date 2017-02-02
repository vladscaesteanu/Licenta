package com.vladscaesteanu.licenta.video_screen;



import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import com.vladscaesteanu.licenta.R;

public class VideoFragment extends Fragment {

    String transitionName, imageBitmap, transText;
    int videoLocation;
    VideoView videoView;
    SeekBar seekBar;
    MediaPlayer mp;
    ImageView imagePlay, imagePause;
    String videoAddress;
    String videoName, videoDescription;
    TextView videoNameText, videoDescText;
    ProgressBar progressBar;
    Button fullScreen;

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
            videoAddress = bundle.getString("VID_PATH");
            videoName = bundle.getString("VID_NAME");
            videoDescription = bundle.getString("VID_DESCRIPTION");
        }
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        videoNameText = (TextView)view.findViewById(R.id.video_title);
        videoDescText = (TextView) view.findViewById(R.id.video_desc);
        videoNameText.setText(videoName);
        videoDescText.setText(videoDescription);
        videoView = (VideoView) view.findViewById(R.id.videoViewElement);
        seekBar = (SeekBar) view.findViewById(R.id.videoSeekbar);
        progressBar = (ProgressBar) view.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        imagePlay = (ImageView) view.findViewById(R.id.play);
        imagePause = (ImageView) view.findViewById(R.id.pause);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                seekBar.postDelayed(onEverySecond, 1000);
                mp = mediaPlayer;
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if (videoView.isPlaying()) {
                        if (mp != null) {
                            mp.pause();
                        }
                        imagePause.setVisibility(View.VISIBLE);
                        timerDelayRemoveView(700, imagePause);
                    } else {
                        if (mp != null) {
                            mp.start();
                        }
                        imagePlay.setVisibility(View.VISIBLE);
                        timerDelayRemoveView(700, imagePlay);
                    }
                }
                    return true;
                }

        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b)
                    videoView.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

     //   MediaController vidControl = new MediaController(this.getActivity());
     //   vidControl.setAnchorView(videoView);
      //  videoView.setMediaController(vidControl);
        videoAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
        final Uri vidUri = Uri.parse(videoAddress);
        fullScreen = (Button) view.findViewById(R.id.fullScreenButon);
        fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        videoView.setVideoURI(vidUri);
        videoView.start();
//TODO orientarea
        return view;
    }

    @Override
    public void onDestroy() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        super.onDestroy();
    }

    private Runnable onEverySecond=new Runnable() {

        @Override
        public void run() {

            if(seekBar != null) {
                seekBar.setProgress(videoView.getCurrentPosition());
            }

            if(videoView.isPlaying()) {
                seekBar.postDelayed(onEverySecond, 1000);
            }

        }
    };

    public void timerDelayRemoveView(long time, final ImageView v) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                v.setVisibility(View.INVISIBLE);
            }
        }, time);
    }
}
