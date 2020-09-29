package com.example.complaints;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AssignEmp extends AppCompatActivity {
ArrayList<String> al=new ArrayList<String>();
String e1,e2,e3,e4,e5,e6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_emp);
        Intent it=getIntent();
         e1=it.getStringExtra("e1");
         e2=it.getStringExtra("e2");
         e3=it.getStringExtra("e3");
         e4=it.getStringExtra("e4");
         e5=it.getStringExtra("e5");
         e6=it.getStringExtra("e6");
        final Spinner sp=(Spinner)findViewById(R.id.spinner3);
        al.add("select Department");
        al.add("Electrical");
        al.add("Municipal");
        sp.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,al));
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String emp=sp.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),emp,Toast.LENGTH_LONG).show();
if(emp.equalsIgnoreCase("Electrical")||emp.equalsIgnoreCase("Municipal")){

                Intent it=new Intent(AssignEmp.this,EmpList.class);
                it.putExtra("e1",e1);
                it.putExtra("e2",e2);
                it.putExtra("e3",e3);
                it.putExtra("e4",e4);
                it.putExtra("e5",e5);
                it.putExtra("e6",e6);
                it.putExtra("emp",emp);
                startActivity(it);
            }}

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
