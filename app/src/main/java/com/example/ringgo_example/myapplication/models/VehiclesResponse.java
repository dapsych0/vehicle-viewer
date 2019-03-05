package com.example.ringgo_example.myapplication.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VehiclesResponse implements Serializable {
    public int count;
    public List<Vehicle> vehicles;
    public int currentPage;
    public int nextPage;
    public int totalPages;

    public VehiclesResponse() {
        vehicles = new ArrayList<Vehicle>();
    }
}
