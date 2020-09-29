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

public class ViewComplaintsEmp extends AppCompatActivity {
    SQLiteDatabase db;
    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints_emp);
        final ListView lv=(ListView)findViewById(R.id.listview3);
        Intent it=getIntent();
        String ename=it.getStringExtra("uname");

        lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,al));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=lv.getItemAtPosition(position).toString();
                Intent it=new Intent(ViewComplaintsEmp.this,ViewComplaintsEmpMain.class);
                it.putExtra("name",name);
                startActivity(it);
            }
        });
        try{
            db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
            Cursor c=db.rawQuery("select * from complaintemp  where ename='"+ename+"'",null);
            c.moveToFirst();
            if(c!=null){
                do {
                    String uname=c.getString(1);
                    al.add(uname);

                }while (c.moveToNext());
            }}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Complaints not found",Toast.LENGTH_LONG).show();
        }
    }
}
