package com.example.informationexchangeserviceplatform.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.informationexchangeserviceplatform.MainActivity;
import com.example.informationexchangeserviceplatform.R;
import com.example.informationexchangeserviceplatform.ui.login.LoginActivity;

public class HomeFragment extends Fragment {

    public static final int REQUEST_CODE_Login = 901;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */
        TextView textViewLogIn;
        textViewLogIn=root.findViewById(R.id.text_view_LogIn);
        textViewLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivityForResult(intent,REQUEST_CODE_Login);
            }
        });
        return root;
    }
}