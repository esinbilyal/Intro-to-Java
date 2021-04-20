package com.adastragrp;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ListOfNumbers numbersList = new ListOfNumbers();
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        while (number != -99) {
            numbersList.addNumber(number);
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }
        numbersList.printList();
        System.out.printf("The largest number is: %d%n", numbersList.findLargest());
        System.out.printf("The smallest number is: %d%n", numbersList.findSmallest());
    }
}
