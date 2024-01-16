package com.example.demo.parking.Entity;

import com.example.demo.parking.Model.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    @Id
    private Integer vehicleNumber;

    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "VEHICLE_TYPE")
    private VehicleType vehicleType;

    private Integer slotId;
    private Integer levelId;




}
