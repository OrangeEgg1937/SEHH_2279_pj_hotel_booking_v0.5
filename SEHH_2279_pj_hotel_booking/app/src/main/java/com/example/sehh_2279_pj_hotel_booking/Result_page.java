package com.example.sehh_2279_pj_hotel_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;


public class Result_page extends AppCompatActivity {

    private Database_Service database_service = new Database_Service(this);
    private ListView result_list;
    private String check_in_date;
    private String check_out_date;
    private String[] result_of_hotel_name = new String[2];
    private int[] price_1 = new int[2];
    private int[] price_2 = new int[2];
    private int[] image_set = {R.drawable.hotel_icon_1, R.drawable.hotel_icon_2};
    private CustomListView listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        result_list = (ListView) findViewById(R.id.result_list);

        //Get the information that was sent to this activity (screen)
        //from the previous
        Bundle extras = getIntent().getExtras();
        check_in_date = extras.getString("check_in_date");
        check_out_date = extras.getString("check_out_date");
        setScreen();

        //Set result
        final List<String> result = new ArrayList<String>();
        database_service.getResult(extras.getString("location"), result);
        database_service.getResult(extras.getString("location"), result_of_hotel_name, price_1, price_2);

        result_list = (ListView) findViewById(R.id.result_list);

        listAdapter = new CustomListView(Result_page.this, result_of_hotel_name, price_1, price_2, image_set);

        result_list.setAdapter(listAdapter);

        result_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Result_page.this, Hotel_detail_info_page.class);


                String name = result.get(position).substring(0,result.get(position).indexOf("Hotel")+5);
                String price_1 = result.get(position).substring(result.get(position).indexOf("Adult Price (per person):")+25,result.get(position).indexOf("Child")-1);
                String price_2 = result.get(position).substring(result.get(position).indexOf("Child Price (per person):")+25,result.get(position).indexOf("Available")-1);
                String room = result.get(position).substring(result.get(position).indexOf("Available Room:")+16,(result.get(position).length()));

                Bundle extras = getIntent().getExtras();
                //Give the following information to the new activity
                i.putExtra("name", name);
                i.putExtra("price_1", price_1);
                i.putExtra("price_2", price_2);
                i.putExtra("room", room);
                i.putExtra("check_in_date", check_in_date);
                i.putExtra("check_out_date", check_out_date);
                i.putExtra("Pos", position);
                i.putExtra("location",extras.getString("location"));


                //Run the new activity (i.e show the new screen)
                startActivity(i);
            }
        });




    }

    private void setScreen() {
        TextView display_text = (TextView) findViewById(R.id.textView4);
        display_text.setText("From "+check_in_date+" to "+check_out_date);

        Button back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result_page.this.finish();
            }
        });
    }

}
