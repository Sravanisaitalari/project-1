package com.example.complaints;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewComplaintsAMain extends AppCompatActivity {
    SQLiteDatabase db;
    String e1,e2,e3,e4,e5,e6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints_amain);
        Intent it=getIntent();
        String name=it.getStringExtra("name");
        EditText et1=(EditText)findViewById(R.id.editText27);
        EditText et2=(EditText)findViewById(R.id.editText28);
        EditText et3=(EditText)findViewById(R.id.editText29);
        EditText et4=(EditText)findViewById(R.id.editText30);
        EditText et5=(EditText)findViewById(R.id.editText31);
        EditText et6=(EditText)findViewById(R.id.editText32);
        Button bt=(Button)findViewById(R.id.button24);
bt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent it=new Intent(ViewComplaintsAMain.this,AssignEmp.class);
        it.putExtra("e1",e1);
        it.putExtra("e2",e2);
        it.putExtra("e3",e3);
        it.putExtra("e4",e4);
        it.putExtra("e5",e5);
        it.putExtra("e6",e6);
        startActivity(it);
    }
});

        try{
            db=openOrCreateDatabase("citizen",MODE_PRIVATE,null);
            Cursor c=db.rawQuery("select * from complaints where uname='"+name+"'",null);
            c.moveToFirst();
            if(c!=null){
                do {
                    e1=c.getString(0);
                    e2=c.getString(1);
                    e3=c.getString(2);
                    e4=c.getString(3);
                    e5=c.getString(4);
                    e6=c.getString(5);



                }while (c.moveToNext());
            }}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Complaints not found",Toast.LENGTH_LONG).show();
        }

        et1.setText(e1);
        et2.setText(e2);
        et3.setText(e3);
        et4.setText(e4);
        et5.setText(e5);
        et6.setText(e6);

    }
}
