package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminPage extends AppCompatActivity {

    Button addlib,viewlib,deletelib,logout;
    boolean doublepress=false;


    public void onBackPressed() {



        if (doublepress) {

            super.onBackPressed();
            Intent intent = new Intent(AdminPage.this, Chooseadminlibrarian.class);
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
        setContentView(R.layout.activity_admin_page);

        deletelib = (Button) findViewById(R.id.deletelib);
        viewlib = (Button) findViewById(R.id.viewlib);
        logout = (Button) findViewById(R.id.logout);
        addlib = (Button) findViewById(R.id.addlibrarian);

        addlib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPage.this,Addlibrarian.class);
                startActivity(intent);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPage.this,Chooseadminlibrarian.class);
                startActivity(intent);
                finish();

            }
        });

        viewlib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPage.this,ViewLibrarians.class);
                startActivity(intent);
                finish();
            }
        });

        deletelib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPage.this,DeleteLibrarian.class);
                startActivity(intent);
                finish();
            }
        });



    }


}
