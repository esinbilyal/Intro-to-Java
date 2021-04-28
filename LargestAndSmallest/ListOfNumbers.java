package com.adastragrp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListOfNumbers {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number;
        int smallest;
        int largest;

        System.out.print("Enter \"-99\" to stop\n");
        System.out.print("PLese enter a number: ");
        number = scanner.nextInt();
        smallest = number;
        largest = number;
        while (number != -99) {
            System.out.print("Enter the next a number: ");
            number = scanner.nextInt();
            if (number != -99) {
                if (number > largest) {
                    largest = number;
                }
                if(number < smallest){
                    smallest = number;
                }
            }
        }

        System.out.printf("Smallest number: %d\nLargest number: %d", smallest, largest);
    }
}
