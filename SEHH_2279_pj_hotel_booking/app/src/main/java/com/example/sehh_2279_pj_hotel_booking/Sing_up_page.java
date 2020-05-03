package com.example.sehh_2279_pj_hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sing_up_page extends AppCompatActivity {

    EditText user_id, user_name, user_password, user_phone_number, user_passport;
    Button back_key, sign_up_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_page);

        initialize_allElements();

        back_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sing_up_page.this.finish();
            }
        });

        sign_up_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDB.isAccount2Created = true;
                UserDB.account2_name = user_name.getText().toString();
                UserDB.account2_id = user_id.getText().toString();
                UserDB.account2_passport = user_passport.getText().toString();
                UserDB.account2_pw = user_password.getText().toString();
                UserDB.account2_phone_number = Integer.parseInt(user_phone_number.getText().toString());

                Intent i = new Intent(Sing_up_page.this, Home_Page.class);
                UserDB.isAccount1Login = false;
                startActivity(i);

            }
        });

    }

    private void initialize_allElements() {
        user_id = (EditText) findViewById(R.id.s_user_email);
        user_name = (EditText) findViewById(R.id.s_input_name);
        user_password = (EditText) findViewById(R.id.s_password);
        user_phone_number = (EditText) findViewById(R.id.s_input_phone_name);
        user_passport = (EditText) findViewById(R.id.s_input_passport_number);

        back_key = (Button) findViewById(R.id.back_to_login);
        sign_up_key = (Button) findViewById(R.id.sign_up_button);
    }
}
