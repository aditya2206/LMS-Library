package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteLibrarian extends AppCompatActivity {

    EditText e1;
    Button b1,b2;
    DbLibrarians dbLibrarians;


    public void onBackPressed(){
        Intent intent = new Intent(DeleteLibrarian.this,AdminPage.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_librarian);

        b1 = (Button) findViewById(R.id.dellib);
        b2 = (Button) findViewById(R.id.back2);
        e1 = (EditText) findViewById(R.id.e1);
        dbLibrarians = new DbLibrarians(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = e1.getText().toString();

                if(name.isEmpty()){
                    Toast.makeText(DeleteLibrarian.this, "Name field must not be empty!", Toast.LENGTH_SHORT).show();
                }else if(dbLibrarians.deletelib(name)){
                    Toast.makeText(DeleteLibrarian.this, "Librarian Succesfully deleted", Toast.LENGTH_SHORT).show();
                    e1.setText("");
                }else{
                    Toast.makeText(DeleteLibrarian.this, "Librarian not Found!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeleteLibrarian.this,AdminPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
