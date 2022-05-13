package com.example.persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Users.db";

    DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseTables.SQL_CREATE_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DatabaseTables.SQL_DELETE_TABLE_USERS);
        onCreate(sqLiteDatabase);
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + DatabaseTables.Users.TABLE_NAME,null);
        return cursor;
    }
     List<UserModel> getAllUsers(){

           Cursor cursor = getReadableDatabase().query(DatabaseTables.Users.TABLE_NAME, null, null, null, null, null, null);
            List<UserModel> returnList = new ArrayList<>();
            while (cursor.moveToNext()) {
                UserModel newUser = new UserModel(
                        cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Users.COLUMN_NAME_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Users.COLUMN_NAME_FORNAMN)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Users.COLUMN_NAME_EFTERNAMN)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTables.Users.COLUMN_NAME_TELNR)),
                        cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Users.COLUMN_NAME_MAILADRESS))

                );
                returnList.add(newUser);
            }
            cursor.close();
            return returnList;

    }



    public List<UserModel> getAllUsers2(){
        SQLiteDatabase db = this.getReadableDatabase();
        String queryString = "SELECT * FROM " + DatabaseTables.Users.TABLE_NAME;
        Cursor cursor = db.rawQuery(queryString, null);
        List<UserModel> returnList = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do{
                String ID = cursor.getString(0);
                String fnamn = cursor.getString(1);
                String enamn = cursor.getString(2);
                int telnr = cursor.getInt(3);
                String mail = cursor.getString(4);
                UserModel newUser = new UserModel(ID,fnamn,enamn,telnr,mail);
                returnList.add(newUser);

            }while(cursor.moveToNext());
        }
        else{

        }
        Log.d("BTN", "" + returnList);
        cursor.close();
        return returnList;
    }

}
