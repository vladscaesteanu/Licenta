package com.vladscaesteanu.licenta.initscreen;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vladscaesteanu.licenta.R;
import com.vladscaesteanu.licenta.loginscreen.LoginFragment;

public class InitFragmentThree extends Fragment {

    private static String TAG = InitFragmentThree.class.getSimpleName();

    public InitFragmentThree() {
        // Required empty public constructor
    }

    public static InitFragmentThree newInstance() {
        return new InitFragmentThree();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_init_three, container, false);
        Button skipButton = (Button) view.findViewById(R.id.skipButtonInit);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTutorial();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container_init, LoginFragment.newInstance());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        });
        return view;
    }

    private void endTutorial() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.edit().putBoolean("tutorial", false).apply();
    }


}
