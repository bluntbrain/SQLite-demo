package com.ishanlakhwani.sqlitedemo;


import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplaySQLiteDataActivity extends AppCompatActivity {

    SQLiteHelper sqLiteHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    ListAdapter listAdapter ;
    ListView LISTVIEW;

    ArrayList<String> ID_Array;
    ArrayList<String> NAME_Array;
    ArrayList<String> Ans1_Array;
    ArrayList<String> Ans2_Array;
    ArrayList<String> Time_Array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sqlite_data);

        LISTVIEW = (ListView) findViewById(R.id.listView1);

        ID_Array = new ArrayList<String>();

        NAME_Array = new ArrayList<String>();
        Ans1_Array = new ArrayList<String>();
        Ans2_Array = new ArrayList<String>();

        Time_Array = new ArrayList<String>();

        sqLiteHelper = new SQLiteHelper(this);

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper.TABLE_NAME+"", null);

        ID_Array.clear();
        NAME_Array.clear();
        Ans1_Array.clear();
        Ans2_Array.clear();
        Time_Array.clear();

        if (cursor.moveToFirst()) {
            do {

                ID_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_ID)));

                NAME_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_1_Name)));
                Ans1_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_2_Ans1)));
                Ans2_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_Ans2)));
                Time_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_4_Time)));


            } while (cursor.moveToNext());
        }

        listAdapter = new ListAdapters(DisplaySQLiteDataActivity.this,

                ID_Array,
                NAME_Array,
                Ans1_Array,
                Ans2_Array,
                Time_Array
        );

        LISTVIEW.setAdapter(listAdapter);

        cursor.close();
    }
}