package com.github.systemdesign.dao;

import com.github.systemdesign.exception.NotFoundException;
import com.github.systemdesign.model.Parking;
import com.github.systemdesign.model.Slot;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class ParkingRepository {
    Map<UUID, Parking> parkingMap;

    public ParkingRepository() {
        this.parkingMap = new HashMap<>();
    }

    public Parking save(Parking parking) {
        parkingMap.put(parking.getId(), parking);
        return parking;
    }

    public Parking getId(UUID id) {
        if(parkingMap.containsKey(id))
            return parkingMap.get(id);
        throw new NotFoundException();
    }
}
