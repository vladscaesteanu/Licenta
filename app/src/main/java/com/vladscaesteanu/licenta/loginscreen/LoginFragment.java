package com.vladscaesteanu.licenta.loginscreen;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vladscaesteanu.licenta.MainActivity;
import com.vladscaesteanu.licenta.R;

public class LoginFragment extends Fragment {

    EditText username;
    EditText password;
    boolean authorized = false;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        username = (EditText) view.findViewById(R.id.userNameText);
        password = (EditText) view.findViewById(R.id.passwordText);
        Button login = (Button) view.findViewById(R.id.loginButton);
        Button register = (Button) view.findViewById(R.id.registerButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authorized = true;
                if(username.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Username must not be empty" , Toast.LENGTH_SHORT).show();
                    authorized = false;
                }
                if(password.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Password must not be empty" , Toast.LENGTH_SHORT).show();
                    authorized = false;
                }
                //TODO auth
                if(authorized) {
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    prefs.edit().putBoolean("logged", true).apply();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    getActivity().finish();
                    startActivity(intent);
                }
            }
        });
        return view;
    }

}
