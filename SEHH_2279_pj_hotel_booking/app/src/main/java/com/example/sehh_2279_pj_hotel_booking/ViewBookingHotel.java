package com.example.sehh_2279_pj_hotel_booking;

public class ViewBookingHotel {

    private String title;
    private int image;

    public ViewBookingHotel(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
