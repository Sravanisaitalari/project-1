package com.example.complaints;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PoliceHome extends AppCompatActivity {
String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_home);

        Button bt2=(Button)findViewById(R.id.button17);
        Button bt3=(Button)findViewById(R.id.button18);
        Intent it=getIntent();
         uname=it.getStringExtra("uname");
       /* bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(PoliceHome.this,PoliceComplaints.class);
                it.putExtra("uname",uname);
                startActivity(it);
            }
        });*/

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(PoliceHome.this,ViewComplaintsEmp.class);
                it.putExtra("uname",uname);
                startActivity(it);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(PoliceHome.this,MainActivity.class);
                startActivity(it);
            }
        });


    }
}
