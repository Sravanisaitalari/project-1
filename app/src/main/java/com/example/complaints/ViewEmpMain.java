package com.example.complaints;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class ViewEmpMain extends AppCompatActivity {
SQLiteDatabase db;
String e1,e2,e3,e4,e5,e6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_emp_main);
        Intent it=getIntent();
        String name=it.getStringExtra("name");
        EditText et1=(EditText)findViewById(R.id.editText5);
        EditText et2=(EditText)findViewById(R.id.editText10);
        EditText et3=(EditText)findViewById(R.id.editText11);
        EditText et4=(EditText)findViewById(R.id.editText12);
        EditText et5=(EditText)findViewById(R.id.editText15);
        EditText et6=(EditText)findViewById(R.id.editText19);

        try{
            db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
            Cursor c=db.rawQuery("select * from emp where uname='"+name+"'",null);
            c.moveToFirst();
            if(c!=null){
                do {
                    e1=c.getString(0);
                    e2=c.getString(1);
                    e3=c.getString(2);
                    e4=c.getString(3);
                    e5=c.getString(4);
                    e6=c.getString(5);


                }while (c.moveToNext());
            }}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Employees not found",Toast.LENGTH_LONG).show();
        }

        et1.setText(e1);
        et2.setText(e2);
        et3.setText(e3);
        et4.setText(e4);
        et5.setText(e5);
        et6.setText(e6);

    }
}
