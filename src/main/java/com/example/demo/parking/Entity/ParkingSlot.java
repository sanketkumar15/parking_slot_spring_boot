package com.example.demo.parking.Entity;

import com.example.demo.parking.Model.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PARKING_SLOT")
@Getter
@Setter
@NoArgsConstructor

public class ParkingSlot{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;
    @Column(name = "LEVEL_ID")
    private int levelId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "SLOT_TYPE")
    private VehicleType slotType;

    @Column(name = "OCCUPIED")
    private Boolean occupied;

}

