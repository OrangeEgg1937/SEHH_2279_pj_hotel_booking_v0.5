package com.example.sehh_2279_pj_hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Payment_personal_info_edit_page extends AppCompatActivity {

    EditText user_name, user_phone_number, user_email, user_passport_number;
    Button save_and_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_personal_info_edit_page);

        user_name = (EditText) findViewById(R.id.edit_name);
        user_email = (EditText) findViewById(R.id.edit_email);
        user_phone_number = (EditText) findViewById(R.id.edit_phone_number);
        user_passport_number = (EditText) findViewById(R.id.edit_passport_number);
        save_and_exit = (Button) findViewById(R.id.save_exit_key);

        user_name.setText(UserDB.getAccountName());
        user_email.setText(UserDB.getAccountId());
        user_passport_number.setText(UserDB.getAccountPassort());
        user_phone_number.setText(UserDB.getAccountPhoneNumber());

        save_and_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDB.setAccountId(user_email.getText().toString());
                UserDB.setAccountName(user_name.getText().toString());
                UserDB.setAccountPhoneNumber(user_phone_number.getText().toString());
                UserDB.setAccountPassort(user_passport_number.getText().toString());
                Payment_personal_info_edit_page.this.finish();
            }
        });
    }
}
