package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LibrarianLogin extends AppCompatActivity {

    EditText libemail,libpassword;
    Button login;
    String empid=null,password=null;
    DbLibrarians dbLibrarians;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LibrarianLogin.this, Chooseadminlibrarian.class));
        finish();

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian_login);

        libemail = (EditText) findViewById(R.id.ed1);
        libpassword = (EditText) findViewById(R.id.ed2);
        login = (Button) findViewById(R.id.button1);
        dbLibrarians = new DbLibrarians(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empid=libemail.getText().toString();
                password=libpassword.getText().toString();

                if(dbLibrarians.getlib(empid,password)){
                    Intent intent = new Intent(LibrarianLogin.this,LibrarianPage.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LibrarianLogin.this, "Wrong Employee ID/Password", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
