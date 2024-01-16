package com.example.demo.parking.Service;

import com.example.demo.parking.Entity.ParkingLevel;


import com.example.demo.parking.Common.Response;
import com.example.demo.parking.Model.ParkingLevelModel;
import com.example.demo.parking.Model.VehicleModel;

public interface ParkingService {
    public Response<String> park(VehicleModel vehicleModel);
    public Response<String> unpark(VehicleModel vehicleModel);
    public Response<String> addLevel(ParkingLevelModel parkingLevelModel);
}
