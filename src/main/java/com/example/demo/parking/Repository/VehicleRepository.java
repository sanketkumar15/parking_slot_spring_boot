package com.example.demo.parking.Repository;

import com.example.demo.parking.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

}
