package com.ishanlakhwani.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="AndroidJSonDataBase2";

    public static final String TABLE_NAME="AndroidJSonTable";

    public static final String Table_Column_ID="id";

    public static final String Table_Column_1_Name="name";
    public static final String Table_Column_2_Ans1="ans1";
    public static final String Table_Column_3_Ans2="ans2";

    public static final String Table_Column_4_Time="time";


    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (" + Table_Column_ID +" INTEGER PRIMARY KEY, "+Table_Column_1_Name+" VARCHAR, "+Table_Column_2_Ans1+" VARCHAR,  "+Table_Column_3_Ans2+" VARCHAR, "+Table_Column_4_Time+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}