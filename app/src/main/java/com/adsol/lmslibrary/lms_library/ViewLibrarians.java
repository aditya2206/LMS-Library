package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewLibrarians extends AppCompatActivity {
    DbLibrarians dbLibrarians;
    ListView listView;
    Button b1;
    public void onBackPressed(){
        Intent intent = new Intent(ViewLibrarians.this,AdminPage.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_librarians);

        b1 = (Button) findViewById(R.id.back3);
        dbLibrarians = new DbLibrarians(this);
        ArrayList arrayList = dbLibrarians.viewlib();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewLibrarians.this,AdminPage.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
