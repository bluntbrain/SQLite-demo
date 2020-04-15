package com.ishanlakhwani.sqlitedemo;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabaseObj;
    EditText editTextName, editTextPhoneNumber, editAns1, editAns2;
    String NameHolder, TimeHolder, Ans1Holder, Ans2Holder, SQLiteDataBaseQueryHolder;
    Button EnterData, ButtonDisplayData;
    Boolean EditTextEmptyHold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnterData = (Button)findViewById(R.id.button);
        ButtonDisplayData = (Button)findViewById(R.id.button2);
        editTextName = (EditText)findViewById(R.id.editName);
        editAns1 = (EditText)findViewById(R.id.editAns1);
        editAns2 = (EditText)findViewById(R.id.editAns2);
        editTextPhoneNumber = (EditText)findViewById(R.id.editTime);

        EnterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SQLiteDataBaseBuild();

                SQLiteTableBuild();

                CheckEditTextStatus();

                InsertDataIntoSQLiteDatabase();

                EmptyEditTextAfterDataInsert();


            }
        });

        ButtonDisplayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(MainActivity.this, DisplaySQLiteDataActivity.class);
//                startActivity(intent);
                startActivity(new Intent(MainActivity.this, DisplaySQLiteDataActivity.class));
            }
        });


    }

    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_NAME+"("+SQLiteHelper.Table_Column_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+SQLiteHelper.Table_Column_1_Name+" VARCHAR, "+SQLiteHelper.Table_Column_2_Ans1+" VARCHAR, "+SQLiteHelper.Table_Column_3_Ans2+" VARCHAR, "+SQLiteHelper.Table_Column_4_Time+" VARCHAR);");

    }

    public void CheckEditTextStatus(){


                NameHolder = editTextName.getText().toString();
                Ans1Holder = editAns1.getText().toString();
                Ans2Holder = editAns2.getText().toString();
                TimeHolder = editTextPhoneNumber.getText().toString();

        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(TimeHolder)){

            EditTextEmptyHold = false ;

        }
        else {

            EditTextEmptyHold = true ;
        }
    }

    public void InsertDataIntoSQLiteDatabase(){

        if(EditTextEmptyHold == true)
        {

            SQLiteDataBaseQueryHolder = "INSERT INTO "+SQLiteHelper.TABLE_NAME+" (name,ans1,ans2,time) VALUES('"+NameHolder+"', '"+Ans1Holder+"', '"+Ans2Holder+"', '"+ TimeHolder +"');";

            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            Toast.makeText(MainActivity.this,"Data Inserted Successfully", Toast.LENGTH_LONG).show();

        }
        else {

            Toast.makeText(MainActivity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }

    public void EmptyEditTextAfterDataInsert(){

        editTextName.getText().clear();

        editTextPhoneNumber.getText().clear();

    }

}