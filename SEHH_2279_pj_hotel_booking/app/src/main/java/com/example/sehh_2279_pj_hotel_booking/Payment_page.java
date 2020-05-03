package com.example.sehh_2279_pj_hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Payment_page extends AppCompatActivity{

    private TextView hotel_name, location, total_price, user_name, user_email, user_phone_number, user_passport, confirmed_date, coupon_code_tips;
    private EditText coupon_code;
    private Button back_key, edit_and_read_key, use_coupon_key, paypal, pps, visa;
    private Boolean isUsedOneCoupon = true;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
        extras = getIntent().getExtras();

        elementsSetup();
        screenSetup();
        setButtonListener();


    }

    private void setButtonListener() {

        back_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Payment_page.this)
                        .setTitle("back to the previous page")
                        .setMessage("Are you sure you want to back to the previous page?")
                        // When user click yes, go to next page
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Payment_page.this.finish();
                            }
                        })

                        // When user click no, show nothings
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        edit_and_read_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(Payment_page.this, Payment_personal_info_edit_page.class);

            i.putExtra("user_name", user_name.getText().toString());
            i.putExtra("user_email", user_email.getText().toString());
            i.putExtra("user_phone_number", user_phone_number.getText().toString());
            i.putExtra("user_passport", user_passport.getText().toString());

            startActivity(i);

            user_name.setText(UserDB.getAccountName());
            user_email.setText(UserDB.getAccountId());
            user_passport.setText(UserDB.getAccountPassort().substring(0,4)+"****");
            user_phone_number.setText(UserDB.getAccountPhoneNumber());
            }
        });

        use_coupon_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coupon_code.getText().toString().matches("ABC123") && isUsedOneCoupon){
                    coupon_code_tips.setText("Coupon applied successfully!");
                    coupon_code_tips.setTextColor(Color.RED);
                    total_price.setText("$"+Integer.parseInt(total_price.getText().toString().substring(1))*0.8);

                    isUsedOneCoupon = false;
                }else if (!(isUsedOneCoupon)){
                    coupon_code_tips.setText("You have used a coupon already!");
                    coupon_code_tips.setTextColor(Color.RED);
                }else{
                    coupon_code_tips.setText("The coupon code is wrong!");
                    coupon_code_tips.setTextColor(Color.RED);
                }
            }
        });

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Payment_page.this)
                        .setTitle("Ready to pay")
                        .setMessage("Are you sure you want to pay by paypal?")
                        // When user click yes, go to next page
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(Payment_page.this, Payment_loading_page.class);
                                i.putExtra("Paying method", "paypal");
                                UserDB.setBookedHotelName(hotel_name.getText().toString());
                                startActivity(i);
                            }
                        })

                        // When user click no, show nothings
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        pps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Payment_page.this)
                    .setTitle("Ready to pay")
                    .setMessage("Are you sure you want to pay by pps?")
                    // When user click yes, go to next page
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(Payment_page.this, Payment_loading_page.class);
                            i.putExtra("Paying method", "pps");
                            UserDB.setBookedHotelName(hotel_name.getText().toString());
                            startActivity(i);
                        }
                    })

                    // When user click no, show nothings
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
            }
        });

        visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Payment_page.this)
                        .setTitle("Ready to pay")
                        .setMessage("Are you sure you want to pay by credit card?")
                        // When user click yes, go to next page
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(Payment_page.this, Payment_loading_page.class);
                                i.putExtra("Paying method", "credit card");
                                UserDB.setBookedHotelName(hotel_name.getText().toString());
                                startActivity(i);
                            }
                        })

                        // When user click no, show nothings
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }

    private void screenSetup() {

        //Local the information to the screen
        hotel_name.setText(extras.getString("p_hotel"));
        location.setText(extras.getString("p_location"));
        confirmed_date.setText(extras.getString("p_check_in_date")+" to "+extras.getString("p_check_out_date"));
        total_price.setText(extras.getString("p_total").substring(0,extras.getString("p_total").length()-9));
        user_name.setText(UserDB.getAccountName());
        user_email.setText(UserDB.getAccountId());
        user_passport.setText(UserDB.getAccountPassort().substring(0,4)+"****");
        user_phone_number.setText(UserDB.getAccountPhoneNumber()+"");

    }

    private void elementsSetup(){
        //Set elements
        confirmed_date = (TextView) findViewById(R.id.payment_booking_time);
        hotel_name = (TextView) findViewById(R.id.payment_hotel_name);
        location = (TextView) findViewById(R.id.payment_hotel_location);
        total_price = (TextView) findViewById(R.id.Payment_price_display);
        user_name = (TextView) findViewById(R.id.payment_buyer_name);
        user_email = (TextView) findViewById(R.id.payment_buyer_email);
        user_phone_number = (TextView) findViewById(R.id.payment_phone_number);
        user_passport = (TextView) findViewById(R.id.payment_buyer_passport);
        coupon_code_tips = (TextView) findViewById(R.id.coupon_code_tips);
        coupon_code = (EditText) findViewById(R.id.coupon_input);

        //Set button
        back_key = (Button) findViewById(R.id.payment_back);
        edit_and_read_key = (Button) findViewById(R.id.payment_edit_or_read_key);
        use_coupon_key = (Button) findViewById(R.id.coupon_key);
        paypal = (Button) findViewById(R.id.paypal);
        pps = (Button) findViewById(R.id.pps);
        visa = (Button) findViewById(R.id.credit);
    }

}
