package com.adastragrp;

public class Main {

    public static void main(String[] args) {
	    ParkedCar parkedCar = new ParkedCar("Rolls Royce", "Cullinan", "Black", "X 4589 BG", 45);
	    ParkingMeter parkingMeter = new ParkingMeter(60);
	    PoliceOfficer policeOfficer = new PoliceOfficer("Castle", "Agent");

	    boolean isIllegal = policeOfficer.isParkingTimeExpired(parkedCar, parkingMeter);

	    if(isIllegal) {
	        ParkingTicket issuedParkingTicket = policeOfficer.issueParkingTicket(parkedCar, parkingMeter);
            System.out.print(issuedParkingTicket);
        } else {
			System.out.print("No ticket issued! Have a nice day!");
		}
    }
}
