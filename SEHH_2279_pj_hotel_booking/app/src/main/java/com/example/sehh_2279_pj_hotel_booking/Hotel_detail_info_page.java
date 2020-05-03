package com.example.sehh_2279_pj_hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Hotel_detail_info_page extends AppCompatActivity {

    String name, check_in_date, check_out_date, price_1, price_2, location;
    int room;

    Button add_adult_number, add_child_number, mins_adult_number, mins_child_number, next_to_pay, back_key, view_hotel_key, view_room_key;
    EditText numberOfadult, numberOfChild;
    TextView countOfadult, countOfChild, total_cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail_info_page);

        //initialize the screen
        setScreen();
        setButton();
        setEditText();
        setTextView();
        setButtonListener();


    }

    private void setTextView() {
        countOfadult = (TextView) findViewById(R.id.count_of_adult);
        countOfChild = (TextView) findViewById(R.id.count_of_child);
        total_cost = (TextView) findViewById(R.id.total_cost);
    }

    private void setEditText() {
        numberOfadult = (EditText) findViewById(R.id.numberOfAdult);
        numberOfChild = (EditText) findViewById(R.id.numberOfChild);
    }

    private void setButtonListener() {
        //Set add button
        add_adult_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(numberOfadult.getText().toString()) + 1;
                numberOfadult.setText(String.valueOf(number));
                countOfadult.setText("Adult:$" + (number * Integer.parseInt(price_2)));
                total_cost.setText("Total cost: $" + (number * Integer.parseInt(price_2) + Integer.parseInt(numberOfChild.getText().toString()) * Integer.parseInt(price_1)) + "(in $HKD)");
            }
        });

        add_child_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(numberOfChild.getText().toString()) + 1;
                numberOfChild.setText(String.valueOf(number));
                countOfChild.setText("Child:$" + (number * Integer.parseInt(price_1)));
                total_cost.setText("Total cost: $" + (number * Integer.parseInt(price_1) + Integer.parseInt(numberOfadult.getText().toString()) * Integer.parseInt(price_2)) + "(in $HKD)");
            }
        });

        //Set mins button
        mins_adult_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer.parseInt(numberOfadult.getText().toString())) > 0) {
                    int number = Integer.parseInt(numberOfadult.getText().toString()) - 1;
                    numberOfadult.setText(String.valueOf(number));
                    countOfadult.setText("Child:$" + (number * Integer.parseInt(price_2)));
                    total_cost.setText("Total cost: $" + (number * Integer.parseInt(price_2) + Integer.parseInt(numberOfChild.getText().toString()) * Integer.parseInt(price_1)) + "(in $HKD)");
                }
            }
        });

        mins_child_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer.parseInt(numberOfChild.getText().toString())) > 0) {
                    int number = Integer.parseInt(numberOfChild.getText().toString()) - 1;
                    numberOfChild.setText(String.valueOf(number));
                    countOfChild.setText("Adult:$" + (number * Integer.parseInt(price_1)));
                    total_cost.setText("Total cost: $" + (number * Integer.parseInt(price_1) + Integer.parseInt(numberOfadult.getText().toString()) * Integer.parseInt(price_2)) + "(in $HKD)");
                }

            }
        });

        //Set view photo page
        view_room_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView photo = (ImageView) findViewById(R.id.hotel_display_image);
                photo.setImageResource(R.drawable.hotel_room);
            }
        });
        view_hotel_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView photo = (ImageView) findViewById(R.id.hotel_display_image);
                photo.setImageResource(R.drawable.hotel_detail);
            }
        });

        //Set back key
        back_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hotel_detail_info_page.this.finish();
            }
        });

        //Set next key
        next_to_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(numberOfChild.getText().toString())==0 && Integer.parseInt(numberOfadult.getText().toString()) == 0){
                    new AlertDialog.Builder(Hotel_detail_info_page.this)
                            .setIcon(null)
                            .setTitle("Number of travel cannot be zero!!")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).show();
                }else {
                    new AlertDialog.Builder(Hotel_detail_info_page.this)
                            .setTitle("Process to payment")
                            .setMessage("Are you sure you want to process to payment?")
                            // When user click yes, go to next page
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent payment_page = new Intent(Hotel_detail_info_page.this, Payment_page.class);
                                    TextView hotel_name = (TextView) findViewById(R.id.hotel_name);
                                    TextView address = (TextView) findViewById(R.id.Location);


                                    //Give the following information to the new activity
                                    Log.d("DEBUG MODE: TEXT -> ", address.getText().toString()+""+"");
                                    payment_page.putExtra("p_hotel", hotel_name.getText().toString());
                                    payment_page.putExtra("p_location", address.getText().toString());
                                    payment_page.putExtra("p_check_in_date", check_in_date);
                                    payment_page.putExtra("p_check_out_date", check_out_date);
                                    payment_page.putExtra("p_sum_of_child", countOfChild.getText().toString());
                                    payment_page.putExtra("p_sum_of_adult", countOfadult.getText().toString());
                                    payment_page.putExtra("p_total", total_cost.getText().toString());


                                    //Run the new activity (i.e show the new screen)
                                    startActivity(payment_page);

                                }
                            })

                            // When user click no, show nothings
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }

            }
        });
    }

    private void setScreen() {
        //initialize the screen

        //set the element
        Bundle extras = getIntent().getExtras();
        TextView hotel_title = (TextView) findViewById(R.id.hotel_name);
        TextView hotel_desc = (TextView) findViewById(R.id.hotel_description);
        TextView hotel_location = (TextView) findViewById(R.id.Location);
        TextView hotel_date = (TextView) findViewById(R.id.booking_date);


        hotel_title.setText(extras.getString("name"));
        name = hotel_title.getText().toString();
        int pos = extras.getInt("Pos");
        room = Integer.parseInt(extras.getString("room"));
        price_1 = extras.getString("price_1");
        price_2 = extras.getString("price_2");

        price_1 = price_1.substring(6);
        price_2 = price_2.substring(7);

        if (pos == 1) {
            hotel_desc.setText("It includes: 1 bedroom, 1 beds, 1 private bathroom, Free Wifi, Free drink");
        } else {
            hotel_desc.setText("It includes: 1 bedroom, 2 beds, 1 private bathroom, Free Wifi");
        }

        hotel_location.setText("Location: Hong Kong, " + extras.getString("location") + "xxxxxx, xxxx Road, xxx No.xx");
        check_in_date = extras.getString("check_in_date");
        check_out_date = extras.getString("check_out_date");
        hotel_date.setText("From " + check_in_date + " to " + check_out_date);


    }

    private void setButton() {

        //local the button
        add_adult_number = (Button) findViewById(R.id.adult_plus);
        add_child_number = (Button) findViewById(R.id.child_plus);
        mins_adult_number = (Button) findViewById(R.id.adult_mins);
        mins_child_number = (Button) findViewById(R.id.child_mins);
        next_to_pay = (Button) findViewById(R.id.next_to_pay);
        back_key = (Button) findViewById(R.id.back_hotel_result);
        view_hotel_key = (Button) findViewById(R.id.view_hotel_button);
        view_room_key = (Button) findViewById(R.id.view_room_button);


    }
}
