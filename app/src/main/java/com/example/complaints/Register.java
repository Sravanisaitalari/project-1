package com.example.complaints;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText et1=(EditText)findViewById(R.id.editText6);
        final EditText et2=(EditText)findViewById(R.id.editText7);
        final EditText et3=(EditText)findViewById(R.id.editText8);
        final EditText et4=(EditText)findViewById(R.id.editText9);
        final EditText et5=(EditText)findViewById(R.id.editText26);
        Button bt=(Button)findViewById(R.id.button4);
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=et1.getText().toString();
                String password=et2.getText().toString();
                String mailid=et3.getText().toString();
                String phone=et4.getText().toString();
                String address=et5.getText().toString();
                if(uname.trim().length()>0){
                    if(password.trim().length()>0){
                        if(mailid.matches(emailPattern)){


                            if((phone.trim().length()>0)&(phone.length()>=10)){
                                if(address.trim().length()>0){



                                        db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
                db.execSQL("create table if not exists register(uname varchar,password varchar,mailid varchar,phone varchar,adr varchar)");
                db.execSQL("insert into register values('"+uname+"','"+password+"','"+mailid+"','"+phone+"','"+address+"')");
                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                                }else {
                                    Toast.makeText(getApplicationContext(),"Please enter Address",Toast.LENGTH_LONG).show();
                                }

                            }else {
                                Toast.makeText(getApplicationContext(),"Please enter Phone Number",Toast.LENGTH_LONG).show();
                            }}else {
                            Toast.makeText(getApplicationContext(),"Please enter Mailid",Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Please enter password",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Please enter username",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
