package com.example.complaints;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button bt1=(Button)findViewById(R.id.button5);
        Button bt2=(Button)findViewById(R.id.button6);
        Button bt3=(Button)findViewById(R.id.button7);
        Button bt4=(Button)findViewById(R.id.button21);
        Intent it=getIntent();
         uname=it.getStringExtra("uname");
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent it=new Intent(Home.this,AddComplaints.class);
it.putExtra("uname",uname);
startActivity(it);

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Home.this,ViewStatusComplaint.class);
                it.putExtra("uname",uname);
                startActivity(it);

            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Home.this,MainActivity.class);
                startActivity(it);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Home.this,ViewComplaints.class);
                it.putExtra("uname",uname);
                startActivity(it);
            }
        });
    }
}
