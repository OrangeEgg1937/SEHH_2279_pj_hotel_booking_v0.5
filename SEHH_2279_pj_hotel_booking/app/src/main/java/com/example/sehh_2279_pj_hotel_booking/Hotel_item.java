package com.example.sehh_2279_pj_hotel_booking;

public class Hotel_item {

    Hotel_item(int id, String name, String location, int price_1, int price_2, int room){
        hotel_id = id;
        hotel_name = name;
        hotel_location = location;
        hotel_price_1 = price_1;
        hotel_price_2 = price_2;
        hotel_room = room;
    }

    // Labels DB
    public static final String DATABASE_TABLE = "HOTEL_TABLE";

    // Labels Table Columns names
    public static final String KEY_ID = "_ID";
    public static final String KEY_HOTEL_NAME = "Hotel_Name";
    public static final String KEY_LOCATION = "Hotel_Location";
    public static final String KEY_PRICE_1 = "Hotel_Price_1";
    public static final String KEY_PRICE_2 = "Hotel_Price_2";
    public static final String KEY_ROOM = "Hotel_Room";

    //Location code
    public static final String D1 = "Hong Kong Island";
    public static final String D2 = "Central and Western District";
    public static final String D3 = "Eastern District";
    public static final String D4 = "Southern District";
    public static final String D5 = "Wan Chai";
    public static final String D6 = "Kowloon";
    public static final String D7 = "Kowloon City";
    public static final String D8 = "Kwun Tong";
    public static final String D9 = "Sham Shui Po";
    public static final String D10 = "Wong Tai Sin";
    public static final String D11 = "Yau Tsim Mong";
    public static final String D12 = "Kwai Tsing";
    public static final String D13 = "Sai Kung";
    public static final String D14 = "Sha Tin";
    public static final String D15 = "Tai Po";
    public static final String D16 = "Tsuen Wan";
    public static final String D17 = "Tuen Mun";
    public static final String D18 = "Yuen Long";


    //Variables
    public int hotel_id;
    public String hotel_name;
    public String hotel_location;
    public int hotel_price_1;
    public int hotel_price_2;
    public int hotel_room;



}
