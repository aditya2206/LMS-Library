package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReturnBook extends AppCompatActivity {

    EditText returnid;
    Button returnb;
    String returnid1=null;
    Issuedbooks issuedbooks;

    public void onBackPressed(){
        Intent intent = new Intent(ReturnBook.this,LibrarianPage.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book);

        returnid = (EditText) findViewById(R.id.returnid);
        returnb = (Button) findViewById(R.id.returnb);
        issuedbooks = new Issuedbooks(this);


        returnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnid1 = returnid.getText().toString();
                if(returnid1.isEmpty()){
                    Toast.makeText(ReturnBook.this, "Enter A Student ID!", Toast.LENGTH_SHORT).show();
                }else if(issuedbooks.returnbook(returnid1)){
                    Toast.makeText(ReturnBook.this, "Book Succesfully Returned!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ReturnBook.this,LibrarianPage.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ReturnBook.this, "No Students found in Records!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
