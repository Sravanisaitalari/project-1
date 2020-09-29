package com.example.complaints;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class PoliceComplaints extends AppCompatActivity {
  String department;
    SQLiteDatabase db;
ArrayList<String> al=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_complaints);
        final EditText et1=(EditText)findViewById(R.id.editText20);
        final EditText et2=(EditText)findViewById(R.id.editText21);
        final EditText et3=(EditText)findViewById(R.id.editText22);
        final EditText et4=(EditText)findViewById(R.id.editText23);
        final EditText et5=(EditText)findViewById(R.id.editText24);
        final Spinner sp=(Spinner)findViewById(R.id.spinner2);
        sp.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,al));
       al.add("Traffic Police");
       sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department=sp.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
        Button bt=(Button)findViewById(R.id.button19);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=et1.getText().toString();
                String cid=et2.getText().toString();
                String description=et3.getText().toString();
                String date=et4.getText().toString();
                String time=et5.getText().toString();

                if(uname.trim().length()>0){
                    if(cid.trim().length()>0){

                        if(description.trim().length()>0){
                                    if(date.trim().length()>0) {

                                        if(time.trim().length()>0) {

                db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
                db.execSQL("create table if not exists complaints(uname varchar,cid varchar,dep varchar,description varchar,date varchar,time varchar,status varchar)");
                db.execSQL("insert into complaints values('"+uname+"','"+cid+"','"+department+"','"+description+"','"+date+"','"+time+"','no')");
                Toast.makeText(getApplicationContext(),"Complaint added Successfully",Toast.LENGTH_LONG).show();


                                        }else {
                                            Toast.makeText(getApplicationContext(),"Please enter time",Toast.LENGTH_LONG).show();
                                        }}else {
                                        Toast.makeText(getApplicationContext(),"Please enter date",Toast.LENGTH_LONG).show();
                                    }
                        }else {
                            Toast.makeText(getApplicationContext(),"Please enter description",Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Please enter complaint id",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Please enter username",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
