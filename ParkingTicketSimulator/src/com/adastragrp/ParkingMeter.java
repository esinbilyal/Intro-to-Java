package com.adastragrp;

public class ParkingMeter {
    private double purchasedParkingMinutes;

    public ParkingMeter(double purchasedParkingMinutes) {
        this.purchasedParkingMinutes = purchasedParkingMinutes;
    }

    public double getPurchasedParkingMinutes() {
        return purchasedParkingMinutes;
    }
}
