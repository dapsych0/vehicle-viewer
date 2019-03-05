package com.example.ringgo_example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ringgo_example.myapplication.models.Vehicle;

import java.util.List;

public class VehicleListAdapter extends RecyclerView.Adapter<VehicleListAdapter.VehicleViewHolder> {
    private final List<Vehicle> mVehiclesList;
    private LayoutInflater mInflater;

    public VehicleListAdapter(Context context, List<Vehicle> vehiclesList) {
        mInflater = LayoutInflater.from(context);
        this.mVehiclesList = vehiclesList;
    }

    @NonNull
    @Override
    public VehicleListAdapter.VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.vehicle_item, parent, false);
        return new VehicleViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleListAdapter.VehicleViewHolder vehicleHolder, int position) {
        String mCurrent = mVehiclesList.get(position).vrn;
        vehicleHolder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mVehiclesList.size();
    }

    class VehicleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final VehicleListAdapter mAdapter;

        public VehicleViewHolder(View itemView, VehicleListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.listItemText);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {
            int mPosition = getLayoutPosition();
            Vehicle mVehicleDetails = mVehiclesList.get(mPosition);

            Context context = itemView.getContext();
            Intent intent = new Intent(context, VehicleDetailsActivity.class);
            intent.putExtra(MainActivity.VEHICLE_DETAILS, mVehicleDetails);
            context.startActivity(intent);
        }
    }
}
