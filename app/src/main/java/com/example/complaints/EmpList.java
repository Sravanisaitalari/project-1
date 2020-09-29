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
import java.util.List;

public class EmpList extends AppCompatActivity {
    String e1,e2,e3,e4,e5,e6;
    SQLiteDatabase db;
    ArrayList<String> al=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_list);
        final ListView lv=(ListView)findViewById(R.id.listview2);
        Intent it=getIntent();
        e1=it.getStringExtra("e1");
        e2=it.getStringExtra("e2");
        e3=it.getStringExtra("e3");
        e4=it.getStringExtra("e4");
        e5=it.getStringExtra("e5");
        e6=it.getStringExtra("e6");
        String emp=it.getStringExtra("emp");
        lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,al));
lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String ename=lv.getItemAtPosition(position).toString();
        Intent it=new Intent(EmpList.this,EmpListMain.class);
        it.putExtra("e1",e1);
        it.putExtra("e2",e2);
        it.putExtra("e3",e3);
        it.putExtra("e4",e4);
        it.putExtra("e5",e5);
        it.putExtra("e6",e6);
        it.putExtra("emp",ename);
        startActivity(it);

    }
});
        try{
        db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
        Cursor c=db.rawQuery("select * from emp where dep='"+emp+"'",null);
        c.moveToFirst();
        if(c!=null){
            do {
                String emp1= c.getString(0);
                al.add(emp1);

            }while (c.moveToNext());

        }}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Employess not found",Toast.LENGTH_LONG).show();
        }

    }
}
