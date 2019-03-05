package com.example.ringgo_example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ringgo_example.myapplication.models.Vehicle;

public class VehicleDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_details);

        // Get the Intent that started this activity and extract the data
        Intent intent = getIntent();
        Vehicle vehicleDetails = (Vehicle) intent.getSerializableExtra(MainActivity.VEHICLE_DETAILS);

        this.setTitle(vehicleDetails.vrn + " [" + vehicleDetails.vehicleId + "] " + getResources().getString(R.string.vehicle_details));

        TextView mVehicleColour = findViewById(R.id.textViewVehicleColour);
        mVehicleColour.setText(vehicleDetails.color);

        TextView mVehicleType = findViewById(R.id.textViewVehicleType);
        mVehicleType.setText(vehicleDetails.type);

        TextView mVehicleCountry = findViewById(R.id.textViewVehicleCountry);
        mVehicleCountry.setText(vehicleDetails.country);

        TextView mVehicleIsDefault = findViewById(R.id.textView9);
        mVehicleIsDefault.setText(vehicleDetails._default ? "Y" : "N");
    }
}
