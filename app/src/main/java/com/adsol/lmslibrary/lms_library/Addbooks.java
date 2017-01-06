package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Addbooks extends AppCompatActivity {
    EditText bookname1,authorname1,publishername1,quantity1;
    Button addbooks;
    DBBooks dbBooks;
    String bookname=null,authorname=null,publishername=null,quantity=null;


    public  void onBackPressed(){
        Intent intent = new Intent(Addbooks.this,LibrarianPage.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbooks);

        bookname1 = (EditText) findViewById(R.id.bookname);
        authorname1 = (EditText) findViewById(R.id.authorname);
        publishername1 = (EditText) findViewById(R.id.publishername);
        quantity1 = (EditText) findViewById(R.id.quantity);
        addbooks = (Button) findViewById(R.id.booksadd);
        dbBooks = new DBBooks(this);

        addbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bookname = bookname1.getText().toString();
                authorname = authorname1.getText().toString();
                publishername = publishername1.getText().toString();
                quantity = quantity1.getText().toString();


                if(bookname.isEmpty()||authorname.isEmpty()||publishername.isEmpty()){
                    Toast.makeText(Addbooks.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
                } else if (dbBooks.addbook(bookname,authorname,publishername,quantity)){
                    Toast.makeText(Addbooks.this, "Books Successfully added to Library!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Addbooks.this,LibrarianPage.class);
                    startActivity(intent);
                    finish();

                }
             }
        });


    }
}
