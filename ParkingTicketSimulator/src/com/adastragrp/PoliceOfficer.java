package com.adastragrp;

public class PoliceOfficer {
    private String name, badge;

    public PoliceOfficer(String name, String badge) {
        this.name = name;
        this.badge = badge;
    }

    public String getName() {
        return name;
    }

    public String getBadge() {
        return badge;
    }

    public boolean isParkingTimeExpired(ParkedCar car, ParkingMeter parkingMeter) {
        if(car.getMinutesParked() > parkingMeter.getPurchasedParkingMinutes()) {
            return true;
        }
        return false;
    }

    public ParkingTicket issueParkingTicket(ParkedCar car, ParkingMeter parkingMeter) {
        ParkingTicket parkingTicket = new ParkingTicket(car, parkingMeter, this);
        if(isParkingTimeExpired(car, parkingMeter)) {
            double fine;
            double parkedMinutes = car.getMinutesParked();
            double purchasedParkingMinutes = parkingMeter.getPurchasedParkingMinutes();
            if(parkedMinutes - purchasedParkingMinutes <= 60) {
                fine = 25;
            } else {
                fine = 25 + (10 * Math.ceil((parkedMinutes - purchasedParkingMinutes - 60) / 60));
            }
            parkingTicket.setFine(fine);
        }
        return parkingTicket;
    }
}
