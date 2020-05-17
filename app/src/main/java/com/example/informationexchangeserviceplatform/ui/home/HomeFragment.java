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
import com.example.informationexchangeserviceplatform.ui.BooksDetailActivity;
import com.example.informationexchangeserviceplatform.ui.ResourcesDetailActivity;
import com.example.informationexchangeserviceplatform.ui.TasksDetailActivity;
import com.example.informationexchangeserviceplatform.ui.login.LoginActivity;

public class HomeFragment extends Fragment {

    public static final int REQUEST_CODE_Login = 901;
    public static final int REQUEST_CODE_TasksDetail = 902;
    public static final int REQUEST_CODE_BooksDetail = 904;
    public static final int REQUEST_CODE_ResourcesDetail = 905;
    private HomeViewModel homeViewModel;
    private TextView textViewBooks,textViewTasks,textViewResources;
    private TextView textViewLogIn;

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
        textViewTasks=root.findViewById(R.id.text_view_tasks);
        textViewBooks=root.findViewById(R.id.text_view_books);
        textViewResources=root.findViewById(R.id.text_view_resources);
        textViewLogIn=root.findViewById(R.id.text_view_LogIn);

        /*登录*/
        textViewLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivityForResult(intent,REQUEST_CODE_Login);
            }
        });

        textViewTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), TasksDetailActivity.class);
                startActivityForResult(intent, REQUEST_CODE_TasksDetail);
            }
        });

        textViewBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), BooksDetailActivity.class);
                startActivityForResult(intent, REQUEST_CODE_BooksDetail);
            }
        });

        textViewResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ResourcesDetailActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ResourcesDetail);
            }
        });

        return root;
    }
}