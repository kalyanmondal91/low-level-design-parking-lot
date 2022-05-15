# ParkingLot - Low level system design
Repository for low level system design of a parking lot

## Problem Statement
We have to do low level design for a Parking Lot system.
Parking lot that can hold up to 'n' cars at any given point in time. Each slot is given a number starting at 1 increasing with increasing distance from the entry point in steps of one.

When a car enters my parking lot, a ticket issued to the driver. The ticket issuing process includes us documenting the registration number (number plate) and the colour of the car and allocating an available parking slot to the car before actually handing over a ticket to the driver (we assume that our customers are nice enough to always park in the slots allocated to them). The customer should be allocated a parking slot which is nearest to the entry. At the exit the customer returns the ticket which then marks the slot they were using as being available.

Due to government regulation, the system should provide with the ability to find out:

* Registration numbers of all cars of a particular colour.
* Slot number in which a car with a given registration number is parked.
* Slot numbers of all slots where a car of a particular colour is parked.

Parking Lot design will have to support following operations:
* **createParkingLot**: This will create a parking lot and assign space to it.
* **park**: This will allow user to park car.
* **exit**: This will allow to exit the parking lot and return amount to be paid.

### Expectations
* Code should be functionally correct.
* Code should be modular and readable. Clean and professional level code.
* Code should be extensible and scalable. Means it should be able to accommodate new requirements with minimal changes.
* Code should have good OOPs design.

### Solution
* Natural Parking Order
* Factory Design Pattern
* HashMap based storage