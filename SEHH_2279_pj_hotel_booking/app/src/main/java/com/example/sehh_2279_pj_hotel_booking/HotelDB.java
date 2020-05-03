package com.example.sehh_2279_pj_hotel_booking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HotelDB extends SQLiteOpenHelper {

    private final static int _DBVersion = 1; //Database version
    private final static String _DBName = "Hotel.db";	//<-- Database name
    private final static String _TableName = Hotel_item.DATABASE_TABLE; //<-- table name

    public HotelDB(Context context) {
        super(context, _DBName, null, _DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL = "CREATE TABLE IF NOT EXISTS " + _TableName + "( " +
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Hotel_Name VARCHAR(50), " +
                "Hotel_Location VARCHAR(50), " +
                "Hotel_Price_1 INTEGER, " +
                "Hotel_Price_2 INTEGER, " +
                "Hotel_Room INTEGER" +
                "); ";

        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + _TableName;
        db.execSQL(SQL);
    }
}
