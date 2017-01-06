package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Issuedbookslist extends AppCompatActivity {

    Issuedbooks issuedbook;
    ListView listView;
    public void onBackPressed(){
        Intent intent = new Intent(Issuedbookslist.this,LibrarianPage.class);
        startActivity(intent);
        finish();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issuedbookslist);

        issuedbook = new Issuedbooks(this);
        ArrayList arrayList = issuedbook.issuedBookslist();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView = (ListView) findViewById(R.id.listview3);
        listView.setAdapter(arrayAdapter);
    }
}
