package com.example.demo.parking.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleModel {
    private Integer vehicleNumber;
    private VehicleType vehicleType;
    private Integer slotId;
    private Integer levelId;
}
