package com.example.ringgo_example.myapplication.interfaces;

import com.example.ringgo_example.myapplication.models.VehiclesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
    String BASE_URL = "https://private-6d86b9-vehicles5.apiary-mock.com/";

    @GET("vehicles")
    Observable<VehiclesResponse> getVehicles();
}
