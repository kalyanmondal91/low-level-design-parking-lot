package com.github.systemdesign.strategy.impl;

import com.github.systemdesign.exception.NoFreeSlotAvailableException;
import com.github.systemdesign.strategy.ParkingStrategy;
import org.springframework.stereotype.Component;

import java.util.TreeSet;

@Component
public class NaturalOrderParkingStrategy implements ParkingStrategy {

    private final TreeSet<Integer> slotSet;

    public NaturalOrderParkingStrategy() {
        this.slotSet = new TreeSet<>();
    }

    @Override
    public void addSlot(Integer slotNumber) {
        this.slotSet.add(slotNumber);
    }

    @Override
    public void removeSlot(Integer slotNumber) {
        this.slotSet.remove(slotNumber);
    }

    @Override
    public Integer getNextFreeSlot() {
        if(slotSet.isEmpty()) {
            throw new NoFreeSlotAvailableException();
        }
        return this.slotSet.first();
    }
}
