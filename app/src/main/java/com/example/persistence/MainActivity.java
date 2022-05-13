package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText forNamn,efterNamn, telNR, mailAdress;
    Button btnRead,btnWrite;
    TextView viewAll;
    private SQLiteDatabase dataBase;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forNamn = findViewById(R.id.fornamn);
        efterNamn = findViewById(R.id.efternamn);
        telNR = findViewById(R.id.telnr);
        mailAdress = findViewById(R.id.mailadress);
        btnRead = findViewById(R.id.btn_read);
        btnWrite = findViewById(R.id.btn_write);
        viewAll = findViewById(R.id.viewAll);

        dataBaseHelper = new DataBaseHelper(this);
        dataBase = dataBaseHelper.getWritableDatabase();

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BTN", "btn read clicked");
            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BTN", "btn write clicked");
                addUser(forNamn.getText().toString(), efterNamn.getText().toString(),mailAdress.getText().toString(), Integer.parseInt(telNR.getText().toString()));


            }
        });

    }
    private long addUser (String fornamn, String efternamn, String mailadress, int telnr){
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Users.COLUMN_NAME_FORNAMN, fornamn);
        values.put(DatabaseTables.Users.COLUMN_NAME_EFTERNAMN, efternamn);
        values.put(DatabaseTables.Users.COLUMN_NAME_MAILADRESS, mailadress);
        values.put(DatabaseTables.Users.COLUMN_NAME_TELNR, telnr);
        Log.d("BTN","" + values);
        return dataBase.insert(DatabaseTables.Users.TABLE_NAME, null, values);

    };
}
