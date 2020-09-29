package com.example.complaints;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmpListMain extends AppCompatActivity {
    String e1,e2,e3,e4,e5,e6,name,password,phone,address;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_list_main);
        final EditText et1=(EditText)findViewById(R.id.editText33);
        EditText et2=(EditText)findViewById(R.id.editText34);
        EditText et3=(EditText)findViewById(R.id.editText35);
        EditText et4=(EditText)findViewById(R.id.editText36);

        Intent it=getIntent();
        e1=it.getStringExtra("e1");
        e2=it.getStringExtra("e2");
        e3=it.getStringExtra("e3");
        e4=it.getStringExtra("e4");
        e5=it.getStringExtra("e5");
        e6=it.getStringExtra("e6");
        String emp=it.getStringExtra("emp");

        try{
            db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
            Cursor c=db.rawQuery("select * from emp where uname='"+emp+"'",null);
            c.moveToFirst();
            if(c!=null){
                do {
                     name= c.getString(0);
                     password= c.getString(1);
                     phone= c.getString(3);
                     address= c.getString(5);


                }while (c.moveToNext());

            }}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Employess not found",Toast.LENGTH_LONG).show();
        }

        et1.setText(name);
        et2.setText(password);
        et3.setText(phone);
        et4.setText(address);
        Button bt=(Button)findViewById(R.id.button25);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String depname=et1.getText().toString();

                db.execSQL("create table if not exists complaintemp(ename varchar,uname varchar,cid varchar,cdes varchar,adr varchar,status varchar)");
                db.execSQL("insert into complaintemp values('"+depname+"','"+e1+"','"+e2+"','"+e3+"','"+e6+"','no')");
                Toast.makeText(getApplicationContext(),"Complaint Assigned",Toast.LENGTH_LONG).show();
            }
        });
    }
}
