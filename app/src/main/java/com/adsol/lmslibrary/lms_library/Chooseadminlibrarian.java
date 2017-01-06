package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class Chooseadminlibrarian extends AppCompatActivity {


    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseadminlibrarian);

        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.b2);

        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chooseadminlibrarian.this,AdminLogin.class);
                startActivity(intent);
                finish();
            }
        });

        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chooseadminlibrarian.this,LibrarianLogin.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
