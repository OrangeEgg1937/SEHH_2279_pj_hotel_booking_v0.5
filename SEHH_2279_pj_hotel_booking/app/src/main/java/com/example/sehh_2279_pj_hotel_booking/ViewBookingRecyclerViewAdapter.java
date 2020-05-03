package com.example.sehh_2279_pj_hotel_booking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewBookingRecyclerViewAdapter extends RecyclerView.Adapter<ViewBookingRecyclerViewAdapter.MyViewHolder>{

    private List<ViewBookingHotel> hotelList;

    public ViewBookingRecyclerViewAdapter(List<ViewBookingHotel> hotelList) {
        this.hotelList = hotelList;
    }


    @Override
    public ViewBookingRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewBookingRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.title.setText(hotelList.get(position).getTitle());
        holder.image.setImageResource(hotelList.get(position).getImage());
        holder.detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent i = new Intent(context, ViewBookingDetail.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public View detailButton;
        private TextView title;
        private ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            detailButton = itemView.findViewById(R.id.detailBtn);
        }
    }
}
