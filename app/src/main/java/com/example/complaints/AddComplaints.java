package com.example.complaints;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddComplaints extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_complaints);
        final EditText et1=(EditText)findViewById(R.id.editText6);
        final EditText et2=(EditText)findViewById(R.id.editText7);
        final EditText et3=(EditText)findViewById(R.id.editText8);
        final EditText et4=(EditText)findViewById(R.id.editText9);
        final EditText et5=(EditText)findViewById(R.id.editText3);
        final EditText et6=(EditText)findViewById(R.id.editText4);
        Intent it=getIntent();
        String uname=it.getStringExtra("uname");
        et1.setText(uname);

        Button bt=(Button)findViewById(R.id.button4);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=et1.getText().toString();
                String cid=et2.getText().toString();
                String description=et3.getText().toString();
                String date=et4.getText().toString();
                String time=et5.getText().toString();
                String address=et6.getText().toString();

                if(uname.trim().length()>0){
                    if(cid.trim().length()>0){
                        if(description.trim().length()>0){
                                    if(date.trim().length()>0) {
                                        if(time.trim().length()>0) {
                                            if(address.trim().length()>0) {


                                            db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
                db.execSQL("create table if not exists complaints(uname varchar,cid varchar,des varchar,date varchar,time varchar,address varchar,status varchar)");
                db.execSQL("insert into complaints values('"+uname+"','"+cid+"','"+description+"','"+date+"','"+time+"','"+address+"','no')");
                Toast.makeText(getApplicationContext(),"Complaint added Successfully",Toast.LENGTH_LONG).show();

                                            }else {
                                                Toast.makeText(getApplicationContext(),"Please enter Time",Toast.LENGTH_LONG).show();
                                            }}else {
                                            Toast.makeText(getApplicationContext(),"Please enter Date",Toast.LENGTH_LONG).show();
                                        }
                                    }else {
                                        Toast.makeText(getApplicationContext(),"Please enter Description",Toast.LENGTH_LONG).show();
                                    }
                        }else {
                            Toast.makeText(getApplicationContext(),"Please enter Department",Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Please enter complaint id",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Please enter user name",Toast.LENGTH_LONG).show();
                }



            }
        });
    }
}
