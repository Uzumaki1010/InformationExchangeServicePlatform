package com.example.informationexchangeserviceplatform.ui.books;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.informationexchangeserviceplatform.R;
import com.example.informationexchangeserviceplatform.data.Book;
import com.example.informationexchangeserviceplatform.data.Techtask;

import java.util.List;

class BookAdapter extends ArrayAdapter<Book> implements Filterable {

    private int resourceId;
    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getItem(position);//获取当前项的实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ((ImageView) view.findViewById(R.id.image_view_book_cover)).setImageResource(book.getCoverResourceID());
        ((TextView) view.findViewById(R.id.text_view_book_title)).setText(book.getTitle());
        ((TextView) view.findViewById(R.id.text_view_book_pay)).setText(book.getPay());
        return view;
    }
}
