package com.example.informationexchangeserviceplatform.ui.books;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.informationexchangeserviceplatform.R;
import com.example.informationexchangeserviceplatform.data.Book;

import java.util.ArrayList;

public class BooksFragment extends Fragment {

    public static final int REQUEST_CODE_SellBook = 908;
    private BooksViewModel booksViewModel;
    private ListView listViewBooks;
    private BookAdapter bookAdapter;
    private ArrayList<Book> books=new ArrayList<>();
    private ArrayList<Book> booksResult=new ArrayList<>();
    private Button buttonSellBook,buttonSearchBook;
    private EditText editTextSearchBookName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        booksViewModel =
                ViewModelProviders.of(this).get(BooksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_books, container, false);

        books.add(new Book("Computer Network","10",R.drawable.computer));
        books.add(new Book("Marketing","12",R.drawable.market));
        books.add(new Book("International finance 第3版","15",R.drawable.international));
        listViewBooks=root.findViewById(R.id.list_view_books);
        bookAdapter=new BookAdapter(getContext(),R.layout.list_book,books);
        listViewBooks.setAdapter(bookAdapter);

        buttonSellBook=root.findViewById(R.id.button_sell_book);
        buttonSellBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),SellBookActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SellBook);
            }
        });

        editTextSearchBookName=root.findViewById(R.id.edit_text_search_bookname);
        buttonSearchBook=root.findViewById(R.id.button_search_book);
        buttonSearchBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title=editTextSearchBookName.getText().toString();
                for(int i=0;i<books.size();i++)
                {
                    String CompareStr=books.get(i).getTitle().toString();
                    if(CompareStr.equals(title))
                        booksResult.add(new Book(books.get(i).getTitle().toString(),books.get(i).getPay().toString(),books.get(i).getCoverResourceID()));
                }
                bookAdapter=new BookAdapter(getContext(),R.layout.list_book,booksResult);
                listViewBooks.setAdapter(bookAdapter);
            }
        });
        /*
        final TextView textView = root.findViewById(R.id.text_books);
        booksViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */
        return root;
    }
}
