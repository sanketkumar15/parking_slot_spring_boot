package com.example.demo.parking.Repository;

import com.example.demo.parking.Entity.ParkingLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingLevel,Integer> {

}
