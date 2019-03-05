package com.example.ringgo_example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vehicle implements Serializable {
    public int vehicleId;
    public String vrn;
    public String country;
    public String color;
    public String type;

    @SerializedName("default")
    @Expose
    public boolean _default;
}
