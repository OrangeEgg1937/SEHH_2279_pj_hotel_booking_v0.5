package com.example.sehh_2279_pj_hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class Booking_page extends AppCompatActivity {

    //Create booking information
    private TextView displayCheckInDate;
    private TextView displayCheckOutDate;
    private DatePicker datePicker;
    private Spinner location;
    private String selected_location;

    //Create DDMMYY for store the date;
    private int year;
    private int month;
    private int day;
    static final int DATE_DIALOG_ID = 999;
    private boolean isCheckInClicked = false;
    private String today, selectedCheckInDate, selectedCheckOutDate = "0M0Y0000";
    boolean isFirstTimeClicked = true;

    //Create buttons
    private Button setCheckInDate;
    private Button setCheckOutDate;
    private Button goToNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_page);

        location = (Spinner) findViewById(R.id.location);

        setCurrentDateOnView();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

    }

    private void addListenerOnButton() {
        //Set button listener
        setCheckInDate = (Button) findViewById(R.id.check_in_button);
        setCheckOutDate = (Button) findViewById(R.id.check_out_button);
        goToNextActivity = (Button) findViewById(R.id.next);

        setCheckInDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheckInClicked = true;
                showDialog(DATE_DIALOG_ID);
            }
        });

        setCheckOutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheckInClicked = false;
                showDialog(DATE_DIALOG_ID);
            }
        });

        goToNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (true){
                    //When the button is clicked,
                    //it will go to the next page (AnimationActivity) first
                    Intent i = new Intent(Booking_page.this, Result_page.class);

                    //Give the following information to the new activity
                    i.putExtra("location", selected_location);
                    i.putExtra("check_in_date", displayCheckInDate.getText().toString());
                    i.putExtra("check_out_date", displayCheckOutDate.getText().toString());
                    //Run the new activity (i.e show the new screen)
                    startActivity(i);

                }else{
                    new AlertDialog.Builder(Booking_page.this)
                            .setIcon(null)
                            .setTitle("The selected date is wrong!")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
                }


            }
        });

    }

    //Set current date
    private void setCurrentDateOnView() {
        displayCheckInDate = (TextView) findViewById(R.id.check_in_date);
        displayCheckOutDate = (TextView) findViewById(R.id.check_out_date);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        //Get current date
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);


        // Set current date into text view;
        displayCheckInDate.setText(day+"/"+(month+1)+"/"+year);
        displayCheckOutDate.setText("Please select your Check Out Date");
        selectedCheckInDate = day + "M" + (month+1) + "Y" + year;

        if (isFirstTimeClicked){
            today = day + "M" + (month+1) + "Y" + year;
            selectedCheckInDate = day + "M" + (month+1) + "Y" + year;
            isFirstTimeClicked = false;
        }


        // Set current date into date picker
        datePicker.init(year, month, day, null);
    }

    //Create the date picker dialog after button is clicked
    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_DIALOG_ID:
                // Set date picker as current date
                return new DatePickerDialog(this, datePickerListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int clickedYear, int clickedMonth, int dayOfMonth) {
            year = clickedYear;
            month = clickedMonth;
            day = dayOfMonth;

            // Set current date into text view;
            if (isCheckInClicked){
                displayCheckInDate.setText(day+"/"+(month+1)+"/"+year);
                isCheckInClicked = false;
                selectedCheckInDate = day + "M" + (month+1) + "Y" + year;
            }else {
                displayCheckOutDate.setText(day+"/"+(month+1)+"/"+year);
                selectedCheckOutDate = day + "M" + (month+1) + "Y" + year;
            }


            // Set current date into date picker
            datePicker.init(year, month, day, null);
        }
    };

    public void addListenerOnSpinnerItemSelection() {

        //Prepare spinner to ready when clicked
        location.setOnItemSelectedListener(new SpinnerOnItemSelectedListener());
    }

    private class SpinnerOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //Get the number that user selected
            selected_location = ((parent.getItemAtPosition(position).toString()));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //Deliberately empty
        }
    }

    private boolean checkDateValidation(){
        int day = Integer.parseInt(today.substring(0,today.indexOf("M")));
        int month = Integer.parseInt(today.substring(today.indexOf("M")+1,today.indexOf("Y"))) * 100;
        int year = Integer.parseInt(today.substring(today.indexOf("Y")+1));

        int selected_iday = Integer.parseInt(selectedCheckInDate.substring(0,selectedCheckInDate.indexOf("M")));
        int selected_imonth = Integer.parseInt(selectedCheckInDate.substring(selectedCheckInDate.indexOf("M")+1,selectedCheckInDate.indexOf("Y"))) * 100;
        int selected_iyear = Integer.parseInt(selectedCheckInDate.substring(selectedCheckInDate.indexOf("Y")+1));

        int selected_oday = Integer.parseInt(selectedCheckOutDate.substring(0,selectedCheckOutDate.indexOf("M")));
        int selected_omonth = Integer.parseInt(selectedCheckOutDate.substring(selectedCheckOutDate.indexOf("M")+1,selectedCheckOutDate.indexOf("Y"))) * 100;
        int selected_oyear = Integer.parseInt(selectedCheckOutDate.substring(selectedCheckOutDate.indexOf("Y")+1));

        Log.d("DDMMYY","Day:"+day+" Month:"+month+" Year:"+year);

        Log.d("ERROR COND 1",(selected_iday+selected_imonth+selected_iyear)+" "+(day+month+year));
        Log.d("ERROR COND 2",(selected_iday+selected_imonth+selected_iyear)+" "+(selected_oday+selected_omonth+selected_oyear));
        if ((selected_iday+selected_imonth+selected_iyear)<(day+month+year) || (selected_iday+selected_imonth+selected_iyear)<(selected_oday+selected_omonth+selected_oyear) || (selected_oday+selected_omonth+selected_oyear) == 0 )
        {
            Log.d("To False","To False");
            return false;
        }else return true;

    }
}
