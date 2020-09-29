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

public class ViewComplaintsEmpMain extends AppCompatActivity {
    SQLiteDatabase db;
    String uname,cid,des,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints_emp_main);
        Intent it=getIntent();
        String name=it.getStringExtra("name");
        EditText et1=(EditText)findViewById(R.id.editText37);
        EditText et2=(EditText)findViewById(R.id.editText38);
        EditText et3=(EditText)findViewById(R.id.editText39);
        EditText et4=(EditText)findViewById(R.id.editText40);
        Button bt=(Button)findViewById(R.id.button16);
        Button bt2=(Button)findViewById(R.id.button26);
        Button bt3=(Button)findViewById(R.id.button27);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("update complaintemp set status='yes' where uname='"+uname+"'");
                Toast.makeText(getApplicationContext(),"Complaint Accepted Successfully",Toast.LENGTH_LONG).show();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("update complaintemp set status='no' where uname='"+uname+"'");
                Toast.makeText(getApplicationContext(),"Complaint declined Successfully",Toast.LENGTH_LONG).show();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(ViewComplaintsEmpMain.this,ViewLocation.class);
                it.putExtra("adr",address);
                startActivity(it);
            }
        });



        try{
            db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
            Cursor c=db.rawQuery("select * from complaintemp where uname='"+name+"'",null);
            c.moveToFirst();
            if(c!=null){
                do {
                    uname=c.getString(1);
                    cid=c.getString(2);
                    des=c.getString(3);
                    address=c.getString(4);




                }while (c.moveToNext());
            }}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Complaints not found",Toast.LENGTH_LONG).show();
        }

        et1.setText(uname);
        et2.setText(cid);
        et3.setText(des);
        et4.setText(address);


    }
}
