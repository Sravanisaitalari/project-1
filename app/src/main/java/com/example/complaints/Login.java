package com.example.complaints;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
SQLiteDatabase db;
String username,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText et1=(EditText)findViewById(R.id.editText);
        final EditText et2=(EditText)findViewById(R.id.editText2);
        Button bt=(Button)findViewById(R.id.button2);
        Button bt2=(Button)findViewById(R.id.button8);
        Button bt3=(Button)findViewById(R.id.button15);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=et1.getText().toString();
                String password=et2.getText().toString();
                if(uname.trim().length()>0){
                    if(password.trim().length()>0){

                db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
                Cursor c=db.rawQuery("select * from emp where uname='"+uname+"' and pwd='"+password+"'",null);
                try {
                    c.moveToFirst();
                    if (c != null) {
                        do {
                            username = c.getString(0);
                            pwd = c.getString(1);
                            if (username.equalsIgnoreCase(uname) && pwd.equalsIgnoreCase(password)) {
                                Intent it = new Intent(Login.this, PoliceHome.class);
                                it.putExtra("uname",uname);
                                startActivity(it);
                            }

                        } while (c.moveToNext());
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Invalid uname and password",Toast.LENGTH_LONG).show();
                }
                    }else {
                        Toast.makeText(getApplicationContext(),"Please enter Password",Toast.LENGTH_LONG).show();
                    }}else {
                    Toast.makeText(getApplicationContext(),"Please enter Username",Toast.LENGTH_LONG).show();
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=et1.getText().toString();
                String password=et2.getText().toString();
                if(uname.trim().length()>0){
                    if(password.trim().length()>0){
                if(uname.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin")){
                    Intent it=new Intent(Login.this, AdminHome.class);
                    startActivity(it);
                }else{
                    Toast.makeText(getApplicationContext(),"Invalid username and password",Toast.LENGTH_LONG).show();

                }
                    }else {
                        Toast.makeText(getApplicationContext(),"Please enter Password",Toast.LENGTH_LONG).show();
                    }}else {
                    Toast.makeText(getApplicationContext(),"Please enter Username",Toast.LENGTH_LONG).show();
                }

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=et1.getText().toString();
                String password=et2.getText().toString();
                if(uname.trim().length()>0){
                    if(password.trim().length()>0){

                db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
                Cursor c=db.rawQuery("select * from register where uname='"+uname+"' and password='"+password+"'",null);
               try {
                   c.moveToFirst();
                   if (c != null) {
                       do {
                           username = c.getString(0);
                           pwd = c.getString(1);
                           if (username.equalsIgnoreCase(uname) && pwd.equalsIgnoreCase(password)) {
                               Intent it = new Intent(Login.this, Home.class);
                               it.putExtra("uname",uname);
                               startActivity(it);
                           }

                       } while (c.moveToNext());
                   }
               }catch (Exception e){
                   Toast.makeText(getApplicationContext(),"Invalid uname and password",Toast.LENGTH_LONG).show();
               }
                    }else {
                        Toast.makeText(getApplicationContext(),"Please enter Password",Toast.LENGTH_LONG).show();
                    }}else {
                    Toast.makeText(getApplicationContext(),"Please enter Username",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
