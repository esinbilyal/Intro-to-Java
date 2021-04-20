package com.adastragrp;

import java.util.ArrayList;
import java.util.Collections;

public class ListOfNumbers {
    private ArrayList<Integer> numberList = new ArrayList<Integer>();

    public void addNumber(int number) {
        numberList.add(number);
    }

    public int findLargest() {
        return Collections.max(numberList);
    }

    public int findSmallest() {
        return Collections.min(numberList);
    }

    public void printList() {
        for(int number : numberList) {
            System.out.printf("%d ", number);
        }
        System.out.println("\n");
    }
}
