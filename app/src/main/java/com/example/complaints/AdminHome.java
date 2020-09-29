package com.example.complaints;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        Button bt1=(Button)findViewById(R.id.button9);
        Button bt2=(Button)findViewById(R.id.button10);
        Button bt3=(Button)findViewById(R.id.button11);
        Button bt4=(Button)findViewById(R.id.button12);
        Button bt5=(Button)findViewById(R.id.button13);
        Button bt6=(Button)findViewById(R.id.button20);
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(AdminHome.this,ViewStatusAdmin.class);
                startActivity(it);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(AdminHome.this,AddEmp.class);
                startActivity(it);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it=new Intent(AdminHome.this,ViewEmp.class);
                startActivity(it);

            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it=new Intent(AdminHome.this,ViewUsers.class);
                startActivity(it);

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it=new Intent(AdminHome.this,ViewComplaintsA.class);
                startActivity(it);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it=new Intent(AdminHome.this,MainActivity.class);
                startActivity(it);
            }
        });
    }
}
