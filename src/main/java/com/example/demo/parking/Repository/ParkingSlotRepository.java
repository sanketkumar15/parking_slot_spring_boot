package com.example.demo.parking.Repository;

import com.example.demo.parking.Entity.ParkingLevel;
import com.example.demo.parking.Entity.ParkingSlot;
import com.example.demo.parking.Model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot,Integer> {
   ParkingSlot findFirstByLevelIdAndSlotTypeAndOccupiedIsNull(Integer levelId, VehicleType vehicleType);
}