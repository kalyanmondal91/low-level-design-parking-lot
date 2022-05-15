package com.github.systemdesign;

import com.github.systemdesign.model.Car;
import com.github.systemdesign.model.Parking;
import com.github.systemdesign.service.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppRunner implements CommandLineRunner {
    private final ParkingService parkingService;

    @Autowired
    public AppRunner(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void run(String... args) throws Exception {
        parkingService.createParkingLot(100);

        Parking p1 = parkingService.park(new Car("KA010001", "Blue"));
        Parking p2 = parkingService.park(new Car("KA010002", "Red"));
        Parking p3 = parkingService.park(new Car("KA010003", "Blue"));

        parkingService.exit(p1.getId());
        Parking p4 = parkingService.park(new Car("KA010004", "Green"));

        parkingService.exit(p2.getId());
        parkingService.exit(p3.getId());
        parkingService.exit(p4.getId());
    }
}
