package com.example.sehh_2279_pj_hotel_booking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomListView extends BaseAdapter {

    Context context;
    private final String[] hotel_name;
    private final int[] price_1;
    private final int[] price_2;
    private final int[] image;

    public CustomListView(Context context, String[] hotel_name, int[] price_1, int[] price_2, int[] image) {
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.hotel_name = hotel_name;
        this.price_1 = price_1;
        this.price_2 = price_2;
        this.image = image;
    }

    @Override
    public int getCount() {
        return hotel_name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.result_listview, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.Title);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.DEscription);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.listview_images);
            viewHolder.hotelD = (TextView) convertView.findViewById(R.id.HotelD);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.title.setText(hotel_name[position]);
        viewHolder.desc.setText("Adult:$HKD" + price_1[position] + "  Child:$HKD" + price_2[position]);
        viewHolder.icon.setImageResource(image[position]);
        if (position == 0){
            viewHolder.hotelD.setText("Contain: 1 bedroom, 2 beds, 1 private bathroom, Free Wifi");
        } else viewHolder.hotelD.setText("Contain: 1 bedroom, 1 bed, 1 private bathroom, Free Wifi");

        return convertView;
    }

    private static class ViewHolder {

        TextView title;
        TextView desc;
        ImageView icon;
        TextView hotelD;

    }
}
