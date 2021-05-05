package com.adastragrp;

public class ParkingTicket {
    private ParkedCar car;
    private ParkingMeter parkingMeter;
    private PoliceOfficer policeOfficer;
    private double fine;

    public ParkingTicket(ParkedCar car, ParkingMeter parkingMeter, PoliceOfficer policeOfficer) {
        this.car = car;
        this.parkingMeter = parkingMeter;
        this.policeOfficer = policeOfficer;
    }

    public ParkedCar getCar() {
        return car;
    }

    public ParkingMeter getParkingMeter() {
        return parkingMeter;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Parking Ticket issued to: \n" +
                "Car with: Make → " + car.getMake() +
                ", Model → " + car.getModel() +
                ", Color → " + car.getColor() +
                ", Licence Number → " + car.getLicenceNumber() + "\n" +
                "The amount of the fine is " + "$" + getFine() + "\n" +
                "Issued by " + policeOfficer.getBadge() + " " + policeOfficer.getName();
    }
}
