package com.example.complaints;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class ViewUsersMain extends AppCompatActivity {
SQLiteDatabase db;
String u1,u2,u3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users_main);
        Intent it=getIntent();
        String name=it.getStringExtra("name");
        EditText et1=(EditText)findViewById(R.id.editText5);
        EditText et2=(EditText)findViewById(R.id.editText10);
        EditText et3=(EditText)findViewById(R.id.editText11);




        try{
            db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
            Cursor c=db.rawQuery("select * from register where uname='"+name+"'",null);
            c.moveToFirst();
            if(c!=null){
                do {
                    u1=c.getString(0);
                    u2=c.getString(2);
                    u3=c.getString(3);



                }while (c.moveToNext());
            }}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Employees not found",Toast.LENGTH_LONG).show();
        }

        et1.setText(u1);
        et2.setText(u2);
        et3.setText(u3);


    }
}
