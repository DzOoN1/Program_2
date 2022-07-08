package com.example.library5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private ImageView image;
    private Button btnAddToRead, btnAddToNotRead;
    private TextView txtBookName, txtAuthor, txtPages, txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        image = (ImageView) findViewById(R.id.imageBook);
        btnAddToRead = (Button) findViewById(R.id.btnAddToRead);
        btnAddToNotRead = (Button) findViewById(R.id.btnAddToNotRead);
        txtBookName = (TextView) findViewById(R.id.ba_txtBookName);
        txtAuthor = (TextView) findViewById(R.id.ba_txtAuthor);
        txtPages = (TextView) findViewById(R.id.ba_txtPages);
        txtDescription = (TextView) findViewById(R.id.ba_txtDescription);


        Intent intent = getIntent();
        if(intent != null){
            int bookID = intent.getIntExtra("bookID",-1);
            if(bookID != -1){
                Book incomingBook = DataBase.getInstance().getBookByID(bookID);
                if(incomingBook != null){
                    setData(incomingBook);

                    handleRead(incomingBook);
                    handleNotRead(incomingBook);
                }
            }
        }
    }

    private void setData(Book incomingBook) {
        Glide.with(BookActivity.this).asBitmap().load(incomingBook.getImageURL()).into(image);
        txtBookName.setText(incomingBook.getBookName());
        txtAuthor.setText(incomingBook.getAuthor());
        txtPages.setText(String.valueOf(incomingBook.getPages()));
        txtDescription.setText(incomingBook.getDescription());

    }

    private void handleNotRead(Book incomingBook) {
        ArrayList<Book> books = DataBase.getInstance().getNotReadBooks();
        for(Book b:books){
            if(b.getID() == incomingBook.getID()){
                btnAddToNotRead.setEnabled(false);
            }
        }
        btnAddToNotRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase.getInstance().AddToNotRead(incomingBook);

                Intent intent = new Intent(BookActivity.this,NotReadActivity.class);
                startActivity(intent);
            }
        });


    }

    private void handleRead(Book incomingBook) {
        ArrayList<Book> books = DataBase.getInstance().getReadBooks();
        for(Book b:books){
            if(b.getID() == incomingBook.getID()){
                btnAddToRead.setEnabled(false);
            }
        }
        btnAddToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase.getInstance().AddToRead(incomingBook);
                Intent intent = new Intent(BookActivity.this,ReadBooksActivity.class);
                startActivity(intent);
            }
        });
    }
}