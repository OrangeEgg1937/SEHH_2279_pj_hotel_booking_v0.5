package com.example.sehh_2279_pj_hotel_booking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database_Service {

    private HotelDB hotelDB;

    public Database_Service(Context context) {
        hotelDB = new HotelDB(context);
    }

    public int insert(Hotel_item input) {

        SQLiteDatabase db = hotelDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Hotel_item.KEY_ID, input.hotel_id);
        values.put(Hotel_item.KEY_HOTEL_NAME, input.hotel_name);
        values.put(Hotel_item.KEY_LOCATION, input.hotel_location);
        values.put(Hotel_item.KEY_PRICE_1, input.hotel_price_1);
        values.put(Hotel_item.KEY_PRICE_2, input.hotel_price_2);
        values.put(Hotel_item.KEY_ROOM, input.hotel_room);

        // Inserting Row
        db.insert(Hotel_item.DATABASE_TABLE, null, values);
        db.close(); // Closing database connection
        return (int) 1;
    }

    public String getAll() {
        Cursor cursor = getCursor();  //Get Cursor item
        StringBuilder resultData = new StringBuilder("Result:\n");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String hotel_name = cursor.getString(1);
            String hotel_location = cursor.getString(2);
            int hotel_price_1 = cursor.getInt(3);
            int hotel_price_2 = cursor.getInt(4);
            int hotel_room = cursor.getInt(5);
            resultData.append(id).append(": ");
            resultData.append(hotel_name).append(": ");
            resultData.append(hotel_location).append(": ");
            resultData.append(hotel_price_1).append(": ");
            resultData.append(hotel_price_2).append(": ");
            resultData.append(hotel_room).append("\n");
        }
        return String.valueOf(resultData);
    }

    public String getResult(String location) {
        Cursor cursor = getCursor(location);  //Get Cursor item
        StringBuilder resultData = new StringBuilder("Result:\n");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String hotel_name = cursor.getString(1);
            String hotel_location = cursor.getString(2);
            int hotel_price_1 = cursor.getInt(3);
            int hotel_price_2 = cursor.getInt(4);
            int hotel_room = cursor.getInt(5);
            resultData.append(id).append(": ");
            resultData.append(hotel_name).append(": ");
            resultData.append(hotel_location).append(": ");
            resultData.append(hotel_price_1).append(": ");
            resultData.append(hotel_price_2).append(": ");
            resultData.append(hotel_room).append("\n");
        }
        return String.valueOf(resultData);
    }

    public void getResult(String location, List<String> result_array) {
        Cursor cursor = getCursor(location);  //Get Cursor item
        StringBuilder resultData = new StringBuilder("");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String hotel_name = cursor.getString(1);
            String hotel_location = cursor.getString(2);
            int hotel_price_1 = cursor.getInt(3);
            int hotel_price_2 = cursor.getInt(4);
            int hotel_room = cursor.getInt(5);
            resultData.append(hotel_name).append("\nAdult Price (per person): $HKD ");
            resultData.append(hotel_price_1).append("\nChild Price (per person):  $HKD ");
            resultData.append(hotel_price_2).append("\nAvailable Room: ");
            resultData.append(hotel_room);
            result_array.add(String.valueOf(resultData));
            resultData.delete(0, resultData.length());
        }
    }

    public void getResult(String location, String[] result_hotel_name, int[] r_price_1, int[] r_price_2) {
        Cursor cursor = getCursor(location);  //Get Cursor item
        StringBuilder resultData = new StringBuilder("");
        int i = 0;
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String hotel_name = cursor.getString(1);
            String hotel_location = cursor.getString(2);
            int hotel_price_1 = cursor.getInt(3);
            int hotel_price_2 = cursor.getInt(4);
            int hotel_room = cursor.getInt(5);
            result_hotel_name[i] = hotel_name;
            r_price_1[i] = hotel_price_1;
            r_price_2[i] = hotel_price_2;
            i++;
        }
    }

    private Cursor getCursor() {

        SQLiteDatabase db = hotelDB.getReadableDatabase();  //Get database info

        String[] columns = {Hotel_item.KEY_ID, Hotel_item.KEY_HOTEL_NAME, Hotel_item.KEY_LOCATION, Hotel_item.KEY_PRICE_1, Hotel_item.KEY_PRICE_2, Hotel_item.KEY_ROOM};
        Cursor cursor = db.query(Hotel_item.DATABASE_TABLE, columns, null, null, null, null, null);
        return cursor;
    }

    private Cursor getCursor(String location) {

        SQLiteDatabase db = hotelDB.getReadableDatabase();  //Get database info

        String[] columns = {Hotel_item.KEY_ID, Hotel_item.KEY_HOTEL_NAME, Hotel_item.KEY_LOCATION, Hotel_item.KEY_PRICE_1, Hotel_item.KEY_PRICE_2, Hotel_item.KEY_ROOM};
        Cursor cursor = db.rawQuery("SELECT * FROM HOTEL_TABLE WHERE "+ Hotel_item.KEY_LOCATION+"="+"'"+location+"'", null);
        return cursor;
    }


}
