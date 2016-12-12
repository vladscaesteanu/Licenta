package com.vladscaesteanu.licenta.initscreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vladscaesteanu.licenta.R;

public class InitFragmentTwo extends Fragment {


    public InitFragmentTwo() {
        // Required empty public constructor
    }

    public static InitFragmentTwo newInstance() {
        return new InitFragmentTwo();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_init_two, container, false);
    }

}
