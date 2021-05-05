package com.adastragrp;

public class ParkedCar {
    private String make, model, color, licenceNumber;
    private double minutesParked;

    public ParkedCar(String make, String model, String color, String licenceNumber, double minutesParked) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenceNumber = licenceNumber;
        this.minutesParked = minutesParked;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public double getMinutesParked() {
        return minutesParked;
    }

    public void setMinutesParked(double minutesParked) {
        this.minutesParked = minutesParked;
    }
}
