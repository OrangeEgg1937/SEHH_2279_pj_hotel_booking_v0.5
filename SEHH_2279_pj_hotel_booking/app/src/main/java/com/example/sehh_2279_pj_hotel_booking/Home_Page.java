package com.example.sehh_2279_pj_hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Home_Page extends AppCompatActivity implements View.OnClickListener {

    ImageView news;
    ImageView booking;
    ImageView view_booking;
    ImageView my_info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initializeSelection();

    }

    private void initializeSelection() {
        //Initialize the selection
        news = (ImageView) findViewById(R.id.news);
        booking = (ImageView) findViewById(R.id.booking);
        view_booking = (ImageView) findViewById(R.id.view_booking);
        my_info = (ImageView) findViewById(R.id.personal_info);


        //Add OnClickListener
        news.setOnClickListener(this);
        booking.setOnClickListener(this);
        view_booking.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ImageView imageView = (ImageView) v;
        int id = v.getId();
        Intent i;

        //Go to the selected page (activity)
        switch(id) {
            case R.id.news:
                Toast.makeText(this, "Go to news", Toast.LENGTH_LONG).show();
                i = new Intent(Home_Page.this, News_Page.class);
                startActivity(i);
                break;
            case R.id.booking:
                Toast.makeText(this, "Go to booking", Toast.LENGTH_LONG).show();
                i = new Intent(Home_Page.this,Booking_page.class);
                startActivity(i);
                break;
            case R.id.view_booking:
                Toast.makeText(this, "Go to view booking", Toast.LENGTH_LONG).show();
                Intent i2 = new Intent(Home_Page.this, ViewBooking_Page.class);
                startActivity(i2);
                break;
            case R.id.personal_info:
                Toast.makeText(this, "Go to My Personal Infomation", Toast.LENGTH_LONG).show();
                Intent i3 = new Intent(Home_Page.this, Payment_personal_info_edit_page.class);
                startActivity(i3);
                break;
            case R.id.log_out_key:
                Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show();
                Home_Page.this.finish();
                break;
        }
    }
}
