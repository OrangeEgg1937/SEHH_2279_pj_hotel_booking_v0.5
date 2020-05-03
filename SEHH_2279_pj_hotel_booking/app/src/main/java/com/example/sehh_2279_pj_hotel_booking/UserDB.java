package com.example.sehh_2279_pj_hotel_booking;

import android.content.Intent;

public class UserDB {

    //TESTing account
    public static String account1_id = "user@gmail.com";
    public static String account1_pw = "12345";
    public static String account1_name = "Chan Tai Man";
    public static String account1_date_of_birth = "D12M10Y1987";
    public static String account1_passport = "M1234567";
    public static int account1_phone_number = 12345678;
    public static String account1_booked_hotel_name = "ABC";
    public static String account1_booked_hotel_date = "ABC";
    public static String account1_booked_hotel_location = "ABC";
    public static String account1_booked_hotel_total_price = "ABC";


    //second account
    public static String account2_id = "user@gmail.com";
    public static String account2_pw = "12345";
    public static String account2_name = "Chan Tai Man";
    public static String account2_date_of_birth = "D12M10Y1987";
    public static String account2_passport = "M7654321";
    public static int account2_phone_number = 12345678;
    public static String account2_booked_hotel_name = "ABC";
    public static String account2_booked_hotel_date = "ABC";
    public static String account2_booked_hotel_location = "ABC";
    public static String account2_booked_hotel_total_price = "ABC";

    //Other variable
    public static boolean isAccount2Created = false;
    public static boolean isAccount1Login = true;
    public static boolean isAccount1Booked = false;
    public static boolean isAccount2Booked = false;


    //Method
    public static String getAccountName(){
        if (isAccount1Login){
            return account1_name;
        }else return account2_name;
    }

    public static String getAccountId(){
        if (isAccount1Login){
            return account1_id;
        }else return account2_id;
    }

    public static String getAccountPw(){
        if (isAccount1Login){
            return account1_pw;
        }else return account2_pw;
    }

    public static String getAccountPassort(){
        if (isAccount1Login){
            return account1_passport;
        }else return account2_passport;
    }

    public static int getAccountPhoneNumber(){
        if (isAccount1Login){
            return  account1_phone_number;
        }else return account2_phone_number;
    }

    public static void setAccountName(String input){
        if (isAccount1Login){
            account1_name = input;
        }else account2_name = input;
    }

    public static void setAccountId(String input){
        if (isAccount1Login){
            account1_id = input;
        }else  account2_id = input;
    }

    public static void setAccountPw(String input){
        if (isAccount1Login){
            account1_pw = input;
        }else  account2_pw = input;
    }

    public static void setAccountPassort(String input){
        if (isAccount1Login){
            account1_passport = input;
        }else  account2_passport = input;
    }

    public static void setAccountPhoneNumber(String input){
        if (isAccount1Login){
            account1_phone_number = Integer.parseInt(input);
        }else  account2_phone_number = Integer.parseInt(input);
    }

    public static boolean isBooked(){
      if (isAccount1Login){
          if (isAccount1Booked){
              return true;
          }else return false;
      }else if (isAccount2Booked){
          return true;
      }else return false;
    };

    public static String getBookedHotelName(){
        if (isAccount1Login){
            return account1_booked_hotel_name;
        } else return account2_booked_hotel_name;
    }

    public static void setBookedHotelName(String input){
        if (isAccount1Login){
            account1_booked_hotel_name = input;
            isAccount1Booked = true;
        } else {
            account2_booked_hotel_name = input;
            isAccount2Booked = true;
        }
    }



}
