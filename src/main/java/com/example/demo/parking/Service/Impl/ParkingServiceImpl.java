package com.example.demo.parking.Service.Impl;

import com.example.demo.parking.Common.Response;
import com.example.demo.parking.Entity.ParkingLevel;
import com.example.demo.parking.Entity.ParkingSlot;
import com.example.demo.parking.Entity.Vehicle;
import com.example.demo.parking.Model.ParkingLevelModel;
import com.example.demo.parking.Model.VehicleModel;
import com.example.demo.parking.Model.VehicleType;
import com.example.demo.parking.Repository.ParkingRepository;
import com.example.demo.parking.Repository.ParkingSlotRepository;
import com.example.demo.parking.Repository.VehicleRepository;
import com.example.demo.parking.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @Autowired
    private VehicleRepository vehicleRepository;
    public Response<String> park(VehicleModel vehicleModel) {
        if (isVehicleParked(vehicleModel.getVehicleNumber())) {
            throw new RuntimeException("Vehicle is already parked");
        }

        ParkingSlot availableSlot = findAvailableSlot(vehicleModel.getVehicleType(), vehicleModel.getLevelId());

        if (availableSlot != null) {
            availableSlot.setOccupied(true);
            parkingSlotRepository.save(availableSlot);

            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicle.getVehicleNumber());
            vehicle.setVehicleType(vehicle.getVehicleType());
            vehicle.setLevelId(vehicle.getLevelId());
            vehicle.setSlotId(vehicle.getSlotId());
            vehicleRepository.save(vehicle);
        } else {
            throw new RuntimeException("No available slot for parking");
        }
        return new Response<>("null");
    }

    private boolean isVehicleParked(Integer vehicleNumber) {
        return vehicleRepository.existsById(vehicleNumber);
    }

    private ParkingSlot findAvailableSlot(VehicleType vehicleType, Integer levelId) {
        return parkingSlotRepository.findFirstByLevelIdAndSlotTypeAndOccupiedIsNull(levelId, vehicleType);
    }





    public Response<String> unpark(VehicleModel vehicleModel){
        return new Response<>("true");
    }


    public Response<String> addLevel(ParkingLevelModel parkingLevelModel) {
        ParkingLevel parkingLevel = new ParkingLevel();
        parkingLevel.setId(parkingLevelModel.getLevelId());
        parkingLevel.setName(parkingLevelModel.getName());
        parkingLevel.setBikeAvailable(parkingLevelModel.getBikeAvailable());
        parkingLevel.setCarAvailable(parkingLevelModel.getCarAvailable());
        parkingLevel.setBusAvailable(parkingLevelModel.getBusAvailable());
        parkingLevel.setBikeOccupied(0);
        parkingLevel.setCarOccupied(0);
        parkingLevel.setBusOccupied(0);

        parkingRepository.save(parkingLevel);

        initializeParkingSlots(parkingLevel);

        return new Response<>("true");
    }

    private void initializeParkingSlots(ParkingLevel parkingLevel) {
        int bikeCapacity = parkingLevel.getBikeAvailable();
        int carCapacity = parkingLevel.getCarAvailable();
        int busCapacity = parkingLevel.getBusAvailable();

        for (int i = 1; i <= bikeCapacity; i++) {
            saveParkingSlot(parkingLevel.getId(), VehicleType.BIKE);
        }

        for (int i = 1; i <= carCapacity; i++) {
            saveParkingSlot(parkingLevel.getId(), VehicleType.CAR);
        }

        for (int i = 1; i <= busCapacity; i++) {
            saveParkingSlot(parkingLevel.getId(), VehicleType.BUS);
        }
    }

    private void saveParkingSlot(Integer levelId, VehicleType slotType) {
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setLevelId(levelId);
        parkingSlot.setSlotType(slotType);
        parkingSlotRepository.save(parkingSlot);
    }
}

