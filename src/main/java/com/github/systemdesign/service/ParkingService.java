package com.github.systemdesign.service;

import com.github.systemdesign.dao.ParkingRepository;
import com.github.systemdesign.dao.SlotRepository;
import com.github.systemdesign.model.Car;
import com.github.systemdesign.model.Parking;
import com.github.systemdesign.model.Slot;
import com.github.systemdesign.strategy.ParkingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParkingService {
    private final ParkingStrategy parkingStrategy;
    private final ParkingRepository parkingRepository;
    private final SlotRepository slotRepository;

    @Autowired
    public ParkingService(ParkingStrategy parkingStrategy, ParkingRepository parkingRepository, SlotRepository slotRepository) {
        this.parkingStrategy = parkingStrategy;
        this.parkingRepository = parkingRepository;
        this.slotRepository = slotRepository;
    }

    public void createParkingLot(final int capacity) {
        for(int i=1; i<=capacity; i++) {
            slotRepository.addSlot(i);
            parkingStrategy.addSlot(i);
        }
    }

    public Parking park(final Car car) {
        final Integer nextFreeSlot = parkingStrategy.getNextFreeSlot();
        Slot slot = slotRepository.getSlot(nextFreeSlot);
        slot.setParkedVehicle(car);
        Parking parking = new Parking(slot);
        parkingRepository.save(parking);
        parkingStrategy.removeSlot(nextFreeSlot);
        return parking;
    }

    public Parking exit(final UUID id) {
        Parking parking = parkingRepository.getId(id);
        parkingStrategy.addSlot(parking.getSlot().getSlotNumber());
        parking.makeSlotFree();
        return parking;
    }

}
