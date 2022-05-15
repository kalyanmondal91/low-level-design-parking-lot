package com.github.systemdesign.strategy;

public interface ParkingStrategy {
    void addSlot(Integer slotNumber);
    void removeSlot(Integer slotNumber);
    Integer getNextFreeSlot();
}
