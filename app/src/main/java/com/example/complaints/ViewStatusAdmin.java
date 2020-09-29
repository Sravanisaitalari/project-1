package com.example.complaints;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewStatusAdmin extends AppCompatActivity {
    SQLiteDatabase db;
    String name;
    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_status_admin);
        final ListView lv=(ListView)findViewById(R.id.listview6);
        Intent it=getIntent();
        String uname=it.getStringExtra("uname");

        lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,al));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name1=lv.getItemAtPosition(position).toString();
                Intent it=new Intent(ViewStatusAdmin.this,ViewStatus.class);
                it.putExtra("name",name1);
                startActivity(it);
            }
        });
        try{
            db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
            Cursor c=db.rawQuery("select * from complaintemp",null);
            c.moveToFirst();
            if(c!=null){
                do {
                    String name=c.getString(1);
                    al.add(name);

                }while (c.moveToNext());
            }}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Complaint not found",Toast.LENGTH_LONG).show();
        }
    }
}
