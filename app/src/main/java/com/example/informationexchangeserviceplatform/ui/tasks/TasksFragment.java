package com.example.informationexchangeserviceplatform.ui.tasks;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.informationexchangeserviceplatform.R;

public class TasksFragment extends Fragment {

    public static final int REQUEST_CODE_PostTask = 906;
    public static final int REQUEST_CODE_TechTaskDetail = 907;
    private TasksViewModel tasksViewModel;
    private Button buttonPostTask,button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tasksViewModel=
                ViewModelProviders.of(this).get(TasksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tasks, container, false);

        buttonPostTask=root.findViewById(R.id.button9);
        button=root.findViewById(R.id.button);

        buttonPostTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),PostTaskActivity.class);
                startActivityForResult(intent, REQUEST_CODE_PostTask);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),TechTaskDetailActivity.class);
                startActivityForResult(intent, REQUEST_CODE_TechTaskDetail);
            }
        });
        /*
        final TextView textView = root.findViewById(R.id.text_tasks);
        tasksViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */
        return root;
    }

}
