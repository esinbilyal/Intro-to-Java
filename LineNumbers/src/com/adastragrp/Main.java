package com.adastragrp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner fileToRead = null;
        String fileName;
        int numberOfLines = 1;

        System.out.print("Please enter the name of the file yuo want to open and read: ");
        fileName = scanner.nextLine();

        try {
            fileToRead = new Scanner(new BufferedReader(new FileReader(fileName)));
            while (fileToRead.hasNext() && numberOfLines <= 5) {
                System.out.println(fileToRead.nextLine() + "\n");
                numberOfLines++;
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Cannot find the file " + fileNotFoundException.getMessage());
        } finally {
            if (fileToRead != null) {
                scanner.close();
            }
        }
    }
}
