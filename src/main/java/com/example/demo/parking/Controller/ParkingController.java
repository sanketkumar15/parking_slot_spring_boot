package com.example.demo.parking.Controller;

import com.example.demo.parking.Common.Response;
import com.example.demo.parking.Entity.ParkingLevel;
import com.example.demo.parking.Model.ParkingLevelModel;
import com.example.demo.parking.Model.VehicleModel;
import com.example.demo.parking.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class ParkingController {
    @Autowired

    ParkingService parkingService;
    @GetMapping("/")

    public String f(){
        return "hearar";
    }
    @PostMapping("/parking/addLevel")

    public Response<String> addLevel(@RequestBody ParkingLevelModel parkingLevelModel){

        try{
            return  parkingService.addLevel(parkingLevelModel);
//            return new Response<>("hearar");
        } catch(Exception e) {
            return new Response<>(e.getMessage());
        }
    }
    @PostMapping("/parking/park")
    public Response<String> park(@RequestBody VehicleModel vehicleModel){

        return new Response<>("hearar", HttpStatus.OK);
    }
 @PostMapping("/parking/unpark")

    public Response<String>unpark(@RequestBody  VehicleModel vehicleModel){

        return new Response<>("hearar",HttpStatus.OK);
    }
}

