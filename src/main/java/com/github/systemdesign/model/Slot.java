package com.github.systemdesign.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Slot {
    private Car parkedVehicle;
    private Integer slotNumber;

    public Slot(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isSlotAvailable() {
        return Objects.isNull(parkedVehicle);
    }
}
