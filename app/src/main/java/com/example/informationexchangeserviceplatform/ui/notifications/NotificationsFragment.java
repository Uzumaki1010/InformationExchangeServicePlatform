package com.example.informationexchangeserviceplatform.ui.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.informationexchangeserviceplatform.R;
import com.example.informationexchangeserviceplatform.data.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private ListView listViewNotifications;
    private NotificationAdapter notificationAdapter;
    private ArrayList<Notification> notifications=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


        notifications.add(new Notification("本学期非毕业班学生不回学校。"));
        listViewNotifications=root.findViewById(R.id.list_view_notifications);
        notificationAdapter=new NotificationAdapter(getContext(),R.layout.list_notifications,notifications);
        listViewNotifications.setAdapter(notificationAdapter);
        /*
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */
        return root;
    }
}

class NotificationAdapter extends ArrayAdapter<Notification>{

    private int resourceId;

    public NotificationAdapter(@NonNull Context context, int resource, @NonNull List<Notification> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Notification notification = getItem(position);//获取当前项的实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        ((TextView) view.findViewById(R.id.text_view_notification)).setText(notification.getNotification());

        return view;
    }
}

