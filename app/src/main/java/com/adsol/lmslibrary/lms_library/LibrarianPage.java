package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LibrarianPage extends AppCompatActivity {

    Button addbook,viewbook,issuebook,viewissudbook,returnbook,logout;

    boolean doublepress=false;


    public void onBackPressed() {



        if (doublepress) {

            super.onBackPressed();
            Intent intent = new Intent(LibrarianPage.this, Chooseadminlibrarian.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Successfully Logged Out!", Toast.LENGTH_SHORT).show();

        } else {

            this.doublepress = true;
            Toast.makeText(this, "Press again to Logout!", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doublepress = false;
                }
            }, 2000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian_page);

        addbook = (Button) findViewById(R.id.addbook);
        viewbook = (Button) findViewById(R.id.viewbook);
        issuebook = (Button) findViewById(R.id.issuebook);
        viewissudbook = (Button) findViewById(R.id.viewissuedbook);
        returnbook = (Button) findViewById(R.id.returnbook);
        logout = (Button) findViewById(R.id.logout);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibrarianPage.this,Chooseadminlibrarian.class);
                startActivity(intent);
                finish();
                Toast.makeText(LibrarianPage.this, "Successfully Logged Out!", Toast.LENGTH_SHORT).show();
            }
        });

        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibrarianPage.this,Addbooks.class);
                startActivity(intent);
                finish();
            }
        });

        viewbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibrarianPage.this,Books.class);
                startActivity(intent);
                finish();
            }
        });

        issuebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibrarianPage.this,Issuebook.class);
                startActivity(intent);
                finish();
            }
        });

        viewissudbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibrarianPage.this,Issuedbookslist.class);
                startActivity(intent);
                finish();
            }
        });

        returnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibrarianPage.this,ReturnBook.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
