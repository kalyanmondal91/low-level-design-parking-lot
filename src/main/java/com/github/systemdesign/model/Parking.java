package com.github.systemdesign.model;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Parking {
    UUID id;
    Slot slot;
    Double cost;

    public Parking(Slot slot) {
        this.id = UUID.randomUUID();
        this.slot = slot;
    }

    public void makeSlotFree() {
        this.slot.setParkedVehicle(null);
    }
}
