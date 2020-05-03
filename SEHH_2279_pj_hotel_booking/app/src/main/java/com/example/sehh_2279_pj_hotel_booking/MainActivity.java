package com.example.sehh_2279_pj_hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sehh_2279_pj_hotel_booking.Home_Page;
import com.example.sehh_2279_pj_hotel_booking.R;

public class MainActivity extends AppCompatActivity {

    private Button login_key, sign_up_key;
    private Database_Service database_service = new Database_Service(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean firsttime_setup = getSharedPreferences("first_time_run", MODE_PRIVATE).getBoolean("first_time_check", true);

        if (firsttime_setup){
            initialize_db();
            SharedPreferences inner_pref = getSharedPreferences("first_time_run", MODE_PRIVATE);
            inner_pref.edit().putBoolean("first_time_check", false).commit();
        } else {
        }

        login_key = findViewById(R.id.login);
        login_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLoginPass()){
                    Intent i = new Intent(MainActivity.this, Home_Page.class);
                    startActivity(i);
                }else{
                    TextView warning_text = findViewById(R.id.tip_text);
                    warning_text.setText("Incorrect username/password |User1ID:user@gmail.com, PW:12345|");
                    warning_text.setTextColor(Color.RED);

                }
            }
        });

        sign_up_key = (Button) findViewById(R.id.sign_up);
        sign_up_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserDB.isAccount2Created){
                    Toast.makeText(MainActivity.this,"You have already created an account", Toast.LENGTH_LONG).show();
                }else{
                    Intent i = new Intent(MainActivity.this, Sing_up_page.class);
                    startActivity(i);
                }
            }
        });
    }

    private void initialize_db() {

        Hotel_item hotel1 = new Hotel_item(0,"Happy Hotel", Hotel_item.D1, 150, 190, 15 );
        Hotel_item hotel2 = new Hotel_item(1,"Super Happy Hotel", Hotel_item.D2, 250, 290, 2 );
        Hotel_item hotel3 = new Hotel_item(2,"Good Hotel", Hotel_item.D3, 200, 500, 6 );
        Hotel_item hotel4 = new Hotel_item(3,"ABC Happy Hotel", Hotel_item.D4, 110, 160, 6 );
        Hotel_item hotel5 = new Hotel_item(4,"GGC Hotel", Hotel_item.D5, 120, 220, 10 );
        Hotel_item hotel6 = new Hotel_item(5,"HCI Hotel", Hotel_item.D6, 250, 300, 12 );
        Hotel_item hotel7 = new Hotel_item(6,"Happy Hotel", Hotel_item.D7, 270, 450, 7 );
        Hotel_item hotel8 = new Hotel_item(7,"TEMP Happy Hotel", Hotel_item.D8, 210, 300, 10 );
        Hotel_item hotel9 = new Hotel_item(8,"Chi K Hotel", Hotel_item.D9, 250, 550, 6 );
        Hotel_item hotel10 = new Hotel_item(9,"GC Happy Hotel", Hotel_item.D10, 100, 180, 5 );
        Hotel_item hotel11 = new Hotel_item(10,"Jack Hotel", Hotel_item.D11, 120, 200, 15 );
        Hotel_item hotel12 = new Hotel_item(11,"Ben Hotel", Hotel_item.D12, 210, 390, 25 );
        Hotel_item hotel13 = new Hotel_item(12,"CCL Hotel", Hotel_item.D13, 350, 490, 25 );
        Hotel_item hotel14 = new Hotel_item(13,"AAA Happy Hotel", Hotel_item.D14, 150, 270, 8 );
        Hotel_item hotel15 = new Hotel_item(14,"BBB Hotel", Hotel_item.D15, 170, 290, 12 );
        Hotel_item hotel16 = new Hotel_item(15,"CCC Happy Hotel", Hotel_item.D16, 270, 390, 16 );
        Hotel_item hotel17 = new Hotel_item(16,"DDD Happy Hotel", Hotel_item.D17, 450, 690, 18 );
        Hotel_item hotel18 = new Hotel_item(17,"EEE Happy Hotel", Hotel_item.D18, 150, 390, 30 );
        Hotel_item hotel19 = new Hotel_item(18,"FFF Happy Hotel", Hotel_item.D1, 250, 300, 40 );
        Hotel_item hotel20 = new Hotel_item(19,"GGG Happy Hotel", Hotel_item.D2, 250, 400, 20 );
        Hotel_item hotel21 = new Hotel_item(20,"HIC Hotel", Hotel_item.D3, 130, 270, 15 );
        Hotel_item hotel22 = new Hotel_item(21,"EVD Happy Hotel", Hotel_item.D4, 210, 350, 15 );
        Hotel_item hotel23 = new Hotel_item(22,"GW Hotel", Hotel_item.D5, 130, 390, 10 );
        Hotel_item hotel24 = new Hotel_item(23,"Hong Kong Hotel", Hotel_item.D6, 150, 390, 12 );
        Hotel_item hotel25 = new Hotel_item(24,"joy Hotel", Hotel_item.D7, 160, 220, 15 );
        Hotel_item hotel26 = new Hotel_item(25,"haha Hotel", Hotel_item.D8, 300, 480, 5 );
        Hotel_item hotel27 = new Hotel_item(26,"King Kong Hotel", Hotel_item.D9, 150, 200, 6 );
        Hotel_item hotel28 = new Hotel_item(27,"WICE Hotel", Hotel_item.D10, 220, 320, 3 );
        Hotel_item hotel29 = new Hotel_item(28,"ICE Hotel", Hotel_item.D11, 160, 300, 16 );
        Hotel_item hotel30 = new Hotel_item(29,"Land Hotel", Hotel_item.D12, 250, 330, 5 );
        Hotel_item hotel31 = new Hotel_item(30,"Water Hotel", Hotel_item.D13, 120, 180, 15 );
        Hotel_item hotel32 = new Hotel_item(31,"Cheap Hotel", Hotel_item.D14, 250, 340, 5 );
        Hotel_item hotel33 = new Hotel_item(32,"EWS Hotel", Hotel_item.D15, 150, 220, 15 );
        Hotel_item hotel34 = new Hotel_item(33,"QOE Happy Hotel", Hotel_item.D16, 250, 320, 5 );
        Hotel_item hotel35 = new Hotel_item(34,"TYE Happy Hotel", Hotel_item.D17, 850, 1090, 3 );
        Hotel_item hotel36 = new Hotel_item(35,"PIC Happy Hotel", Hotel_item.D18, 600, 800, 6 );

        database_service.insert(hotel1);
        database_service.insert(hotel2);
        database_service.insert(hotel3);
        database_service.insert(hotel4);
        database_service.insert(hotel5);
        database_service.insert(hotel6);
        database_service.insert(hotel7);
        database_service.insert(hotel8);
        database_service.insert(hotel9);
        database_service.insert(hotel10);
        database_service.insert(hotel11);
        database_service.insert(hotel12);
        database_service.insert(hotel13);
        database_service.insert(hotel14);
        database_service.insert(hotel15);
        database_service.insert(hotel16);
        database_service.insert(hotel17);
        database_service.insert(hotel18);
        database_service.insert(hotel19);
        database_service.insert(hotel20);
        database_service.insert(hotel21);
        database_service.insert(hotel22);
        database_service.insert(hotel23);
        database_service.insert(hotel24);
        database_service.insert(hotel25);
        database_service.insert(hotel26);
        database_service.insert(hotel27);
        database_service.insert(hotel28);
        database_service.insert(hotel29);
        database_service.insert(hotel30);
        database_service.insert(hotel31);
        database_service.insert(hotel32);
        database_service.insert(hotel33);
        database_service.insert(hotel34);
        database_service.insert(hotel35);
        database_service.insert(hotel36);

    }

    private boolean isLoginPass() {

        String user_name = ( ((EditText) findViewById(R.id.user_id)).getText().toString());
        String password = ( ((EditText) findViewById(R.id.user_password)).getText().toString());

        if (user_name.equals(UserDB.account1_id))
        {
            if (password.equals(UserDB.account1_pw))
            {
                UserDB.isAccount1Login = true;
                return true;
            }else return false;
        }else if (user_name.equals(UserDB.account2_id) && UserDB.isAccount2Created){
            if (password.equals(UserDB.account2_pw)){
                UserDB.isAccount1Login = false;
                return true;
            }else return false;
        }else return false;

    }


}
