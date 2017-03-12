package com.example.jerryduran.simplesqlexample;

import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView);

        SQLiteDatabase database = openOrCreateDatabase("example.db", MODE_PRIVATE, null);

        database.execSQL("create table if not exists sampletable(name text, location text)");
        database.execSQL("insert into sampletable values('jerry','sacramento')");

        Cursor cursor = database.rawQuery("select * from sampletable", null);

        cursor.moveToFirst();

        String name = cursor.getString(0);
        String location = cursor.getString(1);

        textView.setText(name + "\n" + location);

        database.close();
    }
}
