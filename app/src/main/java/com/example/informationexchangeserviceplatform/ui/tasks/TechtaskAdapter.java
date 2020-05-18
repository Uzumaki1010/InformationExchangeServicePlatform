package com.example.informationexchangeserviceplatform.ui.tasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.informationexchangeserviceplatform.R;
import com.example.informationexchangeserviceplatform.data.Techtask;

import java.util.List;

class TechtaskAdapter extends ArrayAdapter<Techtask> {
    private int resourceId;

    public TechtaskAdapter(@NonNull Context context, int resource, @NonNull List<Techtask> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Techtask techtask = getItem(position);//获取当前项的实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ((TextView) view.findViewById(R.id.textView2)).setText(techtask.getTtintro());
        ((TextView) view.findViewById(R.id.textView4)).setText(techtask.getTtdiffi());
        ((TextView) view.findViewById(R.id.textView5)).setText(techtask.getTtMon());
        return view;
    }

}
