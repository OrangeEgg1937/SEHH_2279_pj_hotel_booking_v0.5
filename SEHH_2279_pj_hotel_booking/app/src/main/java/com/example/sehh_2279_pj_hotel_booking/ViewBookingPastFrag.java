package com.example.sehh_2279_pj_hotel_booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewBookingPastFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewBookingPastFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ViewBookingRecyclerViewAdapter recyclerViewAdapter;
    private List<ViewBookingHotel> hotelList;

    public ViewBookingPastFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewBookingPastFrag newInstance(String param1, String param2) {
        ViewBookingPastFrag fragment = new ViewBookingPastFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_past, container, false);
        hotelList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new ViewBookingRecyclerViewAdapter(hotelList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        prepareHotel();
        return view;
    }

    private void prepareHotel(){
        ViewBookingHotel hotel = new ViewBookingHotel("EVEN Hotel Eugene", R.drawable.hotel2);
        hotelList.add(hotel);
        hotel = new ViewBookingHotel("Angelica Hotel", R.drawable.hotel3);
        hotelList.add(hotel);
        hotel = new ViewBookingHotel("Mandarin Oriental, Hong Kong", R.drawable.hotel4);
        hotelList.add(hotel);
        hotel = new ViewBookingHotel("Marina Bay Sands", R.drawable.hotel5);
        hotelList.add(hotel);
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
