package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Addlibrarian extends AppCompatActivity {

    EditText name1,empid1,password1,contactno1;
    private Button b1;
    DbLibrarians dbLibrarians;

    public void onBackPressed(){
        Intent intent = new Intent(Addlibrarian.this,AdminPage.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlibrarian);

        name1 = (EditText) findViewById(R.id.name);
        empid1 = (EditText) findViewById(R.id.empid);
        password1 = (EditText) findViewById(R.id.password);
        contactno1 = (EditText) findViewById(R.id.contact);
        b1 = (Button) findViewById(R.id.button1);
        dbLibrarians = new DbLibrarians(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name1.getText().toString();
                String empid=empid1.getText().toString();
                String password=password1.getText().toString();
                String contactno=contactno1.getText().toString();

                if(name.isEmpty()||empid.isEmpty()||password.isEmpty()||contactno.isEmpty()){
                    Toast.makeText(Addlibrarian.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
                }else if(dbLibrarians.addlib(name,password,empid,contactno)){
                    Toast.makeText(Addlibrarian.this, "Librarian Successfully Registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Addlibrarian.this,AdminPage.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Addlibrarian.this, "Librarian Add Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
