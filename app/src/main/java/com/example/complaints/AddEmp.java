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

public class AddEmp extends AppCompatActivity {
ArrayList<String> al=new ArrayList<String>();
String dep;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emp);
        final EditText et1=(EditText)findViewById(R.id.editText13);
        final EditText et2=(EditText)findViewById(R.id.editText14);
        final EditText et3=(EditText)findViewById(R.id.editText16);
        final EditText et4=(EditText)findViewById(R.id.editText17);
        final EditText et5=(EditText)findViewById(R.id.editText18);
        Button bt=(Button)findViewById(R.id.button14);
        final Spinner sp=(Spinner)findViewById(R.id.spinner);
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        al.add("Electrical");
        al.add("Municipal");
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               dep=sp.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,al));
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=et1.getText().toString();
                String pwd=et2.getText().toString();
                String  phone=et3.getText().toString();
                String mailid=et4.getText().toString();
                String adr=et5.getText().toString();
                if(uname.trim().length()>0){
                    if(pwd.trim().length()>0){
                        if((phone.trim().length()>0)&(phone.length()>=10)){
                            if(mailid.matches(emailPattern)){

                                if(adr.trim().length()>0){


                db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
                db.execSQL("create table if not exists emp(uname varchar,pwd varchar,dep varchar,phone varchar,mailid varchar,adr varchar)");
                db.execSQL("insert into emp values('"+uname+"','"+pwd+"','"+dep+"','"+phone+"','"+mailid+"','"+adr+"')");
                Toast.makeText(getApplicationContext(),"Employee Added Successfully",Toast.LENGTH_LONG).show();

                                }else {
                                    Toast.makeText(getApplicationContext(),"Please enter Address",Toast.LENGTH_LONG).show();
                                }}else {
                                Toast.makeText(getApplicationContext(),"Please enter Mailid",Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(),"Please enter Phone number",Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Please enter Password",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Please enter username",Toast.LENGTH_LONG).show();
                }





        }
        });

    }
}
