package com.github.systemdesign.dao;

import com.github.systemdesign.model.Slot;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SlotRepository {
    Map<Integer, Slot> slotMap;

    public SlotRepository() {
        this.slotMap = new HashMap<>();
    }

    public void addSlot(int i) {
        slotMap.put(i, new Slot(i));
    }

    public Slot getSlot(Integer slotId) {
        return slotMap.get(slotId);
    }
}
