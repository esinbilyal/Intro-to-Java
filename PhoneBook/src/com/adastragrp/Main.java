package com.adastragrp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    ;
    public static void main(String[] args) {
        List<PhoneBookEntry> phoneBookList = new ArrayList<>();
        while(phoneBookList.size() <= 5) {
            System.out.print("Please enter person's name: ");
            String personName = scanner.nextLine();
            System.out.print("Please enter person's phone number: ");
            String phoneNumber = scanner.nextLine();
            phoneBookList.add(new PhoneBookEntry(personName, phoneNumber));
        }

        printPhoneBook(phoneBookList);
    }

    public static void printPhoneBook(List<PhoneBookEntry> list) {
        for (PhoneBookEntry person : list) {
            System.out.printf("%s\n", person);
        }
        System.out.printf("\n");
    }
}
