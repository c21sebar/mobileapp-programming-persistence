package com.example.persistence;

public class DatabaseTables {
    static class Users{

        static final String TABLE_NAME = "users";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_FORNAMN="Förnamn";
        static final String COLUMN_NAME_EFTERNAMN = "Efternamn";
        static final String COLUMN_NAME_TELNR = "TelNR";
        static final String COLUMN_NAME_MAILADRESS = "Mailadress";

    }

    static final String SQL_CREATE_TABLE_USERS =
            "CREATE TABLE " + Users.TABLE_NAME + " (" +
            Users.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
            Users.COLUMN_NAME_FORNAMN + " TEXT," +
            Users.COLUMN_NAME_EFTERNAMN + " TEXT," +
            Users.COLUMN_NAME_TELNR + " INT," +
            Users.COLUMN_NAME_MAILADRESS + " TEXT)";

    static final String SQL_DELETE_TABLE_USERS =
            "DROP TABLE IF EXISTS " + Users.TABLE_NAME;


}

