package com.example.demo.parking.Model;

import com.example.demo.parking.Model.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ParkSlot{

    private Integer slotId;

    private VehicleType type;


}
