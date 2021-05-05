package com.adastragrp;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        int number;

        System.out.print("Enter \"-99\" to stop\n");
        System.out.print("PLese enter a number: ");
        number = scanner.nextInt();
        listOfNumbers.addNumber(number);
        while (number != -99) {
            System.out.print("Enter the next a number: ");
            number = scanner.nextInt();
            if (number != -99) {
                listOfNumbers.addNumber(number);
            }
        }

        System.out.printf("Smallest number: %d\nLargest number: %d", listOfNumbers.findSmallest(), listOfNumbers.findLargest());
    }
}
