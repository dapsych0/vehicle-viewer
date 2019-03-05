package com.example.ringgo_example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ringgo_example.myapplication.models.Vehicle;

public class VehicleDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_details);

        // Get the Intent that started this activity and extract the data
        Intent intent = getIntent();
        Vehicle vehicleDetails = (Vehicle) intent.getSerializableExtra(MainActivity.VEHICLE_DETAILS);

        this.setTitle(vehicleDetails.vrn + " " + getResources().getString(R.string.vehicle_details));
    }
}
