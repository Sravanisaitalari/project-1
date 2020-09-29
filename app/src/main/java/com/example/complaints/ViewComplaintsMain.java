package com.example.complaints;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class ViewComplaintsMain extends AppCompatActivity {
    SQLiteDatabase db;
    String e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints_main);
        Intent it=getIntent();
        String name=it.getStringExtra("name");
        EditText et1=(EditText)findViewById(R.id.editText5);
        EditText et2=(EditText)findViewById(R.id.editText10);
        EditText et3=(EditText)findViewById(R.id.editText11);


        try{
            db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
            Cursor c=db.rawQuery("select * from complaints where uname='"+name+"'",null);
            c.moveToFirst();
            if(c!=null){
                do {
                    e1=c.getString(0);
                    e2=c.getString(1);
                    e3=c.getString(2);



                }while (c.moveToNext());
            }}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Complaints not found",Toast.LENGTH_LONG).show();
        }

        et1.setText(e1);
        et2.setText(e2);
        et3.setText(e3);

    }
}
