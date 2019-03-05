package com.example.ringgo_example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.ringgo_example.myapplication.models.VehiclesResponse;

public class DisplayVehiclesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private VehicleListAdapter mAdapter;
    private VehiclesResponse mVehiclesResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicles_display_message);

        mVehiclesResponse = MainActivity.sVehiclesResponse;

        // Capture the layout's TextView and set the string as its text
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new VehicleListAdapter(this, mVehiclesResponse.vehicles);

        TextView mListTitle = findViewById(R.id.vehicleListTitle);
        mListTitle.setText("Showing " + mVehiclesResponse.count + " Vehicles");

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
