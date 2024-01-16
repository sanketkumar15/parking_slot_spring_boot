package com.example.demo.parking.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PARKING_LEVEL")
@Getter
@Setter
@NoArgsConstructor

public class ParkingLevel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="NAME")
    private String name;
    @Column(name="CAR_CAPACITY")
    private Integer carCapacity;
    @Column(name = "BUS_CAPACITY")
    private Integer busCapacity;

    @Column(name = "BIKE_CAPACITY")
    private Integer bikeCapacity;

    @Column(name = "CAR_OCCUPIED")
    private Integer carOccupied;

    @Column(name = "BUS_OCCUPIED")
    private Integer busOccupied;

    @Column(name="CAR_AVAILABLE")
    private Integer carAvailable;

    @Column(name = "BIKE_OCCUPIED")
    private Integer bikeOccupied;

    @Column(name="BUS_AVAILABLE")
    private Integer busAvailable;

    @Column(name="BIKE_AVAILABLE")
    private Integer bikeAvailable;


}


