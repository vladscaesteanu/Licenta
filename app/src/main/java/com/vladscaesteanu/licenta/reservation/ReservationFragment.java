package com.vladscaesteanu.licenta.reservation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vladscaesteanu.licenta.R;

public class ReservationFragment extends Fragment {


    public ReservationFragment() {
        // Required empty public constructor
    }

    public static ReservationFragment newInstance() {
        return new ReservationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        return view;
    }

}
