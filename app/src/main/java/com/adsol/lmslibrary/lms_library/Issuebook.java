package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Issuebook extends AppCompatActivity {

    EditText studentname,studentid,contactno,bookname;
    Button issuebutton;
    DBBooks dbBooks;
    Issuedbooks issuedbooks;
    String name = null,sid = null,cno = null,bname=null;

    public void onBackPressed(){
        Intent intent = new Intent(Issuebook.this,LibrarianPage.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issuebook);

        studentname = (EditText) findViewById(R.id.studentname);
        studentid = (EditText) findViewById(R.id.studentid);
        contactno = (EditText) findViewById(R.id.studentcontact);
        bookname = (EditText) findViewById(R.id.bookname);
        issuebutton = (Button) findViewById(R.id.issuebook1);
        dbBooks = new DBBooks(this);
        issuedbooks = new Issuedbooks(this);

        issuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = studentname.getText().toString();
                sid = studentid.getText().toString();
                cno = contactno.getText().toString();
                bname = bookname.getText().toString();
                int quantity=3;
                if(name.isEmpty()||sid.isEmpty()||cno.isEmpty()||bname.isEmpty()){
                    Toast.makeText(Issuebook.this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
                } else if(dbBooks.getbook(bname)){
                    issuedbooks.issue(name,sid,bname,cno);
                    Intent intent = new Intent(Issuebook.this,LibrarianPage.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(Issuebook.this, "Book Issued Successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Issuebook.this, "No such book in Library!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
