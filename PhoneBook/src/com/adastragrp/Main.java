package com.adastragrp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    ;
    public static void main(String[] args) {
        List<PhoneBookEntry> phoneBookList = new ArrayList<>();
//        while(phoneBookList.size() <= 5) {
//            System.out.print("Please enter person's name: ");
//            String personName = scanner.nextLine();
//            System.out.print("Please enter person's phone number: ");
//            String phoneNumber = scanner.nextLine();
//            phoneBookList.add(new PhoneBookEntry(personName, phoneNumber));
//        }
        phoneBookList.add(new PhoneBookEntry("Esin", "1234567896"));
        phoneBookList.add(new PhoneBookEntry("Bob", "1234567896"));
        phoneBookList.add(new PhoneBookEntry("Noah", "1234567896"));
        phoneBookList.add(new PhoneBookEntry("Lucy", "1234567896"));
        phoneBookList.add(new PhoneBookEntry("Peter", "1234567896"));


        printPhoneBook(phoneBookList);

        SaveFactory saveFactory = new SaveFactory();
        ISave myJSONSaver = saveFactory.init("json");
        String saveLocationJSON = "H:\\Intro to Java\\PhoneBook\\phoneBook.json";
        String saveLocationSQLite = "phoneBook.db";

        myJSONSaver.save(saveLocationJSON, phoneBookList);
        myJSONSaver.load(saveLocationJSON);

        ISave mySQLiteSaver = saveFactory.init("sqlite");
        mySQLiteSaver.save(saveLocationSQLite, phoneBookList);
        mySQLiteSaver.load(saveLocationSQLite);
    }


    public static void printPhoneBook(List<PhoneBookEntry> list) {
        for (PhoneBookEntry person : list) {
            System.out.printf("%s\n", person);
        }
        System.out.printf("\n");
    }
}
