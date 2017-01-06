package com.adsol.lmslibrary.lms_library;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Books extends AppCompatActivity {

    DBBooks dbBooks;
    ListView listView;

    public void onBackPressed(){
        Intent intent = new Intent(Books.this,LibrarianPage.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        dbBooks = new DBBooks(this);
        ArrayList arrayList = dbBooks.Bookslist();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView = (ListView) findViewById(R.id.list2);
        listView.setAdapter(arrayAdapter);

    }

}
