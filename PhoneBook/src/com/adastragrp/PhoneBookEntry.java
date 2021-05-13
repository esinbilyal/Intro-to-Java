package com.adastragrp;

public class PhoneBookEntry {
    private String personsName, phoneNumber;

    public PhoneBookEntry(String personsName, String phoneNumber) {
        if (validateName(personsName)) {
            this.personsName = personsName;
        } else {
            System.out.print("Invalid person name\n");
            this.personsName = "";
        }
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.print("Invalid phone number\n");
            this.phoneNumber = "";
        }
    }

    public String getPersonsName() {
        return personsName;
    }

    public void setPersonsName(String personsName) {
        if (validateName(personsName)) {
            this.personsName = personsName;
        } else {
            System.out.print("Invalid person name\n");
            this.personsName = "";
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.print("Invalid phone number\n");
            this.phoneNumber = "";
        }
    }

    @Override
    public String toString() {
        return ("Person's name: " + this.getPersonsName() + "  →  " + "Phone Number: " + this.getPhoneNumber());
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("^\\d{10}$"))
            return true;
        if (phoneNumber.matches("^\\d{3} \\d{4} \\d{3}$"))
            return true;
        if (phoneNumber.matches("^\\+359 \\d{2} \\d{4} \\d{3}$"))
            return true;
        if (phoneNumber.matches("^\\+359\\d{2}\\d{4}\\d{3}$"))
            return true;
        return false;
    }

    private boolean validateName(String personsName) {
        if (personsName.matches("^[A-Z][a-z]+( [A-Z][a-z]+)?$"))
            return true;
        return false;
    }
}
