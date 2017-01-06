package com.adsol.lmslibrary.lms_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1;
    String username=null,password=null;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AdminLogin.this, Chooseadminlibrarian.class));
        finish();

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        b1 = (Button) findViewById(R.id.Login);
        ed1=(EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);



        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                username = ed1.getText().toString();
                password = ed2.getText().toString();

                if(username.equals("admin") && password.equals("aditya")){
                    Intent intent= new Intent(AdminLogin.this,AdminPage.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(AdminLogin.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
