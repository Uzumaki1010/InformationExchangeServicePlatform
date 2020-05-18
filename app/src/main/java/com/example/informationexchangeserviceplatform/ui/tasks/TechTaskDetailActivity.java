package com.example.informationexchangeserviceplatform.ui.tasks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.informationexchangeserviceplatform.R;
import com.example.informationexchangeserviceplatform.data.Notification;
import com.example.informationexchangeserviceplatform.data.Techtask;

import java.util.ArrayList;
import java.util.List;

public class TechTaskDetailActivity extends AppCompatActivity {

    private ListView listViewTechtasks;
    private TechtaskAdapter techtaskAdapter;
    private ArrayList<Techtask> techtasks=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_task_detail);

        techtasks.add(new Techtask("编写一个程序","中等","100"));
        listViewTechtasks=this.findViewById(R.id.list_view_tech_task);
        techtaskAdapter=new TechtaskAdapter(this,R.layout.list_tech_task,techtasks);
        listViewTechtasks.setAdapter(techtaskAdapter);
    }
}
