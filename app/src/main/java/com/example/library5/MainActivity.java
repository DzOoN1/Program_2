package com.example.library5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private Button btnAllBooks, btnReadBooks, btnNotReadBooks,btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.main_image);
        btnAllBooks = (Button) findViewById(R.id.btnAllBooks);
        btnReadBooks = (Button) findViewById(R.id.btnReadBooks);
        btnNotReadBooks = (Button) findViewById(R.id.btnNotReadBooks);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        DataBase.getInstance();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
        btnReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ReadBooksActivity.class);
                startActivity(intent);
            }
        });
        btnNotReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NotReadActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("This program is developed by J3T and his team!");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("Visi web page", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Intent intent = new Intent(MainActivity.this,WebActivity.class);
                       startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });

    }
}