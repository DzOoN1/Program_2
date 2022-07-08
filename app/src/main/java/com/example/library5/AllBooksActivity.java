package com.example.library5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        recyclerView = (RecyclerView) findViewById(R.id.allbook_RecView);
        adapter = new RecViewAdapter(AllBooksActivity.this);
        adapter.setBooks(DataBase.getInstance().getAllBooks());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}